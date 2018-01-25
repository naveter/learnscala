package cookbook

object ListArrayMapSet extends App {

  //Recipe 11.11, How to Create Multidimensional Arrays in Scala
//  val arr = Array.ofDim[String](5, 5)
//  for {
//    i <- 0 until 5
//    j <- 0 until 5
//  } println(s"($i)($j) = ${arr(i)(j)}")

  //Recipe 11.13, How to Create Maps in Scala (Scala Map class examples)
//  var states = collection.mutable.Map("AL" -> "Alabama")
//  var states1 = collection.mutable.Map[String, String]()
//  states1 += ("AL" -> "Alabama")

  //Recipe 11.19, How to Get the Keys or Values from a Scala Map
//  val states = Map("AK" -> "Alaska", "AL" -> "Alabama", "AR" -> "Arkansas")
//  states.keySet
//  states.keys
//  states.keysIterator

  //Recipe 11.20, How to Reverse Keys and Values in a Scala Map
//  val reverseMap = for ((k,v) <- states) yield (v, k)

  //Recipe 11.24, How to Find the Largest Key or Value in a Scala Map
//  val grades = Map(
//    "Al" -> 80,
//    "Kim" -> 95,
//    "Teri" -> 85,
//    "Julia" -> 90
//  )
//  grades.max
//  grades.keysIterator.max
//  grades.keysIterator.reduceLeft((x,y) => if (x > y) x else y)
//  grades.valuesIterator.max
//  grades.valuesIterator.reduceLeft(_ max _)

  //Recipe 11.25, Going To and From Java Maps in Scala
//  val jmap = new java.util.HashMap[String, String]()
//  jmap.put("fname", "Alvin")
//  jmap.put("lname", "Alexander")
//
//  import scala.collection.JavaConversions.mapAsScalaMap
//  for ((k,v) <- jmap) println(s"key: $k, value: $v")
//
//  val smap = mapAsScalaMap(jmap)

  //Recipe 11.29, How to Use a Queue in Scala
  import scala.collection.mutable.Queue
  var q = new Queue[String]
  q += ("kiwi", "banana")
  q.enqueue("pineapple")
  val next = q.dequeue
  q += ("kiwi", "banana")
  q.dequeueFirst(_.startsWith("b"))
  q.dequeueAll(_.length > 6)

  //Recipe 11.30, How to Use a Stack in Scala
  import scala.collection.mutable.Stack
  var fruits = Stack[String]()
  fruits.push("apple")
  fruits.push("coconut", "orange", "pineapple")
  fruits.pop
  fruits.top

}

