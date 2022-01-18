package de.illusioni.scalabasics.medialibrary

case class MediaLibrary(items: Set[Content] = Set()) extends Collection[Content] {
  override def :+(newItem: Content): MediaLibrary = (super.:+(newItem)).asInstanceOf[MediaLibrary]
}

object MediaLibrary {

  def main(args: Array[String]): Unit = {
    val lost = Series("Lost", Action)

    val tatort = Series(
      "Der Tatort",
      Crime,
      List(
        Episode(1, 1),
        Episode(1, 2),
        Episode(2, 1),
        Episode(2, 2),
        Episode(2, 3)
      )
    )

    var myLib = MediaLibrary(lost, tatort)
    myLib = myLib :+ Movie("Wag the Dog", Comedy, "Barry Levinson")
    println(myLib)
  }

  def apply(items: Content*) = new MediaLibrary(Set(items: _*))
}
