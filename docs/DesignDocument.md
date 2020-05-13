# Design Document 

Authors: Alessandro Borione, Giacomo Garaccione, Corrado Vecchio, Marco Vinai

Date: 25/04/2020

Version: 1.0

# Contents

- [Design Document](#design-document)
- [Contents](#contents)
- [Instructions](#instructions)
- [High level design](#high-level-design)
  - [Front End](#front-end)
  - [Back End](#back-end)
- [Low level design](#low-level-design)
- [Verification traceability matrix](#verification-traceability-matrix)
- [Verification sequence diagrams](#verification-sequence-diagrams)
    - [Use Case 1](#use-case-1)
    - [Use Case 2](#use-case-2)
    - [Use Case 3](#use-case-3)
    - [Use Case 4](#use-case-4)
    - [Use Case 5](#use-case-5)
    - [Use Case 6](#use-case-6)
    - [Use Case 7](#use-case-7)
    - [Use Case 8](#use-case-8)
    - [Use Case 9](#use-case-9)
    - [Scenario 10.1](#scenario-101)
    - [Scenario 10.2](#scenario-102)

# Instructions

The design must satisfy the Official Requirements document (see EZGas Official Requirements.md ). <br>
The design must comply with interfaces defined in package it.polito.ezgas.service (see folder ServicePackage ) <br>
UML diagrams **MUST** be written using plantuml notation.

# High level design 

The style selected is client - server. Clients can be smartphones, tablets, PCs.
The choice is to avoid any development client side. The clients will access the server using only a browser. 

The server has two components: the frontend, which is developed with web technologies (JavaScript, HTML, Css) and is in charge of collecting user inputs to send requests to the backend; the backend, which is developed using the Spring Framework and exposes API to the front-end.
Together, they implement a layered style: Presentation layer (front end), Application logic and data layer (back end). 
Together, they implement also an MVC pattern, with the V on the front end and the MC on the back end.

``` plantuml
@startuml
package "Backend" {

}

package "Frontend" {

}

Frontend -> Backend
@enduml

```

## Front End

The Frontend component is made of: 

Views: the package contains the .html pages that are rendered on the browser and that provide the GUI to the user. 

Styles: the package contains .css style sheets that are used to render the GUI.

Controller: the package contains the JavaScript files that catch the user's inputs. Based on the user's inputs and on the status of the GUI widgets, the JavaScript controller creates REST API calls that are sent to the Java Controller implemented in the back-end.

``` plantuml
@startuml
package "Frontend" {

	package "it.polito.ezgas.resources.views" {

	}

package "it.polito.ezgas.resources.controller" {

	}

package "it.polito.ezgas.resources.styles" {

	}

it.polito.ezgas.resources.styles -down-> it.polito.ezgas.resources.views

it.polito.ezgas.resources.views -right-> it.polito.ezgas.resources.controller

}
@enduml

```

## Back End

The backend  uses a MC style, combined with a layered style (application logic, data). 
The back end is implemented using the Spring framework for developing Java Entrerprise applications.

Spring was selected for its popularity and relative simplicity: persistency (M and data layer) and interactions are pre-implemented, the programmer needs only to add the specific parts.

See in the package diagram below the project structure of Spring.

For more information about the Spring design guidelines and naming conventions:  https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3

``` plantuml
@startuml
package "Backend" {

package "it.polito.ezgas.service"  as ps {
   interface "GasStationService"
   interface "UserService"
} 

package "it.polito.ezgas.controller" {

}

package "it.polito.ezgas.converter" {

}

package "it.polito.ezgas.dto" {

}

package "it.polito.ezgas.entity" {

}

package "it.polito.ezgas.repository" {

}

	
}
note "see folder ServicePackage" as n
n -- ps
@enduml
```

The Spring framework implements the MC of the MVC pattern. The M is implemented in the packages Entity and Repository. The C is implemented in the packages Service, ServiceImpl and Controller. The packages DTO and Converter contain classes for translation services.

**Entity Package**

Each Model class should have a corresponding class in this package. Model classes contain the data that the application must handle.
The various models of the application are organised under the model package, their DTOs(data transfer objects) are present under the dto package.

In the Entity package all the Entities of the system are provided. Entities classes provide the model of the application, and represent all the data that the application must handle.

**Repository Package**

This package implements persistency for each Model class using an internal database. 

For each Entity class, a Repository class is created (in a 1:1 mapping) to allow the management of the database where the objects are stored. For Spring to be able to map the association at runtime, the Repository class associated to class "XClass" has to be exactly named "XClassRepository".

Extending class JpaRepository provides a lot of CRUD operations by inheritance. The programmer can also overload or modify them. 

**DTO package**

The DTO package contains all the DTO classes. DTO classes are used to transfer only the data that we need to share with the user interface and not the entire model object that we may have aggregated using several sub-objects and persisted in the database.

For each Entity class, a DTO class is created (in a 1:1 mapping).  For Spring the Dto class associated to class "XClass" must be called "XClassDto".  This allows Spring to find automatically the DTO class having the corresponding Entity class, and viceversa. 

**Converter Package**

The Converter Package contains all the Converter classes of the project.

For each Entity class, a Converter class is created (in a 1:1 mapping) to allow conversion from Entity class to DTO class and viceversa.

For Spring to be able to map the association at runtime, the Converter class associated to class "XClass" has to be exactly named "XClassConverter".

**Controller Package**

The controller package is in charge of handling the calls to the REST API that are generated by the user's interaction with the GUI. The Controller package contains methods in 1:1 correspondance to the REST API calls. Each Controller can be wired to a Service (related to a specific entity) and call its methods.
Services are in packages Service (interfaces of services) and ServiceImpl (classes that implement the interfaces)

The controller layer interacts with the service layer (packages Service and ServiceImpl) 
 to get a job done whenever it receives a request from the view or api layer, when it does it should not have access to the model objects and should always exchange neutral DTOs.

The service layer never accepts a model as input and never ever returns one either. This is another best practice that Spring enforces to implement  a layered architecture.

**Service Package**

The service package provides interfaces, that collect the calls related to the management of a specific entity in the project.
The Java interfaces are already defined (see file ServicePackage.zip) and the low level design must comply with these interfaces.

**ServiceImpl Package**

Contains Service classes that implement the Service Interfaces in the Service package.

# Low level design

``` plantuml
@startuml
scale 0.8
package "Backend" {

package "it.polito.ezgas.service" as service {
   interface "GasStationService" as gss {

    - getGasStationById(Integer) : GasStationDto
    - saveGasStation(GasStationDto) : GasStationDto
    - getAllGasStations() : List<GasStationsDto>
    - deleteGasStation(Integer) : Boolean
    - getGasStationsByGasolineType(String) : List<GasStationDto>
    - getGasStationsByProximity(double, double) : List<GasStationDto>
    - getGasStationsWithCoordinates(double, double, String, String) : List<GasStationDto>
    - getGasStationsWithoutCoordinates(String, String) : List<GasStationDto>
    - setReport(Integer, double, double, double, double, double, Integer) : void
    - getGasStationByCarSharing(String) : List<GasStationDto>

   }

   interface "UserService" as us {

    - getUserById(Integer) : UserDto
    - saveUser(USerDto) : UserDto
    - getAllUsers() : List<UserDto>
    - deleteUser(Integer) : Boolean
    - login(IdPw) : LoginDto
    - increaseUserReputation(Integer) : Integer
    - decreaseUserReputation(Integer) : Integer

   }

   	class "GasStationServiceImpl" as gssi {

    - isGasolineTypeValid(String) : boolean
    - mapGasolineTypeToMethod(String) : Predicate<GasStationDto>
    - geoPointDistance(double, double, double, double) : double

	   }

	class "UserServiceImpl" as usi

	gssi -up-|> gss
	usi -up-|> us
}

package "it.polito.ezgas.controller" as controller {
	class "GasStationController" as gscont
	class "UserController" as ucont
	class "HomeController" as hcont
}

package "it.polito.ezgas.dto" as dto {
	class "UserDto" as udto
	class "UserMapper" as um
	class "PriceReportDto" as prdto
	class "GasStationDto" as gsdto
	class "GasStationMapper" as gsm
	class "IdPw" as idpw
	class "LoginDto" as ldto
	class "LoginMapper" as lm
}

package "it.polito.ezgas.entity" as entity {
	class "User" as u {

    - userId : Integer
    - userName : String
    - password : String

 		- email : String
 		- reputation : Integer

    - admin : Boolean

	}

	class "PriceReport" as pr {

    - priceReportId : Integer
    - user : User
    - dieselPrice : double
    - superPrice : double
    - superPlusPrice : double
    - gasPrice : double

	}

	class "GasStation" as gs {

    - gasStationId : Integer
    - gasStationName : String
    - gasStationAddress : String
    - brand : String
    - hasDiesel : Boolean
    - hasSuper : Boolean
    - hasSuperPlus : Boolean
    - hasGas : Boolean
    - hasMethane : Boolean
    - carSharing : String
    - lat : double
    - lon : double
    - dieselPrice : double
    - superPrice : double
    - superPlusPrice : double
    - gasPrice : double
    - methanePrice : double
    - reportUser : Integer
    - reportTimestamp : String
    - reportDependability : double

	}

}

package "it.polito.ezgas.repository" as repository {
	interface "UserRepository" as urep {

    - findAll() : List<User>
    - countByAdmin(boolean) : Integer
    - findByEmail(String) : User

	}
	interface "PriceReportRepository" as prrep
	interface "GasStationRepository" as gsrep{

    - findAll() : List<GasStation>
    - findByCarSharing(String) : List<GasStation>
    - delete(GasStation) : void 

	}

}

package "org.springframework.data.repository" {
	interface "CrudRepository <T, ID>" as crud 
}

package "it.polito.ezgas.scheduling" {
    class "ScheduledTasks" as st {
        - userRepository : UserRepository
        - gasStationRepository : GasStationRepository
        - df : DateFormat
        - now : Date
        - seenUsers : Map<INteger, User>
        + scheduleUpdateGasStationReportDependability()
        - updateGasStationsReportDependability() : int
        - computeNewDependability(GasStation) : double
    }
}

urep -up-|> crud : "<User, Integer>"
prrep -up-|> crud : "<PriceReport, Integer>"
gsrep -up-|> crud : "<GasStation, Integer>"

gss --* gsdto
us --* idpw
us --* ldto
us --* udto
gssi --* gsdto
gssi --* gsm
gssi --* gs
gssi --* pr
gssi --* u
gssi --* gsrep
gssi --* prrep
gssi --* urep
usi --* idpw
usi --* ldto
usi --* udto
usi --* um
usi --* lm
usi --* urep
usi --* u
gscont --* gsdto
gscont --* gss
ucont --* idpw
ucont --* ldto
ucont --* udto
ucont --* us
gsm --* gs
lm --* u
prdto --* u
um --* u
gsrep --* gs
prrep --* pr
urep --* u

st --* urep
st --* gsrep
st --* gs
st --* u
}

@enduml
```

# Verification traceability matrix

|                                                     | User  | PriceList | GasStation | UserService | UserServiceImpl | UserMapper | UserRepository | GasStationService | GasStationServiceImpl | GasStationMapper | GasStationRepository | LoginMapper | Spring Application | UpdateReputationScheduler | HomeController | UserServiceController | GasStationController |
| --------------------------------------------------- | :---: | :-------: | :--------: | :---------: | :-------------: | :--------: | :------------: | :---------------: | :-------------------: | :--------------: | :------------------: | :---------: | :----------------: | :-----------------------: | :------------: | :-------------------: | :------------------: |
| **FR1 Manage Users**                                |       |           |            |             |                 |            |                |                   |                       |                  |                      |             |                    |                           |                |                       |                      |
| FR1.1 New/Edit User                                 |   X   |           |            |      X      |        X        |     X      |                |                   |                       |                  |                      |             |                    |             X             |                |           X           |                      |
| FR1.2 Delete User                                   |   X   |           |            |      X      |        X        |            |       X        |                   |                       |                  |                      |             |                    |                           |                |           X           |                      |
| FR1.3 List all Users                                |   X   |           |            |      X      |        X        |     X      |       X        |                   |                       |                  |                      |             |                    |                           |                |           X           |                      |
| FR1.4 Search User                                   |   X   |           |            |      X      |        X        |     X      |       X        |                   |                       |                  |                      |             |                    |                           |                |           X           |                      |
| **FR2 Manage Rights**                               |   X   |           |            |             |        X        |     X      |       X        |                   |                       |                  |                      |             |                    |                           |                |           X           |                      |
| **FR3 Manage Gas Station**                          |       |           |            |             |                 |            |                |                   |                       |                  |                      |             |                    |                           |                |                       |                      |
| FR3.1 New/Edit Gas Station                          |       |           |     X      |             |                 |            |                |         X         |           X           |        X         |          X           |             |                    |                           |                |                       |          X           |
| FR3.2 Delete Gas Station                            |       |           |     X      |             |        X        |            |                |         X         |                       |                  |          X           |             |                    |                           |                |           X           |          X           |
| FR3.3 List all Gas Stations                         |       |           |     X      |             |        X        |            |                |         X         |           X           |        X         |          X           |             |                    |                           |                |                       |          X           |
| **FR4 Search Gas Station**                          |       |           |            |             |                 |            |                |                   |                       |                  |                      |             |                    |                           |                |                       |                      |
| FR4.1 Radius r Geo Point                            |   X   |           |            |             |                 |            |                |         X         |           X           |        X         |          X           |             |                    |                           |                |           X           |          X           |
| FR4.2 Radius r Address                              |   X   |           |            |             |                 |            |                |         X         |           X           |        X         |          X           |             |                    |                           |                |                       |          X           |
| FR4.3 Show on Map                                   |       |           |     X      |             |                 |            |                |         X         |           X           |        X         |          X           |             |                    |                           |       X        |                       |          X           |
| FR4.4 Sort according to Fuel Price                  |       |     X     |     X      |             |                 |            |                |         X         |           X           |        X         |          X           |             |                    |                           |       X        |                       |          X           |
| FR4.5 Filter according to Fuel Type and Car Sharing |       |           |     X      |             |                 |            |                |         X         |           X           |        X         |          X           |             |                    |                           |       X        |                       |          X           |
| **FR5 Manage Price List and Trust**                 |       |           |            |             |                 |            |                |                   |                       |                  |                      |             |                    |                           |                |                       |                      |
| FR5.1 New Price List                                |   X   |     X     |     X      |             |                 |            |                |         X         |           X           |        X         |          X           |             |                    |                           |       X        |                       |          X           |
| FR5.2 Update Trust Level of Price List              |   X   |     X     |     X      |             |                 |            |                |                   |                       |                  |                      |             |         X          |             X             |       X        |                       |          X           |
| FR5.3 Evaluate Price List                           |   X   |     X     |            |      X      |        X        |     X      |       X        |                   |                       |                  |                      |             |                    |                           |                |                       |                      |

# Verification sequence diagrams 

### Use Case 1

``` plantuml
@startuml
Actor User as u
u -> userController : 1 - saveUser()
userController ->UserServiceImpl :2 - saveUser()
UserServiceImpl -> UserMapper :3 - toUser()
UserMapper --> UserServiceImpl :User object
UserServiceImpl -> UserRepository :4 - save()
UserRepository --> UserServiceImpl :User object
UserServiceImpl -> UserMapper :5 - toUserDto()
UserMapper --> UserServiceImpl :UserDto object
UserServiceImpl --> UserServiceController :UserDto object
UserServiceController --> u: 200 ok
@enduml
```

### Use Case 2

``` plantuml
@startuml
Actor User as u
u -> userController : 1 - saveUser()
userController ->UserServiceImpl :2 - saveUser()
UserServiceImpl -> UserMapper :3 - toUser()
UserMapper --> UserServiceImpl :User object
UserServiceImpl -> UserRepository :4 - save()
UserRepository --> UserServiceImpl :User object
UserServiceImpl -> UserMapper :5 - toUserDto()
UserMapper --> UserServiceImpl :UserDto object
UserServiceImpl --> UserServiceController :UserDto object
UserServiceController --> u: 200 ok
@enduml
```

### Use Case 3

``` plantuml
@startuml
actor User as u
u -> userController : 1 - deleteUser()
userController ->UserServiceImpl :2 - deleteUser()
UserServiceImpl -> UserRepository : 3 - findOne()
UserRepository --> UserServiceImpl : User
UserServiceImpl -> UserRepository : 4 - delete()
UserServiceController --> u :  200 ok
@enduml
```

### Use Case 4

``` plantuml
@startuml
actor Administrator as a
a -> GasStationController: 1 - saveGasStation()
GasStationController ->  GasStationServiceImpl :2 - saveGasStation()
GasStationServiceImpl -> GasStationMapper : 3 - toGS()
GasStationMapper --> GasStationServiceImpl : GasStation object
GasStationServiceImpl -> GasStationRepository : 4 - save()
GasStationRepository --> GasStationServiceImpl : GasStation object
GasStationServiceImpl -> GasStationMapper : 5 - toGSDto()
GasStationMapper --> GasStationServiceImpl : GasStationDto object
GasStationServiceImpl --> GasStationController : GasStatinoDto object
GasStationController --> a :200 OK
@enduml
```

### Use Case 5

``` plantuml
@startuml
actor Administrator as a
a -> GasStationController: 1 - saveGasStation()
GasStationController ->  GasStationServiceImpl :2 - saveGasStation()
GasStationServiceImpl -> GasStationMapper : 3 - toGS()
GasStationMapper --> GasStationServiceImpl : GasStation object
GasStationServiceImpl -> GasStationRepository : 4 - save()
GasStationRepository --> GasStationServiceImpl : GasStation object
GasStationServiceImpl -> GasStationMapper : 5 - toGSDto()
GasStationMapper --> GasStationServiceImpl : GasStationDto object
GasStationServiceImpl --> GasStationController : GasStatinoDto object
GasStationController --> a :200 OK
@enduml
```

### Use Case 6

``` plantuml
@startuml
Actor Administrator as a
a -> GasStationController :1 - deleteUser()
GasStationController -> GasStationServiceImpl :2 - deleteGasStation()
GasStationServiceImpl -> GasStationRepository :3 - findOne()
GasStationRepository --> GasStationServiceImpl :GasStation object
GasStationServiceImpl -> GasStationRepository :4 - delete()
GasStationServiceImpl -> GasStationRepository :5 - findOne()
GasStationRepository --> GasStationServiceImpl :null
GasStationServiceImpl --> GasStationController :true
GasStationController --> a :200 OK
@enduml
```

### Use Case 7

``` plantuml
@startuml
actor User as u
u -> GasStationController :1 - setGasStationReport()
GasStationController -> GasStationServiceImpl :2 - setReport()
GasStationServiceImpl -> GasStationRepository :3 - findOne()
GasStationRepository --> GasStationServiceImpl :GasStation object
GasStationServiceImpl -> UserRepository :4 - findOne()
UserRepository --> GasStationServiceImpl :User object
GasStationServiceImpl -> GasStation :5 - setters()
GasStationServiceImpl -> GasStationRepository : 6 - save()
GasStationRepository --> GasStationServiceImpl :GasStation object
GasStationServiceImpl --> GasStationController
GasStationController --> u :200 ok
@enduml
```

### Use Case 8

``` plantuml
@startuml
Actor "Anonymous User" as u
u -> GasStationController :1 - getGasStationsByProximity()
GasStationController -> GasStationServiceImpl :2 - getGasStationByProximity()
GasStationServiceImpl -> GasStationRepository :3 - findAll()
GasStarionRepository --> GasStationServiceImpl :GasStation List
GasStationServiceImpl -> GasStationMapper :4 - toGSDto()
activate GasStationMapper
note right of GasStationMapper: Repeat for every object returned in the list.
GasStationMapper --> GasStationServiceImpl :GasStationDto object
deactivate GasStationMapper
GasStationServiceImpl --> GasStationController :GasStationDto List
GasStationController --> u :200 OK
@enduml
```

### Use Case 9

``` plantuml
@startuml
title Repeated every 12 h

SpringApplication -> UpdateReputationScheduler :1 - run()
UpdateReputationScheduler -> GasStationRepository :2 - findAll()
GasStationRepository --> UpdateReputationScheduler :GasStation List
UpdateReputationScheduler -> UserRepository :3 - findOne()
activate UpdateReputationScheduler
UserRepository --> UpdateReputationScheduler :User object
note left of UpdateReputationScheduler: Repeat for every object returned in the list with prices set.
UpdateReputationScheduler -> UpdateReputationScheduler :4 - computeReputation()
UpdateReputationScheduler -> GasStationRepository :5 - save()
GasStationRepository --> UpdateReputationScheduler :GasStation
deactivate UpdateReputationScheduler

@enduml
```

### Scenario 10.1

``` plantuml
@startuml
actor User as u
u -> userController : 1 - increaseUserReputation()
userController ->UserServiceImpl : 2 - increaseUserReputation()
UserServiceImpl -> UserRepository : 3 - findOne()
UserRepository --> UserServiceImpl : User object
UserServiceImpl -> User: 4 - getReputation()
User --> UserServiceImpl : reputation
UserServiceImpl -> User: 5 - setReputation()
UserServiceImpl -> UserRepository : 6 - save()
UserRepository --> UserServiceImpl : User object
UserServiceImpl --> UserServiceController : reputation
UserServiceController --> u : 200 ok
@enduml
```

### Scenario 10.2

``` plantuml
@startuml
actor User as u
u -> userController : 1 - decreaseUserReputation()
userController ->UserServiceImpl :2 - decreaseUserReputation()
UserServiceImpl -> UserRepository : 3 - findOne()
UserRepository --> UserServiceImpl : User object
UserServiceImpl -> User: 4 - getReputation()
User --> UserServiceImpl : reputation
UserServiceImpl -> User: 5 - setReputation()
UserServiceImpl -> UserRepository : 6 - save()
UserRepository --> UserServiceImpl :User object
UserServiceImpl --> UserServiceController : reputation
UserServiceController --> u :  200 ok
@enduml
```
