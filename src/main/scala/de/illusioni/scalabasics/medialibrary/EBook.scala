package de.illusioni.scalabasics.medialibrary

case class EBook(title: String, genre: Genre, author: String, media: Option[Media] = None) extends Content