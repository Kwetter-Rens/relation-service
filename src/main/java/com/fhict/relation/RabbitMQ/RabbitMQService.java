package com.fhict.relation.RabbitMQ;

import java.util.List;

import com.fhict.relation.models.Relation;
import com.fhict.relation.services.RelationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQService implements RabbitListenerConfigurer {

    @Autowired
    RelationService relationService;

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    @SendTo("kwetter.following.replies")
    public List<String> getFollowingUserIdsByUserId(String userId) {
        return relationService.getByUserId(userId);
    }
}
