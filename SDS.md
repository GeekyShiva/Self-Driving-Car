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
- **Tanmay Ekanath Patil**  U101115FCS164

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

# 2. Conceptual Architecture

![Architecture Diagram](Images/architecture-diagram.jpg?raw=true)

## 2.1 Overview of modules and components

1. Arduino UNO Rev. 3

    * **Communication Driver:** This software driver is responsible for the UART communication link between the Arduino and Raspberry Pi. It specifies the baud rate as well as the format of the data sent.

    * **Motor Driver:** This software driver is responsible for running the car's motors at the desired speed and direction. It also controls the car's degree and direction of turn.

    * **Ultrasonic Sensor Driver:** This software driver is responsible for running the three ultrasonic sensors attached on to the car. This driver ensures that the distance data is captured every 50ms using a timer interrupt on the Arduino.

2. Car

    * **DC Motor:** These motors are responsible for actually running the car.

    * **Ultrasonic Sensors:** These sensors collect distance data from the front, front-left and front-right sides of the car. These sensors use ultrasonic signals to collect data, which is then sent to the Arduino for processing.

3. Cloud Platform

    * **Machine Learning Algorithm:** The machine learning algorithm is at the heart of this project. The model processes visual data from the PiCamera and distance data from the ultrasonic sensors to judge the car's environment. This judgement is used by the Raspberry Pi to control the car's motion.

    * **Storage:** Apart from the actual machine learning algorithm, the cloud platform also provides with a big and reliable storage space for storing all the training and testing data for the algorithm.

4. PiCamera

    The **PiCamera** module will be used to capture 800x600 at 60fps for quick capture and reduced photo size. The PiCamera data is processed by the machine learning algorithm to judge the car's environment.

5. Raspberry Pi 3 Model B

     * **Communication Driver:** This software driver is responsible for the UART communication link between the Arduino and Raspberry Pi. It specifies the baud rate as well as processes the received data into the required format.

     * **Machine Learning API:** This API enables the Raspberry Pi to communicate with the machine learning algorithm running in the cloud. It provides support for sending image data and receiving classification information for it.

     * **PiCamera Driver:** This software driver is responsible for communicating with PiCamera module and extracting image data from it for use for classification.

## 2.2 Structure and relationships

The structure and hierarchy of the system can be understood from the following structural diagram.

![Structural Diagram](Images/structure.jpg?raw=true)


# 3. Logical Architecture

# Class Diagram 

![Class Diagram](Images/class%20diagram.jpg?raw=true)

# Sequence Diagram
![Design Diagram](Images/designdoc.jpg?raw=true)

## 3.1 Component: Phone
![Phone](Images/phone.png?raw=true)

Description: This component as a whole handles functionality related to sending image frames and direction to Google Cloud Storage.

### Class: DirectionsJSONParser

Description: Processes the response from the Google Maps API


| function | input | output | description |
|----------|-------|--------|-------------|
| + parse(jObject : JSONObject) :  List<List<HashMap<String,String>>> | jObject: JSON Object from the Google Maps API |  parses the json object obtained from the url  | Receives a JSONObject and returns a list of lists containing latitude and longitude |
| + decodePoly(encoded : String) : List  | encoded: A string that contains data about multiple lines that are on the road | returns a list with points in the polyline |  Method to decode polyline points|


### Class: MapsActivity

Description: It is responsible for App UI changes and for sending image frames and direction to Google Cloud Storage.


| function | input | output | description |
|----------|-------|--------|-------------|
| + makeDataForGCP() : void | - | -  | Uses compass data and current location to determine where to turn (Left, Right or None) and the amount to turn in degrees |
| + sendImageToGCP() : void | - | - |  Sends images obtained from the back camera to Google Cloud Storage|
| + sendJSONToGCP() : void | - | - |  Sends JSONs obtained from the makeDataForGCP method to Google Cloud Storage|
| + getDirectionsUrl(origin : LatLng, dest : LatLng) : String | origin : Current Location of the car, dest: Destination set by the user | returns a url as string of the web service |  Builds the url to the web service|
| + downloadUrl(strUrl : String) : String | strUrl : url of the web service | returns json data as string | A method to download json data from url|



### Class: Data

Description: This class stores data like current location, compass heading. It then can be used by other classes.


| function | input | output | description |
|----------|-------|--------|-------------|
| + getCurrentLocation(): LatLng | - | returns current latitude and longitude of car  | A method to obtain current location of the car|
| + getDirection() : String | - | returns Left,Right or None |  A method to get the direction where the car has to turn |
| + getJsonObject() : JSONObject| - | returns a JSONObject | A method to get json object which is to be sent to GCP |
| + makeJSON() : void | - | - | A method to build a json object |
| + setCurrentLocation(c : LatLng) : void | c : latitude and longitude of current location | - | A method to store current location of the car|
| + setDirection(d : String) : void | d : Left,Right or None | - | A method to store the direction where the car has to turn|
| + setDiffHeading(d : float) : void | d : amount the car has to turn   | - | A method to store the amount of turning that the car has to do |

