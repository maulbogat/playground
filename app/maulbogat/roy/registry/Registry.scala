package maulbogat.roy.registry

trait Registry {

  protected type Key

  protected type V

  def getAllValues: List[V] = getAllKeys.map(keyToValue)

  protected def getAllKeys: List[Key]

  protected def keyToValue(key: Key): V

}

object Registry {

  trait SimpleNamedRegistry extends Enumeration
    with EnumRegistry
    with NamedRegistry
    with IdentityRegistry {

    protected type NamedVal <: Val with NamedValue

    override protected type V = NamedVal

  }

  trait CompelledGenericRegistry[V] extends Enumeration
    with CompelledRegistry
    with GenericRegistry[V]

}