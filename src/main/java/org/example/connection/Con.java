package org.example.connection;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

public class Con {
    private static Connection connection;
    private static ConnectionFactory connectionFactory;


    public static Connection getConnection() {
        try {
            connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
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
