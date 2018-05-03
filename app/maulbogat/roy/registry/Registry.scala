package maulbogat.roy.registry

import scala.reflect.ClassTag

private[registry] trait Registry {

  protected[registry] type K

  protected[registry] type V

  protected[registry] def getAllKeys: List[K]

  protected[registry] def keyToValue(key: K): V

  final def getByType[T <: V : ClassTag]: List[T] = getAllValues.collect { case t: T => t }

  final def getAllValues: List[V] = getAllKeys.map(keyToValue)

}