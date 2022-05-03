package com.example.demo;

public class ClientNew {
    private Reminder reminder;
    private String name;

    public ClientNew(String name, Reminder reminder) {
        this.name = name;
        this.reminder = reminder;
    }

    public void action() {
        this.reminder.increment();
        System.out.printf("%s %d\n", this.name, this.reminder.getInt());
    }
}
