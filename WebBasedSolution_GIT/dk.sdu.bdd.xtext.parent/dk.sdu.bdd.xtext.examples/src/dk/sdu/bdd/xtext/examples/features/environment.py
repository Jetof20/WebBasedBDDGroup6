import os
import json
from msilib.schema import Feature
from pyexpat import features
from behave import fixture
from behave.model import Scenario
import time

# Dynamically find the path to Environment.json
current_dir = os.path.dirname(os.path.abspath(__file__))
json_file_path = os.path.join(current_dir, 'Environment.json')

# Check if the file exists
if not os.path.exists(json_file_path):
    raise FileNotFoundError(f"File not found: {json_file_path}")

with open(json_file_path) as f:
    data = json.load(f)
    
    

def before_all(context):
    print("Setting up Environment...")
    path = os.path.join(os.path.dirname(__file__))
    for i in range(8):
        path = os.path.abspath(os.path.join(path, os.pardir))
    
    path = os.path.join(path,"dk.sdu.bdd.xtext.web","WebRoot","bddlogs.txt")    
    file = open(path, "w")  # append mode
    file.write("BEGIN "+str(int(time.time())))
    file.write("\n")
    file.close()

def after_all(context):
    print("Close Environment...")
    path = os.path.join(os.path.dirname(__file__))
    for i in range(8):
        path = os.path.abspath(os.path.join(path, os.pardir))
    
    path = os.path.join(path,"dk.sdu.bdd.xtext.web","WebRoot","bddlogs.txt")    
    file = open(path, "a")  # append mode
    file.write("END")
    file.close()
