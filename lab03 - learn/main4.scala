object main4 {
  def main (args :Array[String]): Unit = {
    val list = List(3, 1, 2, 0, 12, 3, 5, 8, -2, -3)
    val result = minmax(list, list(0), list(0))
    println(result(0), result(1))
  }
  def minmax(list : List[Int], min: Int, max: Int) : List[Int] = {
    if(list.isEmpty) List(min, max)
    else if (list.head > max)  minmax(list.drop(1), min, list.head)
    else if (list.head < min)  minmax(list.drop(1), list.head, max)
    else minmax(list.drop(1), min, max)
  }
}