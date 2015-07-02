/**
 * Created by Yuhuan Jiang (jyuhuan@gmail.com) on 7/1/15.
 */

import crete.Sentence
import crete.dsl._

object Test {


  def main(args: Array[String]) {
    val kb = Set[Sentence](
      'smokes('p) implies 'cancer('p),
      'cancer('x) implies 'die('p),
      'cancer('x) implies 'die('p),
      'cancer('x) implies 'die('p),
      'cancer('x) implies 'die('p),
      'smokes("john")
    )
    val query = kb entails 'die("john")

    val sentence = 'smokes('p) && ~'drinks('p) || 'hasFun('p) && ~'jumps('p) implies 'cancer('p)



    val bp = 0

  }
}
