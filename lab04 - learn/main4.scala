object main4 {
  def main(args: Array[String]): Unit = {
    var el = ExpensesList()
    el += Expense(5, "Bread", "food")
    el += Expense(7, "Butter", "food")
    el += Expense(3.2, "Tomatoes", "food")
    el += Expense(18, "Star Wars ticket", "entertainment")
    el.printList()
    println(el.sum)
    println(el.max)
  }

  class Expense(val amount: Double, val item: String, val category: String){
    override def toString: String = {
      amount + " " + item + "(s) of category: " + category
    }
  }
  object Expense{
    def apply(amount: Double, item: String, category: String) = new Expense(amount, item, category)
  }

  class ExpensesList(var list: List[Expense] = Nil){
    def += (element: Expense): Unit = {
      list = element :: list
    }

    def printList(): Unit ={
      println(list.mkString("\n"))
    }

    def sum: Double = {
      var sum = 0.0
      for (i <- list){
        sum += i.amount
      }
      sum
    }

    def max: Expense = {
      val amountMaxBy: Expense => Double = element => element.amount
      list.maxBy(amountMaxBy)
    }
  }

  object ExpensesList{
    def apply() = new ExpensesList()
  }
}
