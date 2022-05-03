package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        // можно и так Client client = context.getBean("client",Client.class);
        Client client = (Client) context.getBean("client");
        client.showMsg();

        ClientNew clientOne = context.getBean("clientOne", ClientNew.class);
        ClientNew clientTwo = context.getBean("clientTwo", ClientNew.class);
        clientOne.action();
        clientTwo.action();

    }
}
