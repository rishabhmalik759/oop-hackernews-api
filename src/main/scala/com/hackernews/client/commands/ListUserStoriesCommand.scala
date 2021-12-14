package com.hackernews.client.commands

import com.hackernews.client.model.{Story, User}
import com.hackernews.client.services.{UserService, UserStoryService}
import com.hackernews.client.util.Formatter

import scala.collection.View

case class ListUserStoriesCommand(userService: UserService,
                                  userStoryService: UserStoryService,
                                  id: String, pageNumber: Int, pageSize: Int) extends Command {

    def execute(): Unit = {

        val response: String = userService.getResponse(id)

        val user: User = userService.getUser(response)

        def ids: List[Long] = userService.getUserItems(user)

        def data: View[Story] = userStoryService.getUserStories(ids, pageNumber, pageSize)

        data.map(Formatter().formatStory).foreach(print)
    }
}
