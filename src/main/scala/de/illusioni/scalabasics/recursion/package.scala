package de.illusioni.scalabasics

import scala.collection.mutable

package object recursion {

  /**
   * This is for demonstration purposes. Consider using scalaz.Memo.immutableHashMapMemo
   */
  def memoize[A, B] (f: (A)=>B): (A)=>B = {
    new Cache(f)
  }

  private class Cache[A, B] (f: (A)=>B) extends Function1[A, B] {
    val cache = mutable.Map.empty[A, B]

    override def apply(a: A): B = {
      cache.getOrElseUpdate(a, f(a))
    }

  }
}
