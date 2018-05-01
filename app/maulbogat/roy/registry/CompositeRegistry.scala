package maulbogat.roy.registry

trait CompositeRegistry[K, V] extends GenericRegistry[V] {

  override protected[registry] type Key = K

  protected def keyRegistry: GenericRegistry[K]

  override protected[registry] def getAllKeys: List[K] = keyRegistry.getAllValues

}