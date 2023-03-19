Feature: Change Request Management
Background:
Given Set the endpoint
And Set the Auth

@Initial
Scenario: Create Change Request
When create change request with String body'{"description": "added","short_description": "Value updated"}'
Then validate response code as 201

@query
Scenario: Get changerequest with one query param
When get changerequest with queryparam "sysparm_fields" and "number,sys_id,sys_updated_by"
Then validate response code as 200

@smoke
Scenario Outline: Create changerequest with Multiple File
When create changerequest with file "<fileName>"
Then validate response code as 201
Examples:
|fileName|
|changerequest1.json|
|changerequest2.json|

@MultipleQP
Scenario: Get changerequest with Multiple QP
When get changerequest with queryparams
|sysparm_fields|sys_id,number,sys_updated_by|
|sysparm_limit|3|
Then validate response code as 200
