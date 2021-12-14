package com.hackernews.client.util

import com.hackernews.client.ResponseMocks
import com.hackernews.client.model.{Comment, Story, User}
import org.scalatest.funsuite.AnyFunSuite

class JsonTest extends AnyFunSuite {

    val responses: ResponseMocks = new ResponseMocks
    val json: JsonUtil = JsonUtil()

    test("Read boolean") {
        val jsonVal = json.parsed(responses.deletedStory)
        assert(json.readBoolean(jsonVal("deleted").toString()))
    }

    test("Read Int") {
        val jsonVal = json.parsed(responses.intJson)
        assert(json.readInt(jsonVal("int").toString()).isInstanceOf[Int])
    }

    test("Read Story") {
        assert(json.readStory(responses.story1).isInstanceOf[Story])
    }

    test("Read Comment") {
        assert(json.readComment(responses.comment1).isInstanceOf[Comment])
    }

    test("Read User") {
        assert(json.readUser(responses.user).isInstanceOf[User])
    }

    test("Read Items") {
        assert(json.readItems(responses.topstories).isInstanceOf[List[Long]])
    }

    test("Get id") {
        val story: Story = json.readStory(responses.story1)
        assert(json.getId(responses.story1) == story.id)
    }

    test("Add cache ttl") {
        val response = json.addCacheTtl(responses.story1, ttl = 600)
        assert(response.contains("\"ttl\":600") )
    }
}
