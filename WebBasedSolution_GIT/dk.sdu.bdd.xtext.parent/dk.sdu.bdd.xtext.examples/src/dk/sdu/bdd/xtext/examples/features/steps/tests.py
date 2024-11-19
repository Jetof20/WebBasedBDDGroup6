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
    
    print("001")
    pass


@when('the robot "{identifier}" moves to position "{position}"')
def step_when(context, identifier : str, position):
    print("002")
    pattern = r"^-?\d+(\.\d+)?,-?\d+(\.\d+)?,-?\d+(\.\d+)?$"
    if not re.match(pattern,position):
        assert false
    write_line("MOVE "+position+"\n")
    pass


@given('the object "{obj_identifier}" is fixed')
def step_impl(context,obj_identifier : str):
    print("[BDD 003] Defining '"+obj_identifier+"' as an active object")
    context.object = obj_identifier


@when('the robot "{identifier}" grabs the object "{obj_identifier}"')
def step_impl(context,identifier : str,obj_identifier : str):
    print("[BDD 004] Grabbing '"+obj_identifier+"'")
    if (context.object != obj_identifier):
        assert False


@then('the object "{obj_identifier}" is placed')
def step_impl(context,obj_identifier : str ):
    print("[BDD 005] Placing '"+obj_identifier+"'")
    if (context.object != obj_identifier):
        assert False