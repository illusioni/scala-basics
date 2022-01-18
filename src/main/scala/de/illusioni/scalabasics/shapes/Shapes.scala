package de.illusioni.scalabasics.shapes

object Shapes {
  def main(args: Array[String]): Unit = {
    println(s"rectangle: ${Rectangle(30, 20).area}")
    println(s"rectangle: ${Square(30).area}")
    println(s"circle: ${Circle(15).area}")
  }
}


sealed trait Shape {
  def area: Int
}

case class Circle(radius: Int) extends Shape {
  override def area: Int = (radius * radius * Math.PI).toInt
}

trait Rectangle extends Shape { self: {def width: Int; def height: Int} =>
  override def area: Int = width * height
}

case class RectangleImpl(width: Int, height: Int) extends Rectangle {
}

case class Square(width: Int) extends Shape with Rectangle {
  protected def height = width
}

object Rectangle {
  def apply(width: Int, height: Int): Rectangle = new RectangleImpl(width, height)
}

object Main {
  def main(args: Array[String]): Unit = {
    val myShape = Rectangle(4, 10)
  }
}