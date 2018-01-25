package cookbook

object Collections extends App{

  //    Recipe 10.5, How to manually declare a type when creating a collection instance
  List(1, 2.0, 33D, 400L)
  List[Number](1, 2.0, 33D, 400L)
  List[AnyVal](1, 2.0, 33D, 400L)

  // Vector, List - immutable
  // ArrayBufer - indexed sequential collection
  // ListBuffer if you prefer a linear sequential collection

  //    Recipe 10.9, How to loop over a Collection with foreach
//  val x = Vector(1, 2, 3)
//  x.foreach((i: Int) => println(i))
//  x.foreach(println(_))
//  val m = Map("fname" -> "Tyler", "lname" -> "LeDude")
//  m foreach (x => println(s"${x._1} -> ${x._2}"))
//  m.foreach {
//    case(movie, rating) => println(s"key: $movie, value: $rating")
//  }

  //  Recipe 10.10, How to Loop over a Collection with a for Loop
//  val fruits = Array("apple", "banana", "orange")
//  for (f <- fruits) println(f.toUpperCase)
//  for (i <- 0 until fruits.size) println(s"element $i is $fruits(i)")
//  for ((elem, count) <- fruits.zipWithIndex) {
//     println(s"element $count is $elem")
//  }
//  val newArray = for (e <- fruits) yield e.toUpperCase

  //  Recipe 10.11, How to Use zipWithIndex or zip to Create Loop Counters
//  val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
//  days.zipWithIndex.foreach {
//    case(day, count) => println(s"$count is $day")
//  }
//  for ((day, count) <- days.zipWithIndex) {
//    println(s"$count is $day")
//  }
//  for ((day,count) <- days.zip(Stream from 1)) {
//       println(s"day $count is $day")
//  }
//  days.zipWithIndex.foreach { d =>
//    println(s"${d._2} is ${d._1}")
//  }

  //  Recipe 10.14, How to Transform One Scala Collection to Another With the map function (method)
//  val cars = Vector("Mercedes", "Porsche", "Tesla")
//  val startsM = for {
//       c <- cars
//       if c.startsWith("M")
//    } yield c
//  println(startsM.mkString(","))
//  val helpers = Vector("adam", "kim", "melissa")
//  val caps = helpers.map(_.capitalize)
//  val newFruits = helpers.map( f =>
//    if (f.length < 6) f.toUpperCase
//  )

  //  Recipe 10.15, How to flatten a List of Lists in Scala with flatten
//  val lol = List(List(1,2), List(3,4))
//  val result = lol.flatten
//  val list = List("Hello", "world")
//  val x = Vector(Some(1), None, Some(3), None)

  //  Recipe 10.17, How to use filter to Filter a Scala Collection
//  val fruits = Set("orange", "peach", "apple", "banana")
//  val x = fruits.filter(_.startsWith("a"))
//  val strings = fruits.filter {
//       case s: String => true
//       case _ => false
//  }

  //  Recipe 10.18, How to Extract a Sequence of Elements from a Scala Collection
//  val x = (1 to 10).toArray
//  val y = x.takeWhile(_ < 5)

  //  Recipe 10.19, How to split sequences into subsets in Scala (groupBy, partition, splitAt, span)
//  val x = List(15, 10, 5, 8, 20, 12)
//  x.groupBy(_ > 10)
//  x.partition(_ > 10)
//  x.span(_ < 20)
//  x.splitAt(2)
//  x.sliding(2).toList
//  x.sliding(2,2).toList
//
//  val listOfTuple2s = List((1,2), ('a', 'b'))
//  listOfTuple2s.unzip
//  val (ind, value) = listOfTuple2s.unzip
//  val couples = ind zip value

  //  Recipe 10.20, How to Walk Through a Scala Collection with the reduce and fold Methods
//  val a = Array(12, 6, 15, 2, 20, 9)
//  a.reduceLeft(_ + _)
//  a.reduceLeft((x,y) => x + y)
//  val findMax = (x: Int, y: Int) => {
//    val winner = x max y
//    println(s"compared $x to $y, $winner was larger")
//    winner
//  }
//  a.reduceLeft(findMax)

  //    Recipe 10.25, How to Populate a Scala Collection with a Range
//  List.range(0, 10)
//  Vector.range(0, 10, 2)
//  val list = (1 to 10).by(2).toList

  //    Recipe 10.26, How to Create and Use Scala Enumerations
  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }
  var currentMargin = Margin.TOP

  trait Margin
  case object TOP extends Margin
  case object RIGHT extends Margin
  case object BOTTOM extends Margin
  case object LEFT extends Margin

  //  Recipe 10.27, Scala Tuples, for When You Just Need a Bag of Things
  val d = ("Amanda", 95)
  val x = ("AL" -> "Alabama")

  //    Recipe 10.28, How to Sort a Scala Collection
  List(10, 5, 8, 1, 7).sorted
  List("banana", "pear", "apple", "orange").sorted
  List(10, 5, 8, 1, 7).sortWith(_ < _)
  List("banana", "pear", "apple", "orange").sortWith(_ < _)
  List("banana", "pear", "apple", "orange").sortWith(_.length < _.length)

  def sortByLength(s1: String, s2: String) = {
    println("comparing %s and %s".format(s1, s2))
    s1.length > s2.length
  }
  List("banana", "pear", "apple").sortWith(sortByLength)

  class Person (var name: String) extends Ordered [Person] {
    override def toString = name

    // return 0 if the same, negative if this < that, positive if this > that
    def compare (that: Person) : Int = {
      if (this.name == that.name)
        0
      else if (this.name > that.name)
        1
      else
        -1
    }
  }

}