## 3.2 Component:  Arduino
![Arduino](Images/arduino.png?raw=true)

Description: This component as a whole handles functionality related to movement of car.

### Class : ContactRaspberryPi

Description: This class accepts motion information from Raspberry Pi.

| function | input | output | description |
|----------|-------|--------|-------------|
| + echoCheck() | - | - | Collects distance data from the current sensor if its ping is complete. |
| + writeDistanceData() | - | - | Writes distance data to the UART channel. |
| + initSpeedPins() | - | - | Initializes pins for speed control I/O. |
| + readSpeedInput() | - | Speed data in the range [0,7] | Reads and returns speed control data. |
| + writeSpeedData(direction : unsigned int, percent : unsigned int)| direction: Direction of the car's motion <br /> percent: Speed of the car in percentage terms. | - | Configure the speed control motors to run at 'percent' percentage of their capacity in 'direction' direction. |
| + initTurnPins() | - | - | Initializes pins for turn control I/O. |
| + readTurnInput() | - | Turn data in the range [0,7]. | Reads and returns turn control data. |
| + writeTurnData(direction : unsigned int, percent : unsigned int) | direction: Direction of the car's turn. <br /> percent: Degree of the car's turn in percentage terms. | - | Configures the turn motors to turn in 'percent' percentage in 'direction' direction. |

## 3.3 Component: Google Cloud Platform
![GCP](Images/GCP.png?raw=true)

Description: This component takes images and JSON from Android 

### Class : CallPi

Description: All the ML functionalities and detections like image detection, text detection are take place here.

| function | input | output | description |
|----------|-------|--------|-------------|
| + receiveImageAndroid() | Images from Android device | -| Recieves Android Image files in GCP container. |
| + receiveJSONAndroid() | JSON from Android device | -| Recieves Android JSON files in GCP container.|
| + classifyImage() | Image | - | Classifies the image. |
| + returnImage() | - | Classified Data  | Returns classified data.|


## 3.4 Component: Raspberry Pi
![Pi](Images/RaspberryPi.png?raw=true)

Description: This component acts as a bridge between ML functions and basic driving functionality of the car. It helps to transfer high level abstraction to machine code. 

#### Class : CallGCP

Description: It sends request to data stored in GCP to classify images and detect road which helps for driving assistance. It sends request to data stored in GCP to classify images and detect different labels which helps for driving assistance.

| function | input | output | description |
|----------|-------|--------|-------------|
| + road_detected(status : Boolean, signal : String) : String,float,int |status:True if road is there, false otherwise.<br />signal: Red, Yellow or Green signal detected.  | Sets direction, speed and degree values for the car. | This method sets values for the direction, degree and speed of the car using status of road and availability of traffic signals. |
| + detect_labels_uri(url : String) : Boolean,String | url: Takes image's Google Cloud container's url as input. | Returns values based on presence of road and traffic signals. | This method takes in url of images present in Google Cloud Storage's bucket and uses Vision API to classify them, it then uses these results to detect presence of road and traffic signals.  |

### Class : CallArduino

Description: Provides functions for Raspberry Pi to interface with Arduino.

| function | input | output | description |
|----------|-------|--------|-------------|
| + init() | - | - | Initializes GPIO pins and serial port. |
| + set_turn(direction : String,degree :float) | direction: Direction of turn <br /> degree: Degree of turn | - | This is used to set the direction and degree of turn. |
| + set_speed(direction : String,speed : int) | direction: Direction of speed <br /> degree: Degree of acceleration | - | This is used to set the car's speed. |
| + get_distance() : int,int,int | - | Returns the distance data as a list of ints. | Reads distance data from serial port. |





#### Class : CallAndroid

Description: This component retrieves images and JSON urls from GCP containers and sends them for furthur computation.

| function | input | output | description |
|----------|-------|--------|-------------|
| + android_data():int,int | - | - | It constantly updates value of directions and degree for the car by retriving values from JSON |
| + image_data() | - | - | It constantly retrieves images from Google Cloud container and sends them for classification.    |

# 4.0 Reuse and relationships to their products <a name="rartop"></a>

This project is not doing any enhancement work for existing Softwares but we via this project have developed a complete new approach of doing enhancement to existing concept of a Self Driving Car, which performs various actions. In addition to that,the project completely focusses over developing a model based on Cloud Platform and perform all its functions remotely keeping in mind the extensive cost expenditures at scale.
So, the enhancement in this project offers an approach to build Self Driving cars with minimal usage of *On-Board* hardware and connects various platform technologies like Android, Cloud and Microcontrollers to a distributed processing unit system which functions to offer all the capabilities which have been developed and offered by presently available options like Waymo: Google Self driving Car Project, Bosch Self Driving Car Project and many other. Enhancements like Mobile Vision and Labeling have been kept under further additions to this project as the present platforms in use for the project don't offer complete support and are labelled under experimental.

PS: Infrastructure and cost optimisations are to be looked at while comparing the features and quality with present day contenders.


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


