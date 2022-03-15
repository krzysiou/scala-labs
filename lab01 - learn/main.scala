object main {
  def main (args :Array[String]): Unit = {

    //get user input
    val userInput = if(args.length > 0) args(0).toInt else 50
    printListOfNumbers(checkIfSquare(userInput))

    //define arrays
    val x = Array.ofDim[Int](4,5)
    for ( i <- 0 until 4; j <- 0 until 5) x(i)(j) = i+j
    val y = Array.ofDim[Int](4,5)
    for ( i <- 0 until 4; j <- 0 until 5) y(i)(j) = i+j + ((i-1) * (j-1))

    //print array x
    print("\n")
    printArray(x)
    print("\n")
    printArray(y)

    //print merged
    print("\n")
    printArray(mergeArrays(x, y))
  }

  def checkIfSquare(limit: Int) : Array[Int] = {
    val checkedInts = for{x <- 1 to limit if Math.sqrt(x)%1 != 0} yield x
    return checkedInts.toArray
  }

  def printListOfNumbers(toPrint: Array[Int]) : Unit = {
    for(x <- 0 until toPrint.length) print(toPrint(x) + " ")
  }

  def printArray(arr: Array[Array[Int]]) : Unit = {
    for (x <- 0 until arr.length) {
      print("|")
      for (y <- 0 until arr(0).length) {
        print(arr(x)(y) + " ")
      }
      print("|\n")
    }
  }

  def mergeArrays(arr1: Array[Array[Int]], arr2: Array[Array[Int]]) : Array[Array[Int]] = {
    val out = Array.ofDim[Int](arr1.length,arr1(0).length)
    for ( i <- 0 until arr1.length; j <- 0 until arr2(i).length){
      out(i)(j) = if(arr1(i)(j) > arr2(i)(j)) arr1(i)(j) else arr2(i)(j)
    }
    return out
  }
}

