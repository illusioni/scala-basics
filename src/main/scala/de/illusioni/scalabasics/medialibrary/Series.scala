package de.illusioni.scalabasics.medialibrary

case class Series(title: String, genre: Genre, episodes: List[Episode] = Nil) extends Content

case class Episode(seasonNr: Int, nr: Int)