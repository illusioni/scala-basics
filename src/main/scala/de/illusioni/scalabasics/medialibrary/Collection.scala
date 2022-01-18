package de.illusioni.scalabasics.medialibrary

trait Collection[ImplType, ItemType <: Content] {
  self: {def items: Set[Content]; def copy(items: Set[Content]): Collection[ImplType, ItemType]} =>

  def :+(newItem: Content): ImplType = {
    val collectionWithNewItem = copy(items + newItem)
    collectionWithNewItem.asInstanceOf[ImplType]
  }

}
