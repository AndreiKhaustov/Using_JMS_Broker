import org.example.connection.Con;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) throws JMSException {
        Connection connection = Con.getConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("MyQueue");
        MessageConsumer d = session.createConsumer(queue);
        System.out.println(((TextMessage) d.receive()).getText());
    }
}
