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
    created: Date,
    login: String,
    password: String,
    lastlogin: Date
  )

  case class Source(id:Int,
    user_id: Int,
    url: String,
    lastupdate: Date,
    parser: String,
    created: Date
  )

  case class Post(
    id:Int,
    user_id: Int,
    category_id: Int,
    created: Date,
    title: String,
    body: String,
    user: User,
    category: Category
  )

}
