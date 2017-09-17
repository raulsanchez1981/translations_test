$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("issues/features/searchIssues.feature");
formatter.feature({
  "line": 1,
  "name": "We want to test the all issues searching service for the project",
  "description": "\r\n*MAIN SCENARIOS*",
  "id": "we-want-to-test-the-all-issues-searching-service-for-the-project",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "SC01. Check the search request retrieve all issues from the database.",
  "description": "",
  "id": "we-want-to-test-the-all-issues-searching-service-for-the-project;sc01.-check-the-search-request-retrieve-all-issues-from-the-database.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "the next issues already created in the system for the owner \u0027test\u0027",
  "rows": [
    {
      "cells": [
        "state",
        "title",
        "url"
      ],
      "line": 7
    },
    {
      "cells": [
        "open",
        "Issue 1",
        "www.test.com"
      ],
      "line": 8
    },
    {
      "cells": [
        "closed",
        "Issue 2",
        "www.google.com"
      ],
      "line": 9
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "the user requests all the issues in the system",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "it should be returned this list of issues with:",
  "rows": [
    {
      "cells": [
        "title",
        "locked"
      ],
      "line": 12
    },
    {
      "cells": [
        "Issue 1",
        "false"
      ],
      "line": 13
    },
    {
      "cells": [
        "Issue 2",
        "false"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 61
    }
  ],
  "location": "IssueSearchSteps.createNewIssues(String,Issue\u003e)"
});
formatter.result({
  "duration": 298073435,
  "error_message": "java.lang.NullPointerException\r\n\tat issues.IssueSearchSteps.createNewIssues(IssueSearchSteps.java:30)\r\n\tat ✽.Given the next issues already created in the system for the owner \u0027test\u0027(issues/features/searchIssues.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "IssueSearchSteps.searchIssues()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "IssueSearchSteps.checkFoundIssues(Issue\u003e)"
});
formatter.result({
  "status": "skipped"
});
});