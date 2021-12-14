package com.hackernews.client

import com.hackernews.client.commands.{Command, ListBestStoriesCommand, ListCommentsCommand, ListNewStoriesCommand, ListTopStoriesCommand, ListUserCommand, ListUserStoriesCommand}
import com.hackernews.client.connector.{CacheClient, Client, RestClient}
import com.hackernews.client.services.{CommentService, StoryService, UserService, UserStoryService}
import com.hackernews.client.util.Cache

import scala.sys.exit

object Main {

    def usage: String = {
        "Usage: hncli [options] [command] [command-options]" + "\n" +
        "Help: hncli --help" + "\n"
    }

    def main(args: Array[String]): Unit = {

        var argsList = args.toList

        if (argsList.isEmpty) {
            print(usage)
            exit(1)
        }

        def getTtl: Int = {
            if (argsList.head.contains("--ttl=")) {
                val ttl = argsList.head.split('=')(1).toInt
                argsList = argsList.drop(1)
                ttl
            } else 600
        }

        // dafaults
        var pageNumber: Int = 1
        var pageSize: Int = 5
        val ttl = getTtl

        def getProxiedRestClient(ttl: Int): Client = {
            CacheClient(RestClient(), ttl)
        }

        def parsePageArgs(args: List[String]): Unit = {
            args.foreach {
                case page if page contains "--page=" => pageNumber = page.split('=')(1).toInt
                case size if size contains "--size=" => pageSize = size.split('=')(1).toInt
                case _ => {
                    print(usage)
                    exit(1)
                }
            }
        }

        argsList match {
            case help :: Nil if help == "--help" || help == "-h" => {
                val source = scala.io.Source.fromResource("user-manual.txt")
                val lines: String = {
                    try source.getLines().mkString("\n") finally source.close()
                }
                print(lines)
            }
            case "--clear-cache" :: Nil => {
                Cache().clear()
                println("Cache cleared")
            }
            case "top-stories" :: _ if argsList.length <= 3 => {
                parsePageArgs(argsList.drop(1))
                val service: StoryService = new StoryService(getProxiedRestClient(ttl))
                var command: Command = ListTopStoriesCommand(service, pageNumber, pageSize)
                command.execute()
            }
            case "best-stories" :: _ if argsList.length <= 3 => {
                parsePageArgs(argsList.drop(1))
                val service: StoryService = new StoryService(getProxiedRestClient(ttl))
                var command: Command = ListBestStoriesCommand(service, pageNumber, pageSize)
                command.execute()
            }
            case "new-stories" :: _ if argsList.length <= 3 => {
                parsePageArgs(argsList.drop(1))
                val service: StoryService = new StoryService(getProxiedRestClient(ttl))
                var command: Command = ListNewStoriesCommand(service, pageNumber, pageSize)
                command.execute()
            }
            case user :: _ if (argsList.length == 1) && (user contains "user=") => {
                val userId: String = user.split('=')(1)
                val service: UserService = new UserService(getProxiedRestClient(ttl))
                var command: Command = ListUserCommand(service, userId)
                command.execute()
            }
            case user :: "--show-stories" :: _ if (argsList.length <= 4) && (user contains "user=") => {
                parsePageArgs(argsList.drop(2))
                val userId: String = user.split('=')(1)

                val userService: UserService = new UserService(getProxiedRestClient(ttl))
                val userStoryService: UserStoryService = new UserStoryService(getProxiedRestClient(ttl))
                var command: Command = ListUserStoriesCommand(userService, userStoryService, userId, pageNumber, pageSize)
                command.execute()
            }
            case displayComments :: _ if (argsList.length <= 3) && (displayComments contains "show-comments=") => {
                parsePageArgs(argsList.drop(1))
                val itemId: Long = displayComments.split('=')(1).toInt

                val service: CommentService = new CommentService(getProxiedRestClient(ttl))
                var command: Command = ListCommentsCommand(service, itemId, pageNumber, pageSize)
                command.execute()
            }
            case _ => {
                print(usage)
                exit(1)
            }
        }

    }
}
