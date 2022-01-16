package de.illusioni.scalabasics.implicits

case class Banana(length: Int)

case class PeeledBanana(length: Int, completelyPeeled: Boolean)



object ImplicitBananas {
  implicit def peel(b: Banana) = PeeledBanana(b.length, true)

  def eat(b: PeeledBanana) = {
    val bites = b.length / 2
    println(s"Eating this banana in $bites bites")
  }

  def main(args: Array[String]): Unit = {
    val banana = Banana(11)
    eat(banana)
  }

}
