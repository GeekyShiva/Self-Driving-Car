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
* Ultrasound sensor to detect objects infront of the car
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

## 1.5 Terminology

| Term | Description |
| --- | --- |
| User | Any living being who is interacting with the software is a _user_.|
| System | The package of all the components which takes input and gives output to demonstrate the features of the software is called a system. |
| Database | Collection of information on different topics related to each other. |
| Library| The collection of tracks inside a directory or across multiple directories forms up a library.|
| Store | This is the persistence layer of whole system. |
| Classifier| An algorithm that implements classification, especially in a concrete implementation. |
| Tags | A label attached to track which gives extra information about it. |
