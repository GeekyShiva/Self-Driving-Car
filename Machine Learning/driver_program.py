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
    # check loop for json files

    for i in range(1, 10001):

        try_check = 0

        recieve_json = urlopen(
            
            "https://storage.googleapis.com/pokjb-186519.appspot.com/jsons/" + str(i) + ".json").read()

        if(recieve_json):

            response = urlopen(
                "https://storage.googleapis.com/pokjb-186519.appspot.com/jsons/" + str(i) + ".json").read().decode('utf8')
            obj = json.loads(response)

            for key, value in obj.items():
                if (key == 'compass'):
                    if(value<5):
                        degree = 0
                    elif(5<value<10):
                        degree = 1
                    elif(10<value<20):
                        degree = 2
                    elif(value>20):
                        degree = 3
                else:
                    direction = value

        else:
            if(not recieve_json and try_check < 5):
                try_check += 1
                time.sleep(0.1)

            elif(recieve_json and try_check < 5):
                android_data()

            else:
                sys.exit(0)


def road_detected(status, signal, obstacle):

    if(obstacle is 1):
        set_turn("Left", 3)
        set_speed("Left", 3)
        time.sleep(1)
        set_turn("Right", 3)
        set_speed("Right", 3)
        time.sleep(1)
        set_turn(direction, degree)
        set_speed(direction, 3)

    elif(status is True and signal is 'red'):

        set_turn(direction, degree)
        set_speed(direction, 0)

    elif(status is True and signal is 'yellow'):

        set_turn(direction, degree)
        set_speed(direction, 1)

    elif(status is True and signal is 'green'):

        init()
        set_turn(direction, degree)
        set_speed(direction, 3)

    elif(status is False):

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
    # print('Labels:')

    for label in labels:
        # check loop/if condition for basic attributes
        print(label.description)

        if(label.description == 'road' or label.description == 'lane' or label.description == 'highway' or label.description == 'asphalt' or label.description == 'road trip' or label.description == 'infrastructure' or label.description == 'road surface' or label.description == 'field' or label.description == 'floor' or label.description == 'flooring'):

            for label in labels:

                if(label.description == 'stop' or label.description == 'stop sign' or label.description == 'red' or label.description == 'stop signage'):
                    road_detected(True, 'red', 0)

                elif(label.description == 'yellow' or label.description == 'lighting' or label.description == 'orange'):
                    road_detected(True, 'yellow', 0)

                elif(label.description == 'green' or label.description == 'green signal'):
                    road_detected(True, 'green', 0)
                
                elif(label.description == 'plastic' or label.description == 'product'):
                    road_detected(True, 'green', 1)

                else:
                    road_detected(True, 'green', 0)
        else:
            road_detected(False, 'false', 0)


# [END def_detect_labels_uri]


# loop for multiple images

def image_data():

    for i in range(1, 10001):
        try_check = 0

        image_url = 'https://storage.googleapis.com/pokjb-186519.appspot.com/images/' + \
            str(i) + '.jpg'

        if(image_url):
            detect_labels_uri(image_url)

        else:

            if(not image_url and try_check < 5):

                try_check += 1
                time.sleep(0.1)

            elif(image_url and try_check < 5):
                detect_labels_uri(image_url)

            else:
                sys.exit(0)


android_data()
image_data()