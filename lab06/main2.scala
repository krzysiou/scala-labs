object main2 {
  def main(args: Array[String]): Unit = {
    val a: TwistedMonoPair[A] = TwistedMonoPair[A](new B(7), new A)
    println(a(0))
    println(a(1))
    println(a)
    val b: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new C(77))
    println(b)
    // val c: TwistedMonoPair[A] = new TwistedMonoPair[B](new B(9), new A)
    val d1 = b.replace(0)(new A)
    println(d1)
    val tA : TwistedMonoPair[A] = d1
    // val tB : TwistedMonoPair[B] = d1
    val d2 = b.replace(1)(new A)
    println(d2)
  }

  class A {
    override def toString: String = "A"
  }

  class B(val x: Int) extends A {
    override def toString: String = "B:" + x.toString
  }

  class C(x: Int) extends B(x) {
    override def toString: String = "C:" + x.toString
  }

  class TwistedMonoPair[+T](val val1: T, val val2: T){
    override def toString() = val1.toString + " " + val2.toString

    def replace[U >: T](index: Int)(newElement: U) : TwistedMonoPair[U] = {
      if(index == 0)
        return TwistedMonoPair[U](newElement, val2)
      else
        return TwistedMonoPair[U](val1, newElement)
    }

    def apply(index: Int): T = {
      if(index == 0)
        return val1
      else
        return val2
    }
  }

  object TwistedMonoPair {
    def apply[T](arg1: T, arg2: T) = new TwistedMonoPair[T](arg1, arg2)
  }
}