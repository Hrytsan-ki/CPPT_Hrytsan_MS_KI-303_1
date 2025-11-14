import sys,random
from Plane import Plane
class Bomber(Plane):
    def __init__(self,model, fuelCapacity, pilotName, pilotExpirience, countbomb,maxountbomb):
        super().__init__(model, fuelCapacity, pilotName, pilotExpirience)
        self.MaxOuntBomb=maxountbomb
        if(countbomb>maxountbomb):
            print("No space")
            sys.exit(1)
        self.CountBomb=countbomb
        
    def dropTheBomb(self,ount):
        if(ount<=self.CountBomb):
            self.CountBomb-=ount
            print("Drop the {ount} bombs")
        else:
            print("Not enough bombs")
    def loadTheBombs(self,ount):
        if(ount<=(self.MaxOuntBomb-self.CountBomb)):
            self.OuntBomb+=ount
            print("Load the {ount} bombs")
    def pilotRank(self):
        if(self.PilotExpirience<=1):
            rank="Second officer"
            numrank=1
        elif(self.PilotExpirience<=5):
            rank="First officer"
            numrank=2
        elif(self.PilotExpirience<=7):
            rank="Major"
            numrank=3
        elif(self.PilotExpirience>7):
            rank="Colonel"
            numrank=4
        print("Pilot rank:"+ str(rank))
        return numrank   
    def searchForEnemies(self):
        A_int =random.uniform(0, 20)
        print("Targets found: " + str(A_int))
     

