package maulbogat.roy.registry

private[registry] trait GenericRegistry[T] {
  _: Registry =>

  final override protected[registry] type V = T

}