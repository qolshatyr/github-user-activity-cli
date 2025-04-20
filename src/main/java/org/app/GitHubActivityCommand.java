package org.app;

import org.app.service.GitHubService;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "github-activity", mixinStandardHelpOptions = true, description = "Prints GitHub User activity",
        version = "1.0")
public class GitHubActivityCommand implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "GitHub user name")
    private String userName;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new GitHubActivityCommand()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {

        new GitHubService().showUserActivity(userName);

        return 0;
    }
}
