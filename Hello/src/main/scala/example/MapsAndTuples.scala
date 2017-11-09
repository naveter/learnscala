package example

import scala.collection.immutable.SortedMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.JavaConversions.mapAsScalaMap
import java.util.{Scanner, TreeMap}
import scala.collection.mutable.Map

/**
  * Created by bass on 27.08.17.
  */
object MapsAndTuples extends App{

  // Ex1
  val gizmos = Map("Nexus 5" -> 300, "Nexus 7" -> 200, "Chromecast" -> 35)
  val discount = for((k,v) <- gizmos) yield (k, v*0.9)
  println( discount.mkString(", ") )

  // ex2
  val lines = scala.io.Source.fromFile("./Hello/resourse/ch04_ex02.txt").mkString
  val uw = new scala.collection.mutable.HashMap[String, Int]
  for(w <- lines.split("\\W+")) uw(w) = uw.getOrElse(w, 0) + 1
  println(uw.filter((t) => t._2 > 5).mkString(", "))

  // ex3
  val words = lines.split("\\W+")
  val wordCounts = (for(w <- words.distinct) yield (w, words.count(_==w))).toMap
  println( wordCounts.filter((t) => t._2 > 5).mkString(", ") )

  // ex4
  val wordCounts2 = SortedMap[String, Int]() ++ ( for( w <- words.distinct ) yield (w, words.count( _==w )) )
  println( wordCounts2.filter((t) => t._2 > 5).mkString(", ") )

  // ex5
  val url = getClass.getResource("/ch04_ex02.txt")
  val words2 = new Scanner(url.openStream()).useDelimiter("\\W+")
  val tree = new TreeMap[String, Int]()
  while (words2.hasNext()) {
    val word = words2.next()
    if (tree.contains(word)) tree(word)+=1 else tree(word)=1
  }
  val map: Map[String, Int] = tree.filter(t => t._2 > 5)
  println( map.mkString(", ") )

  // ex6
  val days = scala.collection.mutable.LinkedHashMap(
    "MONDAY" -> java.util.Calendar.MONDAY,
    "TUESDAY" -> java.util.Calendar.TUESDAY,
    "WEDNESDAY" -> java.util.Calendar.WEDNESDAY,
    "THURSDAY" -> java.util.Calendar.THURSDAY,
    "FRIDAY" -> java.util.Calendar.FRIDAY,
    "SATURDAY" -> java.util.Calendar.SATURDAY,
    "SUNDAY" -> java.util.Calendar.SUNDAY
  )
  println(days.mkString(", "))

  // ex7
  val props: scala.collection.Map[String, String] = System.getProperties
  val maxLength = props.keys.maxBy(_.length).length
  for((k,v) <- props.filter((t) => t._1.length < 10)) println(k + " " * (maxLength - k.length) + "|" + v)

  // ex8
  def minmax(a: Array[Int]) = (a.min, a.max)
  println( minmax(Array(1,2,3,4,5,6)).toString() )

  // ex9
  def lteqgt(values: Array[Int], v: Int) = (values.count(_<v), values.count(_==v), values.count(_>v))
  println( lteqgt(Array(1,2,3,4,5,6), 3).toString() )

  // ex10
  val diff = "Hello world! pu".zip("hello world!").filter(t => t._1!=t._2)
  println( diff.mkString(", ") )



}
