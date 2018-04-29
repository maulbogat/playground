package maulbogat.roy.enumeration.registry

trait TypedRegistry[T] extends Registry[T] {

  def register(element: T): Registration[T] = TypedRegisterVal(element)

  protected case class TypedRegisterVal(element: T) extends RegisterVal

}