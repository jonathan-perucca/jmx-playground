package com.github.jperucca;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

@Service
public class HelloService {

    private static final Logger logger = getLogger(HelloService.class);
    private int counter = 0;

    void logHello(String helloMessage) {
        final String log = format("Hello was said %d times : %s", ++counter, helloMessage);

        logger.info(log);
    }
}
