package mud.mutable

/**
  * Created by jaredmackey on 4/24/16.
  */
class MOB(val name: String, val items: List[Item], private var mCurrentRoom: String) extends Character {
  def currentRoom = mCurrentRoom

}
