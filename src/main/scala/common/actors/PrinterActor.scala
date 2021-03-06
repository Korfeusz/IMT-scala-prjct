package common.actors

import akka.actor.{Actor, ActorLogging, Props}
import common.messages.CommonMessages.{LogText, Response}

object PrinterActor {
  def props: Props = Props[PrinterActor]
}

class PrinterActor extends Actor with ActorLogging {

  def receive = {
    case sequence: collection.Seq[String] =>
      sequence.foreach(println)
      print("\n> ")
    case Response(text) =>
      println(text)
      print("\n> ")
    case LogText(text) =>
      log.info("[Sender: " + sender + "], msg: " + text)
    case  text: String =>
      println(text)

  }
}