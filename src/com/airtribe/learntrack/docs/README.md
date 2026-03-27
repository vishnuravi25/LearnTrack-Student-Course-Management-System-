com.airtribe.learntrack
│
├── entity        # Core models (Student, Course, Enrollment)
├── service       # Business logic (StudentService, CourseService, EnrollmentService)
├── ui            # User interaction (Main.java - console menu)
├── exception     # Custom exceptions
└── util          # Helper classes

2
7:49 pm
7:29 pm
1
7:19 pm
7:11 pm
5:56 pm
4:46 pm
4:00 pm
3:59 pm
2:21 pm
1
12:23 pm
11:27 am
11:21 am
9:29 am
9:16 am
7:52 am
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Yesterday
Wednesday
Wednesday
Wednesday
Wednesday
Wednesday
Wednesday
Wednesday
7:20 pm
Tuesday
Tuesday
Tuesday
Get WhatsApp for Mac
Message yourself
Today
Yesterday
Today
A. Environment Setup & JVM Understanding (10 marks)
Install and configure Java (JDK).


Create a file: docs/Setup_Instructions.md with:


JDK version used


Screenshots or brief explanation of “Hello World” program run.


Create docs/JVM_Basics.md explaining in simple language:


What is JDK, JRE, JVM


What is bytecode


What does “write once, run anywhere” mean (1–2 short paragraphs)
6:46 pm
# Setup Instructions

## JDK Version Used
JDK Version: Java 26
Installed from: Oracle / OpenJDK

## Steps to Install & Configure Java

Download the JDK from the official website (Oracle or OpenJDK).
Install the JDK by following the setup instructions.
Set environment variables:
- Set JAVA_HOME to the JDK installation path
- Add the bin folder inside JDK to the system PATH

Verify installation by running:
7:32 pm
---

## Hello World Program

### Code:
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
7:32 pm
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
7:35 pm
Explanation:
	•	javac compiles the Java code into bytecode (.class file)
	•	java runs the bytecode using JVM
7:39 pm
com.airtribe.learntrack
│
├── entity        # Core models (Student, Course, Enrollment)
├── service       # Business logic (StudentService, CourseService, EnrollmentService)
├── ui            # User interaction (Main.java - console menu)
├── exception     # Custom exceptions
└── util          # Helper classes (optional)
7:44 pm
+----------------------+
                 |        Person        |
                 +----------------------+
                 | - id: int            |
                 | - firstName: String  |
                 | - lastName: String   |
                 +----------------------+
                 | + getId()            |
                 | + getFirstName()     |
                 | + getLastName()      |
                 +----------▲-----------+
                            |
                            | (extends)
                            |
                 +----------------------+
                 |       Student        |
                 +----------------------+
                 | - email: String      |
                 | - batch: String      |
                 | - active: boolean    |
                 +----------------------+
                 | + getters/setters    |
                 +----------------------+


+------------------------+         +------------------------+
|        Course          |         |      Enrollment        |
+------------------------+         +------------------------+
| - id: int              |         | - student: Student     |
| - name: String         |         | - course: Course       |
| - description: String  |         | - status: String       |
| - durationWeeks: int   |         +------------------------+
| - active: boolean      |         | + getStudent()         |
+------------------------+         | + getCourse()          |
| + getters/setters      |         +------------------------+
+------------------------+


         +----------------------------------+
         |        IdGenerator (final)       |
         +----------------------------------+
         | - static counter: int            |
         +----------------------------------+
         | + generateId(): int (static)     |
         +----------------------------------+
7:47 pm
+----------------------+
                         |        Person        |
                         +----------------------+
                         | - id: int            |
                         | - firstName: String  |
                         | - lastName: String   |
                         +----------▲-----------+
                                    |
                                    | (extends)
                                    |
                         +----------------------+
                         |       Student        |
                         +----------------------+
                         | - email: String      |
                         | - batch: String      |
                         | - active: boolean    |
                         +----------------------+
                         | + getters/setters    |
                         +----------------------+

     uses ↑                                      uses ↑
          |                                           |
+---------------------------+         +---------------------------+
|     StudentService        |         |      CourseService        |
+---------------------------+         +---------------------------+
| + addStudent()            |         | + addCourse()             |
| + getStudentById()        |         | + getCourseById()         |
| + updateStudent()         |         +---------------------------+
| + deleteStudent()         |                   |
+-------------|-------------+                   |
              |                                 |
              |                                 |
              ▼                                 ▼

        +------------------------+       +------------------------+
        |        Student         |       |        Course          |
        +------------------------+       +------------------------+
                                        | - id: int              |
                                        | - name: String         |
                                        | - description: String  |
                                        | - durationWeeks: int   |
                                        | - active: boolean      |
                                        +------------------------+
                                        | + getters/setters      |
                                        +------------------------+

                          ▲
                          |
                          | (HAS-A)
                          |
                 +------------------------+
                 |      Enrollment        |
                 +------------------------+
                 | - student: Student     |
                 | - course: Course       |
                 | - status: String       |
                 +------------------------+
                 | + getStudent()         |
                 | + getCourse()          |
                 +------------------------+
                          ▲
                          |
                          | uses
                          |
             +-------------------------------+
             |     EnrollmentService         |
             +-------------------------------+
             | + enrollStudent()             |
             | + getEnrollments()            |
             +-------------------------------+

------------------------------------------------------------

             +----------------------------------+
             |     IdGenerator (final)          |
             +----------------------------------+
             | - static counter: int            |
             +----------------------------------+
             | + generateId(): int (static)     |
             +----------------------------------+
submission PR
