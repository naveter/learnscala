package example

import scala.language.implicitConversions

object Implicits extends App {

  // ex2
  class RichInt(val value:Int) {
    def +%(percent: Double): Double = value * (1 + 1/percent)
  }
  implicit def int2Percent(value: Int): RichInt = new RichInt(value)
  assert(120 +% 10 == 132.0)

  // ex4
  object Read {
    private def readLine(text: String): String = Console.readLine(text + ": ")
    def readString(text: String): String = readLine(text)
    def readInt(text: String): Int = readLine(text).toInt
    def readDouble(text: String): Double = readLine(text).toDouble
  }

  abstract class aType
  object aString extends aType
  object anInt extends aType
  object aDouble extends aType

  type Reader = Read.type

  trait LoggerComponent {
    def log(msg:String)
  }

  class FluentReader(reader: Reader) {
    this: LoggerComponent =>
    abstract class FluentAsk { def askingFor(name:String): Reader }

    def in(at: aType): FluentAsk = new FluentAsk {
      def askingFor(name:String): Reader = {

        val res = at match {
          case _:anInt.type => reader.readInt(name)
          case _:aDouble.type => reader.readDouble(name)
          case _ => reader.readString(name)
        }

        log(name + " -> " + res.toString)

        reader
      }
    }
    def and(at: aType): FluentAsk = in(at)
  }

  implicit def reader2FluentReader(reader: Reader): FluentReader = new FluentReader(reader) with LoggerComponent {
    def log (msg: String) {println(msg)}
  }

  Read in aString askingFor "Your name" and anInt askingFor "Your age" and aDouble askingFor "Your weight"








}
