package ru.spbau.jvm.scala.hlist

import scala.language.implicitConversions

sealed trait Nat

class O extends Nat

class S[T <: Nat] extends Nat
