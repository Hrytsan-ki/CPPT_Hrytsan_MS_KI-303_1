import math
import os
import struct
import sys

def calculate(x):
    try:
        e=math.sin(2*x)
        if(e==0):
            raise ZeroDivisionError
    except ZeroDivisionError:
        print("division by zero error")
        sys.exit()
    else:
        return math.tan(x)/math.sin(2*x)
def writeResTxt(fName, result):
    with open(fName, 'w') as f:
        f.write(str(result))
def readResTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                result = f.read()
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result
def writeResBin(fName, result):
    with open(fName, 'wb') as f:
        f.write(struct.pack('f', result))
def readResBin(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                result = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result
if __name__ == "__main__":
    data = float(input("Enter data: "))
    result = calculate(data)
    print(f"Result is: {result}")
    try:
        writeResTxt("textRes.txt", result)
        writeResBin("binRes.bin", result)
        print("Result is: {0}".format(readResBin("binRes.bin")))
        print("Result is: {0}".format(readResTxt("textRes.txt")))
    except FileNotFoundError as e:
        print (e)
        sys.exit(1)