package com.hackernews.client

/* This class contains the response types that could be received from the api */
class ResponseMocks {

    val story1 =
        """
        {
            "by" : "dhouston",
            "descendants" : 71,
            "id" : 8863,
            "kids" : [ 8952, 9224, 8917, 8884, 8887, 8943, 8869, 8958, 9005, 9671, 8940, 9067, 8908, 9055, 8865, 8881, 8872, 8873, 8955, 10403, 8903, 8928, 9125, 8998, 8901, 8902, 8907, 8894, 8878, 8870, 8980, 8934, 8876 ],
            "score" : 111,
            "time" : 1175714200,
            "title" : "My YC app: Dropbox - Throw away your USB drive",
            "type" : "story",
            "url" : "http://www.getdropbox.com/u/2/screencast.html"
        }
        """

    val story2 =
        """
        {
            "by" : "tel",
            "descendants" : 16,
            "id" : 121003,
            "kids" : [ 121016, 121109, 121168 ],
            "score" : 25,
            "time" : 1203647620,
            "title" : ""Ask HN: The Arc Effect",
            "type" : "story"
        }
        """

    val story3 =
        """
        {
            "by" : "pg",
            "descendants" : 54,
            "id" : 126809,
            "kids" : [ 126822, 126823, 126993, 126824, 126934, 127411, 126888, 127681, 126818, 126816, 126854, 127095, 126861, 127313, 127299, 126859, 126852, 126882, 126832, 127072, 127217, 126889, 127535, 126917, 126875 ],
            "score" : 46,
            "time" : 1204403652,
            "title" : "Poll: What would happen if News.YC had explicit support for polls?",
            "type" : "story",
            "url" : "https://github.com/bbodi/notecalc3/releases/tag/v0.3.0"
        }
        """

    val story4 =
        """
        {
            "by" : "giuliomagnifico",
            "descendants" : 172,
            "id" : 25493804,
            "kids" : [ 25494029, 25495623, 25493969, 25495318, 25494135, 25496317, 25496160, 25496173, 25494151, 25494721, 25495301, 25494103, 25494557, 25495874, 25494153, 25494448, 25493970, 25494357, 25495907, 25495910, 25494751, 25494158, 25494213, 25495280, 25493924 ],
            "score" : 329,
            "time" : 1608548397,
            "title" : "Nikon Is ending 70 years of camera production in Japan",
            "type" : "story",
            "url" : "https://www.mirrorlessrumors.com/nikon-is-ending-70-years-of-camera-production-in-japan/"
        }
        """

    val deletedStory =
        """
        {
            "deleted" : true
        }
        """

    val storyWithNoKids =
        """
        {
            "by" : "bbodi",
            "descendants" : 25,
            "id" : 25495393,
            "score" : 60,
            "time" : 1608562243,
            "title" : "Show HN: NoteCalc",
            "type" : "story",
            "url" : "https://github.com/bbodi/notecalc3/releases/tag/v0.3.0"
        }
        """

    val storyWithNoTitle =
        """
        {
            "by" : "bbodi",
            "descendants" : 25,
            "id" : 25495393,
            "kids" : [ 25496552, 25496080, 25496100, 25496581, 25496000, 25496200, 25496348, 25496191, 25496436, 25495895, 25496127, 25496276, 25496305, 25496029, 25496133, 25495925, 25496094 ],
            "score" : 60,
            "time" : 1608562243,
            "type" : "story",
            "url" : "https://github.com/bbodi/notecalc3/releases/tag/v0.3.0"
        }
        """

    val storyWithNoUrl =
        """
        {
            "by" : "bbodi",
            "descendants" : 25,
            "id" : 25495393,
            "kids" : [ 25496552, 25496080, 25496100, 25496581, 25496000, 25496200, 25496348, 25496191, 25496436, 25495895, 25496127, 25496276, 25496305, 25496029, 25496133, 25495925, 25496094 ],
            "score" : 60,
            "time" : 1608562243,
            "title" : "Show HN: NoteCalc",
            "type" : "story"
        }
        """

    val storyWithNoDecendants =
        """
        {
            "by" : "bbodi",
            "id" : 25495393,
            "kids" : [ 25496552, 25496080, 25496100, 25496581, 25496000, 25496200, 25496348, 25496191, 25496436, 25495895, 25496127, 25496276, 25496305, 25496029, 25496133, 25495925, 25496094 ],
            "score" : 60,
            "time" : 1608562243,
            "title" : "Show HN: NoteCalc",
            "type" : "story",
            "url" : "https://github.com/bbodi/notecalc3/releases/tag/v0.3.0"
        }
        """

    val storyWithNoScore =
        """
        {
            "by" : "bbodi",
            "descendants" : 25,
            "id" : 25495393,
            "kids" : [ 25496552, 25496080, 25496100, 25496581, 25496000, 25496200, 25496348, 25496191, 25496436, 25495895, 25496127, 25496276, 25496305, 25496029, 25496133, 25495925, 25496094 ],
            "time" : 1608562243,
            "title" : "Show HN: NoteCalc",
            "type" : "story",
            "url" : "https://github.com/bbodi/notecalc3/releases/tag/v0.3.0"
        }
        """

