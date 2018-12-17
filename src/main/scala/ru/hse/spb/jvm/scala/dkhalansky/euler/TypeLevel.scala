package ru.hse.spb.jvm.scala.dkhalansky.euler
import shapeless.Lazy

object TypeFramework {

  // -------------------------------- Booleans --------------------------------

  object Bool {

    trait Bool
    trait True extends Bool
    trait False extends Bool

  }

  // --------------------------------- Pairs ----------------------------------

  object Pair {

    trait Pair[+A, +B]

  }

  // ----------------------------- Natural numbers ----------------------------

  object Nat {

    trait Nat
    trait Z extends Nat
    trait S[R <: Nat] extends Nat

    type _0 = Z
    type _1 = S[Z]
    type _2 = S[_1]
    type _3 = S[_2]
    type _4 = S[_3]
    type _5 = S[_4]
    type _6 = S[_5]
    type _7 = S[_6]
    type _8 = S[_7]
    type _9 = S[_8]

    trait NatAdd[A <: Nat, B <: Nat] { type Out <: Nat }
    object NatAdd {
      type Aux[A <: Nat, B <: Nat, C <: Nat] = NatAdd[A, B] { type Out = C }
      implicit def cZ[B <: Nat]: Aux[Z, B, B] = ???
      implicit def cS[A <: Nat, B <: Nat](
          implicit c: NatAdd[A, B]): Aux[S[A], B, S[c.Out]] = ???
    }

    implicitly[NatAdd.Aux[_3, _4, _7]]

    trait NatSub[A <: Nat, B <: Nat] { type Out <: Nat }
    object NatSub {
      type Aux[A <: Nat, B <: Nat, C <: Nat] = NatSub[A, B] { type Out = C }
      implicit def cB[A <: Nat]: Aux[A, Z, A] = ???
      implicit def cS[A <: Nat, B <: Nat](
          implicit c: NatSub[A, B]): Aux[S[A], S[B], c.Out] = ???
    }

    implicitly[NatSub.Aux[_7, _5, _2]]

    trait NatMult[A <: Nat, B <: Nat] { type Out <: Nat }
    object NatMult {
      type Aux[A <: Nat, B <: Nat, C <: Nat] = NatMult[A, B] { type Out = C }
      implicit def cZ[B <: Nat]: Aux[Z, B, Z] = ???
      implicit def cS[A <: Nat, B <: Nat, R <: Nat](
          implicit c: Aux[A, B, R],
          p: NatAdd[R, B]): Aux[S[A], B, p.Out] = ???
    }

    implicitly[NatMult.Aux[_3, _2, _6]]

    trait NatLt[A <: Nat, B <: Nat]
    object NatLt {
      implicit def cA[B <: Nat]: NatLt[Z, S[B]] = ???
      implicit def cS[A <: Nat, B <: Nat](
          implicit c: NatLt[A, B]): NatLt[S[A], S[B]] = ???
    }

    implicitly[NatLt[_0, _8]]
    implicitly[NatLt[_0, _1]]
    implicitly[NatLt[_7, _8]]

    trait NatQuotRem[A <: Nat, B <: Nat] { type Out <: Pair.Pair[Nat, Nat] }
    object NatQuotRem {
      type Aux[A <: Nat, B <: Nat, Q <: Nat, R <: Nat] = NatQuotRem[A, B] {
        type Out = Pair.Pair[Q, R]
      }
      implicit def cL[A <: Nat, B <: Nat](
          implicit c: NatLt[A, B]): Aux[A, B, Z, A] = ???
      implicit def cS[A <: Nat, B <: Nat, C <: Nat, D <: Nat, E <: Nat](
          implicit c: NatLt[B, S[A]],
          d: NatSub.Aux[A, B, C],
          e: Aux[C, B, D, E]): Aux[A, B, S[D], E] = ???
    }

    implicitly[NatQuotRem.Aux[_7, _2, _3, _1]]

  }

  // ------------------------------ Functions ---------------------------------

  object Funs {

    trait Func

    trait Apply[F <: Func, A] { type Out }

    object Apply {
      type Aux[F <: Func, A, B] = Apply[F, A] { type Out = B }
    }

    trait BiFunc extends Func

    trait BiApply[F <: BiFunc, A, B] { type Out }

    object BiApply {
      type Aux[F <: BiFunc, A, B, C] = BiApply[F, A, B] { type Out = C }
    }

    trait BiCurry[F <: BiFunc, A] extends Func { type Out }

