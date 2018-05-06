package maulbogat.roy.example.event

import maulbogat.roy.registry.Registered.Registration
import maulbogat.roy.registry._
import maulbogat.roy.registry.named.{DefaultRegistryError, NamedExternalRegistry}

object EventRegistry extends NamedExternalRegistry[Event]
  with DefaultRegistryError {

  val userCreated: Registration[Event] = register(UserCreatedEvent)

  val userDeleted: Registration[Event] = register(UserDeletedEvent)

  val productCreated: Registration[Event] = register(ProductCreatedEvent)

  val productDeleted: Registration[Event] = register(ProductDeletedEvent)

  override def error(name: String): Throwable = new IllegalArgumentException(s"unknown event: $name")

}