package de.illusioni.scalabasics.ifelse

object Falls {

  def falls[T](cond: Boolean)(block: => T): T = {
    cond match {
      case true => block
      case false => null.asInstanceOf[T]
    }
  }

  def main(args: Array[String]): Unit = {
    val v1 = falls (true) { println("true passt"); 8 }
    val v2 = falls (false) { assert(false); "str" }
    println("false passt")
    assert(v1 == 8)
    assert(v2 eq null)
    println("result passt")
  }
}