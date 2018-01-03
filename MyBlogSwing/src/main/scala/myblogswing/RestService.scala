package myblogswing

import org.apache.http.impl.client.HttpClients
import scala.util.control.Breaks._
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import java.io.BufferedReader
import java.io.InputStreamReader

class RestService {

  val serverUrl = "http://localhost:8080/rest/"

  def getRestContent(url:String): String = {
    val rurl = serverUrl + url

    val httpclient = HttpClients.createDefault
    val httpGet = new HttpGet(rurl)
    val response1 = httpclient.execute(httpGet)

    var respond = ""
    try {
      val rd = new BufferedReader(new InputStreamReader(response1.getEntity.getContent))

      var line = ""
      while ( {
        (line = rd.readLine) != null
      }) respond += line

    } finally response1.close

    respond
  }

  def getRest(): String = {

    val url = "http://localhost:8080/rest/categories"

    val client = HttpClientBuilder.create.build
    val request = new HttpGet(url)

    // add request header
    request.addHeader("User-Agent", "Mozilla")
    val response = client.execute(request)

    System.out.println("Response Code : " + response.getStatusLine.getStatusCode)

    val rd = new BufferedReader(new InputStreamReader(response.getEntity.getContent))

    val result = new StringBuffer
    var line = ""
    breakable {
      while ((line = rd.readLine()) != null) {


        if (line == null) break()

        result.append(line)
      }
    }
    result.toString
  }

  def getCategories():Array[Category] = {
//    val cont = getRestContent("categories")

    val cont = getRest()

    Array(new Category())
  }

  def getPosts(category_id:Integer) : Array[Post] = {

    Array(new Post())
  }

  def getPost(post_id:Integer) : Post = {

    new Post()
  }
}

class CurrentData {
  var categoryId = null
  var postId = null
}