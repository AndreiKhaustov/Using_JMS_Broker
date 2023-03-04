package org.example.producers;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class Producer {
    private final Session session;
    private MessageProducer messageProducer;
    private Destination destination;

    public Producer(Session session, Destination destination) {
        this.session = session;
        this.destination = destination;
    }

    public MessageProducer createMsgProducer() {
        try {
            messageProducer = session.createProducer(destination);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return messageProducer;
    }

}
