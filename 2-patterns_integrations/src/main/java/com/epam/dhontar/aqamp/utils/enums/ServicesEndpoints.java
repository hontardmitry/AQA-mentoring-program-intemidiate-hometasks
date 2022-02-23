package com.epam.dhontar.aqamp.utils.enums;

public enum ServicesEndpoints {
    BASE_URL("https://fakerestapi.azurewebsites.net/api/v1/"),
    AUTHORS_URL("Authors/"),
    USERS_URL("Users/"),
    SLACK_API_URL("https://hooks.slack.com/services/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");

    private final String urlValue;

    ServicesEndpoints(String urlValue) {
        this.urlValue = urlValue;
    }

    public String getValue() {
        return urlValue;
    }
}
