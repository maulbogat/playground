package maulbogat.roy.registry

trait IdentityRegistry {
  _: Registry =>

  final override protected[registry] type Key = V

  final override protected def keyToValue(key: Key): V = key

}