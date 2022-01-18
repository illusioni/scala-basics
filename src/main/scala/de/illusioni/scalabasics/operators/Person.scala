package de.illusioni.scalabasics.operators

case class Person(val name: String, val age: Int) {
  def +(years: Int) = new Person(name, age + years)
  def unary_! = new Person(name.reverse, age)
}

object Main {
  def main(args: Array[String]): Unit = {
    val steve = new Person("Steve", 42)
    val oldSteve = steve + 35
    val creepySteve = ! oldSteve
    println(creepySteve)
  }
}
