package example

import scala.io.Source
import scala.math.pow
import java.io.PrintWriter
import scala.util.matching.Regex
import java.io.File
import scala.collection.mutable.ArrayBuffer

/**
  * Created by bass on 31.08.17.
  */
object FilesAndRegEx extends App {

  // ex1
  val url = getClass.getResource("/tinyFile.txt")
  val in = Source.fromURL(url)
  println( in.getLines.toArray.reverse.mkString("\n") )

  // ex3
  val url2 = getClass.getResource("/ch04_ex02.txt")
  println( """\w{12,}""".r.findAllIn(Source.fromURL(url2).mkString).mkString(", ") )
  """\w{12,}""".r.findAllIn(Source.fromURL(url2).mkString).foreach{println(_)}

  // ex4
  val url3 = getClass.getResource("/ch09_ex04.txt")
  val floats = """[0-9\.]+""".r.findAllIn(Source.fromURL(url3).mkString).map(_.toDouble).toArray
  List(
    "Max: " + floats.max,
    "Min: " + floats.min,
    "Average: " + floats.sum/floats.length
  ).foreach(println)

  // ex5
  val out = new PrintWriter("resourse/ch09-ex05.txt")
  (0 to 20).map(pow(2,_)).foreach(i => out.println("%7d ".format(i.toInt) + 1/i))
  //Option
  //for(v <- 0 to 20; p=pow(2,v)) {out.println("%7d ".format(p.toInt) + 1/p)}
  out.close

  // ex6
  val out2 = new PrintWriter("resourse/ch09-ex06.txt")
  """\\\"""".r.findAllIn("""Hello \"Basile\" how are you ?""").foreach(out2.println(_))
  out2.close

  // ex7
  val url4 = getClass.getResource("/ch09_ex07.txt")
  val r = new Regex("""^\d+?\.\d+$""")
  val result = Source.fromURL(url4).mkString.split("""\s+""").filter(r.findFirstIn(_)==None)
  println( result.mkString(", ") )

  // ex8
  val r2 = """<img([^>]+)src=\"(http:[^\"]+)""".r
  for(a <- r2.findAllMatchIn(Source.fromURL("""http://www.lemonde.fr""").mkString).take(5)) println(a.group(2))

  // ex9
  def countClass(dir: File): Int = {
    val dirList = dir.listFiles
    dirList.filter(_.toString.endsWith(".class")).length + dirList.filter(_.isDirectory).map(countClass(_)).sum
  }
  val dir = new File("/home/bass/repos/learnscala/Hello/target")
  println("countClass: " + countClass(dir))


  // ex10
  @SerialVersionUID(42L) class Person(val name: String) extends Serializable {
    private val friends = new ArrayBuffer[Person]
    def addFriend(p: Person) {friends += p}
    def isFriend(p: Person) = friends.contains(p)
  }
  val paul = new Person("paul")
  val pierre = new Person("pierre")
  val jacques = new Person("jacques")
  paul.addFriend(pierre)
  pierre.addFriend(paul)
  jacques.addFriend(paul)
  jacques.addFriend(pierre)
  val persons = Array(paul, pierre, jacques)
  import java.io._
  val out3 = new ObjectOutputStream(new FileOutputStream("resourse/test.obj"))
  out3.writeObject(persons)
  out3.close()
  val in2 = new ObjectInputStream(new FileInputStream("resourse/test.obj"))
  val Array(paulA, pierreA, jacquesA) = in2.readObject().asInstanceOf[Array[Person]]
  println( paulA.name + " " + pierreA.name + " " + jacquesA.name )


}
