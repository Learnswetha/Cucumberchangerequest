Feature: Change Request Management
@Initial
Scenario: Create Change Request
Given Set the endpoint
And Set the Auth
When create change request with String body'{"description": "added","short_description": "Value updated"}'
Then validate response code as 201
@query
Scenario: Get changerequest with one query param
Given Set the endpoint
And Set the Auth
When get changerequest with queryparam "sysparm_fields" and "number,sys_id,sys_updated_by"
Then validate response code as 200

@smoke
Scenario Outline: Create changerequest with Multiple File
Given Set the endpoint
And Set the Auth
When create changerequest with file "<fileName>"
Then validate response code as 201
Examples:
|fileName|
|changerequest1.json|
|changerequest2.json|

