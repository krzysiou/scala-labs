object main3 {
  def main(args: Array[String]) : Unit = {

    val max : Int => Int => Int = x => y => {
      if(x > y) x
      else y
    }

    <("Hellow world")
    <(3)("Hellow world")

    println(invokeAndAccumulate(3, (x: Int) => 2+x ,  4))
    println(invokeAndAccumulate(2, (x: Int) => x*x ))

    println(max(4)(5))
  }
  def < (n: Int) : String => Unit = {
    return (str: String) => println(" "*n + str)
  }

  def < (str: String) : Unit = {
    println(str)
  }

  def invokeAndAccumulate(a: Int, fun: (Int) => Int, b: => Int = 1) : Int = {
    if(b == 0) return a
    invokeAndAccumulate(fun(a), fun, b - 1)
  }
}
