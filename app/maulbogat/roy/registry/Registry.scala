package maulbogat.roy.registry

import scala.reflect.ClassTag

trait Registry extends RegistryKeyGetter {

  protected[registry] type V

  final def getByType[T <: V : ClassTag]: List[T] = getAllValues.collect { case t: T => t }

  final def getAllValues: List[V] = getAllKeys.map(keyToValue)

  protected[registry] def keyToValue(key: K): V

}

trait RegistryKeyGetter {

  protected[registry] type K

  protected[registry] def getAllKeys: List[K]

}