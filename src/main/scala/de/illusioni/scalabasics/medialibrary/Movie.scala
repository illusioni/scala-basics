package de.illusioni.scalabasics.medialibrary

case class Movie(title: String, genre: Genre, director: String, media: Option[Media] = None) extends Content