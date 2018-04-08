$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("createBooking.feature");
formatter.feature({
  "line": 2,
  "name": "Create and Delete Bookings",
  "description": "",
  "id": "create-and-delete-bookings",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@wip"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Create a new booking",
  "description": "",
  "id": "create-and-delete-bookings;create-a-new-booking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on the hotel booking form page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I create the following bookings",
  "rows": [
    {
      "cells": [
        "First name",
        "Surname",
        "Price",
        "Deposit",
        "Check in",
        "Check out"
      ],
      "line": 7
    },
    {
      "cells": [
        "Rashmith",
        "Reddy",
        "99",
        "true",
        "2018-05-10",
        "2018-05-15"
      ],
      "line": 8
    },
    {
      "cells": [
        "Sanjana",
        "Reddy",
        "129",
        "true",
        "2018-05-15",
        "2018-05-20"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I should see the bookings created on the list of bookings",
  "rows": [
    {
      "cells": [
        "First name"
      ],
      "line": 11
    },
    {
      "cells": [
        "Rashmith"
      ],
      "line": 12
    },
    {
      "cells": [
        "Sanjana"
      ],
      "line": 13
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "BookingsStepDef.scala:26"
});
formatter.result({
  "duration": 1437617599,
  "status": "passed"
});
formatter.match({
  "location": "BookingsStepDef.scala:32"
});
formatter.result({
  "duration": 3496771645,
  "status": "passed"
});
formatter.match({
  "location": "BookingsStepDef.scala:50"
});
formatter.result({
  "duration": 62369390,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Delete a booking",
  "description": "",
  "id": "create-and-delete-bookings;delete-a-booking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "I am on the hotel booking form page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I delete recently created bookings",
  "rows": [
    {
      "cells": [
        "First name"
      ],
      "line": 18
    },
    {
      "cells": [
        "Sanjana"
      ],
      "line": 19
    },
    {
      "cells": [
        "Rashmith"
      ],
      "line": 20
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the bookings should be deleted from the list of bookings",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingsStepDef.scala:26"
});
formatter.result({
  "duration": 230546023,
  "status": "passed"
});
formatter.match({
  "location": "BookingsStepDef.scala:59"
});
formatter.result({
  "duration": 711921975,
  "status": "passed"
});
formatter.match({
  "location": "BookingsStepDef.scala:67"
});
formatter.result({
  "duration": 20391328463,
  "status": "passed"
});
});