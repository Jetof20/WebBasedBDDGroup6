from behave import *
import sys
from behave.__main__ import main
import time
import os

if __name__ == '__main__':
    path = os.path.abspath(__file__) # get the path of the executable
    for i in range(9):
        path = os.path.dirname(path) # go 9 steps back
    path = os.path.join(path,"dk.sdu.bdd.xtext.examples","src","dk","sdu","bdd","xtext","examples","bdd","tests.feature")
    
    if os.path.exists(path):
        print("File exists!")
    else:
        print("File does not exist!")
    
    print(path)
    sys.argv[0] = "behave"
    sys.argv[1:] = ["--no-capture","-v", path]
    main()
    
 