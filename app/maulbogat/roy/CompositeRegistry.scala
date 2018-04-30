package maulbogat.roy

trait CompositeRegistry[K, V <: Registered[K]] extends GenericRegistry[V] {

  override protected type Key = K

  protected def keyRegistry: GenericRegistry[K]

  override protected def getAllKeys: List[K] = keyRegistry.getAllValues

}