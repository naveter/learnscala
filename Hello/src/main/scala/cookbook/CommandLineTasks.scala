package cookbook

object CommandLineTasks extends  App {

  //Recipe 14.1, How to get started with the Scala REPL
  //scala> "foo".[Tab]

  //Recipe 14.3, How to add Jar files and classes to the REPL Classpath
  //scala> :sh ls -al

  //Recipe 14.5, How to compile Scala code with 'scalac' and run it with 'scala'
  //$ scalac -classpath lib/DateUtils.jar -d classes " src/com/alvinalexander/pizza/*
  //$ scala -classpath classes:lib/DateUtils.jar com.alvinalexander.pizza.Main

  //Recipe 14.6, How to disassemble and decompile Scala code
  //$ javap Person
  //$ scalac -Xprint:parse Main.scala
  //$ jad Main

  //Recipe 14.7, How to find good Scala libraries
  //resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  //libraryDependencies ++= Seq(
  //  "org.scalatest" %% "scalatest" % "1.8" % "test",
  //  "org.mockito" % "mockito-core" % "1.9.0" % "test"
  //)

  //Recipe 14.9, How to compile your Scala code faster with the 'fsc' command-line compiler
  //$ fsc *.scala

  //Recipe 14.10, How to use Scala as a scripting language
  //exec scala -classpath "lib/htmlcleaner-2.2.jar:lib/scalaemail_2.10.0-1.0.jar:lib/stockutils_2.10.0-1.0.jar" "$0" "$@"

  //Recipe 14.11, How to access command-line arguments in a Scala shell script
  args.foreach(println)

  //Recipe 14.13, How to make your Scala shell scripts run faster by pre-compiling them
  // exec scala -savecompiled "$0" "$@"

}

