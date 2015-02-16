package org.bm.logviewer.parser.impl

import org.bm.logviewer.Tokens
import org.bm.logviewer.exceptions.NoMatchFoundException
import org.bm.logviewer.parser.Parser

import scala.annotation.tailrec
import scala.collection.immutable.Queue
import scala.util.matching.Regex
import scala.util.matching.Regex.Match

/**
 * Uses Regular expression groups to split the message into tokens.
 * @author Baptiste Morin
 */
class RegexParser(val regex: Regex) extends Parser {

  private[this] def getTokens(m: Match): Tokens = {
    require(m.groupCount > 0, "Current match does not have groups.")

    @tailrec
    def accumulator(tokens: Tokens, group: Int): Tokens = {
      if (group > m.groupCount) {
        tokens
      } else {
        accumulator(tokens.enqueue(m.group(group)), group + 1)
      }
    }

    accumulator(Queue[String](), 1)

  }

  /**
   * @param message The line of text to be parsed.
   * @return Tokens (which is a Queue[String] type alias) corresponding to the parsed message.
   */
  override def parse(message: String): Tokens =
    regex.findFirstMatchIn(message) match {
      case Some(m) => getTokens(m)
      case None => throw new NoMatchFoundException(regex, message)
    }



}
