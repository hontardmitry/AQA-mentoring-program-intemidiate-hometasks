package common;

import static java.lang.String.format;

import com.codeborne.selenide.Selenide;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public abstract class BaseTest {
    protected static final Logger LOGGER =  Logger.getLogger(BaseTest.class);

    @BeforeEach
    public void init(TestInfo testInfo) {
        LOGGER.info(format("Test '%s' started.", testInfo.getDisplayName()));
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        LOGGER.info(format("Test '%s' finished successfully.", testInfo.getDisplayName()));
    }


}

