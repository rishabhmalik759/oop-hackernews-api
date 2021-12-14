package com.hackernews.client.connector

import scala.io.Source

case class RestClient() extends Client {

    private val base_url: String = s"https://hacker-news.firebaseio.com/v0/"

    private def getResponseFromUrl(url: String): String = {
        val s = Source.fromURL(url)
        s.getLines().mkString("\n")
    }

    def getStories(storyType: String): String = {
        val url = base_url + storyType + ".json"
        getResponseFromUrl(url)
    }

    def getData(id: Long): String = {
        val url = base_url + "item/" + id + ".json"
        getResponseFromUrl(url)
    }

    def getUser(id: String): String = {
        val url = base_url + "user/" + id + ".json"
        getResponseFromUrl(url)
    }

    def getUpdates: String = {
        val url = base_url + "updates.json"
        getResponseFromUrl(url)
    }
}
