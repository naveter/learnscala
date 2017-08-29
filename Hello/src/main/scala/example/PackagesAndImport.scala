package example

// ex6
import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable._

// ex9
import java.lang.System._

/**
  * Created by bass on 29.08.17.
  */
object PackagesAndImport extends App {

  // ex1
  println(com.horstmann.Horst.name);
  import com.horstmann._
  println(Horst.name)
  var employee = new com.horstmann.impatient.EmployeeA("Supername")

  // ex2
  val a = 1
  com.basile.scala.ch07.Ex02.func


  // ex3
  println(Random.nextDouble())

  // ex6
  val hm = new JavaHashMap[String, String]()
  hm.put("1", "John")
  hm.put("2", "Paul")
  val shm = HashMap[String, String]()
  val it = hm.entrySet().iterator()
  while (it.hasNext()) {
    val pairs = it.next()
    shm += (pairs.getKey() -> pairs.getValue())
  }
  println(shm.mkString(", "));


 // ex7
  val hm2 = new java.util.HashMap[String, String]()
  hm2.put("1", "John")
  hm2.put("2", "Paul")
  println( javaToHashMap(hm2).mkString(", ") )

  // ex9
  val userName = getProperties.getProperty("user.name")
  if (args.length > 0 && args(0) == "secret")
    println("Welcome " + userName)
  else
    println("Wrong password")



}


// ex1
package com.horstmann {
  object Horst {
    val name: String = "horstmann"
  }
}
package com {
  package horstmann {
    package impatient {
      class EmployeeA(val name: String) {
        println(Horst.name) //Horst is accessible
      }
    }
  }
}
package com.horstmann.impatient {
  class EmployeeB(val name: String) {
    //println(Horst.name) Horst is not accessible
  }
}

// ex2
package com.basile.scala.ch07 {
  object Ex02 {
    val a = 1

    def func {
      println("_root_.example.PackagesAndImport.a: " + _root_.example.PackagesAndImport.a + ", com.basile.scala.ch07.Ex02.a:" + com.basile.scala.ch07.Ex02.a)
    }
  }
}


// ex3
package object Random {
  private var previous: Int = 0
  val a: Int = 1664525
  val b: Int = 1013904223
  val n: Int = 32
  def setSeed(seed: Int) {
    previous = seed
  }
  def nextInt(): Int = {
    previous = (previous * a + b) % scala.math.pow(2,n).toInt
    previous
  }
  def nextDouble(): Double = nextInt.toDouble
}

// ex7
object javaToHashMap{
  import java.util.{HashMap => JavaHashMap}
  def apply[A, B](hm: JavaHashMap[A, B]) = {
    import scala.collection.mutable.HashMap
    val shm = new HashMap[A, B]()
    val it = hm.entrySet().iterator()
    while (it.hasNext()) {
      val pairs = it.next()
      shm += (pairs.getKey() -> pairs.getValue())
    }
    shm
  }
}





