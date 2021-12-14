package de.illusioni.scalabasics.higherorderfunc

object Falls {

  def falls[T](cond: Boolean)(block: => T): Any = {
    cond match {
      case true => block
      case false => ()
    }
  }

  def main(args: Array[String]): Unit = {
    falls (true) { println("true passt")}
    falls (false) { assert(false) }
    println("false passt")
  }
}