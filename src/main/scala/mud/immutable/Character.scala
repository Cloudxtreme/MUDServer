package mud.immutable

/**
  * Created by jaredmackey on 4/24/16.
  */
trait Character {
  val name: String
  def items: List[Item]
  def currentRoom: String
}
