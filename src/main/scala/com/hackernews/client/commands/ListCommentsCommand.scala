package com.hackernews.client.commands

import com.hackernews.client.connector.RestClient
import com.hackernews.client.model.Comment
import com.hackernews.client.services.CommentService
import com.hackernews.client.util.Formatter

case class ListCommentsCommand(service: CommentService, id: Long, pageNumber: Int, pageSize: Int) extends Command {

    def execute(): Unit = {

        val response: String = RestClient().getData(id)

        val ids: List[Long] = {
            val list: List[Long] = service.getChildren(response)

            service.getDisplayList(list, pageNumber, pageSize)
        }

        val data: List[Comment] = service.getList(ids)

        data.map(Formatter().formatComment).foreach(print)
    }
}
