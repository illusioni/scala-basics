package de.illusioni.scalabasics.shapes

import org.scalatest.GivenWhenThen
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import scala.language.postfixOps

class ShapesSpec extends AnyFlatSpec with should.Matchers {

  val rectanglesWithArea = Map(
    Rectangle(2, 5) -> 10,
    Rectangle(1, 1) -> 1,
    Rectangle (0, 7) -> 0,
    Square(5) -> 25,
    Square(3) -> 9
  )

  "A rectangle" should "compute its surface area correctly" in {
    for ((shape, area) <- rectanglesWithArea) shape.area should equal(area)
  }

  "A rectangle" should "resize when setter of width is called" in {
    // val myRect = Rectangle(2, 5)
    for ((rect, area) <- rectanglesWithArea) {
      rect.setWidth(4)
      rect.setHeight(5)
      rect.area should equal(20)
    }
  }

  "Squares" should "resize both sides when setter is called" in {
    for ((square, area) <- rectanglesWithArea) {
      if (square.isInstanceOf[Square]) {
        square.setWidth(7)
        square.height should equal(7)
        square.setHeight(9)
        square.width should equal(9)
      }
    }
  }

}
