package org.example.consumers;

import javax.jms.*;

public class Consumer {
    private final Session session;
    private MessageConsumer messageConsumer;
    private Destination destination;

    public Consumer(Session session, Destination destination) {
        this.session = session;
        this.destination = destination;
    }

    public MessageConsumer createMsgConsumer() {
        try {
            messageConsumer = session.createConsumer(destination);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return messageConsumer;
    }
}
