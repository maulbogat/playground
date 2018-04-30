package maulbogat.roy.registry

trait CompositeRegistry[K, V] extends GenericRegistry[V] {

  override protected type Key = K

  protected def keyRegistry: GenericRegistry[K]

  override protected def getAllKeys: List[K] = keyRegistry.getAllValues

}