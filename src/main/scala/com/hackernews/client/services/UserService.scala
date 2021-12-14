package com.hackernews.client.services

import com.hackernews.client.connector.Client
import com.hackernews.client.model.User
import com.hackernews.client.util.JsonUtil

class UserService(client: Client) {

    def getResponse(userID: String): String = client.getUser(userID)

    def validateResponse(response: String): Boolean = response != "null"

    def getUser(response: String): User = {

        validateResponse(response)

        JsonUtil().readUser(response)
    }

    def getUserItems(user: User): List[Long] = {
        user.submitted
    }
}
