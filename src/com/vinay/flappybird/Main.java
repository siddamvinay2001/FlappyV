package com.vinay.flappybird;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import org.lwjgl.glfw.GLFWVidMode;

public class Main implements Runnable {
    
    private int width = 1280;
    private int height = 720;
    
    private Thread thread;
    private boolean running = false;
    private long window;
    
    public void start() {
        running = true; // Corrected to set running to true
        thread = new Thread(this,"Game");
        thread.start();
    }
    
    private void init() {
        
        if(!glfwInit()) { // Corrected to compare with GLFW_TRUE
            // Error handling
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwWindowHint(GLFW_RESIZABLE,GL_TRUE);
        window = glfwCreateWindow(width, height ,"Flappy", NULL, NULL);
        
        // Getting primary monitor video mode for handling windows resolution
        long primaryMonitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidMode = glfwGetVideoMode(primaryMonitor);
        
    }
    
    public void run() {
        init();
        while(running) {
            update();
            render();
        }
    }
    
    private void update() {
        
    }
    
    private void render() {
        
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }
}
