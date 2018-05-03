package maulbogat.roy.registry

import maulbogat.roy.registry.named.NamedRegistry

object UniqueRegistryValidation {

  final def getDuplicateKeys(registry: Registry): Set[Registry#K] = getDuplications(registry.getAllKeys)

  final def getDuplicateValues(registry: Registry): Set[Registry#V] = getDuplications(registry.getAllValues)

  final def getDuplicateNames(registry: NamedRegistry): Set[String] = getDuplications(registry.getAllNames)

  private def getDuplications[T](all: List[T]): Set[T] = {
    val duplications = all diff all.distinct
    duplications.toSet
  }

}