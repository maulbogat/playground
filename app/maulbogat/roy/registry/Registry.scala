package maulbogat.roy.registry

trait Registry {

  protected[registry] type Key

  protected[registry] type V

  def getAllValues: List[V] = getAllKeys.map(keyToValue)

  protected[registry] def getAllKeys: List[Key]

  protected def keyToValue(key: Key): V

}

object Registry {

  trait SimpleNamedRegistry extends Enumeration
    with EnumRegistry
    with NamedRegistry
    with IdentityRegistry {

    protected type NamedVal <: Val with NamedValue

    override protected[registry] type V = NamedVal

  }

  trait CompelledGenericRegistry[V] extends Enumeration
    with CompelledRegistry
    with GenericRegistry[V]

}