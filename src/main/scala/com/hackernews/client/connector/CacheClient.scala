package com.hackernews.client.connector

import com.hackernews.client.util.Cache

case class CacheClient(service: Client, ttl: Int = 600) extends Client {

    val location: String = "cache/"

    val cache: Cache = Cache(ttl)

    def itemUpdated(id: Long): Boolean = {
        getUpdates.contains(id)
    }

    def userUpdated(id: String): Boolean = {
        getUpdates.contains(id)
    }

    def getStories(storyType: String): String = {
        service.getStories(storyType)
    }

    def getData(id: Long): String = {
        if (!itemUpdated(id) && cache.isValid(id.toString)) {
            cache.getCache(id.toString)
        } else {
            val response: String = service.getData(id)
            cache.addItem(response)
            response
        }
    }

    def getUser(id: String): String = {
        if (!userUpdated(id) && cache.isValid(id)) {
            cache.getCache(id)
        } else {
            val response: String = service.getUser(id)
            cache.addUser(response)
            response
        }
    }

    def getUpdates: String = {
        service.getUpdates
    }
}
