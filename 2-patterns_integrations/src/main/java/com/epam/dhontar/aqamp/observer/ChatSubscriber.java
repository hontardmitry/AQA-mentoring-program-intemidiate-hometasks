package com.epam.dhontar.aqamp.observer;

import static java.lang.String.format;

import java.util.logging.Logger;

public class ChatSubscriber implements ChatObserver{
    private static final Logger LOGGER = Logger.getLogger(ChatSubscriber.class.getName());
    private String subscriberName;

    public ChatSubscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update(String message) {
        LOGGER.info(format("%s get new message: %s", this.getSubscriberName(), message));
    }

    public String getSubscriberName() {
        return subscriberName;
    }
}
