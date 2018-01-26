package cookbook


object InteractingWithJava extends App {

  //Recipe 17.1, How to go to and from Java collections in Scala
  import scala.collection.JavaConversions._
  def nums = {
    var list = new java.util.ArrayList[Int]()
    list.add(1)
    list.add(2)
    list
  }
  nums.foreach(println)

  //Recipe 17.2, How to add exception annotations to Scala methods so they can be called from Java
  @throws(classOf[Exception])
  def exceptionThrower {
    throw new Exception("Exception!")
  }

  //Recipe 17.5, How to annotate varargs methods in Scala
  import scala.annotation.varargs
  class Printer {
    @varargs def printAll(args: String*) {
      args.foreach(print)
      println
    }
  }

  //Recipe 17.6, How to create JavaBeans in Scala (to interact with Java libraries)
  import scala.beans.BeanProperty

  class Person(@BeanProperty var firstName: String,
               @BeanProperty var lastName: String) {
    override def toString = s"Person: $firstName $lastName"
  }
  class EmailAccount {
    @BeanProperty var username: String = ""
    @BeanProperty var password: String = ""
    override def toString = s"Email Account: ($username, $password)"
  }

}

