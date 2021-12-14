package com.hackernews.client.data

import com.hackernews.client.ResponseMocks
import com.hackernews.client.model.Story
import com.hackernews.client.util.JsonUtil
import org.scalatest.funsuite.AnyFunSuite

class StoryTest extends AnyFunSuite {

    val responses: ResponseMocks = new ResponseMocks
    val json: JsonUtil = JsonUtil()

    test("Response with no kids parameter does not raise an error") {
        var story: Story = json.readStory(responses.storyWithNoKids)
        assert(story.kids == List[Long]())
        story = null
    }

    test("Response with no title parameter does not raise an error") {
        var story: Story = json.readStory(responses.storyWithNoTitle)
        assert(story.title == "")
        story = null
    }

    test("Response with no url parameter does not raise an error") {
        var story: Story = json.readStory(responses.storyWithNoUrl)
        assert(story.url == "")
        story = null
    }

    test("Response with no descendants parameter does not raise an error") {
        var story: Story = json.readStory(responses.storyWithNoDecendants)
        assert(story.descendants == 0)
        story = null
    }

    test("Response with no score parameter does not raise an error") {
        var story: Story = json.readStory(responses.storyWithNoScore)
        assert(story.score == 0)
        story = null
    }
}
