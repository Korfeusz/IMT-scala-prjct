package server.database.tables
import slick.jdbc.PostgresProfile.api._

class Users(tag: Tag) extends Table[(Int, String, String, String, Boolean, Boolean)](tag, "USERS") {
  def id = column[Int]("SUP_ID", O.PrimaryKey) // This is the primary key column
  def name = column[String]("SUP_NAME")
  def passwordHash = column[String]("PASSWORD_HASH")
  def salt = column[String]("SALT")
  def isAdmin = column[Boolean]("ADMIN")
  def isAuthorized = column[Boolean]("AUTHORIZED")
  // Every table needs a * projection with the same type as the table's type parameter
  def * = (id, name, passwordHash, salt, isAdmin, isAuthorized)
}