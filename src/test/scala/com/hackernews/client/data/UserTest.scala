package com.hackernews.client.data

import com.hackernews.client.ResponseMocks
import com.hackernews.client.model.User
import com.hackernews.client.util.JsonUtil
import org.scalatest.funsuite.AnyFunSuite

class UserTest extends AnyFunSuite {

    val responses: ResponseMocks = new ResponseMocks
    val json: JsonUtil = JsonUtil()

    test("Response with empty about section does not raise an error") {
        val user: User = json.readUser(responses.userWithNoAbout)
        assert(user.about == "")
    }

    test("Response with empty submitted items does not raise an error") {
        val user: User = json.readUser(responses.userWithNoSubmitted)
        assert(user.submitted == List[Long]())
    }
}
