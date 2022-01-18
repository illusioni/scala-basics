package de.illusioni.scalabasics.types

object SelfType {
  def main(args: Array[String]): Unit = {
    val testEnv = initEnv()
    testEnv.log("test")
  }

  def initEnv(): Environment = {
    new Environment with DbConnector with TxManagerB
//    new Environment with FileConnector with TxManagerA
  }
}



class Environment { self: DataConnector with TxManager =>
  def log(msg: String): Unit = {
    connect()
    beginTx()
    println(msg)
    commitTx()
  }
}

trait DataConnector {
  def connect(): Unit
}
trait DbConnector extends DataConnector {
  def connect() = println("connecting to db")
}
trait FileConnector extends DataConnector {
  def connect() = println("connecting to file storage")
}

trait TxManager {
  def beginTx(): Unit
  def commitTx(): Unit
}
trait TxManagerA extends TxManager {
  def beginTx() { println("begin tx of type A") }
  def commitTx() { println("committing tx of type A") }
}
trait TxManagerB extends TxManager {
  def beginTx() { println("begin tx of type B") }
  def commitTx() { println("committing tx of type B") }
}