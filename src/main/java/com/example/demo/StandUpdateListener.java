package com.example.demo;


import lombok.extern.slf4j.Slf4j;


import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@Dependent
@Slf4j
public class StandUpdateListener implements MessageListener {

//    @Inject
//    private StandNamedBean standNamedBean;

    @Inject
    private TestBean testBean;
//    @EJB
//    private JsonParser jsonParser;

    @Override
    public void onMessage(Message message) {
        try {
            log.info("Message " + message.getJMSMessageID() + " recieved");
            processMessage(message);
        } catch (JMSException e) {
            log.error("Error processing the message", e);
        }
    }

    private void processMessage(Message message) throws JMSException {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
//            StandUpdateDto standUpdateDto = jsonParser.readStandDtoJSON(text);
//            System.out.println(standUpdateDto);
//            standNamedBean.updateStand(standUpdateDto);
            log.info("Message " + message.getJMSMessageID() + " has been processed");
        }
    }
}
