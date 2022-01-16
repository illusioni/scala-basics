package de.illusioni.scalabasics.implicits

import scala.util.Try
import OptionOps._

object ImplicitsMain {
  def main(args: Array[String]): Unit = {
    val o: Option[String] = args.lift(0)
    if (isSuccess(o)) {
      println("yay")
    }
    else {
      println("nope")
    }
  }

  def isSuccess(t: Try[Any]) = {
    t.isSuccess
  }
}
