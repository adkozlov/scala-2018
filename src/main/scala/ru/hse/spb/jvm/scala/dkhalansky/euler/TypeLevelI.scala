package ru.hse.spb.jvm.scala.dkhalansky.euler
import scala.language.higherKinds

object TypeLevelI {

  trait Pair[A, B] {
    type fst = A
    type snd = B
  }

  class CPair[A, B, X <: A, Y <: B] extends Pair[A, B] {}

  object Maybe {

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

  }

  object Bool {

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

  }

  object Bin {

    import Bool._

    sealed trait Bin {
      type isZero <: Bool
      type suc <: Bin
      type norm <: Bin
      type pred <: Bin
      type add[Y <: Bin] <: Bin
      type mul[Y <: Bin] <: Bin
      type sub[Y <: Bin] <: Bin
      type le[Y <: Bin] <: Bool
      type mod2 <: Bin
      type halve <: Bin

      type natCata[U, F[_ <: Bin, _ <: U] <: U, A <: U] <: U

      protected type addO[Y <: Bin] <: Bin
      protected type addI[Y <: Bin] <: Bin
      protected type subFromO[Y <: Bin] <: Bin
      protected type subFromI[Y <: Bin] <: Bin
      protected type leO[Y <: Bin] <: Bool
      protected type leI[Y <: Bin] <: Bool
    }

    class E extends Bin {
      type isZero = T
      type suc = I[E]
      type norm = E
      type pred = E
      type add[Y <: Bin] = Y
      type mul[Y <: Bin] = E
      type sub[Y <: Bin] = E
      type le[Y <: Bin] = T
      type mod2 = E
      type halve = E

      type natCata[U, F[_ <: Bin, _ <: U] <: U, A <: U] = A

      protected type addO[Y <: Bin] = O[Y]
      protected type addI[Y <: Bin] = I[Y]
      protected type subFromO[Y <: Bin] = O[Y]
      protected type subFromI[Y <: Bin] = I[Y]
      protected type leO[Y <: Bin] = T
      protected type leI[Y <: Bin] = T
    }

