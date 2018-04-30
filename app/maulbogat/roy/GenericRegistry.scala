package maulbogat.roy

trait GenericRegistry[T] extends Registry {

  override protected type V = T

}