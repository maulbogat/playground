package maulbogat.roy.registry

trait IdentityRegistry {
  _: Registry =>

  override protected[registry] type Key = V

  protected def keyToValue(key: Key): V = key

}