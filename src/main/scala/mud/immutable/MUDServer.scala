package mud.immutable

import scala.annotation.tailrec

/**
  * Created by jaredmackey on 4/24/16.
  */

object MUDServer extends App {
  private def intro(player: Player, rooms: Map[String, Room]): Unit = {
    println("Welcome to a simple text adventure.")
    rooms(player.currentRoom).print()
    step(player, rooms)
  }

  @tailrec
  private def step(player: Player, rooms:Map[String, Room]): Unit = {
    print("> ")
    val input = io.StdIn.readLine.trim
    if (input != "quit") {
      val (newPlayer, newRooms) = player.process(input, rooms)
      step(newPlayer, newRooms)
    }
  }


  println("What is your name?")
  intro(Player(io.StdIn.readLine, "inn"), (xml.XML.loadFile("map.xml") \ "room").map(n => {
    val room = Room(n)
    room.keyword -> room
  }).toMap)
  println("Goodbye!")
}