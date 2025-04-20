package org.app.model;

public class GitHubEvent {
    private String id;
    private String type;
    private Repo repo;


    public String getType() {
        return type;
    }

    public Repo getRepo() {
        return repo;
    }

    public static class Repo {
        String name;

        public String getName() {
            return name;
        }
    }
}
