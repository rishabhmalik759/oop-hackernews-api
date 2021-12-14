package com.hackernews.client.services

import com.hackernews.client.connector.Client
import com.hackernews.client.model.Comment

class CommentService(client: Client) extends Service {

    def getResponse(id: Long): String = {
        client.getData(id)
    }

    def getData(response: String): Comment = {
        json.readComment(response)
    }

    def getList(list: List[Long]): List[Comment] = {
        list.map(id => getData(getResponse(id)))
    }
}
