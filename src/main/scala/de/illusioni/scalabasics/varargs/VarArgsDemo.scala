package de.illusioni.scalabasics.varargs

object VarArgsDemo {

  def main(args: Array[String]): Unit = {
    val x : Seq[Seq[Int]] = Seq(Seq(1),Seq(2))

    def f(arg: Seq[Any]*) : Int = {
      println(s"argument(s): $arg")
      arg.length
    }
    println(f(x)) //1 as x is taken as single arg
    println(f(x:_*))  // 2 as x is "unpacked" as a Seq[Any]*
  }

}
