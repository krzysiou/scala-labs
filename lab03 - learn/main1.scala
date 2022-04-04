object main1 {
  def main(args: Array[String]) : Unit = {
    println(sumfrac(1e-3))
  }
  def sumfrac(stop : Double) : Double = {
    @scala.annotation.tailrec
    def getValue(nextValue: Double, sum: Double, n: Int) : Double = {
      if(nextValue < stop) return sum
      else getValue(1/Math.pow(2, n), sum + nextValue, n + 1)
    }
    return getValue(1, 0, 1)
  }
}
