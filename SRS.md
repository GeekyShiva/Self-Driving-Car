# 1. Introduction

## 1.1 Purpose

The purpose of this document is to provide a debriefed view of requirements and specifications of the project called "_Volante_".

Goal of this project is to make an autonomous self-driving car, capable of maneuvering around bends, avoid obstacles and follow traffic signals and road signs.

The tools used in this project and described in this document are:

* TensorFlow library for machine learning
* OpenCV for computer vision

The hardware used in this project and described in this document are:

* RC Car serving as the actual self-driving car
* Arduino Uno used for controlling the car speed and turning radius
* Raspberry Pi used for classifying the camera data and communicating with GCP
* PyCamera used for capturing objects in front of the car

## 1.2 Document Conventions

* All terms are in italics style.
* Main features or important terms are in *bold* style.
* TBD means "To be Decided", these are the components that are not yet decided
* For more references see Terminology

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
