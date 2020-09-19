package pl.sharefood.project.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void sayHello() {
        HelloController controller = new HelloController();
        String response = controller.hello("World");
        assertEquals("Hello,World", response);
    }
}