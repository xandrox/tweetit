REST-API Beschreibung
=====================

Create a User
-------------

    curl http://localhost:8080/tweetit.server/rest/users/fpoATadorsys.de --request PUT --data "{\"nickname\":\"francis\" }" -H Content-Type:application/json
    curl http://localhost:8080/tweetit.server/rest/users/ssoATadorsys.de --request PUT --data "{\"nickname\":\"sandro\" }" -H Content-Type:application/json

Add a follower
--------------

    curl http://localhost:8080/tweetit.server/rest/users/fpoATadorsys.de/followers/ssoATadorsys.de --request PUT

Show following tweets
---------------------

    curl http://localhost:8080/tweetit.server/rest/users/fpoATadorsys.de/tweets

Show my postings
----------------

    curl http://localhost:8080/tweetit.server/rest/users/fpoATadorsys.de/my-tweets