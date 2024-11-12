from behave import given, when, then
import logging

@given("the search page is displayed")
def step_impl(context):
    # implementation for the given step
    print("1")

@when("I enter {search_term} in the search field")
def step_impl(context, search_term):
    # implementation for the when step
    print(search_term)

@then("the search results should contain {expected_result}")
def step_impl(context, expected_result):
    # implementation for the then step
    print("3")