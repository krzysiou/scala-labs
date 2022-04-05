object main2 {
  def main (args :Array[String]): Unit = {
    val x = List(-3,10, 90, 89, 12, 5, -5, 12, -16, 9908)
    val mm = minmax(x)

    println(mm(0), mm(1))
  }
  def minmax(list : List[Int]) : List[Int] = {
    @scala.annotation.tailrec
    def wrapped(list: List[Int], min: Int, max: Int) : List[Int] = {
      if(list.isEmpty) List(min, max)
      else if (list.head > max)  wrapped(list.drop(1), min, list.head)
      else if (list.head < min)  wrapped(list.drop(1), list.head, max)
      else wrapped(list.drop(1), min, max)
    }
    wrapped(list, list(0), list(0))
  }
}