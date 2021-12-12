package de.illusioni.scalabasics.hello

import scala.io.StdIn

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Please enter all participant names.")
    participantNames().foreach(name => println(s"Hello, $name!"))
  }

  def participantNames(names: Seq[String] = Nil): Seq[String] = {
    val name = StdIn.readLine("Next name (empty to end adding participants):")
    if (name.isEmpty) names else participantNames(names :+ name)
  }
}


