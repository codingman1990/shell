package com.codingman.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import java.util.concurrent.atomic.AtomicBoolean;

@ShellComponent
public class ShellCommands {
    private AtomicBoolean check = new AtomicBoolean(false);

    @ShellMethod("Add two integers together.")
    public int add(int a, int b) {
        check.set(true);
        return a + b;
    }

    @ShellMethod(key = "test", value = "test!", group = "haha")
    public String test(@ShellOption String tt) {
        return tt;
    }
    @ShellMethodAvailability("test")
    public Availability check() {
        return check.get() ? Availability.available() : Availability.unavailable("false");
    }
}
