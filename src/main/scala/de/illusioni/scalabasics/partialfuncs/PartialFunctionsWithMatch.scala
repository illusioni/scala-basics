package de.illusioni.scalabasics.partialfuncs

sealed trait Gender
object Male extends Gender
object Female extends Gender
object Other extends Gender

case class Child(name: String, age: Int, gender: Gender)

//extractor objects
object Boy {
  def unapply(c: Child) = if (c.gender == Male) Some(c) else None
}
object Girl {
  def unapply(c: Child) = if (c.gender == Female) Some(c) else None
}

object PartialFunctionsWithMatch {

  def main(args: Array[String]): Unit = {

    val data =
      Child("Nina", 11, Female) ::
      Child("Kevin", 14, Male) ::
      Child("Tracy", 9, Other) ::
      Child("Fabian", 6, Male) ::
      Child("Tanja", 12, Female) ::
      Nil

    val agesOfBoys = data.collect {
      case Boy(b) => b.age
    }
    println(agesOfBoys.mkString(","))

    val namesOfGirls = data.collect {
      case Girl(g) => g.name
    }
    println(namesOfGirls.mkString(","))

    val namesContainingA = data.collect {
      case Child(name, age, gender) if name.contains("a") => name
    }
    println(namesContainingA.mkString(","))

    val agesOfBoysWithK = data.collect {
      case Child(name, age, Male) if name.startsWith("K") => age
    }
    println(agesOfBoysWithK.mkString(","))
  }

}
