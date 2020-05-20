# Integration and API Test Documentation

Authors: Alessandro Borione, Giacomo Garaccione, Corrado Vecchio, Marco Vinai

Date: 20/05/2020

Version: 0.1

# Contents

- [Integration and API Test Documentation](#integration-and-api-test-documentation)
- [Contents](#contents)
- [Dependency graph](#dependency-graph)
	- [Class it.polito.ezgas.service.impl.UserServiceimpl](#class-itpolitoezgasserviceimpluserserviceimpl)
- [Integration approach](#integration-approach)
- [Tests](#tests)
	- [Step 1](#step-1)
	- [Step 2](#step-2)
	- [Step n API Tests](#step-n-api-tests)
- [Scenarios](#scenarios)
	- [Scenario UCx.y](#scenario-ucxy)
- [Coverage of Scenarios and FR](#coverage-of-scenarios-and-fr)
- [Coverage of Non Functional Requirements](#coverage-of-non-functional-requirements)
		- [](#)

# Dependency graph 

## Class it.polito.ezgas.service.impl.UserServiceimpl

```plantuml
@startuml

agent UserServiceimpl.getUserById as getUserById
agent UserRepository.findOne as findOne
agent UserMapper.toUserDto as toUserDto
agent "new UserDto" as newUserDto
agent UserServiceimpl.saveUser as saveUser
agent UserMapper.toUser as toUser
agent "new User" as newUser
agent UserRepository.save as save
agent UserServiceimp.getAllUsers as getAllUsers
agent UserRepository.findAll as findAll
agent UserServiceimp.deleteUser as deleteUser
agent UserRepository.delete as delete
agent UserServiceimpl.login as login
agent IdPw.getUser as getUser
agent UserRepository.findByEmail as findByEmail
agent User.getPassword as getPassword
agent IdPw.getPw as getPw
agent User.getEmail as getEmail
agent LoginMapper.toLoginDto as toLoginDto
agent "new LoginDto" as newLoginDto
agent UserServiceimpl.increaseUserReputation as increaseUserReputation
agent User.setReputation as setReputation
agent UserServiceimpl.decreaseUserReputation as decreaseUserReputation

getUserById -- findOne
getUserById -- toUserDto
toUserDto -- newUserDto
saveUser -- toUser
saveUser -- save
saveUser -- toUserDto
toUser -- newUser
getAllUsers -- findAll
getAllUsers -- toUserDto
deleteUser -- findOne
deleteUser -- delete
login -- getUser
login -- findByEmail
login -- getPassword
login -- getPw
login -- getEmail
login -- toLoginDto
toLoginDto -- newLoginDto
increaseUserReputation -- findOne
increaseUserReputation -- setReputation
increaseUserReputation -- save
decreaseUserReputation -- findOne
decreaseUserReputation -- setReputation
decreaseUserReputation -- save

@enduml
```

	  
# Integration approach

	 <Write here the integration sequence you adopted, in general terms (top down, bottom up, mixed) and as sequence
	 (ex: step1: class A, step 2: class A+B, step 3: class A+B+C, etc)> 
	 <The last integration step corresponds to API testing at level of Service package>
	 <Tests at level of Controller package will be done later>



#  Tests

	<define below a table for each integration step. For each integration step report the group of classes under test, and the names of
	  JUnit test cases applied to them>

## Step 1
| Classes  | JUnit test cases |
|--|--|
|||


## Step 2
| Classes  | JUnit test cases |
|--|--|
|||


## Step n API Tests

	<The last integration step  should correspond to API testing, or tests applied to all classes implementing the APIs defined in the Service package>

| Classes  | JUnit test cases |
|--|--|
|||




# Scenarios


<If needed, define here additional scenarios for the application. Scenarios should be named
 referring the UC they detail>

## Scenario UCx.y

| Scenario |  name |
| ------------- |:-------------:| 
|  Precondition     |  |
|  Post condition     |   |
| Step#        | Description  |
|  1     |  ... |  
|  2     |  ... |



# Coverage of Scenarios and FR


<Report in the following table the coverage of  scenarios (from official requirements and from above) vs FR. 
Report also for each of the scenarios the (one or more) API JUnit tests that cover it. >




| Scenario ID | Functional Requirements covered | JUnit Test(s) | 
| ----------- | ------------------------------- | ----------- | 
|  ..         | FRx                             |             |             
|  ..         | FRy                             |             |             
| ...         |                                 |             |             
| ...         |                                 |             |             
| ...         |                                 |             |             
| ...         |                                 |             |             



# Coverage of Non Functional Requirements


<Report in the following table the coverage of the Non Functional Requirements of the application - only those that can be tested with automated testing frameworks.>


### 

| Non Functional Requirement | Test name |
| -------------------------- | --------- |
|                            |           |


