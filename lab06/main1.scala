import java.util.Calendar

object main1 {
  def main(args: Array[String]): Unit = {
    val logger = new Loger with Quote with TimeStamp
    logger.pprint("Hello there")
  }
  abstract class Base {
    def pprint(s: String) : Unit
  }

  class Loger extends Base {
    def pprint(s: String): Unit = print(s)
  }

  trait Quote extends Base {
    abstract override def pprint(s: String): Unit = {
      print('"')
      super.pprint(s)
      print('"')
    }
  }

  trait TimeStamp extends Base {
    private val today = Calendar.getInstance.getTime
    abstract override def pprint(s: String): Unit = {
      print(today.toString + " ")
      super.pprint(s)
    }
  }
}
