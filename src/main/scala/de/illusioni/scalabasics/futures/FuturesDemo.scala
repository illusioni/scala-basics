package de.illusioni.scalabasics.futures

//import scala.concurrent.ExecutionContext.Implicits.global
import java.io.IOException
import java.time.LocalDateTime
import scala.concurrent.ExecutionContext.Implicits
import scala.concurrent.Future
import scala.util.{Failure, Success}


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

    val res = longComputationResult.map {
      result => result.length
    }

    longComputationResult.onComplete( resultTry => {
      print(LocalDateTime.now + " - ")
      resultTry match {
        case Success(result) => println(s"The computation was successful. Result: $result")
        case Failure(exception) => println(s"The computation failed. Cause: $exception")
      }
    })

    res.onComplete {
      case Success(res) => println(s"The computed string has $res characters.")
      case Failure(x) => ()
    }

    Thread.sleep(1000)
  }

}
