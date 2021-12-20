package de.illusioni.scalabasics.partialfuncs

object PartialFunctions {

  def main(args: Array[String]): Unit = {

    val data = Seq(1, 3, 4, 6, 7, 8, 12, 15, 32, 33, 34)

    //v1
    val pFunc: PartialFunction[Int, Int] = {
      case x if x % 2 == 0 => x/2
    }
    val qFunc: PartialFunction[Int, Int] = {
      case x if x>0 => x*3
    }
    val aggFunc = pFunc orElse qFunc

    val dAfterPFunc = data.collect(pFunc)
    val res = dAfterPFunc.collect(qFunc)

    val evenNumbersBy2 = data.collect(aggFunc)

    //v2
//    val evenNumbersBy2 = data.collect {
//      case x if x % 2 == 0 => x/2
//    }

    println(evenNumbersBy2.mkString(","))
  }

}
