package pl.sharefood.project.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloRestControllerTest {

    @Test
    void sayHello() {
        HelloRestController controller = new HelloRestController();
        String response = controller.get("World");
        assertEquals("Hello,World", response);
    }
}