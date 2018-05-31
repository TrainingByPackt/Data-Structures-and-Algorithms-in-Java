package com.packt.datastructuresandalg.setup;

import junit.framework.TestCase;

public class HelloWorldTest extends TestCase {
    public void testHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals(helloWorld.seyHello(), "Hello World!");
    }
}
