package com.hackernews.client.services

import com.hackernews.client.connector.Client
import com.hackernews.client.model.Story

import scala.collection.View

class UserStoryService(client: Client) extends StoryService(client) {

    def getBeginningOfList(fullList: List[Long], pageNumber: Int, pageSize: Int): List[Long] = {

        val startPos = pageSize * (pageNumber - 1)

        // drop first n items till reaching first position
        fullList.drop(startPos)
    }

    def getUserStories(fullList: List[Long], pageNumber: Int, pageSize: Int): View[Story] = {

        val list: List[Long] = getBeginningOfList(fullList, pageNumber, pageSize)

        list.view.map(getResponse).filter(validateResponse).map(getData).take(pageSize)
    }
}
