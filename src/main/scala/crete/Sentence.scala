package crete

/**
 * Created by Yuhuan Jiang (jyuhuan@gmail.com) on 7/1/15.
 */
sealed trait Sentence {
  def ∧(that: Sentence) = BinaryCompoundSentence(this, "∧", that)
  def ∨(that: Sentence) = BinaryCompoundSentence(this, "∨", that)
  def →(that: Sentence) = BinaryCompoundSentence(this, "→", that)
  def ↔(that: Sentence) = BinaryCompoundSentence(this, "↔", that)
  def unary_~ = UnaryCompoundSentence("~", this)
}

case class BinaryCompoundSentence(left: Sentence, op: String, right: Sentence) extends Sentence
case class UnaryCompoundSentence(op: String, operand: Sentence) extends Sentence
case class QuantifiedSentence(quantifier: String, variables: Seq[Var] sentence: Sentence) extends Sentence

trait Predicate extends Sentence {
  def name: Symbol
  def eval: Boolean
}

case class ParameterlessPredicate(name: Symbol) extends Predicate {
  override def eval: Boolean = ???
  def apply(t: Term) = UnaryPredicate(name, t)
  def apply(t1: Term, t2: Term) = BinaryPredicate(name, t1, t2)
}

case class UnaryPredicate(name: Symbol, t: Term) extends Predicate {
  override def eval: Boolean = ???
}

case class BinaryPredicate(name: Symbol, t1: Term, t2: Term) extends Predicate {
  override def eval: Boolean = ???
}
