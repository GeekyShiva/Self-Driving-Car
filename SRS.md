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
