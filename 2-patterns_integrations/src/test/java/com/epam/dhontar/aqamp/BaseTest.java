package com.epam.dhontar.aqamp;

import static com.epam.dhontar.aqamp.utils.enums.Constants.TESTRAIL_PWD;
import static com.epam.dhontar.aqamp.utils.enums.Constants.TESTRAIL_URL;
import static com.epam.dhontar.aqamp.utils.enums.Constants.TESTRAIL_USER;

import static java.lang.String.format;

import com.epam.dhontar.aqamp.observer.Chat;
import com.epam.dhontar.aqamp.observer.ChatSubscriber;
import com.epam.dhontar.aqamp.utils.integrations.slack.SlackClient;
import com.epam.dhontar.aqamp.utils.integrations.testrail.TestRails;
import com.epam.dhontar.aqamp.utils.integrations.testrail.bindings.APIClient;
import com.epam.dhontar.aqamp.utils.integrations.testrail.bindings.APIException;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseTest {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final Path PATH = Paths.get(USER_DIR);
    private static final String PROJECT_NAME = PATH.getFileName().toString();
    String PROJECT_ID = "1";

    List<ChatSubscriber> subscribers = new ArrayList<>();
    APIClient client;
    Chat chat = new Chat();
    int failedTests = 0;
    int totalRunTests = 0;

    @BeforeSuite
    public void createSuite(ITestContext ctx) throws IOException, APIException {
        for (int i = 0; i < 2; i++){
            subscribers.add(new ChatSubscriber("Subscriber" + i));
            chat.addObserver(subscribers.get(i));
        }
        chat.addObserver(new SlackClient());

        client = new APIClient(TESTRAIL_URL.getValue());
        client.setUser(TESTRAIL_USER.getValue());
        client.setPassword(TESTRAIL_PWD.getValue());
        Map data = new HashMap();
        data.put("include_all", true);
        data.put("name", "Test Run of " + PROJECT_NAME + " on " + LocalDateTime.now());
        JSONObject c = (JSONObject) client.sendPost("add_run/" + PROJECT_ID, data);
        Long suite_id = (Long) c.get("id");
        ctx.setAttribute("suiteId", suite_id);
    }

    @BeforeMethod
    public void beforeTest(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = this.getClass().getMethod(method.getName());

        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId", ta.id());
            totalRunTests++;
        }
    }

    @AfterMethod
    public void afterTest(ITestResult result, ITestContext ctx, Method method)
        throws IOException, APIException {

        Map data = new HashMap();
        if (result.isSuccess()) {
            data.put("status_id", 1);
        } else {
            data.put("status_id", 5);
            data.put("comment", result.getThrowable().toString());
            chat.addMessage(format("Test %s FAILED with %s", method.getName(), result.getThrowable().toString()));
            failedTests++;
        }

        String caseId = (String) ctx.getAttribute("caseId");
        Long suiteId = (Long) ctx.getAttribute("suiteId");
        client.sendPost("add_result_for_case/" + suiteId + "/" + caseId, data);
    }

    @AfterSuite
    public void notifySubscribersWithOverallStatistics(){
        chat.addMessage(format("Total tests run: %s, failed: %s", totalRunTests, failedTests));
    }
}
