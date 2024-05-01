# Software Architecture Projects

Welcome to our collection of software architecture projects. This repository contains two distinct projects that showcase different approaches to designing and implementing distributed systems. Each project is documented in its own directory with detailed setup and execution instructions.

## Project 1: Implicit-Invocation System

### Objective
The Implicit-Invocation System is designed to automate student course registrations through an event-driven architecture. This project demonstrates how components can communicate effectively within a system without direct coupling, utilizing events to trigger actions across different modules.

### Architecture
This system uses an implicit invocation model where components subscribe to and publish events instead of calling each other directly. This allows for high modularity and easy scalability, as components can be added or replaced without affecting the core functionality.

<p align="center">
  <img src="https://github.com/kevchen266/Software-Architechture-Project/assets/72414426/6ac00132-aedc-41b0-8ca9-9991071fbc90" alt="Implicit Invocation System Architecture" width="644">
</p>

## Project 2: Distributed Software Architecture (RMI)

### Objective
This project provides practical experience with Java Remote Method Invocation (RMI), a method that allows an object residing in one Java Virtual Machine (JVM) to invoke methods on an object in another JVM. This is ideal for building distributed applications where components need to interact over a network.

### Architecture
Utilizing Java RMI, this architecture emphasizes a client-server model where remote objects can be called as easily as local objects. This type of architecture is crucial for applications that require reliable and secure remote procedure calls across different networked environments.

<p align="center">
  <img src="https://github.com/kevchen266/Software-Architechture-Project/assets/72414426/022b59a4-766e-46df-82a8-de6fbd75162e" alt="Distributed Software Architecture" width="646">
</p>

## Exploring the Projects
Each project is housed in its specific folder within this repository. We encourage you to delve into each one to better understand the different architectural paradigms used in distributed systems. For further details, including how to set up and run each project, please refer to the respective project directories.
These projects are designed to provide insights into the architectural choices that can influence system design and functionality, offering a hands-on approach to learning about distributed systems.
