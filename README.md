Tracking web server
==========  
        
## Problem

A Board contains an arbitrary list of Tasks, and each Task could be assigned to one User.
The Users are stored in a Centralised User Service, and only a reference to the User id (i.e., UUIDv4)
is necessary to keep in the ToDo Service. 

1. GET /boards → Returns a list of all Boards. 

2. POST /boards → Creates a Board. Expects Board attributes (without id) and returns a newly created Board without tasks.

3. GET /boards/{id} → Returns a Board with all the Tasks. The Task data response must be enriched with the User information retrieved from the Centralised User Service. Here a Random Data Service can be used to get the user data from the service, such as https://randomuser.me/api/  or https://pipl.ir/v1/getPerson

4. DELETE /boards/{id} → Deletes a Board.

5. POST /boards/{id}/tasks → Create a Task in a Board. Expects Task attributes (without id and status) and returns a newly created Task with id and status with the value: Created.

6. PUT /tasks/{id} → Overwrites an existing Task.

7. PATCH /tasks/{id} → Update Task attributes.

8. DELETE /tasks/{id} → Deletes a Task.

9. Additionally, the users may be removed from the centralized Users service at any moment. Therefore, the
ToDo Service should be able to remove all the Tasks related to the user that was removed. To simplify the
implementation, previously, a Webhook was registered in the Centralised User Service to the 
URL /webhooks/user-deleted using the POST HTTP method. Every time a user is deleted, the ToDo Service 
will receive a call with the following payload.

## Solution
1. File present - Implemented 
2. File absent - Implemented
3. Image download - Implemented

4. Actuator end point - Implemented (http://localhost:8080/actuator)
5. Swagger Integration - Implemented (http://localhost:8080/swagger-ui.html)
6. Generic Exception Handling and Validations - Implemented (Refer to java classes)
7. In Memory Database -  Implemented (Refer properties file) 
8. Run Script - Implemented



```curl
curl -X POST "http://localhost:8080/boards" -H "Content-Type: application/json" -d '{"name":"JIRA", "description": "Track Stories"}'

curl -X POST "http://localhost:8080/boards/1/tasks" -H "Content-Type: application/json" -d '{"name":"Story", "description": "Track Activity", "user":"a5f62627-bbea-4233-9e44-4beb3e01024b"}'

curl -X GET "http://localhost:8080/boards/1" -H "Content-Type: application/json"

curl -X GET "http://localhost:8080/boards" -H "Content-Type: application/json"

curl -X DELETE "http://localhost:8080/boards/1" -H "Content-Type: application/json"

curl -X DELETE "http://localhost:8080/tasks/1" -H "Content-Type: application/json"

curl -X PUT "http://localhost:8080/tasks/1" -H "Content-Type: application/json" -d '{"name":"Bug", "description": "Track Bug"}'

curl -X PATCH "http://localhost:8080/tasks/1" -H "Content-Type: application/json" -d '{"name":"Spike", "description": "Track Spike"}'
```


4. Get board with user detail (Call other rest call)
5. Implement delete hook
6. Clean up
7. README fix