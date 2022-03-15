object main {
  def main(args: Array[String]) : Unit = {
    printOutput(args)
    print("\n")
    printOutput2(args(0).toInt, redo(args))
  }

  def redo(arr: Array[String]) : Array[String] = {
    return arr.slice(1, arr.length)
  }

  def printOutput(arr: Array[String]) : Unit = {
    val spaces = 80 / arr.length
    print(arr.length + " " * spaces)
    print(arr.mkString(" " * spaces))
  }

  def printOutput2(x: Int, arr: Array[String]) : Unit = {
    val spaces = x / arr.length
    print(arr.length + " " * spaces)
    print(arr.mkString(" " * spaces))
  }
}
