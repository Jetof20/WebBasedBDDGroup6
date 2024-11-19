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


@given(u'the object "Object" is fixed')
def step_impl(context):
    print("003")
    pass


@when(u'the robot "Robot" grabs the object "Object"')
def step_impl(context):
    print("004")
    pass


@then(u'the object "Object" is placed')
def step_impl(context):
    print("005")
    pass