    val comment1 =
        """
        {
            "by" : "gorkish",
            "id" : 25496552,
            "kids" : [ 25496770, 25496948, 25496651 ],
            "parent" : 25495393,
            "text" : "Love this, but the lack of interpretation of prefixed currency symbols is absolutely maddening! That it simply ignores the number and operand with no indication that these elements are ignored could easily lead to problems. I don&#x27;t think I could in good conscience trust myself or those I might consider to be the target audience of this app to notice parsing errors in every case. Consider:<p>&quot;$400 &#x2F; 20&quot; =&gt; 20 (ERROR)<p>&quot;$400 &#x2F; 25&quot; =&gt; 25 (ERROR)<p>&quot;400$ &#x2F; 20&quot; =&gt; 20 $ (OK)<p>&quot;400$ &#x2F; 25&quot; =&gt; 16 $ (OK)",
            "time" : 1608568887,
            "type" : "comment"
        }
        """

    val comment2 =
        """
        {
            "by" : "mattweinberg",
            "id" : 25496080,
            "kids" : [ 25497313 ],
            "parent" : 25495393,
            "text" : "This looks great! The README says:<p>&gt; Honestly, it just tries to be a free Soulver alternative in your browser.<p>For people on macOS, Soulver is excellent and worth checking out: <a href=\"https:&#x2F;&#x2F;soulver.app\" rel=\"nofollow\">https:&#x2F;&#x2F;soulver.app</a> . I almost always have a Soulver window open on my screen.",
            "time" : 1608566519,
            "type" : "comment"
        }
        """

    val comment3 =
        """
        {
            "by" : "wongarsu",
            "id" : 25496100,
            "kids" : [ 25496827 ],
            "parent" : 25495393,
            "text" : "Link to the public instance: <a href=\"https:&#x2F;&#x2F;bbodi.github.io&#x2F;notecalc3&#x2F;notecalc\" rel=\"nofollow\">https:&#x2F;&#x2F;bbodi.github.io&#x2F;notecalc3&#x2F;notecalc</a><p>It took me a couple clicks to find, a link in the readme would be useful.<p>It&#x27;s an awesome tool, I think I will use this a lot. It cover 95% of my WolframAlpha use, with an interface that&#x27;s both more responsive and let&#x27;s me keep track of context and streams of thought.",
            "time" : 1608566612,
            "type" : "comment"
        }
        """

    val commentsWithNoChildren =
        """
        {
            "by" : "wongarsu",
            "id" : 25496100,
            "parent" : 25495393,
            "text" : "Link to the public instance: <a href=\"https:&#x2F;&#x2F;bbodi.github.io&#x2F;notecalc3&#x2F;notecalc\" rel=\"nofollow\">https:&#x2F;&#x2F;bbodi.github.io&#x2F;notecalc3&#x2F;notecalc</a><p>It took me a couple clicks to find, a link in the readme would be useful.<p>It&#x27;s an awesome tool, I think I will use this a lot. It cover 95% of my WolframAlpha use, with an interface that&#x27;s both more responsive and let&#x27;s me keep track of context and streams of thought.",
            "time" : 1608566612,
            "type" : "comment"
        }
        """

    val user =
        """
        {
            "about" : "This is a test",
            "created" : 1173923446,
            "delay" : 0,
            "id" : "jl",
            "karma" : 2937,
            "submitted" : [ 8265435, 8168423, 8090946, 8090326, 7699907, 7637962, 7596179, 7596163, 7594569, 7562135, 7562111, 7494708, 7494171, 7488093, 7444860, 7327817, 7280290, 7278694, 7097557, 7097546, 7097254, 7052857, 7039484, 6987273, 6649999, 6649706, 6629560, 6609127, 6327951, 6225810, 6111999, 5580079, 5112008, 4907948, 4901821, 4700469, 4678919, 3779193, 3711380, 3701405, 3627981, 3473004, 3473000, 3457006, 3422158, 3136701, 2943046, 2794646, 2482737, 2425640, 2411925, 2408077, 2407992, 2407940, 2278689, 2220295, 2144918, 2144852, 1875323, 1875295, 1857397, 1839737, 1809010, 1788048, 1780681, 1721745, 1676227, 1654023, 1651449, 1641019, 1631985, 1618759, 1522978, 1499641, 1441290, 1440993, 1436440, 1430510, 1430208, 1385525, 1384917, 1370453, 1346118, 1309968, 1305415, 1305037, 1276771, 1270981, 1233287, 1211456, 1210688, 1210682, 1194189, 1193914, 1191653, 1190766, 1190319, 1189925, 1188455, 1188177, 1185884, 1165649, 1164314, 1160048, 1159156, 1158865, 1150900, 1115326, 933897, 924482, 923918, 922804, 922280, 922168, 920332, 919803, 917871, 912867, 910426, 902506, 891171, 807902, 806254, 796618, 786286, 764412, 764325, 642566, 642564, 587821, 575744, 547504, 532055, 521067, 492164, 491979, 383935, 383933, 383930, 383927, 375462, 263479, 258389, 250751, 245140, 243472, 237445, 229393, 226797, 225536, 225483, 225426, 221084, 213940, 213342, 211238, 210099, 210007, 209913, 209908, 209904, 209903, 170904, 165850, 161566, 158388, 158305, 158294, 156235, 151097, 148566, 146948, 136968, 134656, 133455, 129765, 126740, 122101, 122100, 120867, 120492, 115999, 114492, 114304, 111730, 110980, 110451, 108420, 107165, 105150, 104735, 103188, 103187, 99902, 99282, 99122, 98972, 98417, 98416, 98231, 96007, 96005, 95623, 95487, 95475, 95471, 95467, 95326, 95322, 94952, 94681, 94679, 94678, 94420, 94419, 94393, 94149, 94008, 93490, 93489, 92944, 92247, 91713, 90162, 90091, 89844, 89678, 89498, 86953, 86109, 85244, 85195, 85194, 85193, 85192, 84955, 84629, 83902, 82918, 76393, 68677, 61565, 60542, 47745, 47744, 41098, 39153, 38678, 37741, 33469, 12897, 6746, 5252, 4752, 4586, 4289 ]
        }
        """

