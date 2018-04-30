package maulbogat.roy

import scala.reflect.ClassTag

trait ByType {
  _: Registry =>

  def getByType[T <: V : ClassTag]: List[T] = getAllValues.collect { case t: T => t }

}