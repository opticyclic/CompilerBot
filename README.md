# Compiler Bot

This project is generated as much as possible using ChatGPT.  
Manual changes are made when code hasn't rendered correctly in the chat webpage.  
Prompts are saved in the prompts.md file. 

## Description
Compiler Bot is a command-line Java application that monitors a directory for Java source files, organizes them into a new directory structure, and compiles them using a specified JDK location.

## Features

- Monitors a directory for Java files.
- Organizes Java files into a directory structure matching their package names.
- Compiles Java files using a provided JDK location.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)

### Installation

Clone the repository:

    git clone git@github.com:opticyclic/compiler-bot.git

Navigate to the project directory:

    cd compiler-bot

Build the project using the Gradle Wrapper:

    ./gradlew build

### Usage

Create a configuration file (e.g., **application.properties***) to specify the source directory, build directory, and JDK location:

    source.directory=/path/to/source/directory
    build.directory=/path/to/build/directory
    jdk.location=/path/to/jdk

Run the Compiler Bot application:

    java -jar build/libs/compiler-bot-0.1.jar

The application will start monitoring the source directory, organize and compile Java files.

### Configuration

You can customize the behavior of Compiler Bot by modifying the **application.properties** file. Update the source directory, build directory, and JDK location to fit your project's needs.
