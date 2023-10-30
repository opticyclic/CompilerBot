package com.github.opticyclic.ai.compilerbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileMonitorService {

    @Value("${source.directory}")
    private String sourceDirectory;

    @Value("${build.directory}")
    private String buildDirectory;

    @Value("${jdk.location}")
    private String jdkLocation;

    @Scheduled(fixedRate = 10000) // Run every 10 seconds
    public void monitorDirectory() {
        // Add your directory monitoring logic here
        File sourceDir = new File(sourceDirectory);

        // Example: List files in the source directory
        File[] files = sourceDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    String packageName = getPackageName(file);
                    compileJavaFile(file, packageName);
                }
            }
        }
    }

    private String getPackageName(File file) {
        // Implement the logic to extract the package name from the Java file
        // Example logic: Parse the file content to find the package declaration
        // Replace this with your actual implementation
        return "com.example"; // Replace with actual package name
    }

    private void compileJavaFile(File file, String packageName) {
        // Implement the logic to compile the Java file
        // Example logic: Use ProcessBuilder to run the Java compiler
        // Replace this with your actual implementation
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "javac",
                    "-d", buildDirectory,
                    "-sourcepath", sourceDirectory,
                    file.getAbsolutePath()
            );
            processBuilder.directory(new File(jdkLocation));
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Compiled: " + file.getName());
            } else {
                System.err.println("Compilation failed: " + file.getName());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
