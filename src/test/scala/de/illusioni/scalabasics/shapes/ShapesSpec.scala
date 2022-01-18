package de.illusioni.scalabasics.shapes

import org.scalatest.GivenWhenThen
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import scala.language.postfixOps

class ShapesSpec extends AnyFlatSpec with GivenWhenThen with should.Matchers {

  val rectanglesWithArea = Map(
    Rectangle(2, 5) -> 10,
    Rectangle(1, 1) -> 1,
    Rectangle (0, 7) -> 0,
    Square(5) -> 25
  )

  "A rectangle" should "compute its surface area correctly" in {
    for ((shape, area) <- rectanglesWithArea) shape.area should equal(area)

  }
}
