package de.illusioni.scalabasics.medialibrary

trait Collection[T <: Content] { self: {def items: Set[Content]; def copy(items: Set[Content]): Collection[T]} =>
  def :+(newItem: Content) = copy(items + newItem)
}
