package cookbook

object DatabasesAndPersistence extends App {

  ScalaJdbcConnectSelect

}

//Recipe 16.1, How to connect to a MySQL database with Scala and JDBC
object ScalaJdbcConnectSelect{
  import java.sql.{Connection,DriverManager}

  Class.forName("org.postgresql.Driver")
  val url = "jdbc:postgresql://localhost:5432/postgres"
  val conn = DriverManager.getConnection(url,"postgres", "123456")

  try {
    val statement = conn.createStatement
    val rs = statement.executeQuery("SELECT firstname, lastname FROM public.user")
    while (rs.next) {
      val firstname = rs.getString("firstname")
      val lastname = rs.getString("lastname")
      println("firstname = %s, lastname = %s".format(firstname,lastname))
    }
  } catch {
    case e: Exception => e.printStackTrace
  }
  conn.close
}






