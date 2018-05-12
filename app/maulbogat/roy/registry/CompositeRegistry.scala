package maulbogat.roy.registry

import maulbogat.roy.registry.named.{GenericNamedRegistry, NamedRegistered}

trait CompositeRegistry[S, T <: Registered[S]] extends Registry with GenericRegistry[T] {

  protected def keyRegistry: ExternalRegistry[S]

  final override protected[registry] type K = S

  final override protected[registry] def getAllKeys: List[S] = keyRegistry.getAllValues

}

trait NamedCompositeRegistry[S, T <: NamedRegistered[S]] extends CompositeRegistry[S, T] with GenericNamedRegistry[T]