package com.hackernews.client.connector

trait Client {

    def getStories(storyType: String): String

    def getData(id: Long): String

    def getUser(id: String): String

    def getUpdates: String
}
