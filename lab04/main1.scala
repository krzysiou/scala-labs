object main1 {
  def main(args: Array[String]): Unit = {
    val lA = List(1,2,3,4)
    val lB = List(10,9,8,7)
    val lC = List(-1,-2,1)
    val lD = List(100,90,80,70,60,50)
    val output = merge(List(lA,lB,lC,lD))
    println(output.mkString(", "))
  }

  @scala.annotation.tailrec
  def check(li : List[List[Int]]) : Boolean = {
    if(li.isEmpty) return false
    else if(li.head.isEmpty) return true
    check(li.drop(1))
  }

  @scala.annotation.tailrec
  def drop(li : List[List[Int]], iterator : Int = 0, newList : List[List[Int]] = List()) : List[List[Int]] = {
    if(iterator == li.length) return newList
    drop(li, iterator+1, newList :+ li(iterator).drop(1))
  }

  @scala.annotation.tailrec
  def take(li : List[List[Int]], temp : List[Int] = List()) : List[Int] = {
    if(li.isEmpty) return temp
    take(li.drop(1), temp :+ li.head.head)
  }

  def merge(li : List[List[Int]]) : List[Int] = {
    @scala.annotation.tailrec
    def mergeRec(li : List[List[Int]], newList : List[Int] = List()) : List[Int] = {
      if(check(li)) return newList
      mergeRec(drop(li), newList ++ take(li))
    }
    mergeRec(li)
  }
}