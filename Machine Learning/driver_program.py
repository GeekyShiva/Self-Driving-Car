### BEGIN INIT INFO
# Provides:          dnscheck
# Required-Start:    $remote_fs $syslog
# Required-Stop:     $remote_fs $syslog
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: Start daemon at boot time
# Description:       Enable service provided by daemon.
### END INIT INFO



import argparse
import io

from google.cloud import vision
from google.cloud.vision import types

import json
from urllib.request import urlopen
import requests

from car import init
from car import set_turn
from car import set_speed

import sys
import time

global direction, degree


def android_data():
	#check loop for json files

	for i in range(1, 10001):

		try_check = 0
			
		recieve_json = urlopen("https://storage.googleapis.com/mytest1bucket/"+i+".json").read()		

		if(recieve_json):
		
			response = urlopen("https://storage.googleapis.com/mytest1bucket/"+i+".json").read().decode('utf8')
			obj = json.loads(response)

			for key,value in obj.items():
				if (key == 'compass'):
					degree = value
				else:
					direction = value

		else:
			if(try_check<5):
				
				try_check += 1
				time.sleep(0.1)

			else:
				sys.exit(0)


def road_detected(status, signal):

	if(status is True and signal is 'red'):

		set_turn(direction, degree)
		set_speed(direction, 0)

	else if(status is True and signal is 'yellow'):
	
		set_turn(direction, degree)
		set_speed(direction, 1)

	else if(status is True and signal is 'green'):

		init()		
		set_turn(direction, degree)
		set_speed(direction, 3)
				
	else if(status is False):

		set_turn(direction, degree)
		set_speed(direction, 0)


# [START def_detect_labels]
def detect_labels(path):
    """Detects labels in the file."""
    client = vision.ImageAnnotatorClient()

    # [START migration_label_detection]
    with io.open(path, 'rb') as image_file:
        content = image_file.read()

    image = types.Image(content=content)

    response = client.label_detection(image=image)
    labels = response.label_annotations
    print('Labels:')

    for label in labels:
        print(label.description)
    # [END migration_label_detection]
# [END def_detect_labels]


# [START def_detect_labels_uri]
def detect_labels_uri(uri):

    """Detects labels in the file located in Google Cloud Storage/Firebase or on the
    Web."""

    client = vision.ImageAnnotatorClient()
    image = types.Image()
    image.source.image_uri = uri

    response = client.label_detection(image=image)
    labels = response.label_annotations
    #print('Labels:')

    for label in labels:
	#check loop/if condition for basic attributes	
	
        print(label.description)
	if(label.description == 'road' or label.description == 'lane' or label.description == 'highway' or label.description == 'asphalt' or label.description == 'road trip' or label.description == 'infrastructure' or label.description == 'road surface'):

		for label in labels:

			if(label.description == 'stop' or label.description == 'stop sign' or label.description == 'red' or label.description =='stop signage'):
				road_detected(True, 'red')

			else if(label.description == 'yellow' or label.description == 'lighting' or label.description == 'orange'):
				road_detected(True, 'yellow')

			else if(label.description == 'green' or label.description == 'green signal'):
				road_detected(True, 'green')

			else:
				road_detected(True, 'green')	
	else:
		road_detected(False, 'false')

		


# [END def_detect_labels_uri]



#loop for multiple images

def image_data():

	for i in range(1, 10001):
		try_check = 0

		image_url = 'https://storage.googleapis.com/self-driving-car/'+i+'.jpg'

		if(image_url):
			detect_labels_uri(image_url)

		else:

			if(try_check<5):
				
				try_check += 1
				time.sleep(0.1)    

			else:
				sys.exit(0)


android_data()
image_data()
