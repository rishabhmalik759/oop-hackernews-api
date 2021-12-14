package com.hackernews.client.model

import java.time.LocalDate

case class User(id: String,
                about: String = "",
                created: Long,
                karma: Int,
                submitted: List[Long] = List[Long]()) {

    val creationDate: LocalDate = {
        LocalDate.of(1970, 1, 1).plusDays(created / 60 / 60 / 24)
    }
}
