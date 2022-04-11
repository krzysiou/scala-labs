object main5 {
  def main(args: Array[String]): Unit = {
    val x = Complex(1,2)
    val y = Complex(3,2)
    println("x " + x + " y " + y + " x+y " + (x+y) + " x-y " + (x-y))
    val f = Complex.polar(r=3, angle=math.Pi)
    println(f)
    println("|x| " + x.r + " angle " + x.angle)
  }

  class Complex(val re : Double, val im : Double){
    override def toString: String = {
      "Re:{" + re + "} Im:{"+ im +"}"
    }
    def +(element : Complex) : Complex = {
      new Complex(re + element.re, im + element.im)
    }
    def -(element : Complex) : Complex = {
      new Complex(re - element.re, im - element.im)
    }
    val r = math.sqrt(math.pow(re, 2) + math.pow(im, 2))
    val angle = math.atan(im / re)
  }

  object Complex{
    def apply(re : Double, im : Double) = new Complex(re, im)
    def polar(r : Double, angle : Double) = new Complex(r * math.cos(angle), r * math.sin(angle))
  }
}
