package com.hackernews.client.model

trait Data {

    def id: Long

    def by: String

    def kids: List[Long]
}
