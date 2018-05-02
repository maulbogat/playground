package maulbogat.roy.example.event

import maulbogat.roy.registry.{ActiveRegistry, GenericNamedRegistry, Register, RegistryDefaultError}

object EventRegistry extends ActiveRegistry[Event]
  with GenericNamedRegistry[Event]
  with RegistryDefaultError {

  val userCreated: Register[Event] = register(UserCreatedEvent)

  val userDeleted: Register[Event] = register(UserDeletedEvent)

  val productCreated: Register[Event] = register(ProductCreatedEvent)

  val productDeleted: Register[Event] = register(ProductDeletedEvent)

  override def error(name: String): Throwable = new IllegalAccessException(s"unknown event: $name")

}