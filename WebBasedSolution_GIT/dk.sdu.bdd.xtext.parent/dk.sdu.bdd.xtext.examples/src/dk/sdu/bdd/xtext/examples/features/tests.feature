Feature: New Test
Scenario: "Pick and Place trajectory"
Given the object "Object" is fixed
When the robot "Robot" moves to position "POS10"
And the robot "Robot" grabs the object "Object"
And the robot "Robot" moves to position "Bucket"
Then the object "Object" is placed 