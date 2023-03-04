package org.example;

import org.example.connection.Con;
import org.example.consumers.Consumer;
import org.example.producers.Producer;

import javax.jms.*;


public class App {
    private static Session session;
    private static MessageProducer messageProducer;
    private static MessageConsumer messageConsumer;
    private static TextMessage message;
    private static Queue queue;


    public static void main(String[] args) throws JMSException, InterruptedException {
        initializingVariables();

        message = session.createTextMessage("My message to ActiveMQ");
        messageProducer.send(message);
        TextMessage text = (TextMessage) messageConsumer.receive();
        System.out.println(text.getText());
        Con.closeCon();
        session.close();

    }

    public static void initializingVariables() throws JMSException {
        Connection connection = Con.getConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        queue = session.createQueue("MyQueue");
        Producer producer = new Producer(session, queue);
        messageProducer = producer.createMsgProducer();
        Consumer consumer = new Consumer(session, queue);
        messageConsumer = consumer.createMsgConsumer();
    }
}
