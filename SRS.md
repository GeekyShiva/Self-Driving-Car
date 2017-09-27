 <div align=center>
   <h1>Software Requirements Specification</h1>
   <h2>Project Volantè</h2>
   <b> Self Driving Car </b><br />
   <b> Version <i>1.0</i></b>
</div><br /><br />

# 1. Introduction

## 1.1 Purpose

The purpose of this document is to provide a debriefed view of requirements and specifications of the project called `Volante`.

Goal of this project is to make an autonomous self-driving car, capable of maneuvering around bends, avoid obstacles and follow traffic signals and road signs.

The tools used in this project and described in this document are:

* TensorFlow library for machine learning
* Vision API by Google Cloud Platform and Tensor Flow.

The hardware used in this project and described in this document are:

* RC Car serving as the actual self-driving car
* Arduino Uno used for controlling the car speed and turning radius
* Ultrasonic sensor to detect objects infront of the car
* Raspberry Pi used for capturing and transmission of camera data and communicating with Google Cloud Platform
* PiCamera used for capturing objects in front of the car

## 1.2 Document Conventions

* All terms are in _italics_ style.
* Main features or important terms are in *bold*.
* TBD means "To be Decided", these are the components that are not yet decided
* For more references see Terminology

## 1.3 Intended Audience and Reading Suggestions

Anyone with some programming experience, with familiarity in Python and C can understand this document. The document is intended for developers, software architects, testers, project managers and documentation writers.

This Software Requirement Specification also includes:

* Overall description of the product
* External interface requirements
* System Features
* Other non functional requirements

## 1.4 Product Scope

Road safety has been an issue for as long as cars have been in existence. Over *1.3* million people die of road accidents every year across the globe, most of which are preventable. Ever rising road traffic has led to an exponential increase in commute time. This has a direct impact not only on people’s productivity, but also on the environment.

Recent developments in machine learning and artificial intelligence, along with the ever increasing performance of modern day computers has enabled the use of these technologies in developing self-driving cars. These cars have several advantages, as described below:

* Better road safety: Machines are not prone to human-error and distractions, leading to swift and appropriate responses in real-time road conditions.
* Reduced commute time: With cars communicating with each other and using modern GPS systems, commute times can be greatly reduced as self driving cars reduce the *"phantom effect"* in modern day traffic.
* Increased productivity: Reduced commute times mean more time can be spent on what matters more.
* Reduced expenditure: Reduction in accidents will directly lead to reduced expenditure on damages.
* Environment friendly: Efficient driving styles of the self driving car will lead to lower emissions.
* Solution to Parking Problem: Most of the modern cities face parking problems and which can be resolved by this solution.
* Speed Limits: Better Law enforcement can be achieved and traffic can be manged by capping via speed in various regions.
* Potential For New Design: Because a vehicle may eventually function as a sort of self guided train car, the potential for new car designs is huge. With no need for complicated driving tools, self-driving cars could include new ways to relax or to stay entertained

## 1.5 References

* This document is written in GitBub flavored Markdown.
* IEEE Standard 830-1998 Recommended Practice for Software Requirements Specifications.

## 1.6 Terminology

| Term | Description |
| --- | --- |
| User | Any living being who is interacting with the software is a _user_.|
| System | The package of all the components which takes input and gives output to demonstrate the features of the software is called a system. |
| Database | Collection of information on different topics related to each other. |
| Library| The collection of tracks inside a directory or across multiple directories forms up a library.|
| Store | This is the persistence layer of whole system. |
| Classifier| An algorithm that implements classification, especially in a concrete implementation. |
| Tags | A label attached to track which gives extra information about it. |
| GCP | Gooogle Cloud Platform for running the machine learning algorithm |
# 2 Overall Description

## 2.1 Product Perspective

This system consists of following components:

* RC Car, it is analogous to real world car and tries to mimic it
* Machine Learning Model, it makes decisions as to how the car should move
* Arduino and Raspberry Pi, they control the car’s underlying hardware
* PiCam, it collects visual data
* Ultrasonic Sensor (HC - SR04), it collects distance data

**RC Car** acts as an analog to the real world car with basic motion capabilities. It is battery operated.

