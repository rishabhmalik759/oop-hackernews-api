package com.hackernews.client.util

import com.hackernews.client.model.{Comment, Story, User}
import upickle.default._

import java.time.LocalDateTime

case class JsonUtil() {

    def readString(str: String): String = {
        read[String](str)
    }

    def readInt(str: String): Int = {
        read[Int](str)
    }

    def readBoolean(str: String): Boolean = {
        read[Boolean](str)
    }

    def readItems(response: String): List[Long] = {
        read[List[Long]](response)
    }

    def parsed(str: String): ujson.Value = {
        read[ujson.Value](str)
    }

    def getId(response: String): Long = {
        read[Long](parsed(response)("id"))
    }

    def getUserId(response: String): String = {
        read[String](parsed(response)("id"))
    }

    def readStory(response: String): Story = {
        implicit val itemRW: ReadWriter[Story] = macroRW
        read[Story](response)
    }

    def readComment(response: String): Comment = {
        implicit val itemRW: ReadWriter[Comment] = macroRW
        read[Comment](response)
    }

    def readUser(response: String): User = {
        implicit val itemRW: ReadWriter[User] = macroRW
        read[User](response)
    }

    def addCacheTtl(response: String, ttl: Int): String = {
        val jsonVal: ujson.Value = parsed(response)

        jsonVal("createdOn") = LocalDateTime.now().toString
        jsonVal("ttl") = ttl


        jsonVal.toString()
    }

    def getCacheTtl(response: String): Int = {
        val jsonVal: ujson.Value = parsed(response)

        readInt(jsonVal("ttl").toString())
    }

    def getCacheAddedDateTime(response: String): LocalDateTime = {
        val jsonVal: ujson.Value = parsed(response)
        val createdOn: String = read[String](jsonVal("createdOn"))

        LocalDateTime.parse(createdOn)
    }
}
