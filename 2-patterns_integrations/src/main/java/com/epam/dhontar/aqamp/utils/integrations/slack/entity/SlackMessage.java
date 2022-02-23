package com.epam.dhontar.aqamp.utils.integrations.slack.entity;

public class SlackMessage {
    private String text;

    public SlackMessage(String text) {
        this.text = text;
    }

    public SlackMessage() {
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
