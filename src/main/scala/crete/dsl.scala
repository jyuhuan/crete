package crete

/**
 * Created by Yuhuan Jiang (jyuhuan@gmail.com) on 7/1/15.
 */
object dsl {

  implicit def symbolIsVar(s: Symbol): Var = new Var(s)

  implicit def symbolIsParameterlessPredicate(s: Symbol): ParameterlessPredicate = ParameterlessPredicate(s)

  implicit def stringIsConst(s: String): Const = Const(s)

  implicit class SentenceSetIsKnowledgeBase(val s: Set[Sentence]) extends AnyVal {
    def entails(sentence: Sentence): Boolean = ???
    def existentialQuery(sentence: ExistentiallyQuantifiedSentence): Seq[Const] = ???
  }

  implicit class PredicateCanFollowKnowledgeBase(val p: Predicate) extends AnyVal {
    def follows(kb: Set[Sentence]): Boolean = ???
  }

  def ∃(theQuantified: Var*)(sentence: Sentence): ExistentiallyQuantifiedSentence =
    new ExistentiallyQuantifiedSentence(theQuantified, sentence)

  def ∀(theQuantified: Var*)(sentence: Sentence): UniversallyQuantifiedSentence =
    new UniversallyQuantifiedSentence(theQuantified, sentence)

}
