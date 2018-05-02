package maulbogat.roy.registry

object UniqueRegistryValidation {

  final def getDuplicateKeys(registry: RegistryKeyGetter): Set[RegistryKeyGetter#K] = getDuplications(registry.getAllKeys)

  private def getDuplications[T](all: List[T]): Set[T] = {
    val duplications = all diff all.distinct
    duplications.toSet
  }

  final def getDuplicateValues(registry: Registry): Set[Registry#V] = getDuplications(registry.getAllValues)

  final def getDuplicateNames(registry: NamedRegistry): Set[String] = getDuplications(registry.getAllNames)

}