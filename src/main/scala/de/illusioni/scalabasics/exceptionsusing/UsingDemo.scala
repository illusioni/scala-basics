package de.illusioni.scalabasics.exceptionsusing

import scala.io.Source
import scala.util.Using

object UsingDemo {
  def main(args: Array[String]): Unit = {
    val r = Using(Source.fromFile("/tmp/test.txt")) { src =>
      //      val lines = src.getLines()
      //      for (l <- lines) {
      //        println(l)
      //      }
      src.mkString
    }

    r.foreach(println(_))
  }

}
