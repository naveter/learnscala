package example

import scala.beans.BeanProperty

/**
  * Created by bass on 27.08.17.
  */
object Classes extends  App{

  // ex1
  class Counter(private var value:Int) {
    def increment() {
      if (value + 1 <= Int.MaxValue) {
        value += 1
      }
    }
    def current = value
  }

  // ex2
  class BankAccount(private var _balance:Double = 0.0) {

    def deposit(value:Int) {
      _balance += value
    }

    def withdraw(value:Int) {
      if (_balance - value > 0){
        _balance -= value
      }
    }

    def balance = _balance

  }

  val myBA = new BankAccount
  myBA.deposit(100)
  myBA.withdraw(20)

  println( "Balance:" + myBA.balance )

  // ex3
  class Time(private var _hrs:Int, private var _min:Int) {
    _min = _min match {
      case i:Int if i%60==0 => {_hrs += i/60; 0}
      case i:Int if i<0 => {_hrs += (i/60 - 1); 60 + i%60}
      case i:Int if i>59 => {_hrs += i/60; i%60}
      case _ => _min
    }
    _hrs = _hrs match {
      case i:Int if i<0 => 24 + i%24
      case i:Int if i>23 => i%24
      case _ => _hrs
    }

    def hrs = _hrs
    def min = _min
    def before(other:Time) = {
      _hrs < other._hrs || (other._hrs == _hrs && _min < other._min)
    }
  }

  val T1 = new Time(-1,70)
  val T2 = new Time(2,-59)

  println("Before:" + (T1.before(T2) == true) )

  // ex5
  class Student(@BeanProperty var name: String, @BeanProperty var id: Long)
  val John = new Student("John", 2457)
  println("John ID:" + John.getId )

  // ex6
  class Person(private var _age:Int) {

    if (_age <0) _age=0

    def age = _age
    def age_=(newValue: Int) {
      if (newValue > _age) _age = newValue;
    }
  }

  val Paul = new Person(-2)

  println("Paul:" + Paul.age)

  // ex7
  class Person2(_fullName:String) {
    val (firstName, lastName) =  _fullName.split(" ") match {
      case Array(x:String, y:String, _*) => (x,y)
      case _ => (null,null)
    }
  }

  val FredSmith = new Person2("Fred Smith")

  println("Frad Smith name is:" + FredSmith.firstName + " " + FredSmith.lastName )

  // ex8
  class Car(val manufacturer: String, var modelName: String) {

    var licencePlate: String = ""
    private var _modelYear: Int = -1

    def this(manufacturer: String, modelName: String, modelYear: Int) {
      this(manufacturer, modelName)
      this._modelYear = modelYear
    }

    def this(manufacturer: String, modelName: String, licencePlate: String) {
      this(manufacturer, modelName)
      this.licencePlate = licencePlate
    }

    def this(manufacturer: String, modelName: String, modelYear: Int, licencePlate: String) {
      this(manufacturer, modelName)
      this._modelYear = modelYear
      this.licencePlate = licencePlate
    }

    def modelYear = _modelYear
  }

  val Twingo = new Car("Renault", "Twingo")
  val Twingo2008 = new Car("Renault", "Twingo", 2008)
  val Twingo586QW27 = new Car("Renault", "Twingo", "586 QW 27")
  Twingo586QW27.modelName = "BMW"
  Twingo586QW27.licencePlate = "456 TR 34"

  println(Twingo.toString + " " + Twingo586QW27.modelName + " " + Twingo586QW27.licencePlate)

  // ex10
  class Employee(val name: String, var salary: Double) {
    def this() { this("John Q. Public", 0.0) }
  }

  var employee = new Employee()

  //A more syntactic form
  class EmployeeRewrite(val name: String = "John Q. Public", var salary: Double = 0.0) {}

  var employeeRewrite = new EmployeeRewrite()



}
