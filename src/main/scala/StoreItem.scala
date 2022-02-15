class StoreItem(override val id: Int, override val name: String, override val value: Int) extends Artikel with Logger {
  override def logAction(actionName: String, name: String = name): Unit = {
    println(s"$name $actionName")
  }
}
