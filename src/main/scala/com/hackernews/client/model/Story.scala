package com.hackernews.client.model

case class Story(id: Long, by: String = "", descendants: Int = 0,
                 kids: List[Long] = List[Long](), score: Long = 0,
                 title: String = "",
                 url: String = ""
                 ) extends Data {}
