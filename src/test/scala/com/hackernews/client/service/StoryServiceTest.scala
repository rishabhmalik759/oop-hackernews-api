package com.hackernews.client.service

import com.hackernews.client.ResponseMocks
import com.hackernews.client.connector.{CacheClient, RestClient}
import com.hackernews.client.services.StoryService
import com.hackernews.client.util.JsonUtil
import org.scalatest.funsuite.AnyFunSuite

class StoryServiceTest extends AnyFunSuite {

    val service: StoryService = new StoryService(CacheClient(RestClient()))
    val json: JsonUtil = JsonUtil()
    val responses: ResponseMocks = new ResponseMocks

    test("Story page contains correct indices") {
        val pageNumber = 2
        val pageSize = 3
        val list: List[Long] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val ids = service.getDisplayList(list = list, pageNumber = pageNumber, pageSize = pageSize)
        assert(ids == List(3, 4, 5))
    }

    test("Page size contains more space than available stories is okay") {
        val pageNumber = 3
        val pageSize = 4
        val list: List[Long] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val ids = service.getDisplayList(list = list, pageNumber = pageNumber, pageSize = pageSize)
        assert(ids == List(8, 9))
    }

    test("Page number and size exceed the given list and should return empty") {
        val pageNumber = 100
        val pageSize = 20
        val list: List[Long] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val ids = service.getDisplayList(list = list, pageNumber = pageNumber, pageSize = pageSize)
        assert(ids == List())
    }

    test("Negative page number and size should just return empty") {
        val pageNumber = -3
        val pageSize = -4
        val list: List[Long] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val ids = service.getDisplayList(list = list, pageNumber = pageNumber, pageSize = pageSize)
        assert(ids == List())
    }

    test("Return true if response is of type story") {
        val response: ujson.Value = json.parsed(responses.story1)
        assert(service.isStory(response))
    }

    test("Return false if response is not of type story") {
        val response: ujson.Value = json.parsed(responses.comment1)
        assert(!service.isStory(response))
    }

    test("Find a valid (non deleted) story from the response") {
        val response: ujson.Value = json.parsed(responses.story1)
        assert(!service.isDeleted(response))
    }

    test("Find a deleted story from the response") {
        val response: ujson.Value = json.parsed(responses.deletedStory)
        assert(service.isDeleted(response))
    }
}
