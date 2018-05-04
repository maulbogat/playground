package maulbogat.roy.registry

private[registry] trait GenericRegistry[T <: Registered[_]] {
  _: Registry =>

  final override protected[registry] type V = T

}