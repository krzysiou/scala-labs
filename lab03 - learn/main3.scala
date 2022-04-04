object main3 {
  def main (args :Array[String]): Unit = {
    val arr1 = Array("2", "+", "3")
    val arr2 = Array("sin", "0.23")

    val map1 = Map(
      "sin" -> Math.sin _,
      "cos" -> Math.cos _,
      "tan" -> Math.tan _,
      "sqrt" -> Math.sqrt _,
      "log" -> Math.log _,
      "exp" -> Math.exp _,
    )

    val map2 = Map(
      "+" -> sum _,
      "-" -> subtract _,
      "/" -> divide _,
      "*" -> multiply _,
      "^" -> Math.pow _,
    )
    println(map2(arr1(1))(arr1(0).toDouble, arr1(2).toDouble))
    println(map1(arr2(0))(arr2(1).toDouble))
  }
  def sum(a:Double, b: Double) : Double = {
    return a + b
  }
  def subtract(a:Double, b: Double) : Double = {
    return a - b
  }
  def divide(a:Double, b: Double) : Double = {
    return a / b
  }
  def multiply(a:Double, b: Double) : Double = {
    return a * b
  }
}