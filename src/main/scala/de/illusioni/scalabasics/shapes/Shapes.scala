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

//trait Rectangle extends Shape { self: {var width: Int; var height: Int} =>
//  override def area: Int = width * height
//}

class Rectangle(var width: Int, var height: Int) extends Shape {
  override def area: Int = width * height
  def setWidth(width: Int) = { this.width = width }
  def setHeight(height: Int) = { this.height = height }
}

//case class Square(width: Int) extends Shape with Rectangle {
//  protected def height = width
//}

class Square(w: Int) extends Rectangle(w, w) {
  override def setWidth(width: Int) {
    this.height = width
    this.width = width
  }

  override def setHeight(width: Int) {
    this.height = width
    this.width = width
  }
}

object Square {
  def apply(width: Int): Rectangle = new Square(width)
}

object Rectangle {
  def apply(width: Int, height: Int): Rectangle = new Rectangle(width, height)
}

object Main {
  def main(args: Array[String]): Unit = {
    val myShape = Rectangle(4, 10)
  }
}