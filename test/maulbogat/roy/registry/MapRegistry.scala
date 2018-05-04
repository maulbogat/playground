package maulbogat.roy.registry

case class MapRegistry[S, T](map: Map[S, T]) extends Registry {

  override protected[registry] type K = S

  override protected[registry] type V = T

  override protected[registry] def getAllKeys: List[S] = map.keys.toList

  override protected def keyToValue(key: S): T = map(key)

}