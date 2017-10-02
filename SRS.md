<div align=center>
  <h1>Software Requirements Specification</h1>
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
   Current Version : 1.0
   Current Status : Work in Progress
   Date : 28-09-2017


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

### Component Diagram

![al](https://github.com/GeekyShiva/FordMotors-SelfDrivingCar/blob/master/Images/model.jpg)

## 2.2 Product Functions

* Autonomous motion
* Obstacle avoidance
* Follows traffic signals
* Follows traffic signs

## 2.3 User Classes and Characteristics

1. **Working Professionals:** They shall be able to better utilize their time, leading to increased productivity.
2. **Elderly and Differently Abled:** Elderly or differently abled users will benefit as it would eliminate their dependence on a hired driver, greatly simplify their mobility.
3. **Others:** No reliance on drivers, reduced commute costs and times shall benefit the population in general.

## 2.4 Operating Environment

An embedded system with the following minimum specifications:

* Operating System: Linux distribution
* Processor: 1.2 GHz ARM processor
* Network: 802.11n Wireless LAN
* Memory: 1GB or more
* GPIO Interface
* Ability to interface with a camera
* Ability to interface with a distance sensor
* Ability to generate PWM signals

**Additional Requirements:** A cloud server able to host a TensorFlow application.

To satisfy the embedded system requirements, we have divided the system into to MCUs, an Arduino Uno and a Raspberry Pi.

We have used Google Cloud Platform as our cloud platform to run our TensorFlow application.

## 2.5 Design and Implementation Constraints

* Heavy processing power for running neural networks for classification, thus necessitating the use of a cloud platform.
* Stable and fast internet connection, as a slow connection can cause a delay in the car’s response to its environment.
* Huge data set so that the car can adapt well to its environment.

## 2.6 Assumption and Dependencies

### 2.6.1 Assumptions

* The basic assumption is that the roads are ideal with no environmental variations like potholes, rash drivers, elevation changes, changing weather conditions etc.
* All traffic signals are clearly visible and not malfunctioning.

### 2.6.2 Dependencies

* Tensorflow
* Cloud ML

# 3. External Interface Requirements

## 3.1 User Interfaces

Since this an autonomous self-driving car, the user does not directly interact with the car. Rather, the car may have some in-dash computer system, like those found in modern day cars.

The in-dash systems, apart from providing entertainment features and vital information like speed and engine RPM, provide navigation aids like GPS as well. They, thus, act as an interface between the user and the car. Such in-dash systems and modifications required for them to work with our system, however, are beyond the scope of this project.

## 3.2 Hardware Interfaces

* The deep neural network, running on the Google Cloud Platform, will communicate with the car using a Raspberry Pi 3. The embedded software in Raspberry Pi will itself communicate with the car using an Arduino Uno. The Arduino Uno will run the car by generating PWM signals sent to an L293D IC to run the motors.

* The Raspberry Pi Camera Module connects onto the Raspberry Pi via a non-standard parallel interface.

* The ultrasonic distance sensor communicates with Arduino using a regular GPIO interface.

## 3.3 Software Interfaces

* The embedded software system on the Raspberry Pi has the following interfaces:

   1. Camera input using a built-in library in Raspbian OS
   2. Speed and turn data output to the Arduino using RPi.GPIO library
   3. Communication with the cloud platform via WiFi using a built-in library in Raspbian OS.

* The embedded software system on the Arduino Uno has the following interfaces:

   1. Direction and speed data input using built-in Arduino libraries
   2. PWM output to motors using built-in Arduino libraries

## 3.4 Communication Interfaces

* The Raspberry Pi will communicate with the Google Cloud Platform over Wifi (IEEE Standard 802.11), using an HTTPS protocol.

* The communication interface between Raspberry Pi and Arduino Uno is a non-standard GPIO interface.

* The communication interface between Arduino Uno and the car motors is a non-standard PWM interface.

# 4. System Features

Following is the use case diagram for the self-driving car

![al](https://github.com/falcon1996/FordMotors-SelfDrivingCar/blob/master/Images/car.jpg)


| Use Case Title | Description |
| --- | --- |
| Clear straight road | The road in front of the car is straight and clear. |
| Encounter left road | The road in front of the car is curving the left, which can be a curve of up to 90 degrees. |
| Encounter right road | The road in front of the car is curving the right, which can be a curve of up to 90 degrees. |
| Inactive traffic signal | There is a traffic signal in front of the car with all its light off. |
| Encounter solid "red" traffic signal | There is a traffic signal in front of the car with a solid red light. |
| Encounter solid "yellow" traffic signal | There is a traffic signal in front of the car with a solid yellow light. |
| Encounter solid "green" traffic signal | There is a traffic signal in front of the car with a solid green light. |
| Encounter flashing "red" traffic signal | There is a traffic signal in front of the car with a flashing red light. |
| Encounter flashing "yellow" traffic signal | There is a traffic signal in front of the car with a flashing yellow light. |
| Encounter "STOP" sign | There is a "STOP" signboard in front of the car. |
| Encounter "GO" sign | There is a "GO" signboard in front of the car. |
| Encounter obstacles | There is an obstacle, like another car or human being, in front of the car. |
| Sudden appearance of an object | An object suddenly appears in front of the car. |

## 4.1 Scenario: Clear straight road

### 4.1.1 Description

There is a clear, straight road in front of the car. The car accelerates straight until a new stimulus is introduced into the environment.

### 4.1.2 Functional Response

The computer vision data is sent to the machine learning model for classification. The machine learning model classifies the path in front of the car to be a clear, straight road. The Arduino, in response, runs the motors at their full speed, accelerating the car to its full speed.

## 4.2 Scenario : Encounter left curve

### 4.2.1 Description

  When encountered with a left curve the car slows down and starts to turn until a new stimulus is introduced into the environment.

## 4.2.1 Function Response

The computer vision data is sent to the machine learning model for classification. When the machine learning model classifies the road ahead as a left turn, the Arduino slows the forward motors down and start the turning the front wheels to the appropriate degrees in the left direction.

## 4.3 Scenario : Encounter right curve

### 4.3.1 Description

  When encountered with a right curve the car slows down and starts to turn until a new stimulus is introduced into the environment.

## 4.3.1 Function Response

The computer vision data is sent to the machine learning model for classification. When the machine learning model classifies the road ahead as a right turn, the Arduino slows the forward motors down and start the turning the front wheels to the appropriate degrees in the right direction.

## 4.4 Scenario: Encounter inactive traffic signal

### 4.4.1 Description

The car encounters an inactive traffic signal right in front of it on the road. The car decreases its speed but continues its motion. The car continues to move at this speed until it has passed the traffic signal, then accelerates and continues its motion with original speed, depending on the environment and the stimulus received.

### 4.4.2 Functional Response

The computer vision data received post-processing results in alerting the Raspberry Pi of the presence of an inactive traffic signal. The Raspberry Pi instructs the Arduino to decrease the car's speed. The Raspberry Pi makes the car to move in the decreased speed until it crosses the traffic signal. Once past the traffic signal, Raspberry Pi instructs the Arduino to accelerate and resume its motion with original speed and waits for the next stimulus.

## 4.5 Scenario: Encounter red traffic signal

### 4.5.1 Description

The car encounters a red traffic signal right in front of it on the road. The car comes to a halt. Reverse motion may be applied, if necessary. The car remains stationary until signal reverts back to green, then resumes its motion, depending on the environment and the stimulus recieved.

### 4.5.2 Functional Response

The computer vision data recived post processing results in alerting the Raspberry Pi of the presence of a red traffic signal. The Raspberry Pi instructs the Arduino to halt the car's motion, applying reversing motion, if necessary. The Raspberry Pi makes car to stay in stationary position as long as traffic signal is not green. Once green, Raspberry Pi instructs the Arduino to accelerate and waits for the next stimulus.


## 4.6 Scenario: Encounter yellow traffic signal

### 4.6.1 Description

The scenario is very similar to 4.5 with the difference that the car encounters a yellow traffic signal right in front of it on the road. The car slowly decreases it's speed and comes to a halt. Reverse motion may be applied, if necessary. The car remains stationary until signal reverts back to green, then resumes its motion, depending on the environment and the stimulus received.

### 4.6.2 Functional Response

The computer vision data received post-processing results in alerting the Raspberry Pi of the presence of a yellow traffic signal. The Raspberry Pi instructs the Arduino to slowly decrease the car's speed and halt its motion, applying reversing motion, if necessary. The Raspberry Pi makes the car to stay in stationary position as long as traffic signal is not green. Once green, Raspberry Pi instructs the Arduino to accelerate and waits for the next stimulus.

## 4.7 Scenario: Encounter GREEN Signal

### 4.7.1 Description

There is a traffic signal in front of the car with a solid green light. If a GREEN Signal is encountered, the car accelerates straight until a new stimulus is introduced in the environment.

### 4.7.2 Functional Response
The computer vision data received post-processing results in alerting the Raspberry Pi of the presence of a green signal. The Raspberry Pi instructs the Arduino to accelerate and waits for the next stimulus.

## 4.8 Scenario: Encounter flashing RED Signal

### 4.8.1 Description

There is a traffic signal in front of the car with a flashing red light. A flashing red light means come to a complete stop, then proceed when you can

### 4.8.2 Functional Response

The computer vision data received post-processing results in alerting the Raspberry Pi of the presence of a flashing red signal. The Raspberry Pi instructs the Arduino to halt the car's motion. The Raspberry Pi waits for a fixed timeout, before instructing the Arduino to accelerate and waits for the next stimulus.

## 4.9 Flashing Yellow Light

### 4.9.1 Description

When encountered with a flashing yellow light the car slows down and enters into an alert state.  

### 4.9.2 Function Response

The computer vision data is sent to the machine learning model for classification. When the machine learning model classifies that there is a yellow flashing light in front, the Arduino slows the motors and the model enters into an alert state.

## 4.10 Scenario: Encounter STOP Sign

### 4.10.1 Description

There is a "STOP" sign board in front of the car. If a STOP sign is encountered, the car will stop for 5 seconds, then move forward  until a new stimulus is introduced in the environment.

### 4.10.2 Functional Response

The computer vision data received post-processing results in alerting the Raspberry Pi of the presence of a STOP sign. The Raspberry Pi instructs the Arduino to halt the car's motion. The Raspberry Pi waits for a fixed timeout, before instructing the Arduino to accelerate and waits for the next stimulus.

## 4.11 Scenario: Encounter GO sign

### 4.11.1 Description

The car encounters a GO signboard in front of it. The car comes to a halt, waits for a timeout, then resumes its motion, depending on the environment and the stimulus received.

### 4.11.2 Functional Response

The computer vision data received post-processing results in alerting the Raspberry Pi of the presence of a GO sign. The Raspberry Pi instructs the Arduino to halt the car's motion. The Raspberry Pi waits for a fixed timeout, before instructing the Arduino to accelerate and waits for the next stimulus.

## 4.12 Scenario: Encounter obstacle (Case of Normal Braking)

### 4.12.1 Description

The car encounters an obstacle right in front of it. The car comes to a halt, and waits for the obstacle to be cleared before resuming normal operation.

### 4.12.2 Functional Response

The computer vision data received, along with the data from the distance sensor, alerts the Raspberry Pi of the presence of an obstacle. The Raspberry Pi instructs the Arduino to halt the car's motion. The car remains stationary so long as the obstacle is present. Once cleared, the Raspberry Pi instructs the Arduino to accelerate and waits for the next stimulus.

## 4.13 Scenario: Sudden appearance of an object in front of the car (Case of Emergency Braking)

### 4.13.1 Description

This scenario is very similar to 4.12, with the difference that the object suddenly pops in front of the car, without any warning whatsoever. The car attempts an immediate halt. Reverse motion may be applied, if necessary. Until the obstacle is cleared, the car remains stationary, post which it resumes normal operation.

### 4.13.2 Functional Response

The computer vision data received, along with the data from the distance sensor, alerts the Raspberry Pi of the sudden appearance of an object in front of the car. The Raspberry Pi instructs the Arduino to immediately halt the car's motion, applying reversing motion, if necessary. The car remains stationary so long as the obstacle is present. Once cleared, the Raspberry Pi instructs the Arduino to accelerate and waits for the next stimulus.

# 5. Other Nonfunctional Requirements

## 5.1 Performance Requirements

* Robustness: Vehicle should be robust enough to deal with and act accord to changes in road and tire conditions without losing too much performance.

* Quickness: Vehicle's embedded system should be fast enough to interact with the cloud and exchange data with it on the go while responding to the user actions without any shattering or buffering.

* Failure Handling: In case of failures due to unavoidable reasons, the vehicle should be able to recover quickly.

* Detection and Response time: TBD

* Battery Life: TBD

* Workload (How the performance of the self-driving car changes with time of the day or traffic conditions on the road): TBD

* Scalability: TBD

* Typical throughput required: TBD

Please Note:  _All **TBD** points are kept under check and will only be updated once we get a clearer response and valid as well as computable data to determine the conditions_  

## 5.2 Safety Requirements

* Systems Safety: Vehicle will be tested in different environments to make sure it responds safely to software malfunctions, near crashes, near breakdowns, loss of traction and other risks.

* Ethical Considerations: Humans have to take instant ethical decisions several times when on road. The car will also be programmed to make ethical decisions in case of emergency.

* Detection and Response: Vehicle will be able to detect and respond to other vehicles, pedestrians, animals and traffic signals. It will be able to change lanes, take turns and overtake other vehicles on the road based on the detection.

* Laws and Practices: Vehicle will follow laws of the location it is being operated in. It will be able to recognize different speed limits and traffic rules of different states and cities. The vehicle should be able to violate the law to avoid any fatal accident.

* Certifications: Any new software updates or driverless features must be submitted and get verified from N.H.T.S.A. (for the USA)

## 5.3 Security Requirements

* Data Sharing: Self-driving car collects a lot of data on the go. Data and statistics storage will be done to maintain the correct functioning of the car and to reconstruct what went wrong in case of a breakdown.

* Digital Security: Vehicle will be engineered to prevent online threats. All communications between Raspberry Pi and the GCP will be encrypted using SSL.

## 5.4 Software Quality Attributes

* Compatibility: Any additional feature that will be added to the self-driving car should peacefully co-exist with existing features.

* Error Handling: Vehicle should not cause or trigger any events that create an accident-prone situation on the road under events like loss of network.

## 5.5 Business Rules

* Open Source: This software is an Open Source software.

* Guidelines: Unless required by applicable law or agreed to in writing, software distributed is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
