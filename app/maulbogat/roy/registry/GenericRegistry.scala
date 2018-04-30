package maulbogat.roy.registry

trait GenericRegistry[T] extends Registry {

  override type V = T

}