package cookbook

import java.io.File

object FilesAndProcesses {

  //Recipe 12.1, How to open and read a text file in Scala
//  import scala.io.Source
//  val filename = "fileopen.scala"
//  for (line <- Source.fromFile(filename).getLines) {
//    println(line)
//  }
//
//  val lines = Source.fromFile("/Users/Al/.bash_profile").getLines.toArray
//
//  val bufferedSource = Source.fromFile("example.txt")
//  for (line <- bufferedSource.getLines) {
//    println(line.toUpperCase)
//  }
//  bufferedSource.close
//
//  import java.io.{FileNotFoundException, IOException}
//  val filename2 = "no-such-file.scala"
//  try {
//    for (line <- Source.fromFile(filename2).getLines) {
//      println(line)
//    }
//  } catch {
//    case e: FileNotFoundException => println("Couldn't find that file.")
//    case e: IOException => println("Got an IOException!")
//  }

  //Recipe 12.2, How to write text files in Scala
  // PrintWriter
//  import java.io._
//  val pw = new PrintWriter(new File("hello.txt" ))
//  pw.write("Hello, world")
//  pw.close

  // FileWriter
//  val file = new File("hello.txt")
//  val bw = new BufferedWriter(new FileWriter(file))
//  bw.write("some text")
//  bw.close()

  //Recipe 12.4, How to process every character in a text file in Scala
//  val source = io.Source.fromFile("/Users/Al/.bash_profile")
//  for (char <- source) {
//    println(char.toUpper)
//  }
//  source.close

  //Recipe 12.8, How to use serialization in Scala (Serializable trait)
  @SerialVersionUID(123L)
  class Stock(var symbol: String, var price: BigDecimal) extends Serializable {
    override def toString = f"$symbol%s is ${price.toDouble}%.2f"
  }

  //Recipe 12.9, How to list files in a directory in Scala (and filtering them)
  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  //Recipe 12.10, How to list subdirectories beneath a directory in Scala
  def getListOfSubDirectories(dir: File): List[String] =
    dir.listFiles
      .filter(_.isDirectory)
      .map(_.getName)
      .toList

  //Recipe 12.11, How to execute external system commands in Scala
  import sys.process._
  val code = "ls -al".!
  val process = Process("find / -print").lines

  //Recipe 12.12, How to execute external commands and use their STDOUT in Scala
  import sys.process._
  val result = "ls -al" !!
  val dir = "pwd".!!.trim
  val executable = "which ls".lines_!.headOption

  //Recipe 12.14, How to build a pipeline of external commands in Scala
  import sys.process._
  val numProcs = ("ps auxw" #| "wc -l").!!.trim
  println(s"#procs = $numProcs")

  //Recipe 12.15, How to redirect the STDOUT and STDIN of external commands
  import sys.process._
  import java.io.File
  ("ls -al" #> new File("files.txt")).!
  ("ps aux" #> new File("processes.txt")).!
  ("ps aux" #| "grep http" #> new File("http-processes.out")).!

  val contents = ("cat" #< new File("/etc/passwd")).!!
  println(contents)

  // append to a file
  ("ps aux" #>> new File("ps.out")).!

  //Recipe 12.16, How to use 'and' and 'or' when running external commands in Scala
  val result2 = ("ls temp" #&& "rm temp" #|| "echo 'temp' not found").!!.trim

  //Recipe 12.17, How to handle wildcard characters when running external commands
  val status = Seq("/bin/sh", "-c", "ls *.scala").!

  //Recipe 12.19, How to set environment variables when running external commands
  val p = Process("runFoo.sh",
    new File("/Users/Al/bin"),
    "PATH" -> ".:/usr/bin:/opt/scala/bin")
  val output = p.!!

  //Recipe 12.20, An index of methods available to run external system commands








}