    val userWithNoAbout =
        """
        {
            "created" : 1173923446,
            "delay" : 0,
            "id" : "jl",
            "karma" : 2937,
            "submitted" : [ 8265435, 8168423, 8090946, 8090326, 7699907, 7637962, 7596179, 7596163, 7594569, 7562135, 7562111, 7494708, 7494171, 7488093, 7444860, 7327817, 7280290, 7278694, 7097557, 7097546, 7097254, 7052857, 7039484, 6987273, 6649999, 6649706, 6629560, 6609127, 6327951, 6225810, 6111999, 5580079, 5112008, 4907948, 4901821, 4700469, 4678919, 3779193, 3711380, 3701405, 3627981, 3473004, 3473000, 3457006, 3422158, 3136701, 2943046, 2794646, 2482737, 2425640, 2411925, 2408077, 2407992, 2407940, 2278689, 2220295, 2144918, 2144852, 1875323, 1875295, 1857397, 1839737, 1809010, 1788048, 1780681, 1721745, 1676227, 1654023, 1651449, 1641019, 1631985, 1618759, 1522978, 1499641, 1441290, 1440993, 1436440, 1430510, 1430208, 1385525, 1384917, 1370453, 1346118, 1309968, 1305415, 1305037, 1276771, 1270981, 1233287, 1211456, 1210688, 1210682, 1194189, 1193914, 1191653, 1190766, 1190319, 1189925, 1188455, 1188177, 1185884, 1165649, 1164314, 1160048, 1159156, 1158865, 1150900, 1115326, 933897, 924482, 923918, 922804, 922280, 922168, 920332, 919803, 917871, 912867, 910426, 902506, 891171, 807902, 806254, 796618, 786286, 764412, 764325, 642566, 642564, 587821, 575744, 547504, 532055, 521067, 492164, 491979, 383935, 383933, 383930, 383927, 375462, 263479, 258389, 250751, 245140, 243472, 237445, 229393, 226797, 225536, 225483, 225426, 221084, 213940, 213342, 211238, 210099, 210007, 209913, 209908, 209904, 209903, 170904, 165850, 161566, 158388, 158305, 158294, 156235, 151097, 148566, 146948, 136968, 134656, 133455, 129765, 126740, 122101, 122100, 120867, 120492, 115999, 114492, 114304, 111730, 110980, 110451, 108420, 107165, 105150, 104735, 103188, 103187, 99902, 99282, 99122, 98972, 98417, 98416, 98231, 96007, 96005, 95623, 95487, 95475, 95471, 95467, 95326, 95322, 94952, 94681, 94679, 94678, 94420, 94419, 94393, 94149, 94008, 93490, 93489, 92944, 92247, 91713, 90162, 90091, 89844, 89678, 89498, 86953, 86109, 85244, 85195, 85194, 85193, 85192, 84955, 84629, 83902, 82918, 76393, 68677, 61565, 60542, 47745, 47744, 41098, 39153, 38678, 37741, 33469, 12897, 6746, 5252, 4752, 4586, 4289 ]
        }
        """

    val userWithNoSubmitted =
        """
        {
            "about" : "This is a test",
            "created" : 1173923446,
            "delay" : 0,
            "id" : "jl",
            "karma" : 2937
        }
        """

    val topstories: String = {
        "[ 123, 456, 789 ]"
    }

    val intJson: String =
        """
        {
            "int" : 123
        }
        """

    val listOfTenIDs: List[Long] = {
        List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

}
