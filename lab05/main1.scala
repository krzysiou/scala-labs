object main1 {
  def main(args: Array[String]) : Unit = {
    val krk = MapPoint( "Krakow", 50.061389, 19.938333 );
    println( krk );
    val nyc = MapPoint( "NYC", 40.7127, -74.0059 );
    println( nyc );
    val porto = MapPoint( "Porto", 41.162142, -8.621953 );
    val irkutsk = MapPoint( "Irkutsk",  52.283333, 104.283333 );
    println( irkutsk );
    println( porto - irkutsk )
    println( krk - irkutsk )
    println( krk.distanceTo(porto) )
    val r = Route( krk, nyc, porto )
    println( r );
    r.addStop( porto.move( 1, 1 ) )
    r.addStop( irkutsk )
    println( r ) // 5 stops trip should be printed here
  }

  class MapPoint(val location: String, val X: Double, val Y: Double){
    override def toString: String = {
      return location + " " + X + " " + Y
    }
    def -(point: MapPoint): Double = {
      return Math.sqrt(Math.pow(point.X - X, 2) + Math.pow(point.Y - Y, 2))
    }
    def distanceTo(point: MapPoint) : Double = {
      return (this - point)
    }
    def move(offsetX: Double, offsetY: Double) : MapPoint = {
      return new MapPoint ("Close to " + location, X + offsetX, Y + offsetY)
    }
  }

  object MapPoint {
    def apply(location: String, X: Double, Y: Double) = new MapPoint(location, X, Y)
  }

  class Route(var stops: List[MapPoint]){
    override def toString: String = {
      var output = stops.head.location
      for(i <- stops.tail){
        output += " | " + i.location
      }
      return output
    }
    def addStop(stop: MapPoint) : Unit = {
      stops = stops :+ stop
    }
  }

  object Route{
    def apply(stop1: MapPoint, stop2: MapPoint, stop3: MapPoint) = new Route(List(stop1, stop2, stop3))
  }
}
