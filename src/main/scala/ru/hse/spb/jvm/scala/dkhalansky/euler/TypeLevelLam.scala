package ru.hse.spb.jvm.scala.dkhalansky.euler
import scala.language.higherKinds

object TypeLevelLam {

  sealed trait Maybe[T] {
    type or[O <: Maybe[T]] <: Maybe[T]
    type map[X, P[_ <: T] <: X] <: Maybe[X]
    type get[O <: T] <: T
  }

  class Nothing[T] extends Maybe[T] {
    type or[O <: Maybe[T]] = O
    type map[X, P[_ <: T] <: X] = Nothing[X]
    type get[O <: T] = O
  }

  class Just[T, A <: T] extends Maybe[T] {
    type or[_ <: Maybe[T]] = Just[T, A]
    type map[X, P[_ <: T] <: X] = Just[X, P[A]]
    type get[_ <: T] = A
  }

  sealed trait Bool {
    type select[U, A <: U, B <: U] <: U
    type and[O <: Bool] <: Bool
    type or[O <: Bool] <: Bool
    type not <: Bool
  }

  class T extends Bool {
    type select[U, A <: U, B <: U] = A
    type and[O <: Bool] = O
    type or[_ <: Bool] = T
    type not = F
  }

  class F extends Bool {
    type select[U, A <: U, B <: U] = B
    type and[_ <: Bool] = F
    type or[O <: Bool] = O
    type not = T
  }

  sealed trait Nat {
    type equals[N <: Nat] <: Bool
    type leq[N <: Nat] <: Bool
    type isZero <: Bool
    type pred <: Nat

    type plus[N <: Nat] <: Nat
    type mult[N <: Nat] <: Nat
    type fold[U, F[_ <: U] <: U, A <: U] <: U
  }

  class Z extends Nat {
    type equals[N <: Nat] = N#isZero
    type leq[_ <: Nat] = T
    type isZero = T
    type pred = Z

    type plus[N <: Nat] = N
    type mult[N <: Nat] = Z
    type fold[U, F[_ <: U] <: U, A <: U] = A
  }

  class S[Y <: Nat] extends Nat {
    type equals[N <: Nat] = N#isZero#not#and[Y#equals[N#pred]]
    type leq[N <: Nat] = N#isZero#not#and[Y#leq[N#pred]]
    type isZero = F
    type pred = Y

    type plus[N <: Nat] = S[Y#plus[N]]
    type mult[N <: Nat] = Y#mult[N]#plus[N]
    type fold[U, F[_ <: U] <: U, A <: U] = Y#fold[U, F, F[A]]
  }

  type _0 = Z
  type _1 = S[_0]
  type _2 = S[_1]
  type _3 = S[_2]
  type _4 = S[_3]
  type _5 = S[_4]
  type _6 = S[_5]
  type _7 = S[_6]
  type _8 = S[_7]
  type _9 = S[_8]
  type _10 = S[_9]
  type _100 = _10#mult[_10]

  sealed trait Term {
    type onVars[Rel[_ <: Nat, _ <: Nat] <: Bool,
                Trans[_ <: Nat, _ <: Nat] <: Term,
                Depth <: Nat] <: Term
    type normalStep <: Maybe[Term]
    type body <: Maybe[Term]
  }

  class L[X <: Term] extends Term {
    type onVars[Rel[_ <: Nat, _ <: Nat] <: Bool,
                Trans[_ <: Nat, _ <: Nat] <: Term,
                Depth <: Nat] = L[X#onVars[Rel, Trans, S[Depth]]]
    type normalStep = X#normalStep#map[Term, L]
    type body = Just[Term, X]
  }

  class A[X <: Term, Y <: Term] extends Term {
    type onVars[Rel[_ <: Nat, _ <: Nat] <: Bool,
                Trans[_ <: Nat, _ <: Nat] <: Term,
                Depth <: Nat] =
      A[X#onVars[Rel, Trans, Depth], Y#onVars[Rel, Trans, Depth]]
    type normalStep =
      X#body#map[Term, ({ type Z[R <: Term] = TermOps.beta[R, Y] })#Z]#or[
        X#normalStep#map[Term, ({ type Z[R <: Term] = A[R, Y] })#Z]]#or[
        Y#normalStep#map[Term, ({ type Z[R <: Term] = A[X, R] })#Z]]
    type body = Nothing[Term]
  }

