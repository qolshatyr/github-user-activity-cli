package org.app.service;

import org.app.model.GitHubEvent;
import org.app.utils.HttpUtils;
import org.app.utils.JsonUtils;

import java.util.List;


public class GitHubService {

    public void showUserActivity(String userName) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.getUserEvents(userName);

        JsonUtils jsonUtils = new JsonUtils();
        List<GitHubEvent> events = jsonUtils.deSerializeGitHubEvents();

        if (events.isEmpty()) {
            System.out.println("No Events Found");
            return;
        }

        System.out.println("- Output:\n");
        for (GitHubEvent event : events) {
            switch (event.getType()) {
                case "PushEvent":
                    System.out.println("PushEvent: " + event.getRepo().getName());
                    break;
                case "CreateEvent":
                    System.out.println("CreateEvent: " + event.getRepo().getName());
                    break;
                case "PullRequestEvent":
                    System.out.println("PullRequestEvent: " + event.getRepo().getName());
                    break;
                case "ForkEvent":
                    System.out.println("ForkEvent: " + event.getRepo().getName());
                    break;
                case "PullRequestReviewCommentEvent":
                    System.out.println("PullRequestReviewCommentEvent: " + event.getRepo().getName());
                    break;
                case "PullRequestReviewEvent":
                    System.out.println("PullRequestReviewEvent: " + event.getRepo().getName());
                    break;
                default:
                    System.out.println("Unknown Event: " + event.getType());
            }
        }
    }
}
