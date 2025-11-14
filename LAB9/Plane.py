class Plane:

    def __init__(self,model,fuelCapacity,pilotName,pilotExpirience):
        self.Model=model
        self.FuelCapacity=fuelCapacity
        self.PilotName=pilotName
        self.PilotExpirience=pilotExpirience
    def takeOff(self):
        print("Plane take off")
    def land(self):
        print("Plane land")
    def getInfo(self):
        print("Model: "+ self.Model+ "\nFuel capacity: " + str(self.FuelCapacity)+"\nPilot name" + self.PilotName+"\nPilot expirience: "+ str(self.PilotExpirience))
    def calculateFlightRange(self):
        maxDistance=self.FuelCapacity/5
        print("Max flight range: " +maxDistance)
        return maxDistance
    def pilotRank(self):
        rank="unknown"
        numrank=0
        if(self.PilotExpirience<=1):
            rank="cadet"
            numrank=1
        elif(self.PilotExpirience<=5):
            rank="Second officer"
            numrank=2
        elif(self.PilotExpirience<=7):
            rank="Senior officer"
            numrank=3
        elif(self.PilotExpirience>7):
            rank="Captain"
            numrank=4
        print("Pilot rank:"+ str(rank))
        return numrank
    def checkFuelLevel(self):
        return self.FuelCapacity
    def fuelConsumptionCalculation(self,distance=0):
        if((self.FuelCapacity/distance*5)<5):
            print("Not enough fuel")
        else:
            print("There is enough fuel")
    def priceFlight(self,distance):
        price=(self.pilotRank()*35)+(distance*5*2)
        print("Price Flight:" + str(price))



