# Alfred Gitbook

## Requirements

* [Alfred](https://www.alfredapp.com/) – the app helps to run scripts using keyboard shortcuts or keywords
* JDK 8

## Installation

* Go to the [releases page](https://github.com/dmmax/alfred-gitbook/releases)
* Download the latest `alfred-gitbook.alfredworkflow`
* Double-click on the downloaded file, and follow the installation steps from the Alfred app

## Using

### Configuration

To configure the workflow, you need to define workflow environment variables

* `gb_url` – the Site URL
* `git_book_repository` – the GIT repository URL
* `git_book_branch` – the GIT repository branch

For example

![Alfred workflow environment variables](assets/worklow-environment-variables.png)

### Update links

When configuration is done, you need to update your links, for that need to call `gb update` in Alfred

![Update gitbook links](assets/update-links.png)

The update mechanism will take some time to read the SUMMARY.md depends on the content of your repository

### Find links

Now, you're ready to open links from your site. For that, you need to call `gbs <name>` in Alfred

![Find gitbook links](assets/find-links.png)

### How-to use
![How to use Alfred gitbook workflow](assets/how-to-alfred-gitbook.gif)