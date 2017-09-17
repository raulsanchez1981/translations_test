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
  "name": "SC01. Check the search request retrieve the correct number of issues from the database.",
  "description": "",
  "id": "we-want-to-test-the-all-issues-searching-service-for-the-project;sc01.-check-the-search-request-retrieve-the-correct-number-of-issues-from-the-database.",
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
  "name": "it should be returned this list of issues with \u00272\u0027 elements",
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
  "duration": 563814975,
  "status": "passed"
});
formatter.match({
  "location": "IssueSearchSteps.searchIssues()"
});
formatter.result({
  "duration": 84848820,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 48
    }
  ],
  "location": "IssueSearchSteps.countFoundIssues(long)"
});
formatter.result({
  "duration": 364308,
  "status": "passed"
});
formatter.after({
  "duration": 10924718,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "SC02. Check the search request retrieve all the issues with unique id from the database.",
  "description": "",
  "id": "we-want-to-test-the-all-issues-searching-service-for-the-project;sc02.-check-the-search-request-retrieve-all-the-issues-with-unique-id-from-the-database.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "the next issues already created in the system for the owner \u0027test\u0027",
  "rows": [
    {
      "cells": [
        "state",
        "title",
        "url"
      ],
      "line": 15
    },
    {
      "cells": [
        "open",
        "Issue 1",
        "www.test.com"
      ],
      "line": 16
    },
    {
      "cells": [
        "closed",
        "Issue 2",
        "www.google.com"
      ],
      "line": 17
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "the user requests all the issues in the system",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "it should be returned this list of issues with not empty id",
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
  "duration": 5312411,
  "status": "passed"
});
formatter.match({
  "location": "IssueSearchSteps.searchIssues()"
});
formatter.result({
  "duration": 2560000,
  "status": "passed"
});
formatter.match({
  "location": "IssueSearchSteps.checkIdFoundIssues()"
});
formatter.result({
  "duration": 17675898,
  "status": "passed"
});
formatter.after({
  "duration": 2354871,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "SC03. Check the search request retrieve all issues from the database.",
  "description": "",
  "id": "we-want-to-test-the-all-issues-searching-service-for-the-project;sc03.-check-the-search-request-retrieve-all-issues-from-the-database.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "the next issues already created in the system for the owner \u0027test\u0027",
  "rows": [
    {
      "cells": [
        "state",
        "title",
        "url"
      ],
      "line": 23
    },
    {
      "cells": [
        "open",
        "Issue 1",
        "www.test.com"
      ],
      "line": 24
    },
    {
      "cells": [
        "closed",
        "Issue 2",
        "www.google.com"
      ],
      "line": 25
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "the user requests all the issues in the system",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "it should be returned this list of issues with all the elemets unlocked",
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
  "duration": 5464615,
  "status": "passed"
});
formatter.match({
  "location": "IssueSearchSteps.searchIssues()"
});
formatter.result({
  "duration": 2674462,
  "status": "passed"
});
formatter.match({
  "location": "IssueSearchSteps.checkFoundIssues()"
});
formatter.result({
  "duration": 577641,
  "status": "passed"
});
formatter.after({
  "duration": 1799384,
  "status": "passed"
});
});