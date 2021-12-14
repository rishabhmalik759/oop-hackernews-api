package com.hackernews.client.util

import com.hackernews.client.ResponseMocks
import org.scalatest.funsuite.AnyFunSuite

import java.io.File
import java.nio.file.{Files, Paths}

class CacheTest extends AnyFunSuite {

    val responses: ResponseMocks = new ResponseMocks
    val json: JsonUtil = JsonUtil()

    def deleteAddedFile(name: String): Unit = {
        val cache: Cache = Cache()
        //val path: String = cache.getCache() + name + ".json"
        Files.delete(Paths.get(cache.getLocation() + name + ".json"))
    }

    test("Add item") {
        var cache: Cache = Cache()
        cache.addItem(responses.story1)
        val id: Long = json.getId(responses.story1)
        val expectedLoc: String = cache.location + id + ".json"
        cache = null

        assert(Files.exists(Paths.get(expectedLoc)))
        deleteAddedFile(id.toString)
    }

    test("Add user") {
        var cache: Cache = Cache()
        cache.addUser(responses.user)
        val id: String = json.getUserId(responses.user)
        val expectedLoc: String = cache.location + id + ".json"
        cache = null

        assert(Files.exists(Paths.get(expectedLoc)))
        deleteAddedFile(id)
    }

    test("File exists and is valid") {
        var cache: Cache = Cache()
        cache.addItem(responses.story1)
        val id: Long = json.getId(responses.story1)

        assert(cache.isValid(id.toString))
        cache = null

        deleteAddedFile(id.toString)
    }

    test("File does not exist is not valid") {
        var cache: Cache = Cache()
        assert(!cache.isValid("dummy"))

        cache = null
    }

    test("File within ttl is valid") {
        var cache: Cache = Cache(ttl = 100000)
        cache.addItem(responses.story1)
        val id: Long = json.getId(responses.story1)

        // time within ttl
        assert(cache.isValid(id.toString))
        cache = null

        deleteAddedFile(id.toString)
    }

    test("File out of ttl is not valid") {

        var cache: Cache = Cache(ttl = 1)
        cache.addItem(responses.story1)
        val id: Long = json.getId(responses.story1)

        Thread.sleep(1000)
        assert(!cache.isValid(id.toString))
        cache = null

        deleteAddedFile(id.toString)
    }

    test("Clear cache") {

        //Thread.sleep(10000)
        var cache: Cache = Cache(ttl = 1)
        cache.addItem(responses.story1)

        val expectedLoc: String = cache.location
        val dir = new File(expectedLoc)

        val prevLen = dir.listFiles().length
        cache.clear()
        cache = null
        val newLen = dir.listFiles().length

        assert(newLen == 0)
        assert(prevLen > newLen)

    }
}