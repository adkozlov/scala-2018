import java.util

import org.antlr.v4.runtime.atn.{ATNConfigSet, ATNSimulator}
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.{ANTLRErrorListener, Parser, RecognitionException, Recognizer}

class ErrorListener extends ANTLRErrorListener {
  override def syntaxError(recognizer: Recognizer[_, _], offendingSymbol: Any, line: Int, charPositionInLine: Int, msg: String, e: RecognitionException): Unit = {
    throw new RuntimeException(s"Syntax error on position $charPositionInLine: $msg")
  }

  override def reportAmbiguity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, exact: Boolean, ambigAlts: util.BitSet, configs: ATNConfigSet): Unit = {}

  override def reportAttemptingFullContext(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, conflictingAlts: util.BitSet, configs: ATNConfigSet): Unit = {}

  override def reportContextSensitivity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, prediction: Int, configs: ATNConfigSet): Unit = {}
}
