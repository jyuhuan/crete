/**
 * Created by Yuhuan Jiang (jyuhuan@gmail.com) on 7/1/15.
 */

import crete.Sentence
import crete.dsl._

object Test {


  def main(args: Array[String]) {
    val kb = Set[Sentence](
      ∀('p)('smokes('p) implies 'cancer('p)),
      ∀('p)('cancer('x) implies 'dies('p)),
      'smokes("john"),
      'smokes("mary")
    )

    val query1 = kb entails 'dies("john")
    val query2 = kb existentialQuery ∃('x)('smokes('x))

    //val ex =

    val sentence = 'smokes('p) && !'drinks('p) || 'hasFun('p) && !'jumps('p) implies 'cancer('p)

    val bp = 0

  }
}
