from msilib.schema import Feature
from behave import when, given, then
import time
import environment as env
import os


@then('the position {prep} the robot "{identifier}" is "{position}"')
@given('the position {prep} the robot "{identifier}" is "{position}"')
def step_given(context, identifier : str, position, prep):
    
    print("001")
    pass


@when('the robot "{identifier}" moves to position "{position}"')
def step_when(context, identifier : str, position):
    print("002")
    pass


@given(u'the object "{obj_identifier}" is fixed')
def step_impl(context,obj_identifier : str):
    print("003")
    pass


@when(u'the robot "{identifier}" grabs the object "{obj_identifier}"')
def step_impl(context,identifier : str,obj_identifier : str):
    print("004")
    pass


@then(u'the object "{obj_identifier}" is placed')
def step_impl(context,obj_identifier : str ):
    print("005")
    pass
