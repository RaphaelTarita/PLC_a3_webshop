class Database extends Warenkorb {
  private var storedItems: Array[StoreItem] = Array.empty

  override def delete(id: Int): Array[StoreItem] = {
    storedItems.find(_.id == id) match {
      case Some(item) => item.logAction("gelöscht")
      case None => println(s"Id $id nicht gefunden")
    }
    storedItems = storedItems.filterNot(_.id == id)
    storedItems
  }

  override def search(name: String): Array[StoreItem] = {
    val ret = storedItems.filter(_.name == name)
    if (ret.isEmpty) {
      println(s"$name nicht gefunden")
    } else {
      ret.foreach(_.logAction("gefunden"))
    }
    ret
  }

  override def sortByValueAsc(): Array[StoreItem] = storedItems.sortBy(_.value)

  override def sortByValueDesc(): Array[StoreItem] = storedItems.sortBy(-_.value)

  override def store(item: StoreItem): Array[StoreItem] = {
    val idx = storedItems.indexWhere(_.id == item.id)
    if (idx < 0) {
      storedItems = storedItems :+ item
    } else {
      storedItems.update(idx, item)
    }
    item.logAction("gespeichert")
    storedItems
  }

  override def sumUp(): Int = storedItems.foldLeft(0)(_ + _.value)
}
