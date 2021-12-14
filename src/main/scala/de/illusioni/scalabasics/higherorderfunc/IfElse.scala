package de.illusioni.scalabasics.higherorderfunc

object IfElse {

  def main(args: Array[String]): Unit = {

    val res = wenn(false) {
      println("the condition was true")
      2
    }

    println(res)
  }


  def wenn[T](condition: Boolean)(block: => T): Any = { // When[T] = {
    condition match {
      case true => WhenTrue(block)
      case _ => null.asInstanceOf[T]
    }
  }

  case class WhenTrue[T](result: T) {
    def dann(block: => Any) = result
  }


}


//sonst {
//  println("the condition was false")
//  0f
//}

//trait When[T] {
//  def sonst[U, V](block: => U): V
//}
//
//case class WhenTrue[T](whenResult: T) extends When[T] {
//  override def sonst[U, V<:T](block: => U): V = whenResult
//}
//
//case class WhenFalse[T]() extends When[T] {
//  override def sonst[U, Unit](block: => U) = { block; null.asInstanceOf[Unit] }
//}