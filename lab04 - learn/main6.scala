object main6 {
  def main(args: Array[String]): Unit = {
    val d1 = MyDate(2021, 10, 10)
    val d2 = MyDate(2021, 11, 10)
    val d3 = d2.nextDay()
    println(d1 + " " + d2 + " " + d3)
    println( (d1 < d2) + " " + (d2 < d1))
    val days : Int = d1 - d2
    println("dni " + days + " " + (d2 - d1))
    val period = MyPeriod(begin=d1, end=d2)
    println(d1 + " " + d2 + " " + period)
  }

  class MyDate(val year : Int, val month : Int, val day : Int){
    override def toString: String = {
      year + "-" + month + "-" + day
    }
    def nextDay() : MyDate = {
      new MyDate(year, month, day + 1)
    }
    def <(element: MyDate) : Boolean = {
      if(year < element.year) true
      else if (year > element.year) false
      else if (month < element.month) true
      else if (month > element.month) false
      else if (day < element.day) true
      else false
    }
    def -(element: MyDate) : Int = {
      math.abs(year - element.year) * 12 * 32 + math.abs(month - element.month) * 32 + math.abs(day - element.day)
    }
  }

  object MyDate{
    def apply(year : Int, month : Int, day : Int) = new MyDate(year, month, day)
  }

  class MyPeriod(val begin : MyDate, val end : MyDate){
    override def toString: String = {
      "< " + begin + " : " + end + " >"
    }
  }

  object MyPeriod{
    def apply(begin : MyDate, end : MyDate) = new MyPeriod(begin, end)
  }
}
