package com.hackernews.client.util

import org.scalatest.funsuite.AnyFunSuite

class FormatterTest extends AnyFunSuite {

    test("Interp special chars in a string") {
        val str: String = "&amp; This isn&apos;t a normal string &#x2F;"
        val expectedStr: String = "& This isn't a normal string /"

        val formatter: Formatter = Formatter(str)

        assert(formatter.interpSpecialChars.text == expectedStr)
    }

    test("Interp paragraphs") {
        val str: String = "This is a string.<p>This is also a string."
        val expectedStr: String = "This is a string.\nThis is also a string."

        val formatter: Formatter = Formatter(str)

        assert(formatter.interpParagraphs.text == expectedStr)
    }

    test("Interp italics") {
        val str: String = "<em>This is a string.</em> <i>This is also a string.</i>"
        val expectedStr: String = "`This is a string.` `This is also a string.`"

        val formatter: Formatter = Formatter(str)

        assert(formatter.interpItalics.text == expectedStr)
    }

    test("Interp bold") {
        val str: String = "<strong>This is a string.</strong> <b>This is also a string.</b>"
        val expectedStr: String = s"${Console.BOLD}This is a string.${Console.RESET} ${Console.BOLD}This is also a string.${Console.RESET}"

        val formatter: Formatter = Formatter(str)

        assert(formatter.interpBold.text == expectedStr)
    }

    test("Remove Html tags") {
        val str: String = "<title>This is a string.</title> <body>This is also a string.</body>"
        val expectedStr: String = "This is a string. This is also a string."

        val formatter: Formatter = Formatter(str)

        assert(formatter.removeHtmlTags.text == expectedStr)
    }
}
