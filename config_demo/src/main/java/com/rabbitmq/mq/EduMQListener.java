package com.rabbitmq.mq;


import com.rabbitmq.Enum.QueueEnum;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author : molamola
 * @Project: edu
 * @Description: 队列监听器
 * @date : 2019-12-17 10:30
 **/
@Component
public class EduMQListener {

    @Autowired
    private EduMQService mqService;


    @RabbitHandler
    @RabbitListener(queues = QueueEnum.PYTHON_TO_JAVA_QUEUE_NAME, containerFactory="rabbitListenerContainerFactory")
    public void handler(String message, Channel channel, Message msg){
        System.out.println(message);
        //确认消费，这样队列才会把该消息清除掉
        mqService.ackMessage(channel, msg);
        }

    /**
     * 死信队列监听
     */
    @RabbitHandler
    @RabbitListener(queues = QueueEnum.PYTHON_TO_JAVA_QUEUE_CANCEL_NAME)
    public void handlerCancel(String message, Channel channel, Message msg) {
        System.out.println(message);
        // 拒绝消费该消息
        mqService.rejectMessage(channel, msg);
        //根据实际业务判断该消息是否需要重发，若需要则重发
        mqService.sendMessageToMQ(message);


        }
    }
