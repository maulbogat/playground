package maulbogat.roy.registry.event

import maulbogat.roy._
import maulbogat.roy.registry._

object EventRegistry extends Enumeration
  with CompelledRegistry
  with GenericRegistry[Event]
  with ByTypeRegistry
  with NamedRegistry
  with RegistryDefaultError {

  val userCreated: Register[Event] = register(UserCreatedEvent)

  val userDeleted: Register[Event] = register(UserDeletedEvent)

  val productCreated: Register[Event] = register(ProductCreatedEvent)

  val productDeleted: Register[Event] = register(ProductDeletedEvent)

  override protected def error(name: String): Throwable = new IllegalAccessException(s"unknown event: $name")

}