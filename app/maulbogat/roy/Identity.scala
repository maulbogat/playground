package maulbogat.roy

trait Identity {
  _: Registry =>

  override protected type Key = V

  protected def keyToValue(key: Key): V = key

}