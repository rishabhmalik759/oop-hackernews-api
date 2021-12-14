package com.hackernews.client.service

import com.hackernews.client.ResponseMocks
import com.hackernews.client.connector.{CacheClient, RestClient}
import com.hackernews.client.model.User
import com.hackernews.client.services.UserService
import org.scalatest.funsuite.AnyFunSuite


class UserServiceTest extends AnyFunSuite {

    val service: UserService = new UserService(CacheClient(RestClient()))
    val responses: ResponseMocks = new ResponseMocks

    test("Valid userID response is validated") {
        val response: String = responses.user
        assert(service.validateResponse(response))
    }

    test("Invalid userID response throws IOException") {
        val response: String = "null"
        assert(!service.validateResponse(response))
    }

    test("Able to get user's submitted items") {
        val user: User = User(id = "abcd", about = "test", created = 23223432, karma = 1234, submitted = List[Long](1, 2, 3))
        val items: List[Long] = service.getUserItems(user)
        assert(items == List[Long](1, 2, 3))
    }
}
