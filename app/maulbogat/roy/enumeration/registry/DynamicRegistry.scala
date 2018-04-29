package maulbogat.roy.enumeration.registry

trait DynamicRegistry[T, S] extends TypedRegistry[T] {

  override final protected type EnumVal = RegisterVal

  protected def nameRegistry: Registry[S]

  protected def fromName(name: S): T

  nameRegistry
    .getAllRegistered
    .map(name => register(fromName(name)))

}

trait NamedDynamicRegistry[T, S] extends DynamicRegistry[T, S] {

  def findRegistered(name: String): Option[T] = nameRegistry
    .findRegistered(name)
    .map(fromName)

  protected def nameRegistry: NamedRegistry[S]

}