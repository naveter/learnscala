package example

import scala.collection.mutable.ArrayBuffer
import java.awt.Rectangle

/**
  * Created by bass on 29.08.17.
  */
object Inheritance extends App{

  // ex1
  val MyAccount = new CheckingAccount(100)
  MyAccount.deposit(10)
  println("CheckingAccount:" + MyAccount.getBalance )

  // ex2
  val MyAccount2 = new SavingsAccount(100)
  MyAccount2.deposit(10)
  MyAccount2.withdraw(20)
  MyAccount2.deposit(10)
  println( MyAccount2.getBalance)
  MyAccount2.deposit(10)
  println( MyAccount2.getBalance)
  MyAccount2.earnMonthlyInterest()
  println( MyAccount2.getBalance )
  MyAccount2.deposit(10)
  println( MyAccount2.getBalance )

  // ex3
  val John = new Manager("John", 50000, 2014, 2, 28)
  John.bonus = 5000
  println( "John.getSalary:" + John.getSalary )

  // ex4
  val si1 = new SimpleItem(4.5, "ring")
  val si2 = new SimpleItem(6.5, "necklace")
  val b = new Bundle()
  b.addItem(si1)
  b.addItem(si2)
  println( "b.price:" + b.price )
  println( "b.description:" + b.description )

  // ex5
  val lp = new LabeledPoint("Black Thursday", 1929, 230.07)
  println( lp.label  )
  println( lp.x )
  println( lp.y )

  // ex6
  val C = new Circle((0,0), 45)

  // ex7
  val s1 = new Square(10, 10, 150)
  val s2 = new Square(150)
  val s3 = new Square()









}

// ex1
class BankAccount(initialBalance: Double) {
  protected var balance = initialBalance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
  def getBalance = balance
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  def charge {balance -= 1}
  override def deposit(amount: Double) = { charge; super.deposit(amount) }
  override def withdraw(amount: Double) = { charge; super.withdraw(amount) }
}

// ex2
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  var countDeposit = 0

  def earnMonthlyInterest(rate: Double = 0.01) {
    balance += balance * rate
    countDeposit = 0
  }

  def charge {
    countDeposit += 1
    if (countDeposit > 3) balance -= 1
  }
  override def deposit(amount: Double) = { charge; super.deposit(amount) }
  override def withdraw(amount: Double) = { charge; super.withdraw(amount) }

}


// ex3
class Employee(val name: String, private var _salary: Double, year: Int, month: Int, day: Int) {

  val hireDay = new java.util.GregorianCalendar(year, month - 1, day).getTime()

  def salary = _salary

  def raiseSalary(byPercent: Double) {
    _salary = _salary*(1+byPercent/100)
  }
}

class Manager(n: String, _s: Double, y: Int, m: Int, d: Int) extends Employee(n, _s, y, m, d) {

  var bonus:Double = 0

  def getSalary = salary + bonus
}

// ex4
abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(val price: Double, val description: String) extends Item

class Bundle extends Item {

  private var items = ArrayBuffer[Item]()

  def price(): Double = items.foldLeft(0.0)(_+_.price)
  def description(): String = items.map(_.description).mkString(",")

  def addItem(i: Item) {
    items += i
  }
}

// ex5
class Point(val x: Double, val y: Double)
class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y)

// ex6
abstract class Shape {
  def centerPoint:(Double, Double)
}

class Rectangle(val upperLeft: (Double, Double), val width: Double, val height: Double) extends Shape {
  def centerPoint:(Double, Double) = (upperLeft._1 + width/2, upperLeft._2 + height / 2)
}
class Circle(val centerPoint: (Double, Double), val rayon: Double) extends Shape {
}

// ex7
class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {
  def this(width: Int) {
    this(0, 0, width)
  }
  def this() {
    this(0, 0, 0)
  }
}



