package maulbogat.roy.example.error

import maulbogat.roy.registry.named.{DefaultRegistryError, NamedExternalRegistry, NamedRegister}

object ErrorRegistry extends NamedExternalRegistry[Error]
  with DefaultRegistryError {

  val userCreated: NamedRegister[Error] = registerWithName("user.created", UserCreatedError)

  val userDeleted: NamedRegister[Error] = registerWithName("user.deleted", UserDeletedError)

  val productCreated: NamedRegister[Error] = registerWithName("product.created", ProductCreatedError)

  val productDeleted: NamedRegister[Error] = registerWithName("product.deleted", ProductDeletedError)

  override def error(name: String): Throwable = new IllegalArgumentException(s"unknown error: $name")

}