from msilib.schema import Feature
from behave import when, given, then
import time
import os
import re


def write_line(line):
    path = os.path.join(os.path.dirname(__file__))
    for i in range(9):
        path = os.path.abspath(os.path.join(path, os.pardir))
    
    path = os.path.join(path,"dk.sdu.bdd.xtext.web","WebRoot","bddlogs.txt")    
    file = open(path, "a")  # append mode
    file.write(line)
    file.close()


@then('the position {prep} the robot "{identifier}" is "{position}"')
@given('the position {prep} the robot "{identifier}" is "{position}"')
def step_given(context, identifier : str, position, prep):
    pass


@when('the robot "{identifier}" moves to position "{position}"')
def step_when(context, identifier : str, position):
    pattern = r"^-?\d+(\.\d+)?,-?\d+(\.\d+)?,-?\d+(\.\d+)?$"
    if not re.match(pattern,position):
        write_line("ERR wrong_position_format_given\n")
        assert false
    write_line("MOVE "+position+"\n")
    pass

@when('the robot "{identifier}" moves to position "{position}" with speed {speed}')
def step_when(context, identifier : str, position, speed):
    pattern = r"^-?\d+(\.\d+)?,-?\d+(\.\d+)?,-?\d+(\.\d+)?$"
    if not re.match(pattern,position):
        write_line("ERR wrong_position_format_given\n")
        assert false
    if not speed.isdigit():
        write_line("ERR invalid_speed_use_a_number\n")
        assert false
        
    
    write_line("MOVE "+position+" "+speed+"\n")
    pass

@given('the object "{obj_identifier}" is fixed')
def step_impl(context,obj_identifier : str):
    context.object = obj_identifier


@when('the robot "{identifier}" grabs the object "{obj_identifier}"')
def step_impl(context,identifier : str,obj_identifier : str):
    if (context.object != obj_identifier):
        write_line("ERR wrong_object_grabbed\n")
        assert False

@when('the object "{obj_identifier}" is placed')
@then('the object "{obj_identifier}" is placed')
def step_impl(context,obj_identifier : str ):
    if (context.object != obj_identifier):
        write_line("ERR wrong_object_placed\n")
        assert False