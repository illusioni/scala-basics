package de.illusioni.scalabasics.exceptionsoptional

object OptionDemo {
  def main(args: Array[String]): Unit = {
    val x: Option[Int] = Option(3)
    println(x.flatMap(x => Some(x + 2)))
    println(x.map(x => x * x))
  }
}
