
object main2 {
  def main(args: Array[String]) : Unit = {
    val oPointA = new OrdredPoint(9, 0, 2)
    val oPointB = new OrdredPoint(3, 2, 4)
    print("A < B", oPointA < oPointB)
    print("A < A", oPointA < oPointA)
    print("A == A", oPointA == oPointA)
    print("A != A", oPointA != oPointA)
    print("A == B", oPointA < oPointB)
  }

  abstract class Point(val x: Double, val y: Double, val z: Double){
    def distance() : Double
  }

  trait Dist extends Point {
    override final def distance(): Double = {
      Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2))
    }
    def compare(other: Dist): Int = {
      if(this.distance() > other.distance()) return 1
      else if(this.distance() == other.distance()) return 0
      else return -1
    }
    def addCords(): Double = {
      this.x + this.y + this.z
    }
  }

  class OrdredPoint(x: Double, y: Double, z: Double) extends Point(x,y,z) with Dist with Ordered[Dist]

  object OrdredPoint{
    def apply(x: Double, y: Double, z: Double) = new OrdredPoint(x, y, z)
  }
}
