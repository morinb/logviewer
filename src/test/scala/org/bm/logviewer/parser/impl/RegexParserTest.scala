package org.bm.logviewer.parser.impl

import org.bm.logviewer.parser.Parser
import org.scalatest.FunSuite

/**
 * .
 * @author Baptiste Morin
 */
class RegexParserTest extends FunSuite {

  val regexTest = """((?:\d{4})/(?:0[1-9]|1[012])/(?:0[1-9]|[12][0-9]|3[01])) (\S{1,5}) '(.*)'$""".r
  val message = """2015/09/31 INFO 'Here is '""'my message'"""

  test("Regex Parser") {

    val parser: Parser = new RegexParser(regexTest)

    val tokens = parser parse message

    println(tokens mkString ", ")
    assert(tokens.size === 3)
    assert(tokens(0) === "2015/09/31")
    assert(tokens(1) === "INFO")
    assert(tokens(2) === """Here is '""'my message""")



  }

}
