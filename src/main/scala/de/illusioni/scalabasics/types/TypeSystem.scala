package de.illusioni.scalabasics.types

object TypeSystem {
  def main(args: Array[String]): Unit = {
    var v1: Any = 1
    val v2: AnyVal = 5L
    val v3: AnyRef = "referenced string"
    val v4: AnyRef = new Object()
    v1 = v2
    v1 = v3
    val v5: Any = null
    val v6: AnyRef = null
    // val v6: AnyVal = null // doesn't compile: types incompatible
    // val v7: Any = ??? // compiles and throws at runtime: types compatible
  }

}
