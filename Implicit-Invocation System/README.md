# Implicit-Invocation System

## Objective
The basic function of the current system is to register students for courses. The system provides rudimentary functionality that supports student registration for courses and various queries, such as listing the courses a student has registered for.

### How to Run the System

1. **Compile all the files**: In your CMD (command prompt) or shell, execute:
``
javac *.java
``

3. **Execute the Main function**: In your CMD (command prompt) or shell, execute:
``
java SystemMain Students.txt Courses.txt
``
   
<p align="center">
<img src="https://github.com/kevchen266/Software-Architechture-Project/assets/72414426/6ac00132-aedc-41b0-8ca9-9991071fbc90" alt="System Image" width="644">
</p>

## Functionality
System functionality is partitioned and encapsulated within each component. Components broadcast to the event bus to request services, or listen on the bus to provide services to other components. Some components only send notifications (announce) to the bus, some only receive (listen), and others do both. A shared data component stores shared state, such as students and courses. It is accessed by certain components through point-to-point data access connectors.

The publish-subscribe implementation is accomplished through the use of Java Observer and Observable classes. The system is initialized by the class, `SystemMain`.

### System Components
- **SystemMain.java**: Has the main() method and creates the system structure by instantiating all of the components and starting the ClientInput component.
- **ClientInput.java**: Presents the main menu and broadcasts service requests to the other components based on user input.
- **ClientOutput.java**: Subscribes to and receives “show” notification. The contents of these notifications are displayed onto the user console.
- **DataBase.java**: Provides access to the student and course lists. Also provides methods for student registration.
- **EventBus.java**: The implicit invocation architecture is implemented using Java Observer/Observable classes. This class provides the basis for the components to be observers and to announce notifications.
- **CommandSet.java**: Provides services to list student/course information and to register a student for a course.
- **\*Handler.java**: Implementation of a component that handles a menu event.
- **Student.java**: Class used to represent a Student in the system.
- **Course.java**: Class used to represent a Course in the system.
- **Courses.txt**: Text file that contains list of courses.



