package mud.immutable

/**
  * Created by jaredmackey on 4/24/16.
  */
object Item {
  def apply(n: xml.Node): Item = {
    Item((n \ "@name").text.trim, (n \ "@description").text.trim)
  }
}
case class Item(name: String, description: String) {
  def matches(n: String): Boolean = {
    n.compareToIgnoreCase(name) == 0
  }
}
