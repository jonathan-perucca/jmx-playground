package com.github.jperucca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import static com.github.jperucca.Dates.parse;
import static java.util.Optional.ofNullable;

@Component
@ManagedResource(objectName = "com.github.jperucca:name=HelloService")
public class JMXHelloService {

    @Autowired
    private HelloService helloService;

    private String customMessage;

    @ManagedOperation
    public String invoke(String helloMessage, String executionDate) {
        helloService.logHello( ofNullable(helloMessage).orElse(customMessage) );

        return parse(executionDate).toInstant().toString();
    }

    @ManagedAttribute
    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    @ManagedAttribute
    public String getCustomMessage() {
        return customMessage;
    }
}
