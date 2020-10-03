package dev.binarycoders.spring.listener;

import dev.binarycoders.spring.event.UserRegistered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

public class UserListeners {

    // Technical note: By default listener events return 'void'. If an object is returned, it will be published as an event

    /**
     * Example of event listener using the implementation of {@link ApplicationListener}
     */
    static class RegisteredListener implements ApplicationListener<UserRegistered> {

        private static final Logger logger = LoggerFactory.getLogger(RegisteredListener.class);

        @Override
        public void onApplicationEvent(UserRegistered event) {
            logger.info("Registration event received for {}", event);
        }
    }

    /**
     * Example of annotation based event listener
     */
    @Component
    static class RegisteredAnnotatedListener {

        private static final Logger logger = LoggerFactory.getLogger(RegisteredAnnotatedListener.class);

        @EventListener
        void on(final UserRegistered event) {
            logger.info("Annotated registration event received for {}", event);
        }
    }
}
