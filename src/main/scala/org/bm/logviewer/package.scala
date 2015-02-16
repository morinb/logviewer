package org.bm

import scala.collection.immutable.Queue

/**
 * .
 * @author Baptiste Morin
 */
package object logviewer {
  type Token = String
  type Tokens = Queue[String]

  type ParsedMessage = Map[String, String]
}
