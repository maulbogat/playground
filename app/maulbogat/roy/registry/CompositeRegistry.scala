package maulbogat.roy.registry

trait CompositeRegistry[S <: Registered[S], T <: Registered[S]] extends Registry with GenericRegistry[T] {

  protected def keyRegistry: ExternalRegistry[S]

  final override protected[registry] type K = S

  final override protected[registry] def getAllKeys: List[S] = keyRegistry.getAllValues

}

trait CompositeRegistered[T <: Registered[T]] extends Registered[T] {

  protected def registered: T

  final override def registration: Registration = registered.registration

}