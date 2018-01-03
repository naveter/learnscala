package myblogswing

import java.util.Date

object Classes {

  case class Category(
     id:Int,
     name:String
  )

  case class User(
    id:Int,
    firstname: String,
    lastname: String,
    created: String,
    login: String,
    password: String,
    lastlogin: String
  )

  case class Source(id:Int,
    user_id: Int,
    url: String,
    lastupdate: String,
    parser: String,
    created: String
  )

  case class Post(
    id:Int,
    user_id: Int,
    category_id: Int,
    created: String,
    title: String,
    body: String,
    user: User,
    category: Category
  )

  class CurrentData {
    var categoryId = 0
    var postId = 0
  }

}
