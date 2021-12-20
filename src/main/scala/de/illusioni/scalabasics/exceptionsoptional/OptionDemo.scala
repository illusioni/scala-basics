package de.illusioni.scalabasics.exceptionsoptional

import scala.io.StdIn
import scala.util.Try

object OptionDemo {

  def main(args: Array[String]): Unit = {

    val res = Try {
      val r = StdIn.readLine()
      if (r.length < 2) throw new RuntimeException("too short")
      r
    }

    val res2 = res.map(s => "String length = " + s.length)

    println(res2)







//    val x: Option[Int] = Option(3)
//
//    val res: Option[Int] = x.flatMap(x => if (x>0) Some(x + 2) else None)
//
//    println(res)

//    println(x.map(x => x * x))


  }

}
