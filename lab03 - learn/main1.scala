object main1 {
  def main(args: Array[String]) : Unit = {
    println(sumfrac(1e-3))
  }
  def sumfrac(stop : Double) : Double = {
    return getValue(1, stop, 1)
  }

  def getValue(nextValue : Double, stop : Double, counter : Int): Double = {
    if(nextValue < stop){
      return 0
    } else {
      return nextValue + getValue(1 / Math.pow(2,counter), stop, counter + 1)
    }
  }
}
