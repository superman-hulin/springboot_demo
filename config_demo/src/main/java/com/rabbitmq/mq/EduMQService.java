package com.rabbitmq.mq;

import com.rabbitmq.Enum.QueueEnum;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author : molamola
 * @Project: edu
 * @Description:
 * @date : 2019-12-17 10:06
 **/
@Service
public class EduMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //发送消息，即往哪个交换机、路由键是什么
    public Boolean sendMessageToMQ(String message){
        rabbitTemplate.convertAndSend(QueueEnum.JAVA_TO_PYTHON_QUEUE.getExchange(),
                QueueEnum.JAVA_TO_PYTHON_QUEUE.getRouteKey(),
                message);
        return true;
    }


    // 消息确认消费
    public void ackMessage(Channel channel, Message message) {
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 消息拒绝
    public void rejectMessage(Channel channel, Message message) {
        try {
            //如果b为true，则RabbitMQ会重新将这条消息存入队列，以便可以发送给下一个订阅的消费者。否则RabbitMQ立即会把消息从队列中移除
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
