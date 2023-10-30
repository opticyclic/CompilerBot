package com.github.opticyclic.ai.compilerbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class FileMonitorService {

    @Value("${source.directory}")
    private String sourceDirectory;

    @Value("${build.directory}")
    private String buildDirectory;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Scheduled(fixedRate = 10000) // Run every 10 seconds
    public void monitorDirectory() {
        // Add your directory monitoring logic here
        File sourceDir = new File(sourceDirectory);

        // Example: List files in the source directory
        File[] files = sourceDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Process the file
                    // You can move or compile files here
                }
            }
        }
    }
}
