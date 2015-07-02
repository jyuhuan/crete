# Crete
**Crete** is a DSL in the Scala programming language. With Crete, you can write first-order logic sentences naturally as you would write them in any textbook. 

## Features
### Sentences Made Natural
Write sentences in first order logic in the most intuitive way:
```scala
∀('p)('smokes('p) & !'drinks('p) → 'cancer('p))
```
### Inference Made Easy
Creating a knowledge base on which various kinds of queries can be performed:
```scala
val kb = Set[Sentence](
  ∀('p)('smokes('p) implies 'cancer('p)),
  ∀('p)('cancer('x) implies 'dies('p)),
  'smokes("john"),
  'smokes("mary")
)

val query1 = kb entails 'dies("john")
val query2 = 'dies("john") follows kb
val query3 = kb existentialQuery ∃('x)('smokes('x))
```
### Replaceable Inference Algorithm Provider
The default algorithm used for entailment inference is [refutation resolution](https://en.wikipedia.org/wiki/Resolution_(logic)). You can change this to one of other available presets like forward chaining, etc., or you can make your own inference algorithm by conforming to the typeclass `TODO`. As an example, an inference algorithm that provides trivially a believe-in-everything-inference can be written as:

    TODO
   
