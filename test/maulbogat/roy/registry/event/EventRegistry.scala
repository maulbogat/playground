package maulbogat.roy.registry.event

import maulbogat.roy.registry._

object EventRegistry extends ActiveRegistry[Event]
  with GenericNamedRegistry[Event]
  with TypedRegistry
  with RegistryDefaultError {

  val userCreated: Register[Event] = register(UserCreatedEvent)

  val userDeleted: Register[Event] = register(UserDeletedEvent)

  val productCreated: Register[Event] = register(ProductCreatedEvent)

  val productDeleted: Register[Event] = register(ProductDeletedEvent)

  override def error(name: String): Throwable = new IllegalAccessException(s"unknown event: $name")

}