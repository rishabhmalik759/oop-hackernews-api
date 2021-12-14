package com.hackernews.client.util

import java.io.File
import java.nio.file.{Files, Paths}
import java.time.LocalDateTime
import scala.io.Source

case class Cache(ttl: Int = 600) {

    val location: String = "cache/"

    val json: JsonUtil = JsonUtil()

    def getLocation(): String = {
        return location
    }

    private def addToFile(name: String, content: String): Unit = {
        val filePath: String = location + name + ".json"

        import java.io._
        val pw = new PrintWriter(new File(filePath))
        pw.write(json.addCacheTtl(content, ttl))
        pw.close()
    }

    def addItem(response: String): Unit = {
        addToFile(name = json.getId(response).toString, content = response)
    }

    def addUser(response: String): Unit = {
        addToFile(name = json.getUserId(response), content = response)
    }

    private def getFile(name: String): String = {
        val filePath: String = location + name + ".json"

        val source = Source.fromFile(filePath)
        val lines = try source.getLines().mkString finally source.close()

        lines
    }

    def getCache(name: String): String = {
        getFile(name)
    }

    def exists(name: String): Boolean = {
        Files.exists(Paths.get(location + name + ".json"))
    }

    def isValid(name: String): Boolean = {
        if (exists(name)) {
            val content = getFile(name)
            val oldTtl: Int = json.getCacheTtl(content)
            val oldDateTime: LocalDateTime = json.getCacheAddedDateTime(content)

            oldDateTime plusSeconds oldTtl isAfter LocalDateTime.now()
        } else false
    }

    def clear(): Unit = {
        val dir = new File(location)

        dir.listFiles().foreach(_.delete())
        dir.listFiles().foreach(_ => {
            Files.delete((_))
        })

    }
}
