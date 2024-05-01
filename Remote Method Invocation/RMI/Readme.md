# Distributed Software Architecture: Remote Method Invocation

## Objective
The objective of this lab assignment is to gain practical experience in building a distributed software system using Java Remote Method Invocation (RMI). A distributed software system is a model where components on networked computers interact by exchanging messages to achieve a common goal.

<p align="center">
  <img src="https://github.com/kevchen266/Software-Architechture-Project/assets/72414426/022b59a4-766e-46df-82a8-de6fbd75162e" alt="Distributed System Architecture" width="646">
</p>

## Architecture of the Distributed System
Refer to the above image for the architecture diagram of the current framework. The system includes the following components:

- **Student.java**: Defines the Student class within the system.
- **Course.java**: Defines the Course class within the system.
- **Courses.txt**: A text file containing a list of courses.
- **Students.txt**: A text file containing a list of students.
- **Database.java**: This interface is designed for data access operations, specifically reading data from Courses.txt and Students.txt. Classes implementing the IActivity interface will utilize the implementations of Database.java at runtime to fetch necessary data.
- **Client.java**: This client-side component is responsible for interfacing with remote objects based on user input. It incorporates a command line interface (CLI) that allows users to invoke specific remote methods.
- **IActivity.java**: An interface that extends java.rmi.Remote, which includes the execute() method for remote execution. Implementations of this interface, such as ListStudents, encapsulate their specific logic — for instance, listing all students — within the execute() method to be invoked remotely via RMI.














Distributed Software Architecture
: Remote Method Invocation

Objective:
The objective of this lab assignment is to gain practical experience in building a distributed software
system using Java Remote Method Invocation (RMI). A distributed software system is a model where
components on networked computers interact by exchanging messages to achieve a common goal.

<img width="323" alt="image" src="https://github.com/kevchen266/Software-Architechture-Project/assets/72414426/022b59a4-766e-46df-82a8-de6fbd75162e">


Architecture of the Distributed System

Refer to Figure 1 for the architecture diagram of the current framework.
The system includes the following components:

● Student.java: Defines the Student class within the system.

● Course.java: Defines the Course class within the system.

● Courses.txt: A text file containing a list of courses.

● Students.txt: A text file containing a list of students.

● Database.java: This interface is designed for data access operations, specifically reading data
from Courses.txt and Students.txt. Classes implementing the IActivity interface will utilize the
implementations of Database.java at runtime to fetch necessary data.

● Client.java: This client-side component is responsible for interfacing with remote objects based
on user input. It incorporates a command line interface (CLI) that allows users to invoke specific
remote methods.

● IActivity.java: An interface that extends java.rmi.Remote, which includes the execute() method
for remote execution. Implementations of this interface, such as ListStudents, encapsulate
their specific logic — for instance, listing all students — within the execute() method to
be invoked remotely via RMI
