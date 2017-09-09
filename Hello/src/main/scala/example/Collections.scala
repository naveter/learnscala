package example

import java.util

import scala.collection.mutable
import scala.collection.mutable.Map
import scala.collection.mutable.SortedSet

/**
  * Created by bass on 09.09.17.
  */
object Collections extends App {

  // ex1
  def indexes(s: String) = {
    s.indices.foldLeft( Map[Char, SortedSet[Int]]() ) {
      (m, i) =>
        m += (s(i) -> (m.getOrElse(s(i), SortedSet[Int]()) += i))
    }
  }

  indexes("Mississippi").foreach(t => println(t._1 + ":" + t._2.mkString("{", ",", "}")) )

  // ex2
  import scala.collection.immutable.SortedMap
  import scala.collection.immutable.SortedSet
  def indexes2(s: String) = {
    s.indices.foldLeft(SortedMap[Char, Set[Int]]()) {
      (m,i) =>
        m + ( s(i) -> (m.getOrElse(s(i), SortedSet[Int]()) + i)	)
    }
  }

  indexes2("Mississippi").foreach(t => println(t._1 + ":" + t._2.mkString("{", ",", "}")) )

  // ex4
  def indexes(a: Array[String], m: Map[String,Int]) = a.flatMap(m.get(_))
  val a = Array("Tom", "Fred", "Harry")
  val m = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
  println(indexes(a, m).deep.mkString(","))

  // ex5
  val a2 = Array("Hello", ", ", "world !")
  println( a2.reduceLeft(_ + _) )

  // ex6
  val lst = List(1,2,3,4,5,6,7,8,9)
  assert( (List[Int]() /: lst)((i, l) => l +: i) == lst.foldLeft( List[Int]() )( (i, l) => l +: i ) )

  // ex7
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)
  println( (prices zip quantities).map(p => p._1 * p._2).mkString(", ") )
  println( (prices zip quantities).map( ((_: Double) * (_ :Int)).tupled ).foreach(println) )

  // ex8
  def array2Dim(a: Array[Int], dim: Int): Array[Array[Int]] = a.grouped(dim).toArray
  val a3 = Array(1,2,3,4,5,6)
  println( array2Dim(a3, 3).deep.mkString(", "))

  for (i <- 1 to 10; j <- 1 to i) {
    print(j)
    if(i == j) println()
  }






}

// ex1

