package de.illusioni.scalabasics.futures

//import scala.concurrent.ExecutionContext.Implicits.global
import java.io.IOException
import java.time.LocalDateTime
import scala.concurrent.ExecutionContext.Implicits
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
import de.illusioni.scalabasics.partialfuncs.{Child, Male}

import scala.concurrent.duration.DurationInt
import scala.io.StdIn
import scala.language.postfixOps


object FuturesDemo {

  /**
   * Using this the number of worker threads defaults to java.lang.Runtime.getRuntime.availableProcessors
   */
  implicit val implicitExecutionContext = Implicits.global

  def main(args: Array[String]): Unit = {

    val longComputationResult = Future {
      Thread.sleep(750)
      if (Math.random() < 0.5) throw new IOException("I/O desaster")
      "Okay, I'm done."
    }

    def readname() = Future {StdIn.readLine()}

    val res = for {
      stringData <- longComputationResult
      name <- readname()
    }
    yield Child(name, stringData.length, Male)

//    val res = longComputationResult.map {
//      result => result.length
//    }

//    longComputationResult.onComplete( resultTry => {
//      print(LocalDateTime.now + " - ")
//      resultTry match {
//        case Success(result) => println(s"The computation was successful. Result: $result")
//        case Failure(exception) => println(s"The computation failed. Cause: $exception")
//      }
//    })

    res.onComplete {
      case Success(res) => println(s"The computed child is: " + res)
      case Failure(x) => println(s"The computation failed: " + x.getMessage)
    }


    Await.ready(res, 10 seconds)

    //    Thread.sleep(10000)
  }

}
