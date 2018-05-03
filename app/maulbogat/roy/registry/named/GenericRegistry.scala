package maulbogat.roy.registry.named

import maulbogat.roy.registry.Registry

private[registry] trait GenericRegistry[T] {
  _: Registry =>

  override protected[registry] type V = T // TODO make final

}