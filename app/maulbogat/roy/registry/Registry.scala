package maulbogat.roy.registry

trait Registry {

  protected[registry] type Key

  protected[registry] type V

  def getAllValues: List[V] = getAllKeys.map(keyToValue)

  protected[registry] def getAllKeys: List[Key]

  protected def keyToValue(key: Key): V

}

object Registry {

  trait SimpleRegistry extends Enumeration
    with EnumRegistry
    with IdentityRegistry {

    final override protected[registry] type V = EnumVal

    protected type EnumVal <: Val

  }

  trait SimpleNamedRegistry extends SimpleRegistry
    with NamedRegistry {

    final override protected type EnumVal = NamedVal

    protected type NamedVal <: Val with NamedValue

  }

  trait CompelledGenericRegistry[V] extends Enumeration
    with CompelledRegistry
    with GenericRegistry[V]

}