    object BiCurry {
      implicit def qa[F <: BiFunc, A, B](
          implicit q: BiApply[F, A, B]): Apply.Aux[BiCurry[F, A], B, q.Out] =
        ???
    }

    object BiFunc {
      implicit def qa[B <: BiFunc, A]: Apply.Aux[B, A, BiCurry[B, A]] = ???
    }

  }

  // -------------------------------- Lists -----------------------------------

  object TList {

    import Funs._

    trait TList

    class Nil extends TList

    class Cons[H, T <: TList] extends TList

    trait Head[A <: TList] { type Out }
    object Head {
      type Aux[A <: TList, R] = Head[A] { type Out = R }
      implicit def cH[H, T <: TList]: Aux[Cons[H, T], H] = ???
    }

    trait Tail[A <: TList] { type Out <: TList }
    object Tail {
      type Aux[A <: TList, R <: TList] = Tail[A] { type Out = R }
      implicit def cT[H, T <: TList]: Aux[Cons[H, T], T] = ???
    }

    trait ListMap[F <: Func, A <: TList] { type Out <: TList }
    object ListMap {
      type Aux[F <: Func, A <: TList, C <: TList] = ListMap[F, A] {
        type Out = C
      }
      implicit def cn[F <: Func]: Aux[F, Nil, Nil] = ???
      implicit def cc[F <: Func, A, B, T <: TList, R <: TList](
          implicit p: Apply.Aux[F, A, B],
          c: Aux[F, T, R]): Aux[F, Cons[A, T], Cons[B, R]] = ???
    }

  }

  // ----------------------------- Binary numbers -----------------------------

  object Bin {

    import Bool._

    trait Bin
    trait E extends Bin
    trait O[A <: Bin] extends Bin
    trait I[A <: Bin] extends Bin

    type __0 = E
    type __1 = I[E]
    type __2 = O[I[E]]
    type __3 = I[I[E]]
    type __4 = O[O[I[E]]]
    type __5 = I[O[I[E]]]
    type __6 = O[I[I[E]]]
    type __7 = I[I[I[E]]]
    type __8 = O[O[O[I[E]]]]
    type __9 = I[O[O[I[E]]]]
    type __10 = O[I[O[I[E]]]]
    type __11 = I[I[O[I[E]]]]
    type __12 = O[O[I[I[E]]]]
    type __13 = I[O[I[I[E]]]]
    type __14 = O[I[I[I[E]]]]
    type __15 = I[I[I[I[E]]]]
    type __16 = O[O[O[O[I[E]]]]]
    type __17 = I[O[O[O[I[E]]]]]
    type __18 = O[I[O[O[I[E]]]]]
    type __28 = O[O[I[I[I[E]]]]]
    type __40 = O[O[O[I[O[I[E]]]]]]
    type __53 = I[O[I[O[I[I[E]]]]]]
    type __64 = O[O[O[O[O[O[I[E]]]]]]]
    type __100 = O[O[I[O[O[I[I[E]]]]]]]
    type __256 = O[O[O[O[O[O[O[O[I[E]]]]]]]]]
    type __804 = O[O[I[O[O[I[O[O[I[I[E]]]]]]]]]]
    type __1024 = O[O[O[O[O[O[O[O[O[O[I[E]]]]]]]]]]]
    type __2361 = I[O[O[I[I[I[O[O[I[O[O[I[E]]]]]]]]]]]]

    trait BinSuc[A <: Bin] { type Out <: Bin }
    object BinSuc {
      type Aux[A <: Bin, B <: Bin] = BinSuc[A] { type Out = B }
      implicit def cE: Aux[E, I[E]] = ???
      implicit def cO[A <: Bin]: Aux[O[A], I[A]] = ???
      implicit def cI[A <: Bin](implicit c: BinSuc[A]): Aux[I[A], O[c.Out]] =
        ???
    }

    implicitly[BinSuc.Aux[__0, __1]]
    implicitly[BinSuc.Aux[__1, __2]]
    implicitly[BinSuc.Aux[__6, __7]]
    implicitly[BinSuc.Aux[__7, __8]]

