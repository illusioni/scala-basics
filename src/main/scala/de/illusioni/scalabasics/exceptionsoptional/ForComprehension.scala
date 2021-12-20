package de.illusioni.scalabasics.exceptionsoptional

import scala.util.Random

object ForComprehension {

  def main(args: Array[String]): Unit = {

    val res = for {
      data1 <- readSomething()
      data2 <- readSomething()
    } yield {
      multiply(data1, data2)
    }

    res match {
      case Some(product) => println(s"all operations succeeded, product = $product")
      case None => println("one of the operations failed, no further operations were executed")
    }

//        val res = readSomething()
//          .flatMap(data1 =>
//            readSomething()
//              .map(data2 => multiply(data1, data2))
//          )
  }

  // a pure function that doesn't (need to) care about exceptions
  def multiply(data1: Int, data2: Int) = data1 * data2

  // We simulate an operation that might [think "fail and"] return no data
  def readSomething(): Option[Int] = {
    val r = Random.nextInt()
    if (r%3!=0) {
      println("//read 'succeeding'")
      Some(r)
    } else {
      println("//read 'failing'")
      None
    }
  }

}
