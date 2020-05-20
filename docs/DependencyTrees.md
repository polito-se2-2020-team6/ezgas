# Dependency Trees

## Class it.polito.ezgas.service.impl.UserServiceimpl

### method *getUserById*

```plantuml
@startuml

agent UserServiceimpl.getUserById as getUserById
agent UserRepository.findOne as findOne
agent UserMapper.toUserDto as toUSerDto
agent "new UserDto" as newUserDto

getUserById -- findOne
getUserById -- toUSerDto

toUSerDto -- newUserDto

@enduml
```

### method *saveUser*

```plantuml
@startuml

agent UserServiceimpl.saveUser as saveUSer
agent UserMapper.toUser as toUser
agent "new User" as newUser
agent UserRepository.save as save
agent UserMapper.toUserDto as toUserDto
agent "new UserDto" as newUserDto

saveUSer -- toUser
saveUSer -- save
saveUSer -- toUserDto

toUser -- newUser

toUserDto -- newUserDto

@enduml
```

### method *getAllUsers*

```plantuml
@startuml
agent UserServiceimp.getAllUsers as getAllUsers
agent UserRepository.findAll as findAll
agent UserMapper.toUserDto as toUserDto
agent "new UserDto" as newUserDto


getAllUsers -- findAll
getAllUsers -- toUserDto

toUserDto -- newUserDto
@enduml
```

### method *deleteUSer*

```plantuml
@startuml
agent UserServiceimp.deleteUser as deleteUser
agent UserRepository.findOne as findOne
agent UserRepository.delete as delete

deleteUser -- findOne
deleteUser -- delete
@enduml
```

### method *login*

```plantuml
@startuml

agent UserServiceimpl.login as login
agent IdPw.getUser as getUser
agent UserRepository.findByEmail as findByEmail
agent User.getPassword as getPassword
agent IdPw.getPw as getPw
agent User.getEmail as getEmail
agent LoginMapper.toLoginDto as toLoginDto
agent "new LoginDto" as newLoginDto

login -- getUser
login -- findByEmail
login -- getPassword
login -- getPw
login -- getEmail
login -- toLoginDto
toLoginDto -- newLoginDto


@enduml
```

### method *increaseReputation*

```plantuml
@startuml

agent UserServiceimpl.increaseUserReputation as increaseUserReputation
agent UserRepository.findOne as findOne
agent User.setReputation as setReputation
agent UserRepository.save as save

increaseUserReputation -- findOne
increaseUserReputation -- setReputation
increaseUserReputation -- save

@enduml
```

### method *decreaseReputation*

```plantuml
@startuml

agent UserServiceimpl.decreaseUserReputation as decreaseUserReputation
agent UserRepository.findOne as findOne
agent User.setReputation as setReputation
agent UserRepository.save as save

decreaseUserReputation -- findOne
decreaseUserReputation -- setReputation
decreaseUserReputation -- save

@enduml
```

## Class it.polito.ezgas.service.impl.GasStationServiceimpl

### method *getGasStationById*

```plantuml
@startuml

@enduml
```

### method *saveGasStation*

```plantuml
@startuml

@enduml
```

### method *getAllGasStations*

```plantuml
@startuml

@enduml
```

### method *getGasStationsByProximity*

```plantuml
@startuml

@enduml
```

### method *getGasStationsWithCoordinates*

```plantuml
@startuml

@enduml
```

### method *getGasStationsWithoutCoordinates*

```plantuml
@startuml

@enduml
```

### method *setReport*

```plantuml
@startuml

@enduml
```

### method *getGasStationByCarSharing*

```plantuml
@startuml

@enduml
```

## Class it.polito.ezgas.controller.UserController

### method *getUserById*

```plantuml
@startuml

@enduml
```

### method *getAllUsers*

```plantuml
@startuml

@enduml
```

### method *saveUser*

```plantuml
@startuml

@enduml
```

### method *deleteUser*

```plantuml
@startuml

@enduml
```

### method *increaseUserReputation*

```plantuml
@startuml

@enduml
```

### method *decreaseUserReputation*

```plantuml
@startuml

@enduml
```

### method *login*

```plantuml
@startuml

@enduml
```

## Class it.polito.ezgas.controller.GasStationController

### method *getGasStationById*

```plantuml
@startuml

@enduml
```

### method *getAllGasStations*

```plantuml
@startuml

@enduml
```

### method *saveGasStation*

```plantuml
@startuml

@enduml
```

### method *deleteUser*

```plantuml
@startuml

@enduml
```

### method *getGasStationsByGasolineType*

```plantuml
@startuml

@enduml
```

### method *getGasStationsByProximity*

```plantuml
@startuml

@enduml
```

### method *getGasStationsWithCoordinates*

```plantuml
@startuml

@enduml
```

### method *setGasStationReport*

```plantuml
@startuml

@enduml
```

## Class it.polito.ezgas.scheduling.ScheduledTasks

### method *scheduleUpdateGasStationReportDependability*

```plantuml
@startuml

@enduml
```