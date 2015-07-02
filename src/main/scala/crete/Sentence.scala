package crete

/**
 * Created by Yuhuan Jiang (jyuhuan@gmail.com) on 7/1/15.
 */
sealed trait Sentence {
  def &&(that: Sentence) = BinaryCompoundSentence(this, "∧", that)
  def ||(that: Sentence) = BinaryCompoundSentence(this, "∨", that)
  def implies(that: Sentence) = BinaryCompoundSentence(this, "→", that)
  def iff(that: Sentence) = BinaryCompoundSentence(this, "↔", that)
  def unary_! = UnaryCompoundSentence("~", this)
}

case class BinaryCompoundSentence(left: Sentence, op: String, right: Sentence) extends Sentence
case class UnaryCompoundSentence(op: String, operand: Sentence) extends Sentence
case class ExistentiallyQuantifiedSentence(theQuantified: Seq[Var], sentence: Sentence) extends Sentence
case class UniversallyQuantifiedSentence(theQuantified: Seq[Var], sentence: Sentence) extends Sentence


case class ParameterlessPredicate(name: Symbol) {
  def apply(t: Term) = UnaryPredicate(name, t)
  def apply(t1: Term, t2: Term) = BinaryPredicate(name, t1, t2)
}


trait Predicate extends Sentence {
  def name: Symbol
}

case class UnaryPredicate(name: Symbol, t: Term) extends Predicate {
}

case class BinaryPredicate(name: Symbol, t1: Term, t2: Term) extends Predicate {
}
