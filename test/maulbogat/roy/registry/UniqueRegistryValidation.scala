package maulbogat.roy.registry

object UniqueRegistryValidation {

  private def getDuplications[T](all: List[T]): Set[T] = {
    val duplications = all diff all.distinct
    duplications.toSet
  }

  def getDuplicateKeys(registry: RegistryKeyGetter with RegistryKey): Set[RegistryKey#K] = getDuplications(registry.getAllKeys)

  def getDuplicateValues(registry: Registry with RegistryValue): Set[RegistryValue#V] = getDuplications(registry.getAllValues)

  def getDuplicateNames(registry: NamedRegistry): Set[String] = getDuplications(registry.getAllNames)

}