package com.epam.dhontar.aqamp.utils.integrations.slack;

import static com.epam.dhontar.aqamp.utils.enums.ServicesEndpoints.SLACK_API_URL;

import static io.restassured.RestAssured.given;

import com.epam.dhontar.aqamp.observer.ChatObserver;
import com.epam.dhontar.aqamp.utils.integrations.slack.entity.SlackMessage;

import io.restassured.http.ContentType;

public class SlackClient implements ChatObserver {

    @Override
    public void update(String message) {
        given()
            .contentType(ContentType.JSON)
            .body(new SlackMessage(message))
            .when()
            .post(SLACK_API_URL.getValue());
    }
}
