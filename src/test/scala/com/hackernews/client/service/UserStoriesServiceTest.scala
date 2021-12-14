package com.hackernews.client.service

import com.hackernews.client.connector.{CacheClient, RestClient}
import com.hackernews.client.services.UserStoryService
import org.scalatest.funsuite.AnyFunSuite

class UserStoriesServiceTest extends AnyFunSuite {

  val userStoryService: UserStoryService = new UserStoryService(CacheClient(RestClient()))

    test("Get first itemID in the list based on page number and size") {
        val pageNumber = 2
        val pageSize = 3
        val fullList: List[Long] = List[Long](0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

        val list: List[Long] = userStoryService.getBeginningOfList(fullList, pageNumber, pageSize)
        assert(list == List[Long](3, 4, 5, 6, 7, 8, 9))
    }
}
