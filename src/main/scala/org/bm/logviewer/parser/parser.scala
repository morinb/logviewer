package org.bm.logviewer.parser

import org.bm.logviewer.Tokens

/**
 * Parser trait defines the way a message is parsed into named chunks of text.
 * @author Baptiste Morin
 */
trait Parser {
  /**
   * @param message The line of text to be parsed.
   * @return Tokens (which is a Queue[String] type alias) corresponding to the parsed message.
   */
  def parse(message: String): Tokens
}
