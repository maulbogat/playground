package maulbogat.roy

trait Registry {

  protected type V

  protected type Key

  def getAllValues: List[V] = getAllKeys.map(keyToValue)

  protected def getAllKeys: List[Key]

  protected def keyToValue(key: Key): V

}