package maulbogat.roy.registry

import scala.reflect.ClassTag

trait TypedRegistry {
  _: Registry with RegistryValue =>

  final def getByType[T <: V : ClassTag]: List[T] = getAllValues.collect { case t: T => t }

}