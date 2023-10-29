package com.github.opticyclic.ai.compilerbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@Service
public class FileMonitorService {

    @Value("${source.directory}") // Directory to monitor
    private String sourceDirectory;

    @Value("${build.directory}") // Directory to store compiled classes
    private String buildDirectory;

    @Value("${jdk.location}") // Location of JDK for compilation
    private String jdkLocation;

    public void startMonitoring() {
        try {
            Path sourceDir = Paths.get(sourceDirectory);
            Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".java")) {
                        compileJavaFile(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void compileJavaFile(Path javaFile) {
        try {
            String javaFilePath = javaFile.toString();
            String packageName = getPackageName(javaFilePath);
            String relativePath = javaFilePath.replace(sourceDirectory, "");

            Path compiledDir = Paths.get(buildDirectory, packageName);
            Files.createDirectories(compiledDir);

            // Compile the Java file using the JDK location
            ProcessBuilder processBuilder = new ProcessBuilder(
                    jdkLocation + "/javac",
                    "-d", compiledDir.toString(),
                    javaFilePath
            );
            processBuilder.inheritIO();
            Process compileProcess = processBuilder.start();
            compileProcess.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPackageName(String javaFilePath) {
        String packageDeclaration = "";
        try {
            String content = new String(Files.readAllBytes(Paths.get(javaFilePath)));
            int packageStart = content.indexOf("package ");
            if (packageStart >= 0) {
                int packageEnd = content.indexOf(";", packageStart);
                packageDeclaration = content.substring(packageStart + 8, packageEnd).trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return packageDeclaration.replace(".", File.separator);
    }
}
