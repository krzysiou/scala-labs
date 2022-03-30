object main1 {
  def main(args: Array[String]): Unit = {
    println(getVal(1000000))
  }

  def getPoint() : Array[Double] = {
    return Array(math.random(), math.random())
  }

  def getArray(n : Int): Array[Array[Double]] = {
    val sequence = for(i <- 0 until n) yield getPoint()
    return sequence.toArray
  }

  def check(arr: Array[Double]): Boolean = {
    if(Math.sqrt(Math.pow(arr(0), 2) + Math.pow(arr(1), 2)) <= 1) return true
    else return false
  }

  def countArray(arr: Array[Array[Double]]): Double = {
    return arr.count(check)
  }
  def getVal(n: Int) : Double = {
    return countArray(getArray(n)) / n * 4.0
  }
}