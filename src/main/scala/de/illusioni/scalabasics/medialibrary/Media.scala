package de.illusioni.scalabasics.medialibrary

case class Media(kind: Kind, path: String)

sealed trait Kind
case object Video extends Kind
case object EPub extends Kind
case object Pdf extends Kind