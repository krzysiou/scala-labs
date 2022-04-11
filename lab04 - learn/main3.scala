object main3 {
  def main(args: Array[String]): Unit = {
    val krk = MapPoint( "Krakow", 50.061389, 19.938333 )
    println( krk )
    val nyc = MapPoint( "NYC", 40.7127, -74.0059 )
    println( nyc )
    val porto = MapPoint( "Porto", 41.162142, -8.621953 )
    val irkutsk = MapPoint( "Irkutsk",  52.283333, 104.283333 )
    println( irkutsk )
    println( porto - irkutsk )
    println( krk - irkutsk )
    println( krk.distanceTo(porto) )
    val mp = MapPoint.inTheMiddle( krk,  irkutsk, "Somewhere in Russia" )
    println( mp+" "+( mp - krk ) +" "+ ( mp - irkutsk ) )
    val r = Route( List(krk, nyc, porto) )
    println( r )
    r.addStop( porto.move( 1, 1 ) )
    r.addStop( irkutsk )
    println( r )
  }
  // class that represents a point on a map
  // with given place name and coordinates
  class MapPoint(val place: String, val coordX: Double, val coordY: Double){

    // function to print the point
    override def toString: String = {
      val latitudeSign = if (coordX < 0) "S" else "N"
      val longitudeSign = if (coordY < 0) "W" else "E"
      place + " " + Math.abs(coordX) + latitudeSign + " " + Math.abs(coordY) + longitudeSign
    }

    // function to calculate the distance between two points
    def distanceTo(other: MapPoint) : Double = {
      Math.sqrt(Math.pow(other.coordX - coordX, 2) + Math.pow(other.coordY - coordY, 2))
    }

    // "minus" operator to calculate the distance between two points
    def - (other: MapPoint): Double = this.distanceTo(other)

    // function to move a point by given parameters
    def move(newX: Double, newY: Double) : MapPoint = {
      new MapPoint ("Nearby " + place, newX, newY)
    }
  }
  // companion object to the MapPoint class
  object MapPoint{
    // constructor to create a map point
    // with given place name and coordinates
    def apply(place: String, coordX: Double, coordY: Double) = new MapPoint(place, coordX, coordY)

    // "static" function to find a map point in the middle of two others, with given name
    def inTheMiddle(point1: MapPoint, point2: MapPoint, place: String) : MapPoint = {
      val newX = (point1.coordX + point2.coordX) / 2
      val newY = (point1.coordY + point2.coordY) / 2
      new MapPoint(place, newX, newY)
    }
  }

  // class that represents a route with a given list of stops
  class Route(var stops: List[MapPoint]){

    // function to print the route
    override def toString: String = {
      var result = stops.head.toString()
      for(i <- stops.tail){
        result += " -> " + i.toString()
      }
      result
    }

    // function to add a stop to the start of the list
    def addStop(newStop: MapPoint) : Unit = {
      stops = newStop :: stops
    }
  }
  object Route{
    def apply(stops: List[MapPoint]) = new Route(stops)
  }
}