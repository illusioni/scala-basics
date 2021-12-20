package de.illusioni.scalabasics.recursion

trait GoogleStairs {
  def variationsToClimb: Int => Int
}

object GoogleStairs extends GoogleStairs {

  private var invocations = Map.empty[Int, Int]

  val variationsToClimb: (Int => Int) = memoize { (nrSteps: Int) =>
//  val variationsToClimb: (Int => Int) = (nrSteps: Int) => {
    invocations = invocations.updatedWith(nrSteps)((oldVal: Option[Int]) => oldVal.orElse(Some(0)).map(_ + 1))
    Thread.sleep(50)
    if (nrSteps <= 1) 1
    else variationsToClimb(nrSteps - 1) + variationsToClimb(nrSteps - 2)
  }

  def main(args: Array[String]): Unit = {
    def execution(n: Int): Unit = {
      println(s"There are ${variationsToClimb(n)} variations to climb a stair with $n steps")
      invocations.toList.sorted.foreach(_ match { case (k, v) => println(s"  $k - $v invocations") })
    }

//    execution(0)
//    execution(1)
//    execution(2)
//    execution(3)
//    execution(4)
//    execution(5)
    println("start")
    execution(10)
    println("ende")
  }
}
