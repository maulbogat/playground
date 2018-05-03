package maulbogat.roy.registry

trait CompositeRegistry[S, T] extends Registry with GenericRegistry[T] {

  protected def keyRegistry: ExternalRegistry[S]

  final override protected[registry] type K = S

  final override protected[registry] def getAllKeys: List[S] = keyRegistry.getAllValues

}