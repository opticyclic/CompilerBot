# CompilerBot

This project is generated as much as possible using ChatGPT.  
Manual changes are made when code hasn't rendered correctly in the chat webpage.  
Prompts are saved in the prompts.md file. 

## Description

CompilerBot is a command-line Java application that monitors a directory for Java source files, organizes them into a new directory structure, and compiles them using a specified JDK location.

## Features

- Monitors a directory for Java files.
- Organizes Java files into a directory structure matching their package names.
- Compiles Java files using a provided JDK location.

## Getting Started

These instructions will help you set up and run the CompilerBot application on your local machine.

### Prerequisites

- Java Development Kit (JDK)
- Gradle

### Installation

Clone the repository:
 
    git clone https://github.com/yourusername/compilerbot.git

Build the project:

    cd compilerbot
    gradle build

### Usage

Create a configuration file (e.g., **application.properties***) to specify the source directory, build directory, and JDK location:

    source.directory=/path/to/source/directory
    build.directory=/path/to/build/directory
    jdk.location=/path/to/jdk

Run the CompilerBot application:

    java -jar build/libs/compilerbot-0.1.jar

The application will start monitoring the source directory, organize and compile Java files.

### Configuration

You can customize the behavior of CompilerBot by modifying the **application.properties** file. Update the source directory, build directory, and JDK location to fit your project's needs.
