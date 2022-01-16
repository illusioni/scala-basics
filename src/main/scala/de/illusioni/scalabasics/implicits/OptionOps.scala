package de.illusioni.scalabasics.implicits

import scala.util.{Failure, Success, Try}

/**
 * import OptionOps._ to be able to use an Option where a Try is expected.
 */
object OptionOps {
  implicit def optionToTry[A](opt: Option[A]) = {
    opt
      .map(Success(_))
      .getOrElse(Failure(new NoSuchElementException("Option.None => Try.Failure")))
  }
}
