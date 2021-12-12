package de.illusioni.scalabasics.bubblesort

object Bubblesort {

  private def swap(array: Array[Int], a: Int, b: Int) = {
    val t = array(a)
    array(a) = array(b)
    array(b) = t
  }

  /**
   * sorts the elements of {@code array} in place (mutates it)
   * @param array
   */
  def sort(array: Array[Int]): Unit = {
    for (i <- 0 until array.length-1) {   // for (i <- array.indices) {
      for (j <- 0 until array.length-1-i) {
        if (array(j) > array(j+1)) swap(array, j, j+1)
//        println(s"""dbg: ${array.mkString(",")}""")
//        println("dbg: " + "  "*j + "^ ^")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val intArray = args.map(i => i.toInt)
    println(s"""in: ${intArray.mkString(",")}""")
    sort(intArray)
    println(s"""out: ${intArray.mkString(",")}""")
  }
}

