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
  }

}