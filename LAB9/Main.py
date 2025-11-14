from Plane import Plane
from Bomber import Bomber

plane1 = Plane("Boeing 747", 2000, "John", 6)
bomber1 = Bomber("B-52", 3000, "Mike", 8, 10, 15)

plane1.getInfo()
plane1.takeOff()
plane1.priceFlight(500)

bomber1.getInfo()
bomber1.searchForEnemies()
bomber1.dropTheBomb(5)
