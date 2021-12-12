package de.illusioni.scalabasics.encapsulation

class MyDataV1(val i: Int) {
}

class MyDataV2(var i: Int) {
}

class MyDataV3 {
  private var _i: Int = 0

  def this(i: Int) = {
    this()
    this._i = i
  }

  def i_=(i:Int): Unit = {
    println("interrupted setting of i")
    this._i = i
  }

  def i: Int = {
    println("interrupted getting of i")
    _i
  }
}

object Demo {
  def main(args: Array[String]): Unit = {
    val d1 = new MyDataV1(1)
    println(d1.i)

    val d2 = new MyDataV2(0)
    d2.i = 2
    println(d2.i)

    val d3 = new MyDataV3(0)
    d3.i = 3
    println(d3.i)
  }
}