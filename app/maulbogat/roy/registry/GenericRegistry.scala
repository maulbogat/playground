package maulbogat.roy.registry

trait GenericRegistry[T] extends Registry {

  final override protected[registry] type V = T

}