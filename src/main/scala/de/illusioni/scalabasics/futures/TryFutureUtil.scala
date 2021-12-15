package de.illusioni.scalabasics.futures

import scala.concurrent.Future
import scala.language.implicitConversions
import scala.util.{Failure, Success, Try}

trait TryFutureUtil {

  implicit def tryToFuture[T](t:Try[T]):Future[T] = {
    t match {
      case Success(x) => Future.successful(x)
      case Failure(x) => Future.failed(x)
    }
  }
}
