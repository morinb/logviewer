package org.bm.logviewer.exceptions

import scala.util.matching.Regex

/**
 * .
 * @author Baptiste Morin
 */
class NoMatchFoundException(regex: Regex, line: String) extends Exception(s"No match found for $regex in [$line]")