    trait BinAdd[A <: Bin, B <: Bin] { type Out <: Bin }
    object BinAdd {
      type Aux[A <: Bin, B <: Bin, C <: Bin] = BinAdd[A, B] { type Out = C }
      implicit def cEB[B <: Bin]: Aux[E, B, B] = ???
      implicit def cOE[A <: Bin]: Aux[O[A], E, O[A]] = ???
      implicit def cIE[A <: Bin]: Aux[I[A], E, I[A]] = ???
      implicit def cOO[A <: Bin, B <: Bin](
          implicit c: BinAdd[A, B]): Aux[O[A], O[B], O[c.Out]] = ???
      implicit def cOI[A <: Bin, B <: Bin](
          implicit c: BinAdd[A, B]): Aux[O[A], I[B], I[c.Out]] = ???
      implicit def cIO[A <: Bin, B <: Bin](
          implicit c: BinAdd[A, B]): Aux[I[A], O[B], I[c.Out]] = ???
      implicit def cII[A <: Bin, B <: Bin, C <: Bin](
          implicit c: Aux[A, B, C],
          p: BinSuc[C]): Aux[I[A], I[B], O[p.Out]] = ???
    }

    implicitly[BinAdd.Aux[__0, __0, __0]]
    implicitly[BinAdd.Aux[__4, __2, __6]]
    implicitly[BinAdd.Aux[__1, __1, __2]]

    trait BinNorm[A <: Bin] { type Out <: Bin }
    object BinNorm {
      type Aux[A <: Bin, B <: Bin] = BinNorm[A] { type Out = B }
      implicit def cE: Aux[E, E] = ???
      implicit def cI[A <: Bin](implicit c: BinNorm[A]): Aux[I[A], I[c.Out]] =
        ???
      implicit def cOE[A <: Bin](implicit c: Aux[A, E]): Aux[O[A], E] = ???
      implicit def cOO[A <: Bin, B <: Bin](
          implicit c: Aux[A, O[B]]): Aux[O[A], O[O[B]]] = ???
      implicit def cOI[A <: Bin, B <: Bin](
          implicit c: Aux[A, I[B]]): Aux[O[A], O[I[B]]] = ???
    }

    implicitly[BinNorm.Aux[__0, __0]]
    implicitly[BinNorm.Aux[__1, __1]]
    implicitly[BinNorm.Aux[__2, __2]]
    implicitly[BinNorm.Aux[__3, __3]]
    implicitly[BinNorm.Aux[I[I[O[O[O[E]]]]], __3]]

    trait BinPred[A <: Bin] { type Out <: Bin }
    object BinPred {
      type Aux[A <: Bin, B <: Bin] = BinPred[A] { type Out = B }
      implicit def cI[A <: Bin](implicit c: BinNorm[O[A]]): Aux[I[A], c.Out] =
        ???
      implicit def cO[A <: Bin](implicit c: BinPred[A]): Aux[O[A], I[c.Out]] =
        ???
    }

    implicitly[BinPred.Aux[__7, __6]]
    implicitly[BinPred.Aux[__1, __0]]
    implicitly[BinPred.Aux[__8, __7]]

    trait BinSub[A <: Bin, B <: Bin] { type Out <: Bin }
    object BinSub {
      type Aux[A <: Bin, B <: Bin, C <: Bin] = BinSub[A, B] { type Out = C }
      implicit def cAE[A <: Bin]: Aux[A, E, A] = ???
      implicit def cOO[A <: Bin, B <: Bin, C <: Bin](
          implicit c: Aux[A, B, C],
          p: BinNorm[O[C]]): Aux[O[A], O[B], p.Out] = ???
      implicit def cII[A <: Bin, B <: Bin, C <: Bin](
          implicit c: Aux[A, B, C],
          p: BinNorm[O[C]]): Aux[I[A], I[B], p.Out] = ???
      implicit def cIO[A <: Bin, B <: Bin](
          implicit c: BinSub[A, B]): Aux[I[A], O[B], I[c.Out]] = ???
      implicit def cOI[A <: Bin, B <: Bin, C <: Bin](
          implicit c: Aux[A, B, C],
          p: BinPred[C]): Aux[O[A], I[B], I[p.Out]] = ???
    }

    implicitly[BinSub.Aux[__0, __0, __0]]
    implicitly[BinSub.Aux[__1, __1, __0]]
    implicitly[BinSub.Aux[__6, __4, __2]]
    implicitly[BinSub.Aux[__6, __2, __4]]
    implicitly[BinSub.Aux[__2, __1, __1]]

