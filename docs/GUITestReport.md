# GUI  Testing Documentation 

Authors: Alessandro Borione, Giacomo Garaccione, Corrado Vecchio, MArco Vinai

Date: 29/05/2020

Version: 1.0

# GUI testing

This part of the document reports about testing at the GUI level. Tests are end to end, so they should cover the Use Cases, and corresponding scenarios.

## Coverage of Scenarios and FR

```
<Complete this table (from IntegrationApiTestReport.md) with the column on the right. In the GUI Test column, report the name of the .py  file with the test case you created.>
```

### 

| Scenario ID | Functional Requirements covered | GUI Test(s) |
| ----------- | ------------------------------- | ----------- |
| 1           | FRx                             |             |
| 2           | FRy                             |             |
| ...         |                                 |             |
| ...         |                                 |             |
| ...         |                                 |             |
| ...         |                                 |             |


# REST  API  Testing

## Coverage of Controller methods

| class.method name                                    | Functional Requirements covered | REST  API Test(s)                   |
| ---------------------------------------------------- | :-----------------------------: | ----------------------------------- |
| UserController.getUserById()                         |              FR1.4              | testGetUserById()                   |
| UserController.getAllUsers()                         |              FR1.3              | testGaaUsers()                      |
| UserController.saveUser()                            |              FR1.1              | testSaveUSer()                      |
| UserController.deleteUser()                          |              FR1.2              | testDeleteUser()                    |
| UserController.increaseUserReputation()              |              FR5.3              | testIncreaseUserReputation()        |
| UserController.decreaseUserReputation()              |              FR5.3              | testDecreaseUserReputation()        |
| UserController.login()                               |               FR2               | testLogin()                         |
|                                                      |                                 |                                     |
| GasStationController.getGasStationById()             |                -                | testGetGasStationById()             |
| GasStationController.getAllGasStations()             |              FR3.3              | testGetAllGasStations()             |
| GasStationController.saveGasStation()                |              FR3.1              | testSaveGasStation()                |
| GasStationController.deleteUser()                    |              FR3.2              | testDeleteUser2()                   |
| GasStationController.getGasStationsByGasolineType()  |              FR4.5              | testGetGasStationsByGasolineType()  |
| GasStationController.getGasStationsByProximity()     |              FR4.2              | testGetGasStationsByProximity()     |
| GasStationController.getGasStationsWithCoordinates() |              FR4.1              | testGetGasStationsWtihCoordinates() |
| GasStationController.setGasStationReport()           |              FR5.1              | testSetGasStationReport()           |