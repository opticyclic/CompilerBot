package com.github.opticyclic.ai.compilerbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;

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

    private String getPackageName(File javaFile) {
        try {
            String content = FileUtils.readFileToString(javaFile, "UTF-8");
            int packageStart = content.indexOf("package ");
            if (packageStart >= 0) {
                int packageEnd = content.indexOf(";", packageStart);
                if (packageEnd >= 0) {
                    String packageLine = content.substring(packageStart, packageEnd);
                    return packageLine.replace("package ", "").trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void compileJavaFile(File javaFile, String packageName) {
        // Implement the logic to compile the Java file with the specified package
        // Replace this with your actual implementation
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "javac",
                    "-d", buildDirectory,
                    "-sourcepath", sourceDirectory,
                    javaFile.getAbsolutePath()
            );
            processBuilder.directory(new File(jdkLocation));
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Compiled: " + javaFile.getName());
            } else {
                System.err.println("Compilation failed: " + javaFile.getName());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
