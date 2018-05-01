package maulbogat.roy.registry

object UniqueRegistryValidation {

  private def getDuplications[T](all: List[T]): Set[T] = {
    val duplications = all diff all.distinct
    duplications.toSet
  }

  def getDuplicateKeys(registry: Registry): Set[registry.Key] = getDuplications(registry.getAllKeys)

  def getDuplicateValues(registry: Registry): Set[registry.V] = getDuplications(registry.getAllValues)

  def getDuplicateNames(registry: NamedRegistry): Set[String] = getDuplications(registry.getAllNames)

}