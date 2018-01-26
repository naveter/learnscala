package cookbook

object Types extends App {

  //Recipe 19.2, How to write a Scala method that takes a simple generic type
  def randomElement[A](seq: Seq[A]): A = {
    val randomNum = util.Random.nextInt(seq.length)
    seq(randomNum)
  }

  //Recipe 19.3, How to use 'Duck Typing' (Structural Types) in Scala
  def callSpeak[A <: { def speak(): Unit }](obj: A) {
    obj.speak()
  }

  //Recipe 19.6, How to define a collection whose element are all of some base type
  trait CrewMember {
    def beamDown { println("beaming down") }
  }
  class RedShirt extends CrewMember {
    def putOnRedShirt { println("putting on my red shirt") }
  }
  def getReadyForDay[A <: RedShirt](redShirt: Seq[A]) {
    redShirt.foreach(_.putOnRedShirt)
  }

}

//Recipe 19.1, How to create Scala classes that use generic types (cookbook examples)
class LinkedList[A] {

  private class Node[A] (elem: A) {
    var next: Node[A] = _
    override def toString = elem.toString
  }

  private var head: Node[A] = _

  def add(elem: A) {
    val n = new Node(elem)
    n.next = head
    head = n
  }

  private def printNodes(n: Node[A]) {
    if (n != null) {
      println(n)
      printNodes(n.next)
    }
  }

  def printAll() { printNodes(head) }

}


