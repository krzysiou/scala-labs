object main2 {
  def main (args :Array[String]): Unit = {
    val arr1 = Array("2", "+", "3")
    val arr2 = Array("sin", "0.23")
    val map1 = Map(
      "sin" -> Math.sin _,
      "+" -> suma _ )
    println(map1("+")(2))
  }
  def suma(x:Double) : Double = {
    x
  }
}