    trait BinMult[A <: Bin, B <: Bin] { type Out <: Bin }
    object BinMult {
      type Aux[A <: Bin, B <: Bin, C <: Bin] = BinMult[A, B] { type Out = C }
      implicit def cEB[B <: Bin]: Aux[E, B, E] = ???
      implicit def cOB[A <: Bin, B <: Bin, C <: Bin](
          implicit c: Aux[A, B, C],
          p: BinNorm[O[C]]): Aux[O[A], B, p.Out] = ???
      implicit def cIB[A <: Bin, B <: Bin, C <: Bin, D <: Bin](
          implicit c: Aux[A, B, C],
          p: BinAdd.Aux[B, O[C], D],
          q: BinNorm[D]): Aux[I[A], B, q.Out] = ???
    }

    implicitly[BinMult.Aux[__0, __0, __0]]
    implicitly[BinMult.Aux[__1, __1, __1]]
    implicitly[BinMult.Aux[__2, __4, __8]]
    implicitly[BinMult.Aux[__3, __3, __9]]
    implicitly[BinMult.Aux[__3, __2, __6]]
    implicitly[BinMult.Aux[__6, __3, __18]]

    trait BinLe[A <: Bin, B <: Bin]
    object BinLe {
      implicit def cEB[B <: Bin]: BinLe[E, B] = ???
      implicit def cOO[A <: Bin, B <: Bin](
          implicit c: BinLe[A, B]): BinLe[O[A], O[B]] = ???
      implicit def cII[A <: Bin, B <: Bin](
          implicit c: BinLe[A, B]): BinLe[I[A], I[B]] = ???
      implicit def cOI[A <: Bin, B <: Bin](
          implicit c: BinLe[A, B]): BinLe[O[A], I[B]] = ???
      implicit def cIO[A <: Bin, B <: Bin, C <: Bin](
          implicit p: BinSuc.Aux[A, C],
          c: BinLe[C, B]): BinLe[I[A], O[B]] = ???
    }

    implicitly[BinLe[__0, __0]]
    implicitly[BinLe[__0, __1]]
    implicitly[BinLe[__0, __6]]
    implicitly[BinLe[__0, __8]]
    implicitly[BinLe[__0, __8]]
    implicitly[BinLe[__1, __1]]
    implicitly[BinLe[__2, __2]]
    implicitly[BinLe[__1, __2]]
    implicitly[BinLe[__1, __6]]
    implicitly[BinLe[__2, __5]]
    implicitly[BinLe[__3, __4]]

    trait BinLt[A <: Bin, B <: Bin]
    object BinLt {
      implicit def c[A <: Bin, B <: Bin, C <: Bin](
          implicit p: BinSuc.Aux[A, C],
          c: BinLe[C, B]): BinLt[A, B] = ???
    }

    implicitly[BinLt[__0, __1]]

    trait BinEq[A <: Bin, B <: Bin]
    object BinEq {
      implicit def c[A <: Bin, B <: Bin](implicit p1: BinLe[A, B],
                                         p2: BinLe[B, A]): BinEq[A, B] = ???
    }

    implicitly[BinEq[__5, __5]]

    trait BinDiv[A <: Bin, B <: Bin] { type Out <: Pair.Pair[Bin, Bin] }
    object BinDiv {
      type Aux[A <: Bin, B <: Bin, Q <: Bin, R <: Bin] = BinDiv[A, B] {
        type Out = Pair.Pair[Q, R]
      }
      implicit def cL[A <: Bin, B <: Bin](
          implicit c: BinLt[A, B]): Aux[A, B, E, A] = ???
      implicit def cGOG[A <: Bin, B <: Bin, Q1 <: Bin, R1 <: Bin](
          implicit c: BinLe[B, O[A]],
          p: Aux[A, B, Q1, R1],
          z: BinLe[B, O[R1]],
          y: BinSub[O[R1], B]): Aux[O[A], B, I[Q1], y.Out] = ???
      implicit def cGOL[A <: Bin, B <: Bin, Q1 <: Bin, R1 <: Bin](
          implicit c: BinLe[B, O[A]],
          p: Aux[A, B, Q1, R1],
          z: BinLt[O[R1], B],
          y: BinNorm[O[R1]],
          x: BinNorm[O[Q1]]): Aux[O[A], B, x.Out, y.Out] = ???
      implicit def cGIG[A <: Bin, B <: Bin, Q1 <: Bin, R1 <: Bin](
          implicit c: BinLe[B, I[A]],
          p: Aux[A, B, Q1, R1],
          z: BinLe[B, I[R1]],
          y: BinSub[I[R1], B]): Aux[I[A], B, I[Q1], y.Out] = ???
      implicit def cGIL[A <: Bin, B <: Bin, Q1 <: Bin, R1 <: Bin](
          implicit c: BinLe[B, I[A]],
          p: Aux[A, B, Q1, R1],
          z: BinLt[I[R1], B],
          x: BinNorm[O[Q1]]): Aux[I[A], B, x.Out, I[R1]] = ???
    }

