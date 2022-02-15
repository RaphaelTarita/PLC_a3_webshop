object MainApp {
  def main(args: Array[String]): Unit = {
    val db = new Database

    val item1 = new StoreItem(1, "Laptop", 1000)
    val item2 = new StoreItem(2, "PC", 800)
    val item3 = new StoreItem(3, "Smartphone", 1200)
    val item4 = new StoreItem(4, "PC", 1400)

    db.store(item1)
    println(db.sumUp())

    db.store(item2)
    db.store(item3)
    db.store(item4)
    println(db.sumUp())

    db.delete(1)
    println(db.sumUp())

    db.search("PC")
  }
}