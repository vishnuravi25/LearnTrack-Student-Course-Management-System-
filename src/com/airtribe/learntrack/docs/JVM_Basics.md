## What is JDK?

JDK (Java Development Kit) is a complete package used to develop Java applications. It includes tools like the Java compiler (javac), libraries, and the JRE. Developers use JDK to write, compile, and run Java programs.

---

## What is JRE?

JRE (Java Runtime Environment) provides the environment required to run Java programs. It includes the JVM and necessary libraries but does not contain development tools like a compiler.

---

## What is JVM?

JVM (Java Virtual Machine) is the core component that runs Java programs. It takes the compiled bytecode and converts it into machine code so that it can be executed on a specific system.

---

## What is Bytecode?

Bytecode is the intermediate code generated when a Java program is compiled using the javac compiler. It is stored in a .class file and is platform-independent. The JVM reads this bytecode and converts it into machine code for execution.

---

## Hello World Program

### Code:
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```
## Steps to run :
1. Compile the Program
   -Javac HelloWorld.java
2. Run the Program
   -Java HelloWorld
3. Output
   -Hello, World!

## Explanation:
•	javac compiles the Java code into bytecode (.class file)
•	java runs the bytecode using JVM