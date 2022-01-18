package de.illusioni.scalabasics.medialibrary

case class MediaLibrary(items: Set[Content] = Set()) extends Collection[MediaLibrary, Content]

object MediaLibrary {

  def main(args: Array[String]): Unit = {

//    val movie = Movie("Wag the Dog", Comedy, "Barry Levinson", Some(Media(Video, "/tmp/wag-the-dog.avi")))
////    if (movie.media.nonEmpty) {
////      println(movie.media.get)
////    }
//
//    // movie.media.toString => never throws NullPointerException
//
//    println(movie)
//    movie.media match {
//      case Some(m) => println(s"the content has a media file of kind ${m.kind}: ${m.path}")
//      case None => println("the content has no media file associated with it")
//    }




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
