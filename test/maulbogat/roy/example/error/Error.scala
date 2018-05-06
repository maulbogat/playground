package maulbogat.roy.example.error

import maulbogat.roy.registry.named.NamedRegistered

sealed trait Error extends NamedRegistered[Error]

sealed trait UserError extends Error

case object UserCreatedError extends UserError {
  override val registration: NamedRegistration = () => ErrorRegistry.userCreated
}

case object UserDeletedError extends UserError {
  override val registration: NamedRegistration = () => ErrorRegistry.userDeleted
}

sealed trait ProductError extends Error

case object ProductCreatedError extends ProductError {
  override val registration: NamedRegistration = () => ErrorRegistry.productCreated
}

case object ProductDeletedError extends ProductError {
  override val registration: NamedRegistration = () => ErrorRegistry.productDeleted
}