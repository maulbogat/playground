package maulbogat.roy.example.event

import maulbogat.roy.registry._
import maulbogat.roy.registry.named.DefaultRegistryError

object EventRegistry extends NamedExternalRegistry[Event]
  with DefaultRegistryError {

  val userCreated: Register[Event] = register(UserCreatedEvent)

  val userDeleted: Register[Event] = register(UserDeletedEvent)

  val productCreated: Register[Event] = register(ProductCreatedEvent)

  val productDeleted: Register[Event] = register(ProductDeletedEvent)

  override def error(name: String): Throwable = new IllegalArgumentException(s"unknown event: $name")

}