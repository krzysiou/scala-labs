object main2 {
  def main(args: Array[String]): Unit = {
    val list = List("Hello", "There", "people")
    println(list)
    println(reverseList(list))
    println(filterList(list, _.contains('p')))
  }

  def filterListRec(list: List[String], filtered: List[String], f: (String) => Boolean) : List[String] = {
    if(list.isEmpty) return filtered
    else if(f(list.head)) filterListRec(list.drop(1), filtered :+ list.head, f)
    else filterListRec(list.drop(1), filtered, f)
  }

  def filterList(list: List[String], f: (String) => Boolean) = {
    filterListRec(list, List[String](), f)
  }

  def reverseListRec(reversed : List[String], todo: List[String]) : List[String] = {
    if(todo.isEmpty) return reversed
    reverseListRec(reversed :+ todo.last, todo.dropRight(1))
  }

  def reverseList(list: List[String]): List[String] = {
    reverseListRec(List.empty, list)
  }
}