    implicitly[BinDiv.Aux[__1, __1, __1, __0]]
    implicitly[BinDiv.Aux[__1, __2, __0, __1]]
    implicitly[BinDiv.Aux[__2, __2, __1, __0]]
    implicitly[BinDiv.Aux[__3, __2, __1, __1]]
    implicitly[BinDiv.Aux[__4, __2, __2, __0]]
    implicitly[BinDiv.Aux[__5, __2, __2, __1]]
    implicitly[BinDiv.Aux[__6, __2, __3, __0]]
    implicitly[BinDiv.Aux[__7, __2, __3, __1]]
    implicitly[BinDiv.Aux[__8, __2, __4, __0]]
    implicitly[BinDiv.Aux[__9, __2, __4, __1]]
    implicitly[BinDiv.Aux[__1, __3, __0, __1]]
    implicitly[BinDiv.Aux[__2, __3, __0, __2]]
    implicitly[BinDiv.Aux[__3, __3, __1, __0]]
    implicitly[BinDiv.Aux[__4, __3, __1, __1]]
    implicitly[BinDiv.Aux[__5, __3, __1, __2]]
    implicitly[BinDiv.Aux[__6, __3, __2, __0]]
    implicitly[BinDiv.Aux[__7, __3, __2, __1]]
    implicitly[BinDiv.Aux[__8, __3, __2, __2]]
    implicitly[BinDiv.Aux[__9, __3, __3, __0]]

    trait BinHalve[A <: Bin] { type Out <: Bin }
    object BinHalve {
      type Aux[A <: Bin, C <: Bin] = BinHalve[A] { type Out = C }
      implicit def cz: Aux[__0, __0] = ???
      implicit def co[A <: Bin]: Aux[O[A], A] = ???
      implicit def ci[A <: Bin]: Aux[I[A], A] = ???
    }

    trait BinGcd[A <: Bin, B <: Bin] { type Out <: Bin }
    object BinGcd {
      type Aux[A <: Bin, B <: Bin, C <: Bin] = BinGcd[A, B] { type Out = C }
      implicit def cE[A <: Bin]: Aux[A, E, A] = ???
      implicit def cLO[A <: Bin, B <: Bin, Q <: Bin, R <: Bin](
          implicit p: BinDiv.Aux[A, O[B], Q, R],
          c: BinGcd[O[B], R]): Aux[A, O[B], c.Out] = ???
      implicit def cLI[A <: Bin, B <: Bin, Q <: Bin, R <: Bin](
          implicit p: BinDiv.Aux[A, I[B], Q, R],
          c: BinGcd[I[B], R]): Aux[A, I[B], c.Out] = ???
    }

    implicitly[BinGcd.Aux[__2, __3, __1]]
    implicitly[BinGcd.Aux[__6, __3, __3]]
    implicitly[BinGcd.Aux[__6, __4, __2]]
    implicitly[BinGcd.Aux[__6, __1, __1]]
    implicitly[BinGcd.Aux[__6, __0, __6]]
    implicitly[BinGcd.Aux[__0, __6, __6]]

    trait BinLcm[A <: Bin, B <: Bin] { type Out <: Bin }
    object BinLcm {
      type Aux[A <: Bin, B <: Bin, C <: Bin] = BinLcm[A, B] { type Out = C }
      implicit def c[A <: Bin, B <: Bin, C <: Bin, D <: Bin, F <: Bin](
          implicit p: BinGcd.Aux[A, B, C],
          c: BinMult.Aux[A, B, D],
          d: BinDiv.Aux[D, C, F, E]): Aux[A, B, F] = ???
    }

    implicitly[BinLcm.Aux[__6, __3, __6]]
    implicitly[BinLcm.Aux[__6, __1, __6]]
    implicitly[BinLcm.Aux[__2, __3, __6]]
    implicitly[BinLcm.Aux[__6, __0, __0]]
    implicitly[BinLcm.Aux[__0, __6, __0]]

    import TList._

    trait BinRange[A <: Bin] { type Out <: TList }
    object BinRange {
      type Aux[A <: Bin, C <: TList] = BinRange[A] { type Out = C }
      implicit def cz: Aux[__0, Nil] = ???
      implicit def cc[A <: Bin, P <: Bin](
          implicit p: BinPred.Aux[A, P],
          c: BinRange[P]): Aux[A, Cons[A, c.Out]] = ???
    }

