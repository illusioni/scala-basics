package de.illusioni.scalabasics.types

object Variance {

  trait Game { def name: String }
  case class ComputerGame(name: String, studio: String) extends Game
  case class Tabletop(name: String, maxPlayers: Int) extends Game {}
  type playersAlsoLiked = Function1[Tabletop, Game] // same as (Tabletop) => Game

  def main(args: Array[String]): Unit = {

    //invariance
    val list1: List[ComputerGame] = List[ComputerGame](
      ComputerGame("Monkey Island", "LucasArts"),
      ComputerGame("GTA", "Rockstar Games")
    )

    //covariance: type List[+A]
    val list2: List[Game] = List[ComputerGame](
      ComputerGame("Monkey Island", "LucasArts"),
      ComputerGame("GTA", "Rockstar Games")
    )

    //contravariance: trait Function1[-T1, +R]
    val referralFunc: playersAlsoLiked = (g1: Game) => ComputerGame("A game everyone loves", "EA")
    referralFunc(Tabletop("Claymore Saga", 2))
  }
}
