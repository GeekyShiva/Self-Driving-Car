**** This file yet to be updated soon please refer SRS.md meanwhile ****

<div align=center>
  <h1>Ford Motors Self-Driving Car</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b>
</div><br /><br />


##### Product : Project Volantè [![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/sindresorhus/awesome)
##### Description : Self driving RC Car Project
##### Status : Waiting for Review
##### Development Status  : design and developement phase

----

#### Product
  - Current Version : 1.0
  - Current Status : Work in Progress
  - Date : 03-10-2017
   
   
#### Team Project Volantè

- **Dhruv Parashar**  U101115FCS082
- **Shivang Shekhar**  U101115FCS148
- **Sudhanshu Gupta**  U101115FCS160
- **Yash Deepak Vaidya**  U101115FCS182
- **Tanmay Eknath Patil**  U101115FCS164



# FordMotors-SelfDrivingCar
This repository is for self driving car project for Ford Motors India.

---------------------------------------- Read our project below -------------------------------------------------------------


# 1. Introduction

## 1.1 Purpose

The purpose of this document is to provide a debriefed view of requirements and specifications of the project called `Volante`.

The goal of this project is to make an autonomous self-driving car, capable of maneuvering around bends, avoiding obstacles and following traffic signals and road signs.

The tools used in this project and described in this document are:

* TensorFlow library for machine learning
* Vision API by Google Cloud Platform and TensorFlow.

The hardware used in this project and described in this document are:

* RC Car serving as the actual self-driving car
* Arduino Uno used for controlling the car speed and turning radius
* Ultrasonic sensor to detect objects in front of the car
* Raspberry Pi used for capturing and transmission of camera data and communicating with Google Cloud Platform
* PiCamera used for capturing objects in front of the car

## 1.2 Document Conventions

* All terms are in _italics_ style.
* Main features or important terms are in *bold*.
* TBD means "To be Decided". These are the components that are not yet decided.
* For more references see Terminology.

## 1.3 Intended Audience and Reading Suggestions

Anyone with some programming experience, with familiarity in Python and C, can understand this document. The document is intended for developers, software architects, testers, project managers and documentation writers.

This Software Requirement Specification also includes:

* Overall description of the product
* External interface requirements
* System Features
* Other nonfunctional requirements

## 1.4 Product Scope

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

## 1.5 References

* This document is written in GitHub flavored Markdown.
* IEEE Standard 830-1998 Recommended Practice for Software Requirements Specifications.

## 1.6 Terminology

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

# 2. Overall Description

## 2.1 Product Perspective
This system consists of following components:

* RC Car: analogous to real-world car and tries to mimic it
* Machine Learning Model: makes decisions as to how the car should move
* Arduino and Raspberry Pi: along with motors, form the car’s underlying hardware
* PiCam: collects visual data
* Ultrasonic Sensor (HC - SR04): collects distance data

**RC Car** acts as an analog to the real world car with basic motion capabilities. It is battery operated.

The **Machine Learning Model** guides the car in the environment based on the data set on which it is trained. The model uses neural networks as the underlying learning framework.

**Arduino Uno** controls the actual car’s hardware. It runs the car’s motors and collects distance from the HC-SR04 ultrasonic sensor. This data is then sent to the Raspberry Pi for processing.

**Raspberry Pi** act as interfaces between the Arduino and GCP. While Arduino controls the motion of the car itself, Raspberry Pi processes visual data collected using PiCam, transferring it to GCP server for classification.

