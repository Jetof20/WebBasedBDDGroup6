Feature: New Test
Scenario: "Pick and Place trajectory"
Given the object "Object" is fixed
When the robot "Robot" moves to position "6,4,10"
And the robot "Robot" grabs the object "Object"
And the robot "Robot" moves to position "-6,8,13"
And the robot "Robot" moves to position "10,10,10" with speed 50
Then the object "Object" is placed 