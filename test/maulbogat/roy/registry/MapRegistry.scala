package maulbogat.roy.registry

trait MapRegistry[S, T] extends Registry {

  protected def map: Map[S, T]

  final override protected[registry] type K = S

  final override protected[registry] type V = T

  final override protected[registry] def getAllKeys: List[S] = map.keys.toList

  final override protected def keyToValue(key: S): T = map(key)

}