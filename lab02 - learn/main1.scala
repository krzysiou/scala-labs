object main1 {
  def main (args :Array[String]): Unit = {
    val f1:  (Double) => Double = (x) => x * 2
    val f2 =  (x: Double) => x * 3
    val f3: Double => Double => Double = x => y => x * y

    val l1 = List(f1,f2,f3(2))

    val eval: (Double, Array[(Double) => Double]) => Double = (arg, list) => list(2)(list(1)(list(0)(arg)))
    println(eval(3, l1.toArray))
  }
}
