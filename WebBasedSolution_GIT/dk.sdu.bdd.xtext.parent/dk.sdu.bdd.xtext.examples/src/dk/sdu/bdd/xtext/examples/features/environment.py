import os
import json
from msilib.schema import Feature
from pyexpat import features
from behave import fixture
from behave.model import Scenario

# Dynamically find the path to Environment.json
current_dir = os.path.dirname(os.path.abspath(__file__))
json_file_path = os.path.join(current_dir, 'Environment.json')

# Check if the file exists
if not os.path.exists(json_file_path):
    raise FileNotFoundError(f"File not found: {json_file_path}")

with open(json_file_path) as f:
    data = json.load(f)
    
    
"""

def before_all(context):
    print("Setting up Environment...")

def before_feature(context, feature): 
    context.controller.moveJ(get_position("default"), get_speed(), get_acceleration())

def after_feature(context, feature):
    print("After Feature")

def before_scenario(context, scenario): 
    print("Before Scenario")

def after_scenario(context, scenario):
    print("After Scenario")

# Get coordinate-location based on configured name
def get_position(name):
    locations = data["Positions"]
    coordinate = locations[name]

    return coordinate

# Get speed based naming (if not set, returns moderately)
def get_speed(identifier="moderate"):
    speed = data["Speeds"][identifier]["speed"]
    return speed

# Get acceleration based naming (if not set, returns moderately)
def get_acceleration(identifier="moderate"):
    acceleration = data["Speeds"][identifier]["acceleration"]
    return acceleration

# Get IP-address of robot based on configured name
def get_robot_ip():
    ip = data["Robot"]["IP"]
    return ip

# Get coordinate-location based

"""
