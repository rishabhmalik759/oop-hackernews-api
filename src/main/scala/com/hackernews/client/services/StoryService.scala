package com.hackernews.client.services

import com.hackernews.client.connector.Client
import com.hackernews.client.model.Story
import com.hackernews.client.util.JsonUtil

import scala.util.{Failure, Success, Try}

class StoryService(client: Client) extends Service {

    def isDeleted(response: ujson.Value): Boolean = {
        val deleted = Try(JsonUtil().readBoolean(response("deleted").toString()))
        deleted match {
            case Success(_) => true
            case Failure(_) => false
        }
    }

    def isStory(response: ujson.Value): Boolean = {
        val _type: String = JsonUtil().readString(response("type").toString())
        _type == "story"
    }

    def validateResponse(response: String): Boolean = {
        val pResponse = JsonUtil().parsed(response)
        !isDeleted(pResponse) && isStory(pResponse)
    }

    def getResponse(id: Long): String = {
        client.getData(id)
    }

    def getData(response: String): Story = {
        JsonUtil().readStory(response)
    }

    def getList(list: List[Long]): List[Story] = {
        list.map(id => getData(getResponse(id)))
    }

    private def getStoriesFromAPI(storyType: String): List[Long] = {
        val response: String = client.getStories(storyType)
        JsonUtil().readItems(response)
    }

    def getTopStories: List[Long] = {
        getStoriesFromAPI("topstories")
    }

    def getNewStories: List[Long] = {
        getStoriesFromAPI("newstories")
    }

    def getBestStories: List[Long] = {
        getStoriesFromAPI("beststories")
    }
}