    class O[B <: Bin] extends Bin {
      type isZero = B#isZero
      type suc = I[B]
      type norm = B#isZero#select[Bin, E, O[B#norm]]
      type pred = I[B#pred]
      type add[Y <: Bin] = Y#addO[B]
      type sub[Y <: Bin] = Y#subFromO[B]
      type le[Y <: Bin] = Y#suc#leO[B]#not
      type mul[Y <: Bin] = O[B#mul[Y]]#norm
      type mod2 = E
      type halve = B

      type natCata[U, F[_ <: Bin, _ <: U] <: U, A <: U] =
        F[O[B], pred#natCata[U, F, A]]

      protected type addO[Y <: Bin] = O[B#add[Y]]
      protected type addI[Y <: Bin] = I[B#add[Y]]
      protected type subFromO[Y <: Bin] = O[Y#sub[B]]#norm
      protected type subFromI[Y <: Bin] = I[Y#sub[B]]
      protected type leO[Y <: Bin] = B#le[Y]
      protected type leI[Y <: Bin] = B#le[Y]
    }

    class I[B <: Bin] extends Bin {
      type isZero = F
      type suc = O[B#suc]
      type norm = I[B#norm]
      type pred = O[B]#norm
      type add[Y <: Bin] = Y#addI[B]
      type sub[Y <: Bin] = Y#subFromI[B]
      type le[Y <: Bin] = Y#suc#leI[B]#not
      type mul[Y <: Bin] = O[B#mul[Y]]#norm#add[Y]
      type mod2 = I[E]
      type halve = B

      type natCata[U, F[_ <: Bin, _ <: U] <: U, A <: U] =
        F[I[B], pred#natCata[U, F, A]]

      protected type addO[Y <: Bin] = I[B#add[Y]]
      protected type addI[Y <: Bin] = O[B#add[Y]#suc]
      protected type subFromO[Y <: Bin] = I[Y#pred#sub[B]]
      protected type subFromI[Y <: Bin] = O[Y#sub[B]]#norm
      protected type leO[Y <: Bin] = B#suc#le[Y]
      protected type leI[Y <: Bin] = B#le[Y]
    }

    type _0 = E
    type _1 = I[E]
    type _2 = O[I[E]]
    type _3 = I[I[E]]
    type _4 = O[O[I[E]]]
    type _5 = I[O[I[E]]]
    type _6 = O[I[I[E]]]
    type _7 = I[I[I[E]]]
    type _8 = O[O[O[I[E]]]]
    type _9 = I[O[O[I[E]]]]
    type _10 = O[I[O[I[E]]]]
    type _11 = I[I[O[I[E]]]]
    type _12 = O[O[I[I[E]]]]
    type _13 = I[O[I[I[E]]]]
    type _14 = O[I[I[I[E]]]]
    type _15 = I[I[I[I[E]]]]
    type _16 = O[O[O[O[I[E]]]]]
    type _17 = I[O[O[O[I[E]]]]]
    type _18 = O[I[O[O[I[E]]]]]

    import Maybe._

    object Ops {
      type find[U, F[_ <: Bin] <: Maybe[U], N <: Bin] =
        N#suc#natCata[Maybe[U],
                      ({
                        type Z[A <: Bin, B <: Maybe[U]] = F[N#suc#sub[A]]#or[B]
                      })#Z,
                      Nothing[U]]

      type eq[A <: Bin, B <: Bin] = A#le[B]#and[B#le[A]]

      type isSquare[N <: Bin] =
        N#isZero#or[N#halve#suc#natCata[Bool,
                                        ({
                                          type Z[X <: Bin, B <: Bool] =
                                            eq[N, X#mul[X]]#or[B]
                                        })#Z,
                                        F]]
    }

    implicitly[_3#add[_6] =:= _9]
    implicitly[_2#add[_6] =:= _8]

    implicitly[_0#sub[_0] =:= _0]
    implicitly[_1#sub[_1] =:= _0]
    implicitly[_6#sub[_4] =:= _2]
    implicitly[_6#sub[_2] =:= _4]
    implicitly[_2#sub[_1] =:= _1]

    implicitly[_0#le[_0] =:= T]
    implicitly[_0#le[_1] =:= T]
    implicitly[_0#le[_2] =:= T]
    implicitly[_0#le[_3] =:= T]
    implicitly[_0#le[_4] =:= T]
    implicitly[_0#le[_5] =:= T]
    implicitly[_0#le[_6] =:= T]
    implicitly[_0#le[_7] =:= T]
    implicitly[_0#le[_8] =:= T]
    implicitly[_0#le[_9] =:= T]
    implicitly[_1#le[_0] =:= F]
    implicitly[_1#le[_1] =:= T]
    implicitly[_1#le[_2] =:= T]
    implicitly[_1#le[_3] =:= T]
    implicitly[_1#le[_4] =:= T]
    implicitly[_1#le[_5] =:= T]
    implicitly[_1#le[_6] =:= T]
    implicitly[_1#le[_7] =:= T]
    implicitly[_1#le[_8] =:= T]
    implicitly[_1#le[_9] =:= T]
    implicitly[_2#le[_0] =:= F]
    implicitly[_2#le[_1] =:= F]
    implicitly[_2#le[_2] =:= T]
    implicitly[_2#le[_3] =:= T]
    implicitly[_2#le[_4] =:= T]
    implicitly[_2#le[_5] =:= T]
    implicitly[_2#le[_6] =:= T]
    implicitly[_2#le[_7] =:= T]
    implicitly[_2#le[_8] =:= T]
    implicitly[_2#le[_9] =:= T]
    implicitly[_3#le[_0] =:= F]
    implicitly[_3#le[_1] =:= F]
    implicitly[_3#le[_2] =:= F]
    implicitly[_3#le[_3] =:= T]
    implicitly[_3#le[_4] =:= T]
    implicitly[_3#le[_5] =:= T]
    implicitly[_3#le[_6] =:= T]
    implicitly[_3#le[_7] =:= T]
    implicitly[_3#le[_8] =:= T]
    implicitly[_3#le[_9] =:= T]
    implicitly[_4#le[_0] =:= F]
    implicitly[_4#le[_1] =:= F]
    implicitly[_4#le[_2] =:= F]
    implicitly[_4#le[_3] =:= F]
    implicitly[_4#le[_4] =:= T]
    implicitly[_4#le[_5] =:= T]
    implicitly[_4#le[_6] =:= T]
    implicitly[_4#le[_7] =:= T]
    implicitly[_4#le[_8] =:= T]
    implicitly[_4#le[_9] =:= T]
    implicitly[_5#le[_0] =:= F]
    implicitly[_5#le[_1] =:= F]
    implicitly[_5#le[_2] =:= F]
    implicitly[_5#le[_3] =:= F]
    implicitly[_5#le[_4] =:= F]
    implicitly[_5#le[_5] =:= T]
    implicitly[_5#le[_6] =:= T]
    implicitly[_5#le[_7] =:= T]
    implicitly[_5#le[_8] =:= T]
    implicitly[_5#le[_9] =:= T]

    implicitly[_10#mul[_10]#le[_10#mul[_10]#suc] =:= T]

    implicitly[_0#norm =:= _0]
    implicitly[_1#norm =:= _1]
    implicitly[_2#norm =:= _2]
    implicitly[_3#norm =:= _3]
    implicitly[I[I[O[O[O[E]]]]]#norm =:= _3]

    implicitly[_1#pred =:= _0]
    implicitly[_2#pred =:= _1]
    implicitly[_3#pred =:= _2]
    implicitly[_4#pred =:= _3]
    implicitly[_5#pred =:= _4]
    implicitly[_6#pred =:= _5]
    implicitly[_7#pred =:= _6]
    implicitly[_8#pred =:= _7]
    implicitly[_9#pred =:= _8]
    implicitly[_10#pred =:= _9]
    implicitly[_11#pred =:= _10]

    implicitly[_0#suc =:= _1]
    implicitly[_1#suc =:= _2]
    implicitly[_2#suc =:= _3]
    implicitly[_3#suc =:= _4]
    implicitly[_4#suc =:= _5]
    implicitly[_5#suc =:= _6]
    implicitly[_6#suc =:= _7]
    implicitly[_7#suc =:= _8]
    implicitly[_8#suc =:= _9]
    implicitly[_9#suc =:= _10]
    implicitly[_10#suc =:= _11]
    implicitly[_11#suc =:= _12]

    implicitly[_4#natCata[Bin,
                          ({ type Z[A <: Bin, B <: Bin] = A#add[B] })#Z,
                          _0] =:= _10]

    implicitly[_4#natCata[Bin,
                          ({ type Z[A <: Bin, B <: Bin] = A#add[B] })#Z,
                          _0] =:= _10]

    implicitly[
      Ops.find[Bin, ({ type Z[N <: Bin] = Just[Bin, N] })#Z, _10] =:= Just[Bin,
                                                                           _0]]
    implicitly[
      Ops.find[Bin,
               ({
                 type Z[N <: Bin] =
                   N#le[_5]#not#select[Maybe[Bin], Just[Bin, N], Nothing[Bin]]
               })#Z,
               _10] =:= Just[Bin, _6]]

    implicitly[Ops.eq[_3, _3] =:= T]
    implicitly[Ops.eq[_4, _4] =:= T]
    implicitly[Ops.eq[_0, _0] =:= T]
    implicitly[Ops.eq[_0, _1] =:= F]

    implicitly[Ops.isSquare[_0] =:= T]
    implicitly[Ops.isSquare[_1] =:= T]
    implicitly[Ops.isSquare[_2] =:= F]
    implicitly[Ops.isSquare[_3] =:= F]
    implicitly[Ops.isSquare[_4] =:= T]
    implicitly[Ops.isSquare[_5] =:= F]
    implicitly[Ops.isSquare[_6] =:= F]
    implicitly[Ops.isSquare[_7] =:= F]
    implicitly[Ops.isSquare[_8] =:= F]
    implicitly[Ops.isSquare[_9] =:= T]

  }

  object TList {

    import Maybe._
    import Bool._

    trait TList[A] {

      type head <: Maybe[A]
      type tail <: Maybe[TList[A]]

      type map[B, F[_ <: A] <: B] <: TList[B]

      type foldr[B, F[_ <: A, _ <: B] <: B, X <: B] <: B

      type zip[B, X <: TList[B]] <: TList[Pair[A, B]]

      type append[X <: TList[A]] <: TList[A]

      type isNil <: Bool

      protected type zipToCons[B, Y <: B, X <: TList[B]] <: TList[Pair[B, A]]

    }

    class Nil[A] extends TList[A] {

      type head = Nothing[A]
      type tail = Nothing[TList[A]]

      type map[B, F[_ <: A] <: B] = Nil[B]

      type foldr[B, F[_ <: A, _ <: B] <: B, X <: B] = X

      type zip[B, X <: TList[B]] = Nil[Pair[A, B]]

      type append[X <: TList[A]] = X

      type isNil = T

      protected type zipToCons[B, Y <: B, X <: TList[B]] = Nil[Pair[B, A]]

    }

    class Cons[A, Hd <: A, Tl <: TList[A]] extends TList[A] {

      type head = Just[A, Hd]
      type tail = Just[TList[A], Tl]

      type map[B, F[_ <: A] <: B] = Cons[B, F[Hd], Tl#map[B, F]]

      type foldr[B, F[_ <: A, _ <: B] <: B, X <: B] = F[Hd, Tl#foldr[B, F, X]]

      type zip[B, X <: TList[B]] = X#zipToCons[A, Hd, Tl]

      type append[X <: TList[A]] = Cons[A, Hd, Tl#append[X]]

      type isNil = F

      protected type zipToCons[B, Y <: B, X <: TList[B]] =
        Cons[Pair[B, A], CPair[B, A, Y, Hd], X#zip[A, Tl]]

    }

    import Bin._

    object Ops {

      type sum[L <: TList[Bin]] =
        L#foldr[Bin, ({ type Z[A <: Bin, B <: Bin] = A#add[B] })#Z, _0]
      type replicate[U, B <: Bin, A <: U] =
        B#natCata[TList[U],
                  ({ type Z[_ <: Bin, B <: TList[U]] = Cons[U, A, B] })#Z,
                  Nil[U]]
      type range[B <: Bin] =
        B#suc#natCata[TList[Bin],
                      ({
                        type Z[R <: Bin, O <: TList[Bin]] =
                          Cons[Bin, B#suc#sub[R], O]
                      })#Z,
                      Nil[Bin]]

      type concat[U, X <: TList[TList[U]]] =
        X#foldr[TList[U],
                ({ type Z[A <: TList[U], B <: TList[U]] = A#append[B] })#Z,
                Nil[U]]
    }

    implicitly[Cons[Bin, _0, Cons[Bin, _1, Nil[Bin]]]#zip[
      Bool,
      Cons[Bool, T, Cons[Bool, F, Cons[Bool, F, Nil[Bool]]]]] =:=
      Cons[
        Pair[Bin, Bool],
        CPair[Bin, Bool, _0, T],
        Cons[Pair[Bin, Bool], CPair[Bin, Bool, _1, F], Nil[Pair[Bin, Bool]]]]]

    implicitly[Ops.sum[Cons[Bin, _2, Cons[Bin, _1, Nil[Bin]]]] =:= _3]
    implicitly[Ops.sum[Ops.replicate[Bin, _0, _2]] =:= _0]
    implicitly[Ops.sum[Ops.replicate[Bin, _1, _2]] =:= _2]
    implicitly[Ops.sum[Ops.replicate[Bin, _2, _2]] =:= _4]
    implicitly[Ops.sum[Ops.replicate[Bin, _3, _2]] =:= _6]

    implicitly[Ops.range[_3] =:= Cons[
      Bin,
      _0,
      Cons[Bin, _1, Cons[Bin, _2, Cons[Bin, _3, Nil[Bin]]]]]]

    implicitly[Cons[Bin, _0, Cons[Bin, _1, Nil[Bin]]]#append[Cons[
      Bin,
      _2,
      Cons[Bin, _3, Nil[Bin]]]] =:= Ops.range[_3]]

    implicitly[
      Ops.concat[Bin,
                 Cons[TList[Bin],
                      Cons[Bin, _0, Cons[Bin, _1, Nil[Bin]]],
                      Cons[TList[Bin],
                           Cons[Bin, _2, Cons[Bin, _3, Nil[Bin]]],
                           Nil[TList[Bin]]]]] =:= Ops.range[_3]]

  }

}
