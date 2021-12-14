package com.hackernews.client.data

import com.hackernews.client.ResponseMocks
import com.hackernews.client.model.Comment
import com.hackernews.client.util.JsonUtil
import org.scalatest.funsuite.AnyFunSuite

class CommentTest extends AnyFunSuite {

    val responses: ResponseMocks = new ResponseMocks
    val json: JsonUtil = JsonUtil()

    test("Response with no kids parameter does not raise an error") {

        val comment: Comment = json.readComment(responses.commentsWithNoChildren)
        assert(comment.kids == List[Long]())
    }
}
