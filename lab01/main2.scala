object main2 {
  def main (args :Array[String]): Unit = {
    val number = if (args.length > 0) args(0).toInt else 50
    print(check(number).mkString(" "))
  }

  def check(n: Int) : Array[Int] = {
    val correct = for{i <- 1 to n if Math.sqrt(i) % 1 != 0} yield i
    return correct.toArray
  }
}
