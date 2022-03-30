object main2 {
  def main(args: Array[String]): Unit = {
    println(getVal(1000000))
  }

  def getPoint() : Array[Double] = {
    return Array(math.random(), math.random() * 10)
  }

  def getArray(n : Int): Array[Array[Double]] = {
    val sequence = for(i <- 0 until n) yield getPoint()
    return sequence.toArray
  }

  def check(arr: Array[Double]): Boolean = {
    if(arr(1) < (1 + math.pow(arr(0), 2))) return true
    else return false
  }

  def countArray(arr: Array[Array[Double]]): Double = {
    return arr.count(check)
  }
  def getVal(n: Int) : Double = {
    return (countArray(getArray(n)) / n) * 10.0
  }
}