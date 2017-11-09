package example

import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

import scala.collection.{JavaConverters, mutable}
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
  * Created by bass on 26.08.17.
  */
object WorkingWithArrays extends App {

  // ex1
  def rand(n: Int) = new Array[Int](n).map(_ => Random.nextInt())
  val randArr = rand(10)
  randArr.foreach( print )
  println()

  // ex2
  def swapAdjacent(a: Array[Int]):Array[Int] = {
    for(i <- 0 until a.length if (i%2==0)) {
      val temp = a(i)
      try {
        a.update(i, a(i+1))
        a.update(i+1, temp)
      } catch {
        case _: ArrayIndexOutOfBoundsException => ()
      }
    }
    a
  }
  val swap = swapAdjacent( Array(1,2,3,4,5,6,7,8,9,10) )
  swap.foreach(print)
  println("")

  // ex3
  def swapAdjacent2(a: Array[Int]):Array[Int] =
    (for(i <- a.indices) yield
      if (i%2==0 && (i+1)==a.length) a(i) //last element for odd length
      else if (i%2==0) a(i+1)
      else a(i-1)
      ).toArray
  println( swapAdjacent(Array(51,42,30,4,25)).deep.toString() )

  // ex4
  def sortPositive(a: Array[Int]):Array[Int]  = a.filter( _ > 0 ) ++ a.filter( _ <=0 )
  println( sortPositive(Array(-2, 8, 0, 4, -8, -1, 0, 9)).deep.toString() )

  // ex5
  val a = Array(2.4,2.5,2.6)
  println("Average:" + a.sum / a.length)

  // ex6
  var a2 = Array(30,42,51,4,25)
  println(a2.sortWith(_>_).deep.toString)
  var b2 = ArrayBuffer(30,42,51,4,25)
  println(b2.sortWith(_>_).toString())

  // ex7
  println( Array(51,42,30,4,25,51,8,42).distinct.deep.toString() )

  // ex8
  val ab = ArrayBuffer(51,-42,30,-4,25,-51,8,42)
  val indices = ab.indices.filter(ab(_)<0).drop(1)
  for (i <- 0 until indices.length) ab.remove(indices(i)-i)

  //One line solution with an Array
  val a3 = Array(51,-42,30,-4,25,-51,8,42)
  val res = for (i <- 0 until a3.length if (i<=a3.indexWhere(_<0)||a3(i)>0)) yield a3(i)

  // Ex10
  val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
  val flavorBuffer: mutable.Buffer[String] = JavaConverters.asScalaBufferConverter(flavors.getNativesForFlavor(DataFlavor.imageFlavor)).asScala
  flavorBuffer.foreach(println)




}
