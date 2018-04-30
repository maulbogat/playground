package maulbogat.roy.registry

trait Registry {

  protected type Key

  protected type V

  def getAllValues: List[V] = getAllKeys.map(keyToValue)

  protected def getAllKeys: List[Key]

  protected def keyToValue(key: Key): V

}