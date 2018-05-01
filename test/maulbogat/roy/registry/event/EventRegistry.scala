package maulbogat.roy.registry.event

import maulbogat.roy.registry.Registry.CompelledGenericRegistry
import maulbogat.roy.registry._

object EventRegistry extends CompelledGenericRegistry[Event]
  with NamedRegistry
  with RegistryDefaultError
  with RegistryByType {

  val userCreated: Register[Event] = register(UserCreatedEvent)

  val userDeleted: Register[Event] = register(UserDeletedEvent)

  val productCreated: Register[Event] = register(ProductCreatedEvent)

  val productDeleted: Register[Event] = register(ProductDeletedEvent)

  override protected def error(name: String): Throwable = new IllegalAccessException(s"unknown event: $name")

}