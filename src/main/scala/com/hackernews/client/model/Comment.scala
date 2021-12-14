package com.hackernews.client.model

case class Comment(id: Long,
                   by: String,
                   kids: List[Long] = List[Long](),
                   text: String) extends Data {}