The **Machine Learning Model** guides the car in the environment based on the data set on which it is trained. The model uses neural networks as the underlying learning framework.

**Arduino Uno** controls the actual car’s hardware. It runs the car’s motors, and collects distance from the HC-SR04 ultrasonic sensor. This data is then sent to the Raspberry Pi for processing.

**Raspberry Pi** act as interfaces between the Arduino and GCP. While Arduino controls the motion of the car itself, Raspberry Pi processes visual data collected using PiCam, transferring it to GCP server for classification.

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

To satisfy the above requirements, we have divided the system into to MCUs, an Arduino Uno and a Raspberry Pi.

## 2.5 Design and Implementation Constraints

* Heavy processing power for running neural networks for classification, thus necessitating the use of a cloud platform.
* Stable and fast internet connection, as a slow connection can cause a delay in the car’s response to its environment.
* Huge data set so that the car can adapt to its environment.

## 2.6 Assumption and Dependencies

### 2.6.1 Assumptions

* The basic assumption is that the roads are ideal with no environmental variations like potholes, rash drivers, elevation changes, changing weather conditions etc.
* All traffic signals are clearly visible and not malfunctioning.

### 2.6.2 Dependencies

* Tensorflow
* Cloud ML

# 3. External Interface Requirements

## 3.1 User Interfaces

Since this an autonomous self-driving car, the user does not directly interact with the car. Rather, the car may have some in-dash computer like system, like those found in modern day cars.

The in-dash systems, apart from providing entertainment features and vital information like speed and engine RPM, provide navigation aids like GPS as well. They, thus, act as an interface between the user and the car. Such in-dash systems and modifications required for them, however, are beyond the scope of this project.

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


# 5 Other Nonfunctional Requirements


## 5.1 Performance Requirements

* Robustness : Vehicle should be robust to deal and act accordingly with respect to all road and tire conditions without decreasing too much performance .

* Quickness : Vehicle should be fast enough to interact with cloud and exchange data on the go and respond to any of the user action in any way without any shattering or buffering.

* Failure Handling : In case of failures it should be able to fail or recover quickly.

* Detection and Response time : TBD

* Battery Life : TBD

* Workload (How performance of the self-driving car changes with time of the day as traffic changes on the road.) : TBD

* Scalability : TBD

* Typical throughput required : TBD

* Platform : TBD

Out of Scope

* Fallback : Vehicle will be able to change modes in case of an accident.


## 5.2 Safety Requirements

* Systems Safety : Vehicle will be tested in different environments to make it respond safely to software malfunctions, near crashes, near breakdowns, loss of traction and other risks.

* Ethical Considerations : Humans have to take ethical decisions instantly several times on road, car will also be programmed to make ethical decisions in case of emmergency.

* Detection and Response : Vehicle will be able to detect and respond to other vehicles and pedestrians, animals and various objects. It will be able to change lanes, take turns, overtake other vehicles on the road based on the detection.

* Laws and Practices : Vehicle will follow laws of the location it is being operated in. It will be able to recognize different speed limits and traffic rules of different states and cities. Vehicle should be able to violate the law to avoid an accident.

* Certifications : Any new software updates or driverless features must be submitted  and get verified from N.H.T.S.A. (for USA)

Out of Scope

* Crash Worthiness : Vehicle will be built to best protect occupants in a crash and sustain damages.

* Post-Crash Behavior : Vehicle will be safe to use again after a crash. Auto-drive mode will not be enabled until sensors are enabled.


## 5.3 Security Requirements

* Data Sharing : Self driving car collects a lot of data on the go. Data and stats storage will be done to maintain correct functioning of the car and to reconstruct what went wrong in case of breakdown.

* Digital Security : Vehicle will be engineered to prevent online threats, here encrypted data will be send and received between raspberry pi and cloud.

Out of scope

* Privacy : Vehicle owner will have the authority on the type of data being collected by the self-driving car.


## 5.4 Software Quality Attributes

* Compatibility	: System should peacefully co-exist with other software.

* Error Handling : Vehicle should not cause or trigger any events that create accident-prone situation on the road under events like loss of network .

## 5.5 Business Rules

* Open Source : This software is an Open Source software.

* Guidelines : Unless required by applicable law or agreed to in writing, software distributed is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

