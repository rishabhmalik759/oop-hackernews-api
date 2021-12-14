package com.hackernews.client.util

import com.hackernews.client.model.{Comment, Story, User}

case class Formatter(text: String = "") {

    def interpSpecialChars: Formatter = {

        var replacedText: String = text
        val specialChars: Map[String, String] = Map(
            ("&amp;", "&"),
            ("&#38;", "&"),
            ("&apos;", "\'"),
            ("&#x27;", "\'"),
            ("&#39;", "\'"),
            ("&#47;", "/"),
            ("&lt;", "<"),
            ("&gt;", ">"),
            ("&nbsp;", " "),
            ("&quot;", "\""),
            ("&#x2F;", "/")
        )

        specialChars.foreach(x => {
            replacedText = replacedText.replace(x._1, x._2)
        })
        Formatter(replacedText)
    }

    def interpParagraphs: Formatter = {
        val replaced: String = text.replace("<p>", "\n")
        Formatter(replaced)
    }

    def interpItalics: Formatter = {
        val replaced: String = text.replace("<i>", "`").replace("</i>", "`")
            .replace("<em>", "`").replace("</em>", "`")

        Formatter(replaced)
    }

    def interpBold: Formatter = {
        val replaced: String = text.replace("<b>", Console.BOLD).replace("</b>", Console.RESET)
            .replace("<strong>", Console.BOLD).replace("</strong>", Console.RESET)

        Formatter(replaced)
    }

    def removeHtmlTags: Formatter = {
        val replaced: String = text.replaceAll("<[^>]*>", "")
        Formatter(replaced)
    }

    def interpText: String = {
        interpSpecialChars
            .interpParagraphs
            .interpItalics
            .interpBold
            .removeHtmlTags
            .text
    }

    def formatComment(item: Comment): String = {
        val text: String = {
            s"${Console.BOLD}${item.id} - ${item.by}: ${Console.RESET}\n" +
                s"  ${item.text}\n"
        }
        Formatter(text).interpText
    }

    def formatStory(item: Story): String = {
        val comments: String = if (item.descendants == 1) "comment" else "comments"

        val text: String = {
            s"${Console.BOLD}${item.id} - ${item.title} ${Console.RESET}(${item.url})\n" +
                s"\t${item.score} points by ${item.by} | ${item.descendants} $comments\n"
        }

        Formatter(text).interpText
    }

    def formatUser(user: User): String = {
        var res: String = {
            s"user: ${user.id}\n" +
                s"created on: ${user.creationDate}\n"
        }
        if (!user.about.isEmpty) res += s"about: ${user.about}\n"
        if (user.submitted.nonEmpty) res += s"submitted items: ${user.submitted.length}\n"

        Formatter(res).interpText
    }
}