    implicitly[
      BinRange.Aux[__4, Cons[__4, Cons[__3, Cons[__2, Cons[__1, Nil]]]]]]

    trait BinIsSquare[A <: Bin] { type Out <: Bool }
    object BinIsSquare {

      type Aux[A <: Bin, R <: Bool] = BinIsSquare[A] { type Out = R }

      trait IsSquareHelper[N <: Bin, L <: Bin, H <: Bin] { type Out <: Bool }
      object IsSquareHelper {
        type Aux[N <: Bin, L <: Bin, H <: Bin, R <: Bool] =
          IsSquareHelper[N, L, H] { type Out = R }
        trait Mid[A <: Bin, B <: Bin] { type Out <: Bin }
        object Mid {
          type Aux[A <: Bin, B <: Bin, C <: Bin] = Mid[A, B] { type Out = C }
          implicit def c[A <: Bin, B <: Bin, Sum <: Bin](
              implicit v: BinAdd.Aux[A, B, Sum],
              p: BinHalve[Sum]): Mid[A, B] { type Out = p.Out } = ???
        }

        implicitly[Mid.Aux[__1, __4, __2]]
        implicitly[Mid.Aux[__1, __5, __3]]
        implicitly[Mid.Aux[__0, __8, __4]]

        implicit def searchEnd[N <: Bin, L <: Bin, H <: Bin](
            implicit b: BinLt[H, L]): Aux[N, L, H, False] = ???
        implicit def itIs[N <: Bin, L <: Bin, H <: Bin, M <: Bin, MS <: Bin](
            implicit b: BinLe[L, H],
            p: Mid.Aux[L, H, M],
            ms: BinMult.Aux[M, M, MS],
            be: BinEq[N, MS]): Aux[N, L, H, True] = ???
        implicit def seeLt[N <: Bin,
                           L <: Bin,
                           H <: Bin,
                           M <: Bin,
                           MS <: Bin,
                           MP <: Bin,
                           R <: Bool](
            implicit b: BinLe[L, H],
            p: Mid.Aux[L, H, M],
            ms: BinMult.Aux[M, M, MS],
            be: BinLt[N, MS],
            mp: BinPred.Aux[M, MP],
            r: Lazy[Aux[N, L, MP, R]]): Aux[N, L, H, R] = ???
        implicit def seeGt[N <: Bin,
                           L <: Bin,
                           H <: Bin,
                           M <: Bin,
                           MS <: Bin,
                           MN <: Bin,
                           R <: Bool](
            implicit b: BinLe[L, H],
            p: Mid.Aux[L, H, M],
            ms: BinMult.Aux[M, M, MS],
            be: BinLt[MS, N],
            mn: BinSuc.Aux[M, MN],
            r: Lazy[Aux[N, MN, H, R]]): Aux[N, L, H, R] = ???
      }

      implicitly[IsSquareHelper.Aux[__8, __0, __3, False]]

      implicit def c[A <: Bin](
          implicit c: IsSquareHelper[A, __0, A]): Aux[A, c.Out] = ???
    }

    implicitly[BinIsSquare.Aux[__0, True]]
    implicitly[BinIsSquare.Aux[__1, True]]
    implicitly[BinIsSquare.Aux[__2, False]]
    implicitly[BinIsSquare.Aux[__3, False]]
    implicitly[BinIsSquare.Aux[__4, True]]
    implicitly[BinIsSquare.Aux[__5, False]]
    implicitly[BinIsSquare.Aux[__6, False]]
    implicitly[BinIsSquare.Aux[__7, False]]
    implicitly[BinIsSquare.Aux[__8, False]]
    implicitly[BinIsSquare.Aux[__9, True]]

    trait ListSum[L <: TList] { type Out <: Bin }
    object ListSum {
      type Aux[L <: TList, R <: Bin] = ListSum[L] { type Out = R }
      implicit def cn: Aux[Nil, __0] = ???
      implicit def cc[H <: Bin, T <: TList, P <: Bin](
          implicit c: Aux[T, P],
          v: BinAdd[H, P]): Aux[Cons[H, T], v.Out] = ???
    }

    implicitly[
      ListSum.Aux[Cons[__4, Cons[__3, Cons[__2, Cons[__1, Nil]]]], __10]]

  }

}
