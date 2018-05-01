package maulbogat.roy.registry

trait WrappedEnumRegistry extends EnumRegistry {
  _: Enumeration =>

  override protected[registry] type Key <: Wrapper

  override protected def keyToValue(key: Key): V = key.element

  protected class Wrapper(val element: V) extends Val

}