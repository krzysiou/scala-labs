object main1 {
  def main(args: Array[String]): Unit = {
    val g_1_4 = gen_seq(1,4)
    val g_0_inf = gen_seq(0, Int.MaxValue)
    val g_7_10 = gen_seq(7, 10)
    for ( i <- 0 until 10 ) {
      println(g_1_4() + " " + g_0_inf() + " " + g_7_10())
    }
  }
  def gen_seq(x: Int, y: Int) : () => Int = {
    var i = -1
    () => {
      i += 1
      if(x + i < y)  i + x
      else y
    }
  }
}
