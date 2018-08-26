package tests;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebHookTest {



    @Test
    void stringTest(){
        String str = "/echo Hello world!";
        str = str.replaceFirst("/echo ", "");
        assertEquals("Hello world!", str);
    }


    @Test
    void WebHookJsonTest() throws JsonParseException, IOException{
        String json="{\n" +
                "  \"ref\": \"refs/heads/master\",\n" +
                "  \"before\": \"0000000000000000000000000000000000000000\",\n" +
                "  \"after\": \"36a0b4f28faeb3a66ee6fd4115353d9cf675aba1\",\n" +
                "  \"created\": true,\n" +
                "  \"deleted\": false,\n" +
                "  \"forced\": false,\n" +
                "  \"base_ref\": null,\n" +
                "  \"compare\": \"https://github.com/EvgenySerg/testBotRepo/commit/36a0b4f28fae\",\n" +
                "  \"commits\": [\n" +
                "    {\n" +
                "      \"id\": \"36a0b4f28faeb3a66ee6fd4115353d9cf675aba1\",\n" +
                "      \"tree_id\": \"e86d3988e3f9412742f28a092c7a288d126f68c3\",\n" +
                "      \"distinct\": true,\n" +
                "      \"message\": \"first\",\n" +
                "      \"timestamp\": \"2018-07-06T17:09:19+03:00\",\n" +
                "      \"url\": \"https://github.com/EvgenySerg/testBotRepo/commit/36a0b4f28faeb3a66ee6fd4115353d9cf675aba1\",\n" +
                "      \"author\": {\n" +
                "        \"name\": \"fatboa\",\n" +
                "        \"email\": \"fatboa@yandex.ru\",\n" +
                "        \"username\": \"EvgenySerg\"\n" +
                "      },\n" +
                "      \"committer\": {\n" +
                "        \"name\": \"fatboa\",\n" +
                "        \"email\": \"fatboa@yandex.ru\",\n" +
                "        \"username\": \"EvgenySerg\"\n" +
                "      },\n" +
                "      \"added\": [\n" +
                "        \"First File\"\n" +
                "      ],\n" +
                "      \"removed\": [\n" +
                "\n" +
                "      ],\n" +
                "      \"modified\": [\n" +
                "\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"head_commit\": {\n" +
                "    \"id\": \"36a0b4f28faeb3a66ee6fd4115353d9cf675aba1\",\n" +
                "    \"tree_id\": \"e86d3988e3f9412742f28a092c7a288d126f68c3\",\n" +
                "    \"distinct\": true,\n" +
                "    \"message\": \"first\",\n" +
                "    \"timestamp\": \"2018-07-06T17:09:19+03:00\",\n" +
                "    \"url\": \"https://github.com/EvgenySerg/testBotRepo/commit/36a0b4f28faeb3a66ee6fd4115353d9cf675aba1\",\n" +
                "    \"author\": {\n" +
                "      \"name\": \"fatboa\",\n" +
                "      \"email\": \"fatboa@yandex.ru\",\n" +
                "      \"username\": \"EvgenySerg\"\n" +
                "    },\n" +
                "    \"committer\": {\n" +
                "      \"name\": \"fatboa\",\n" +
                "      \"email\": \"fatboa@yandex.ru\",\n" +
                "      \"username\": \"EvgenySerg\"\n" +
                "    },\n" +
                "    \"added\": [\n" +
                "      \"First File\"\n" +
                "    ],\n" +
                "    \"removed\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"modified\": [\n" +
                "\n" +
                "    ]\n" +
                "  },\n" +
                "  \"repository\": {\n" +
                "    \"id\": 139992065,\n" +
                "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkxMzk5OTIwNjU=\",\n" +
                "    \"name\": \"testBotRepo\",\n" +
                "    \"full_name\": \"EvgenySerg/testBotRepo\",\n" +
                "    \"owner\": {\n" +
                "      \"name\": \"EvgenySerg\",\n" +
                "      \"email\": \"fatboa@yandex.ru\",\n" +
                "      \"login\": \"EvgenySerg\",\n" +
                "      \"id\": 21700245,\n" +
                "      \"node_id\": \"MDQ6VXNlcjIxNzAwMjQ1\",\n" +
                "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/21700245?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/EvgenySerg\",\n" +
                "      \"html_url\": \"https://github.com/EvgenySerg\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/EvgenySerg/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/EvgenySerg/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/EvgenySerg/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/EvgenySerg/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/EvgenySerg/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/EvgenySerg/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/EvgenySerg/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/EvgenySerg/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/EvgenySerg/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"private\": false,\n" +
                "    \"html_url\": \"https://github.com/EvgenySerg/testBotRepo\",\n" +
                "    \"description\": null,\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://github.com/EvgenySerg/testBotRepo\",\n" +
                "    \"forks_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/forks\",\n" +
                "    \"keys_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/keys{/key_id}\",\n" +
                "    \"collaborators_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/collaborators{/collaborator}\",\n" +
                "    \"teams_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/teams\",\n" +
                "    \"hooks_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/hooks\",\n" +
                "    \"issue_events_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/issues/events{/number}\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/events\",\n" +
                "    \"assignees_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/assignees{/user}\",\n" +
                "    \"branches_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/branches{/branch}\",\n" +
                "    \"tags_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/tags\",\n" +
                "    \"blobs_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/git/blobs{/sha}\",\n" +
                "    \"git_tags_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/git/tags{/sha}\",\n" +
                "    \"git_refs_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/git/refs{/sha}\",\n" +
                "    \"trees_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/git/trees{/sha}\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/statuses/{sha}\",\n" +
                "    \"languages_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/languages\",\n" +
                "    \"stargazers_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/stargazers\",\n" +
                "    \"contributors_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/contributors\",\n" +
                "    \"subscribers_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/subscribers\",\n" +
                "    \"subscription_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/subscription\",\n" +
                "    \"commits_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/commits{/sha}\",\n" +
                "    \"git_commits_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/git/commits{/sha}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/comments{/number}\",\n" +
                "    \"issue_comment_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/issues/comments{/number}\",\n" +
                "    \"contents_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/contents/{+path}\",\n" +
                "    \"compare_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/compare/{base}...{head}\",\n" +
                "    \"merges_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/merges\",\n" +
                "    \"archive_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/{archive_format}{/ref}\",\n" +
                "    \"downloads_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/downloads\",\n" +
                "    \"issues_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/issues{/number}\",\n" +
                "    \"pulls_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/pulls{/number}\",\n" +
                "    \"milestones_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/milestones{/number}\",\n" +
                "    \"notifications_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/notifications{?since,all,participating}\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/labels{/name}\",\n" +
                "    \"releases_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/releases{/id}\",\n" +
                "    \"deployments_url\": \"https://api.github.com/repos/EvgenySerg/testBotRepo/deployments\",\n" +
                "    \"created_at\": 1530885580,\n" +
                "    \"updated_at\": \"2018-07-06T13:59:40Z\",\n" +
                "    \"pushed_at\": 1530886198,\n" +
                "    \"git_url\": \"git://github.com/EvgenySerg/testBotRepo.git\",\n" +
                "    \"ssh_url\": \"git@github.com:EvgenySerg/testBotRepo.git\",\n" +
                "    \"clone_url\": \"https://github.com/EvgenySerg/testBotRepo.git\",\n" +
                "    \"svn_url\": \"https://github.com/EvgenySerg/testBotRepo\",\n" +
                "    \"homepage\": null,\n" +
                "    \"size\": 0,\n" +
                "    \"stargazers_count\": 0,\n" +
                "    \"watchers_count\": 0,\n" +
                "    \"language\": null,\n" +
                "    \"has_issues\": true,\n" +
                "    \"has_projects\": true,\n" +
                "    \"has_downloads\": true,\n" +
                "    \"has_wiki\": true,\n" +
                "    \"has_pages\": false,\n" +
                "    \"forks_count\": 0,\n" +
                "    \"mirror_url\": null,\n" +
                "    \"archived\": false,\n" +
                "    \"open_issues_count\": 0,\n" +
                "    \"license\": null,\n" +
                "    \"forks\": 0,\n" +
                "    \"open_issues\": 0,\n" +
                "    \"watchers\": 0,\n" +
                "    \"default_branch\": \"master\",\n" +
                "    \"stargazers\": 0,\n" +
                "    \"master_branch\": \"master\"\n" +
                "  },\n" +
                "  \"pusher\": {\n" +
                "    \"name\": \"EvgenySerg\",\n" +
                "    \"email\": \"fatboa@yandex.ru\"\n" +
                "  },\n" +
                "  \"sender\": {\n" +
                "    \"login\": \"EvgenySerg\",\n" +
                "    \"id\": 21700245,\n" +
                "    \"node_id\": \"MDQ6VXNlcjIxNzAwMjQ1\",\n" +
                "    \"avatar_url\": \"https://avatars1.githubusercontent.com/u/21700245?v=4\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"url\": \"https://api.github.com/users/EvgenySerg\",\n" +
                "    \"html_url\": \"https://github.com/EvgenySerg\",\n" +
                "    \"followers_url\": \"https://api.github.com/users/EvgenySerg/followers\",\n" +
                "    \"following_url\": \"https://api.github.com/users/EvgenySerg/following{/other_user}\",\n" +
                "    \"gists_url\": \"https://api.github.com/users/EvgenySerg/gists{/gist_id}\",\n" +
                "    \"starred_url\": \"https://api.github.com/users/EvgenySerg/starred{/owner}{/repo}\",\n" +
                "    \"subscriptions_url\": \"https://api.github.com/users/EvgenySerg/subscriptions\",\n" +
                "    \"organizations_url\": \"https://api.github.com/users/EvgenySerg/orgs\",\n" +
                "    \"repos_url\": \"https://api.github.com/users/EvgenySerg/repos\",\n" +
                "    \"events_url\": \"https://api.github.com/users/EvgenySerg/events{/privacy}\",\n" +
                "    \"received_events_url\": \"https://api.github.com/users/EvgenySerg/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": false\n" +
                "  }\n" +
                "}";

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(json);
            assertNotNull(jsonNode);


            System.out.printf("[%s] User: %s made push to repo: %s with message: %s\n",
                    jsonNode.get("head_commit").get("timestamp"),
                    jsonNode.get("head_commit").get("committer").get("username"),
                    jsonNode.get("repository").get("url"),
                    jsonNode.get("head_commit").get("message")

            );
//            JsonNode commits=jsonNode.get("commits");
//
//            System.out.println(commits.get("url"));

//            WebHook webHook = mapper.readValue(json, WebHook.class);
//            assertEquals("\"refs/heads/master\"", webHook.getRef());
    }
}
