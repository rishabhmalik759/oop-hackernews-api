
Hacker News Client
==================

## Index

### General

* [Syntax](#syntax)
* [Commands](#commands)

### Features

* [List New Stories](#new-stories)
* [List Top Stories](#top-stories)
* [List Best Stories](#best-stories)
* [List Comments](#list-comments)
* [View User](#view-user)
* [Help](#help)


## Syntax

Usage:

    hncli [options] [command] [command-options]

Here,

    [options]
    --help | -h                 Displays the help page guiding how to use the tool
    --ttl=600                   Sets the time to live value. (Default is 600)
    --clear-cache               Clears the existing cache
    
    [command]
    new-stories                 Lists the newest stories added to hackernews
    top-stories                 Lists the top stories added to hackernews
    best-stories                Lists the best stories added to hackernews
    user=<user>                 Displays the user's profile
    show-comments=<story-id>    Lists the comments of any valid story
    
    [command-options]
    --show-stories              Lists the stories of the presented user (used with user=<user>)
    --page=1                    Sets which page you would like to browse. (Default is 1)
    --size=5                    Sets the page size of the items being displayed. (Default is 5)



# Commands


## New Stories 

Lists the newest stories added to Hacker News.

Usage:

    hncli new-stories [--page=<n>] [--size=<s>]

Examples:

    hncli new-stories
    hncli new-stories --page=5
    hncli new-stories --size=10
    hncli new-stories --page=10 --size=20


## Top Stories

Lists the top stories added to Hacker News.

Usage:

    hncli top-stories [--page=<n>] [--size=<s>]

Examples:

    hncli top-stories
    hncli top-stories --page=5
    hncli top-stories --size=10
    hncli top-stories --page=10 --size=20


## Best Stories

Lists the best stories added to Hacker News.

Usage:

    hncli show-comments=<story-id> [--page=<n>] [--size=<s>]

Examples:

    hncli best-stories
    hncli best-stories --page=5
    hncli best-stories --size=10
    hncli best-stories --page=10 --size=20


## List Comments

Lists the comments of a valid story on Hacker News.

Usage:

    hncli show-comments=<story-id> [--page=<n>] [--size=<s>]

Examples:

    hncli show-comments=123456
    hncli show-comments=123456 --page=5
    hncli show-comments=123456 --size=10
    hncli show-comments=123456 --page=10 --size=20


## View User

Displays Hacker News user's profile, when presented alone

Usage:

    hncli user=<user> [--show-stories [--page=<n>] [--size=<s>]]

Examples:

    hncli user=jl
    hncli user=jl --show-stories --page=5
    hncli user=jl --show-stories --size=10
    hncli user=jl --show-stories --page=10 --size=20


## Help

Displays the help page guiding how to use the tool.

Usage:

    hncli --help
    hncli -h



## Repository

Source code is available at [GitHub page](https://github.com/rishabhmalik759/oop-hackernews-api.git).


## Contact Info

Feel free to contact me to discuss any issues, questions, or comments.

My contact info can be found on my [GitHub page](https://github.com/rishabhmalik759).
