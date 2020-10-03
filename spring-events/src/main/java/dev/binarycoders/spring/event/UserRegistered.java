package dev.binarycoders.spring.event;

import dev.binarycoders.spring.persistence.model.User;
import org.springframework.context.ApplicationEvent;

public class UserRegistered extends ApplicationEvent {

    public UserRegistered(User user) {
        super(user);
    }
}
