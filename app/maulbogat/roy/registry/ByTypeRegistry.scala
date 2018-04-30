package maulbogat.roy.registry

import scala.reflect.ClassTag

trait ByTypeRegistry {
  _: Registry =>

  def getByType[T <: V : ClassTag]: List[T] = getAllValues.collect { case t: T => t }

}