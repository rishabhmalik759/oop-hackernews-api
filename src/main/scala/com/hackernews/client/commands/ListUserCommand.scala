package com.hackernews.client.commands

import com.hackernews.client.model.User
import com.hackernews.client.services.UserService
import com.hackernews.client.util.Formatter

case class ListUserCommand(userSer: UserService, id: String) extends Command {

    def execute(): Unit = {

        val response: String = userSer.getResponse(id)

        val user: User = userSer.getUser(response)

        print(Formatter().formatUser(user))
    }
}
