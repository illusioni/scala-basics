package de.illusioni.scalabasics.futures

import scala.concurrent.{Await, Future, Promise, blocking}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.io.StdIn
import scala.language.postfixOps

object IOPromiseFuture {

  def main(args: Array[String]): Unit = {

    val p = Promise[Long]()
    val future = p.future

    val computation = Future {
      val name = blocking {
        StdIn.readLine("Wie heißt Du?")
      }
      if (name.length > 3) p.success(System.currentTimeMillis())
      else p.failure(new Exception("computation failed"))
    }

    val consumption = Future {
      future.foreach { v =>
        println(s"value: $v")
      }
    }

    println("Gave my orders. Now we wait.")
    Await.ready(computation, 15 seconds)
    Await.ready(consumption, 15 seconds)
    println("Bye!")
  }
}
