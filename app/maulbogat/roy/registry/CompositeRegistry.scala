package maulbogat.roy.registry

trait CompositeRegistry[S, T] extends Registry {

  final override protected[registry] type K = S

  final override protected[registry] type V = T

  final override protected[registry] def getAllKeys: List[S] = keyRegistry.getAllValues

  protected def keyRegistry: Registry with ActiveRegistry[S]

}