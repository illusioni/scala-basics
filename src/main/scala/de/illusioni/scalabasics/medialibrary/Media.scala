package de.illusioni.scalabasics.medialibrary

import java.nio.file.Path

case class Media(kind: Kind, path: String) {
//  private val fileRef = Path.of(path)
}
//Das Java Pendant wäre:
//public class Media {
//  public final Kind kind;
//  public final String path;
//  private final Path fileRef;
//
//  public Media(Kind kind, String path) {
//    this.kind = kind;
//    this.path = path;
//    fileRef = Path.of(path)
//  }
//}



sealed trait Kind
case object Video extends Kind
case object EPub extends Kind
case object Pdf extends Kind