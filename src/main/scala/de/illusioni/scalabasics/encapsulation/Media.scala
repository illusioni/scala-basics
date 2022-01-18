package de.illusioni.scalabasics.encapsulation

import java.nio.file.Path

class Media(var path: String) {
//  private var fileRef: Path = Path.of(path)

//  def path_=(newVal: String) = {
//    fileRef = Path.of(newVal)
//  }

}


object Main {
  def main(args: Array[String]): Unit = {
    val m = new Media ("old/path")
    m.path = "new/path"
  }
}