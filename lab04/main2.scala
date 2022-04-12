object main2 {
  def main(args: Array[String]): Unit = {
    val el = ExpensesList()
    el += Expense(5, "Bread", "food") // amount, item name, category
    el += Expense(7, "Butter", "food")
    el += Expense(3.2, "Tomatoes", "food")
    el += Expense(18, "Star Wars ticket", "entertainment")
    el.printList()
    print("\n")
    println( el.sum )
    print("\n")
    println( el.max )
  }

  //EXPENSE
  class Expense(val price: Double, name: String, category: String) {
    override def toString : String = "price: " + price + " name " + name + " category: " + category
  }

  object Expense {
    def apply(price : Double, name : String, category : String) = new Expense(price, name, category)
  }

  //EXPENSE LIST
  class ExpensesList() {
    private var list: List[Expense] = List()
    def += (e: Expense) : Unit = list = list :+ e
    def printList() : Unit = println(list.mkString("\n"))
    def max : Expense = list.maxBy(e => e.price)
    def sum : Double = {
      var result = 0.0
      for(i <- list) result += i.price
      result
    }
  }

  object ExpensesList{
    def apply() = new ExpensesList()
  }
}
