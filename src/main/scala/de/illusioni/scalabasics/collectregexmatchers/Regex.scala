package de.illusioni.scalabasics.collectregexmatchers

object Regex {
  def main(args: Array[String]): Unit = {
    val fullNamePattern = "([A-Z][a-z]+) ([A-Z][a-z]+)".r
    val strings = Seq("Maxi Erlbacher", "Felix Zenth", "Klaus Baumgartner", "Ali Baba's flying carpet", "25 ducks")
    for (s <- strings) s match {
      case fullNamePattern(first, last) => println(s"$first's last name is $last")
      case x: AnyRef => println("This string doesn't match the full name pattern: " + x)
    }

    //This is at least as much a scala collections exercise as it is a regex exercise.
    //Turn strings with sentences (words, spaces, and punctuation)...
    val string = "This is a sentence. Here is another one."
    //... into something like this: "(4) (2) (1) (8). (4) (2) (7) (3)."
    val wordPattern = "[A-Za-z]+".r
    val words = wordPattern.findAllMatchIn(string).map(_.matched).toSeq
    //for (w <- words) println("Found the word " + w)
    val betweenWords = Seq(wordPattern.split(string): _*)
    val wordInfos = words.map(w => s"(${w.length})")
    def intersperse(sA: Seq[String], sB: Seq[String]): Seq[String] = sA match {
      case head :: tail => head +: intersperse(sB, tail)
      case _ => sB
    }
    val structuralInfo = intersperse(betweenWords, wordInfos).mkString
    println(structuralInfo)
  }
}
