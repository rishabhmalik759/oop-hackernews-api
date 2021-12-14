package com.hackernews.client.services

import com.hackernews.client.model.Data
import com.hackernews.client.util.JsonUtil

import scala.util.Try

abstract class Service {

    val json: JsonUtil = new JsonUtil

    def getResponse(id: Long): String

    def getData(response: String): Data

    def getList(list: List[Long]): List[Data]

    def getChildren(response: String): List[Long] = {
        val jsonVal = json.parsed(response)
        val kids: String = {
            Try(jsonVal("kids").toString()).getOrElse("[]")
        }
        json.readItems(kids)
    }

    def getDisplayList(list: List[Long], pageNumber: Int, pageSize: Int): List[Long] = {
        val startPos = pageSize * (pageNumber - 1)
        list.slice(startPos, startPos + pageSize)
    }
}
