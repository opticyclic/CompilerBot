# Prompts

This file contains the prompts used to create the project and its commits.

> Write a program using Java and SpringBoot that builds with Gradle. The project with be called CompilerBot. The root package will be com.github.opticyclic.ai.compilerbot. It will monitor a directory (that is passed as the first command line argument) for java files. The java files might be nested in directories to match its package name. When a java file appears it will be moved to a new directory in the build dir of the project. The new directory will be nested to match the package name of the class. The SpringBoot project will then compile the java class using the JDK location passed as the second command line parameter. Code will be commented for clarity.

Only a basic structure for the project was provided.

> Implement the FileMonitorService 

The `build.gradle` wouldn't import into IDEA

> Write a full build.gradle using the minimum dependencies to compile and run this project

The `build.gradle` doesn't look right.

> Why is spring-boot-starter-web and spring-boot-starter-actuator used for this application?

... Explanation ...

> This is a command line application without any monitoring. Write the build.gradle again

Need to document the project

> Create a README.md for this project

Gradle won't run

> I got an error when running my gradle project. > Could not find method application() for arguments [build_8xgrq0adhk4ejws9lnqrwctks$_run_closure3@2293481d] on root project 'compiler-bot' of type org.gradle.api.Project.

Gradle fails

~~~
Execution failed for task ':compileJava'.
> Could not resolve all files for configuration ':compileClasspath'.
   > Could not find org.springframework.boot:spring-boot-starter:.
     Required by:
         project :
~~~

Gradle still fails

> This issue is still occurring after the changes have been made. Rewrite the build.gradle to resolve this issue.

Gradle fails because the application plugin has been removed

> I now get the  Could not find method application() error again.

Can't run gradle when following the README

> When I follow the README to build it says 
> "Command 'gradle' not found, but can be installed with:". 
> Should the README be using the Gradle Wrapper instead? 
> If so, output the whole README.md incorporating the changes.

Rename the project to match the created one in GitHub

> The project name is now compiler-bot and the clone command is git clone git@github.com:opticyclic/compiler-bot.git. Update the README

Application doesn't run

> When I try to run I get the error no main manifest attribute, in build/libs/compiler-bot-0.1.jar

Application is missing Spring jars

> When I run I now get the error "Caused by: java.lang.ClassNotFoundException: org.springframework.boot.SpringApplication". The Spring jars are not in the jar

Gradle will not build again

> I now get the error Could not find method implementation() for arguments [org.springframework.boot:spring-boot-starter] on object of type org.gradle.api.internal.artifacts.dsl.dependencies.DefaultDependencyHandler.
