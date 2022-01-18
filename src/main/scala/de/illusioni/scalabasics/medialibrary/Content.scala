package de.illusioni.scalabasics.medialibrary

trait Content { self: {def title: String; def genre: Genre} =>
}