  class V[I <: Nat] extends Term {
    type onVars[Rel[_ <: Nat, _ <: Nat] <: Bool,
                Trans[_ <: Nat, _ <: Nat] <: Term,
                Depth <: Nat] =
      Rel[Depth, I]#select[Term, Trans[Depth, I], V[I]]
    type normalStep = Nothing[Term]
    type body = Nothing[Term]
  }

  object TermOps {

    type shift[Off <: Nat, T <: Term] =
      T#onVars[({ type L[D <: Nat, I <: Nat] = D#leq[I] })#L,
               ({ type L[D <: Nat, I <: Nat] = V[I#plus[Off]] })#L,
               Z]

    type shiftM1[T <: Term] =
      T#onVars[({ type L[D <: Nat, I <: Nat] = D#leq[I] })#L,
               ({ type L[D <: Nat, I <: Nat] = V[I#pred] })#L,
               Z]

    type subst[J <: Nat, S <: Term, T <: Term] =
      T#onVars[({ type L[D <: Nat, I <: Nat] = D#plus[J]#equals[I] })#L,
               ({ type L[D <: Nat, I <: Nat] = shift[D, S] })#L,
               Z]

    type beta[T <: Term, O <: Term] = shiftM1[subst[Z, shift[_1, O], T]]

    type reduce[N <: Nat, T <: Term] =
      N#fold[Term, ({ type Z[R <: Term] = R#normalStep#get[R] })#Z, T]

  }

  object Test {

    implicitly[_3#mult[_2] =:= _6]
    implicitly[_3#plus[_2] =:= _5]

    // takes forever!
    // implicitly[_5#mult[_10]#plus[_5#mult[_10]] =:= _100]

    type term1 = L[L[L[A[A[V[_2], V[_3]], V[_1]]]]]
    type term2 = L[A[A[V[_2], V[_0]], V[_1]]]
    type tomega = L[A[V[_0], V[_0]]]
    type tOmega = A[tomega, tomega]
    type tI = L[V[_0]]

    type tTrue = L[L[V[_1]]]
    type tFalse = L[L[V[_0]]]
    type tIf = tI
    type tOr = L[L[A[A[V[_1], tTrue], V[_0]]]]
    type tAnd = L[L[A[A[V[_1], V[_0]], tFalse]]]

    implicitly[TermOps.shift[_4, term1] =:= L[L[L[A[A[V[_2], V[_7]], V[_1]]]]]]

    implicitly[TermOps.shiftM1[TermOps.shift[_1, term1]] =:= term1]

    implicitly[
      TermOps.subst[_0, V[_0], term2] =:= L[A[A[V[_2], V[_0]], V[_1]]]]
    implicitly[
      TermOps.subst[_0, V[_1], term2] =:= L[A[A[V[_2], V[_0]], V[_2]]]]
    implicitly[
      TermOps.subst[_0, V[_2], term2] =:= L[A[A[V[_2], V[_0]], V[_3]]]]
    implicitly[
      TermOps.subst[_1, V[_0], term2] =:= L[A[A[V[_1], V[_0]], V[_1]]]]
    implicitly[
      TermOps.subst[_2, V[_0], term2] =:= L[A[A[V[_2], V[_0]], V[_1]]]]

    implicitly[TermOps.beta[L[V[_0]], V[_8]] =:= L[V[_0]]]
    implicitly[TermOps.beta[L[V[_1]], V[_8]] =:= L[V[_9]]]

    implicitly[A[tI, tOmega]#normalStep =:= Just[Term, tOmega]]

    implicitly[TermOps.reduce[_5, A[A[tAnd, tFalse], tTrue]] =:= tFalse]

  }

}
