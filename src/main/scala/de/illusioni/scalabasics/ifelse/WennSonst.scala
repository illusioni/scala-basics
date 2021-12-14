package de.illusioni.scalabasics.ifelse

object WennSonst {

  def wenn[T](cond: Boolean)(block: => T): Wenn[T] = new Wenn(cond, block)

  class Wenn[T](cond: Boolean, wennBlock: => T) {
    def sonst[U>:T](sonstBlock: => U) = {
      cond match {
        case true => wennBlock
        case false => sonstBlock
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val v1 = wenn (true) { println("true passt"); 2 } sonst { assert(false, "must not be called"); 5.2 }
    val v2 = wenn (false) { assert(false, "must not be called"); "no" } sonst { println("false passt"); "yo" }
    assert(v1 == 2)
    assert(v2 == "yo")
    println("result passt")
  }
}