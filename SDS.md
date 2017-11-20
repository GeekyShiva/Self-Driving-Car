<div align=center>
  <h1>Software Design Specification</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b>
</div><br /><br />

----

##### Product : Project Volantè [![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/sindresorhus/awesome)
##### Description : Self driving RC Car Project
##### Status : Waiting for Review
##### Development Status  : design and developement phase

----

#### Product
  - Current Version : 1.0
  - Current Status : Work in Progress
  - Date : 26-10-2017
   
   
#### Team Project Volantè

- **Dhruv Parashar**  U101115FCS082
- **Shivang Shekhar**  U101115FCS148
- **Sudhanshu Gupta**  U101115FCS160
- **Yash Deepak Vaidya**  U101115FCS182
- **Tanmay Eknath Patil**  U101115FCS164

# 1. Introduction

## 1.1 Purpose of this document

The purpose of this document is to provide a detailed description of the implementation of the project called `Volante`.

The goal of this project is to make an autonomous self-driving car, capable of maneuvering around bends, avoiding obstacles and following traffic signals and road signs.

The tools used in this project and described in this document are:

* TensorFlow library for machine learning
* Vision API by Google Cloud Platform and TensorFlow.

The hardware used in this project and described in this document are:

* RC Car serving as the actual self-driving car
* Arduino Uno used for controlling the car speed and turning radius
* Ultrasonic sensors to detect objects in front of the car
* Raspberry Pi used for capturing and transmission of camera data and communicating with Google Cloud Platform
* PiCamera used for capturing objects in front of the car

## 1.2 Scope of the development project

Road safety has been an issue for as long as cars have been in existence. Over *1.3* million people die of road accidents every year across the globe, most of which are preventable. Ever-rising road traffic has led to an exponential increase in commute time. This has a direct impact not only on people's productivity but also on the environment.

Recent developments in machine learning and artificial intelligence along with the ever-increasing performance of modern day computers have enabled the use of these technologies in developing self-driving cars. These cars have several advantages, as described below:

* Better road safety: Machines are not prone to human-error and distractions, leading to swift and appropriate responses in real-time road conditions.
* Reduced commute time: With cars communicating with each other and using modern GPS systems, commute times can be greatly reduced as self-driving cars reduce the *"phantom effect"* in modern-day traffic.
* Increased productivity: Reduced commute times mean more time can be spent on what matters more.
* Reduced expenditure: Reduction in accidents will directly lead to reduced expenditure on damages.
* Environment-friendly: Efficient driving styles of the self-driving car will lead to lower emissions.
* Solution to parking problem: Most of the modern cities face parking problems and which can be resolved by this solution.
* Better traffic discipline: Better law enforcement can be achieved and traffic can be managed by capping speed in various regions.
* Potential for a new design: Because a vehicle may eventually function as a self-guided train car, the potential for new car designs is huge. With no need for complicated driving tools, self-driving cars could include new ways to relax or to stay entertained.

## 1.3 Definitions, acronyms, and abbreviations

| Term | Description |
| --- | --- |
| User | Any living being who is interacting with the software is a _user_.|
| System | The package of all the components which takes input and gives output to demonstrate the features of the software is called a system. |
| Database | Collection of information on different topics related to each other. |
| Library| The collection of tracks inside a directory or across multiple directories forms up a library.|
| Store | This is the persistence layer of the whole system. |
| Classifier| An algorithm that implements classification, especially in a concrete implementation. |
| Tags | A label attached to track which gives extra information about it. |
| GCP | Google Cloud Platform for running the machine learning algorithm |

## 1.4 References

* This document is written in GitHub flavored Markdown.
* IEEE Standard 1016-1998 Recommended Practice for Software Design Specifications.

## 1.5 Overview of document

This document is divided into several sections (see Table of Contents) with intended readers being developers and software managers. Sections have, however, been written in a manner that it can be understood by anyone having some knowledge about software.

This Software Design Specification also includes:

* System architecture description
* Detailed description of components
* Reuse and relationships to other products
* Design decisions and tradeoffs

The design has been made clear using class diagrams and sequence diagrams.

# 5 Design Decisions And Trade offs

## 5.1 Design Decisions

This project is coded in C, Python and Java. C is used for Arduino, python is used for Raspberry Pi and GCP and java is used for android application.

Goggle Cloud Platform

	Google Cloud Platform provides the right environment for the deployment of Machine-learning algorithms and models.
	Its is one of the cheapest and value for money service with good customer support.

TensorFlow

	It's a machine learning library for developing and implementing machine learning algorithms.
	It is a combination of both customizability and simplicity of use.  

Arduino

	It is an open sourced micro controller. It is easy to use and simple to understand. It is as an interface between the motors, ultra sound sensor and Raspberry Pi 

Raspberry Pi

	It is a small form factor micro processor. It provides the right mix for portability and CPU power for the application.
	It is used for preprocessing the image data and send it to the GCP server.

Google Maps
	
	They are used for real time tracking of the car and also for navigation.
