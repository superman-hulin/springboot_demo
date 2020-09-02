//package com.rabbitmq;
//
//import com.rabbitmq.Enum.QueueEnum;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @program: config_demo
// * @description: rabbitmq的配置类
// * @author: Su
// * @create: 2020-08-31 12:16
// **/
//@Configuration
//public class RabbitmqConfig {
//
//    /**
//    *@Description: 发送消息到队列
//    *@Param:
//    *@return:
//    *@Author: Su
//    *@date: 2020/8/31
//    */
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
//         RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
//         //改变rabbitmqTemplate对消息的默认系列化，采用json序列化
//         rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//         return rabbitTemplate;
//    }
//
//    /**
//    *@Description: 自定义消息监听器工厂 ，使其支持接收json数据
//    *@Param:
//    *@return:
//    *@Author: Su
//    *@date: 2020/8/31
//    */
//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
//        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory=new SimpleRabbitListenerContainerFactory();
//        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
//        simpleRabbitListenerContainerFactory.setMessageConverter(new Jackson2JsonMessageConverter());
//        return simpleRabbitListenerContainerFactory;
//    }
//
//    /**
//     * 声明类型为Direct的队列交换机
//     *      fanout、headers和topic类型 同理
//     * @return
//     */
//    @Bean
//    public DirectExchange j2pExchange(){
//        return (DirectExchange) ExchangeBuilder
//                .directExchange(QueueEnum.JAVA_TO_PYTHON_QUEUE.getExchange()) //交换机名字
//                .durable(true)  //是否持久化
//                .build();
//    }
//
//    /**
//    *@Description: 声明发送消息到python端的队列
//    *@Param:  防止python端因各种原因未消费该队列中的消息时，引入死信队列
//    *@return:
//    *@Author: Su
//    *@date: 2020/8/31
//    */
//    @Bean
//    public Queue sender(){
//        return QueueBuilder.durable(QueueEnum.JAVA_TO_PYTHON_QUEUE.getName())
//                .withArgument("x-dead-letter-exchange", QueueEnum.JAVA_TO_PYTHON_CANCEL.getExchange())//到期后转发的交换机
//                .withArgument("x-dead-letter-routing-key", QueueEnum.JAVA_TO_PYTHON_CANCEL.getRouteKey())//到期后转发的路由键
//                .withArgument("x-message-ttl", 4000L) //设置该队列上消息的存活时间 队列中的消息存在队列中的时间超过过期时间则成为死信
//                .build();
//    }
//
//    /**
//     * 接收python的消息队列
//     * @return
//     */
//    @Bean
//    public Queue receiver(){
//        return new Queue(QueueEnum.PYTHON_TO_JAVA_QUEUE.getName());
//    }
//
//    /**
//     * 声明发送队列的死信队列
//     */
//    @Bean
//    public Queue cancel(){
//        return new Queue(QueueEnum.JAVA_TO_PYTHON_CANCEL.getName());
//    }
//
//    /**
//     * 绑定发送队列到交换机
//     */
//    @Bean
//    public Binding bindingSender(){
//        return BindingBuilder
//                .bind(sender())
//                .to(j2pExchange())
//                .with(QueueEnum.JAVA_TO_PYTHON_QUEUE.getRouteKey());
//    }
//
//    @Bean
//    public Binding bindingCancel(){
//        return BindingBuilder
//                .bind(cancel())
//                .to(j2pExchange())
//                .with(QueueEnum.JAVA_TO_PYTHON_CANCEL.getRouteKey());
//    }
//
//
//
//}
