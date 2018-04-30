package maulbogat.roy.event

import maulbogat.roy._

object EventRegistry extends Enumeration
  with ObligatedRegistry
  with GenericRegistry[Event]
  with ByType
  with NamedRegistry
  with DefaultError {

  val userCreated: Register[Event] = register(UserCreatedEvent)

  val userDeleted: Register[Event] = register(UserDeletedEvent)

  val productCreated: Register[Event] = register(ProductCreatedEvent)

  val productDeleted: Register[Event] = register(ProductDeletedEvent)

  override protected def error(name: String): Throwable = new IllegalAccessException(s"unknown event: $name")

}