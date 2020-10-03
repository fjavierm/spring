package dev.binarycoders.spring.service;

import dev.binarycoders.spring.event.UserRegistered;
import dev.binarycoders.spring.persistence.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final ApplicationEventPublisher publisher;

    public UserService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void register(final User user) {
        logger.info("Registering {}", user);

        publisher.publishEvent(new UserRegistered(user));
    }
}
