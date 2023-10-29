# Prompts

This file contains the prompts used to create the project and its commits.

> Write a program using Java and SpringBoot that builds with Gradle. The project with be called CompilerBot. The root package will be com.github.opticyclic.ai.compilerbot. It will monitor a directory (that is passed as the first command line argument) for java files. The java files might be nested in directories to match its package name. When a java file appears it will be moved to a new directory in the build dir of the project. The new directory will be nested to match the package name of the class. The SpringBoot project will then compile the java class using the JDK location passed as the second command line parameter. Code will be commented for clarity.
