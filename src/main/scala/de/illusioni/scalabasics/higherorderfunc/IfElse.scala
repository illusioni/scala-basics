package de.illusioni.scalabasics.higherorderfunc

object IfElse {

  def main(args: Array[String]): Unit = {

    when(false) {
      println("the condition was true")
    } otherwise {
      println("the condition was false")
    }
  }


  def when(condition: => Boolean)(block: => Any): When = {
    condition match {
      case true => { block; WhenTrue }
      case _ => WhenFalse
    }
  }

  trait When {
    def otherwise(block: => Any): Unit
  }

  object WhenTrue extends When {
    override def otherwise(block: => Any) = ()
  }

  object WhenFalse extends When {
    override def otherwise(block: => Any): Unit = block
  }

}
