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
        running = true; 
        thread = new Thread(this,"Game");
        thread.start();
    }
    
    private void init() {
        
        if(!glfwInit()) { 
            // Error handling
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwWindowHint(GLFW_RESIZABLE,GL_TRUE);
        window = glfwCreateWindow(width, height ,"Flappy", NULL, NULL);
        
        if(window == NULL) {
        	//ERROR HANDLE
        	return;
        }
        
        // Getting primary monitor video mode for handling windows resolution
        long primaryMonitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidMode = glfwGetVideoMode(primaryMonitor);
        glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);
        glfwMakeContextCurrent(window);
        glfwShowWindow(window);
    }
    
    public void run() {
        init();
        while(running) {
            update();
            render();
            
            if(glfwWindowShouldClose(window)) {
            	running = false;
            }
        }
    }
    
    private void update() {
        glfwPollEvents();
    }
    
    private void render() {
        glfwSwapBuffers(window);
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }
}
