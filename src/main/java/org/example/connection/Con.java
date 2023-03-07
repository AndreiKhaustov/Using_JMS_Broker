package org.example.connection;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Con {
    private static Connection connection;
    private static ConnectionFactory connectionFactory;


    public static Connection getConnection() {
        try {
            connectionFactory = new ActiveMQConnectionFactory(Credentials.USERNAME, Credentials.PASSWORD, Credentials.BROKER_URL);
            connection = connectionFactory.createConnection();
            connection.start();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeCon() throws JMSException {
        connection.close();
    }
}
