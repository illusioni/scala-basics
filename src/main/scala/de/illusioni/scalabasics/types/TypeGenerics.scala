package de.illusioni.scalabasics.types

import java.awt.Color

object TypeGenerics {
  def main(args: Array[String]): Unit = {
    //typed List example
    var list: List[String] = Nil
    list = list :+ "Hallo"
    //list = list :+ new Color(255, 0, 0)

    //typed MyContainer example
    val container1 = new MyContainer[String]("Scorpions")
    val res1 = container1.theElement

    val container2 = new MyContainer[Array[String]](args)
    val res2 = container2.theElement.size

  }
}


/**
 * Stores one element of the given type G
 * @tparam G
 */
class MyContainer[G <: AnyRef](val theElement: G) {

  def toStringAndConcat[H](suffix: H): String = {
    theElement.toString + " " + suffix
  }



}
