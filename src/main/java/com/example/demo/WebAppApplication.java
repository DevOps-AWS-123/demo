package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
class WebappApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the background task
        Thread backgroundTask = new Thread(this::runBackgroundTask);
        backgroundTask.start();

        // Listen for key presses to exit
        listenForExit();
    }

    private void runBackgroundTask() {
        try {
            while (true) {
                // Simulate a background task
                System.out.println("Running background task...");
                Thread.sleep(2000); // Simulate work (2 seconds)
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Background task interrupted!");
        }
    }

    private void listenForExit() {
        System.out.println("Press Enter to exit the application...");

        // Use BufferedReader to listen for key presses
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine(); // Wait for user input
            System.out.println("Exiting application...");
            System.exit(0); // Exit the application
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
