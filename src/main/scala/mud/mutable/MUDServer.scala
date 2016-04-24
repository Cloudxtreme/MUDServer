package mud.mutable

/**
  * Created by jaredmackey on 4/24/16.
  */

object MUDServer extends App {
  println("What's your name?")
  val player = Player(readLine(), "inn")
  val rooms = (xml.XML.loadFile("map.xml") \ "room").map(n => {
    val room = Room(n)
    room.keyword -> room
  }).toMap
  println("Welcome to a simple text adventure. ")
  rooms(player.currentRoom).print()
  var input = ""
  while(input != "quit") {
    print("> ")
    input = readLine().trim
    if (input != "quit") {
      player.process(input, rooms)
    }
  }
}