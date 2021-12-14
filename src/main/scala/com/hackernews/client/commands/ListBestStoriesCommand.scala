package com.hackernews.client.commands

import com.hackernews.client.model.Story
import com.hackernews.client.services.StoryService
import com.hackernews.client.util.Formatter

case class ListBestStoriesCommand(service: StoryService, pageNumber: Int, pageSize: Int) extends Command {

    def execute(): Unit = {

        val responseIds: List[Long] = service.getBestStories

        val ids: List[Long] = service.getDisplayList(list = responseIds, pageNumber, pageSize)

        val data: List[Story] = service.getList(ids)

        data.map(Formatter().formatStory).foreach(print)
    }
}
