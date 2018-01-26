package cookbook

object Idioms extends App {

  //Recipe 20.3, Scala best practice: Think Expression-Oriented Programmingâ€
//  So statements are like this:
//  order.calculateTaxes()
//  order.updatePrices()
//
//  Expressions are like this:
//  val tax = calculateTax(order)
//  val price = calculatePrice(order)

  //Recipe 20.5, Scala best practice: Eliminate null values from your code
  case class Address (city: String, state: String, zip: String)
  class User(email: String, password: String) {
    var firstName = None: Option[String]
    var lastName = None: Option[String]
    var address = None: Option[Address]
  }
  val u = new User("al@example.com", "secret")
  u.firstName = Some("Al")
  u.lastName = Some("Alexander")
  u.address = Some(Address("Talkeetna", "AK", "99676"))

  //Recipe 20.6, Scala best practice: How to use the Option/Some/None pattern
  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }
  val x = toInt("1").getOrElse(0)

  import scala.util.{Try,Success,Failure}
  def divideXByY(x: Int, y: Int): Try[Int] = {
    Try(x / y)
  }
  divideXByY(1, 1) match {
    case Success(i) => println(s"Success, value is: $i")
    case Failure(s) => println(s"Failed, message is: $s")
  }

}






