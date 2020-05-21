# Integration and API Test Documentation

Authors:

Date:

Version:

# Contents

- [Dependency graph](#dependency-graph)

- [Integration and API Test Documentation](#integration-and-api-test-documentation)
- [Contents](#contents)
- [Dependency graph](#dependency-graph)
- [Integration approach](#integration-approach)
- [Tests](#tests)
  - [Step 1](#step-1)
  - [Step 2](#step-2)
  - [Step 3 - API Tests](#step-3---api-tests)
- [Scenarios](#scenarios)
  - [Scenario UCx.y](#scenario-ucxy)
- [Coverage of Scenarios and FR](#coverage-of-scenarios-and-fr)
- [Coverage of Non Functional Requirements](#coverage-of-non-functional-requirements)
    - [](#)

- [Tests](#tests)

- [Scenarios](#scenarios)

- [Coverage of scenarios and FR](#scenario-coverage)
- [Coverage of non-functional requirements](#nfr-coverage)



# Dependency graph 

```plantuml
@startuml


agent GasStationServiceimpl.getGasStationById as getGasStationById
agent GasStationServiceimpl.saveGasStation as saveGasStation
agent GasStationServiceimpl.getAllGasStations as getAllGasStations
agent GasStationServiceimpl.deleteGasStation as deleteGasStation
agent GasStationServiceimpl.getGasStationsByGasolineType as getGasStationsByGasolineType
agent GasStationServiceimpl.getGasStationsByProximity as getGasStationsByProximity
agent GasStationServiceimpl.getGasStationsWithCoordinates as getGasStationsWithCoordinates
agent GasStationServiceimpl.getGasStationsWithoutCoordinates as getGasStationsWithoutCoordinates
agent GasStationServiceimpl.setReport as setReport
agent GasStationServiceimpl.getGasStationByCarSharing as getGasStationByCarSharing
agent GasStationServiceimpl.isGasolineTypeValid as isGasolineTypeValid
agent GasStationServiceimpl.mapGasolineTypeToMethod as mapGasolineTypeToMethod
agent GasStationServiceimpl.priceCorrect as priceCorrect
agent GasStationServiceimpl.geoPointDistance as geoPointDistance
agent GasStationServiceimpl.latLonCorrect as latLonCorrect
agent GasStationRepository.findOne as findOneGs
agent GasStationRepository.findAll as findAllGs
agent GasStationRepository.findByCarSharing as findByCarSharing
agent GasStationRepository.findByAddress as findByAddress
agent GasStationRepository.save as saveGs
agent GasStationRepository.delete as deleteGs
agent GasStationMapper.toGSDto as toGSDto
agent GasStationMapper.toGS as toGS
agent GasStation.getGasStationId as getGasStationId
agent GasStation.setGasStationId as setGasStationId
agent GasStation.getGasStationName as getGasStationName
agent GasStation.setGasStationName as setGasStationName
agent GasStation.getGasStationAddress as getGasStationAddress
agent GasStation.setGasStationAddress as setGasStationAddress
agent GasStation.getReportDependability as getReportDependability
agent GasStation.setReportDependability as setReportDependability
agent GasStation.getReportUser as getReportUser
agent GasStation.setReportUser as setReportUser
agent GasStation.getReportTimestamp as getReportTimestamp
agent GasStation.setReportTimestamp as setReportTimestamp
agent GasStation.getHasDiesel as getHasDiesel
agent GasStation.setHasDiesel as setHasDiesel
agent GasStation.getHasSuper as getHasSuper
agent GasStation.setHasSuper as setHasSuper
agent GasStation.getHasSuperPlus as getHasSuperPlus
agent GasStation.setHasSuperPlus as setHasSuperPlus
agent GasStation.getHasGas as getHasGas
agent GasStation.setHasGas as setHasGas
agent GasStation.getHasMethane as getHasMethane
agent GasStation.setHasMethane as setHasMethane
agent GasStation.getLat as getLat
agent GasStation.setLat as setLat
agent GasStation.getLon as getLon
agent GasStation.setLon as setLon
agent GasStation.getDieselPrice as getDieselPrice
agent GasStation.setDieselPrice as setDieselPrice
agent GasStation.getSuperPrice as getSuperPrice
agent GasStation.setSuperPrice as setSuperPrice
agent GasStation.getSuperPlusPrice as getSuperPlusPrice
agent GasStation.setSuperPlusPrice as setSuperPlusPrice
agent GasStation.getGasPrice as getGasPrice
agent GasStation.setGasPrice as setGasPrice
agent GasStation.getMethanePrice as getMethanePrice
agent GasStation.setMethanePrice as setMethanePrice
agent GasStation.getUser as getUser
agent GasStation.setUser as setUser
agent GasStation.getCarSharing as getCarSharing
agent GasStation.setCarSharing as setCarSharing
agent GasStationDto.getGasStationId as getGasStationIdDto
agent GasStationDto.setGasStationId as setGasStationIdDto
agent GasStationDto.getGasStationName as getGasStationNameDto
agent GasStationDto.setGasStationName as setGasStationNameDto
agent GasStationDto.getGasStationAddress as getGasStationAddressDto
agent GasStationDto.setGasStationAddress as setGasStationAddressDto
agent GasStationDto.getReportDependability as getReportDependabilityDto
agent GasStationDto.setReportDependability as setReportDependabilityDto
agent GasStationDto.getReportUser as getReportUserDto
agent GasStationDto.setReportUser as setReportUserDto
agent GasStationDto.getReportTimestamp as getReportTimestampDto
agent GasStationDto.setReportTimestamp as setReportTimestampDto
agent GasStationDto.getHasDiesel as getHasDieselDto
agent GasStationDto.setHasDiesel as setHasDieselDto
agent GasStationDto.getHasSuper as getHasSuperDto
agent GasStationDto.setHasSuper as setHasSuperDto
agent GasStationDto.getHasSuperPlus as getHasSuperPlusDto
agent GasStationDto.setHasSuperPlus as setHasSuperPlusDto
agent GasStationDto.getHasGas as getHasGasDto
agent GasStationDto.setHasGas as setHasGasDto
agent GasStationDto.getHasMethane as getHasMethaneDto
agent GasStationDto.setHasMethane as setHasMethaneDto
agent GasStationDto.getLat as getLatDto
agent GasStationDto.setLat as setLatDto
agent GasStationDto.getLon as getLonDto
agent GasStationDto.setLon as setLonDto
agent GasStationDto.getDieselPrice as getDieselPriceDto
agent GasStationDto.setDieselPrice as setDieselPriceDto
agent GasStationDto.getSuperPrice as getSuperPriceDto
agent GasStationDto.setSuperPrice as setSuperPriceDto
agent GasStationDto.getSuperPlusPrice as getSuperPlusPriceDto
agent GasStationDto.setSuperPlusPrice as setSuperPlusPriceDto
agent GasStationDto.getGasPrice as getGasPriceDto
agent GasStationDto.setGasPrice as setGasPriceDto
agent GasStationDto.getMethanePrice as getMethanePriceDto
agent GasStationDto.setMethanePrice as setMethanePriceDto
agent GasStationDto.getUser as getUserDto
agent GasStationDto.setUser as setUserDto
agent GasStationDto.getCarSharing as getCarSharingDto
agent GasStationDto.setCarSharing as setCarSharingDto



toGS -- setGasStationId
toGS -- setGasStationName
toGS -- setGasStationAddress
toGS -- setCarSharing
toGS -- setHasDiesel
toGS -- setHasGas
toGS -- setHasMethane
toGS -- setHasSuper
toGS -- setHasSuperPlus
toGS -- setDieselPrice
toGS -- setGasPrice
toGS -- setMethanePrice
toGS -- setSuperPrice
toGS -- setSuperPlusPrice
toGS -- setLat
toGS -- setLon
toGS -- setReportUser
toGS -- setReportTimestamp
toGS -- setReportDependability
toGS -- getGasStationIdDto
toGS -- getGasStationNameDto
toGS -- getGasStationAddressDto
toGS -- getCarSharingDto
toGS -- getHasDieselDto
toGS -- getHasGasDto
toGS -- getHasMethaneDto
toGS -- getHasSuperDto
toGS -- getHasSuperPlusDto
toGS -- getDieselPriceDto
toGS -- getGasPriceDto
toGS -- getMethanePriceDto
toGS -- getSuperPriceDto
toGS -- getSuperPlusPriceDto
toGS -- getLatDto
toGS -- getLonDto
toGS -- getReportUserDto
toGS -- getReportTimestampDto
toGS -- getReportDependabilityDto
toGSDto -- setGasStationIdDto
toGSDto -- setGasStationNameDto
toGSDto -- setGasStationAddressDto
toGSDto -- setCarSharingDto
toGSDto -- setHasDieselDto
toGSDto -- setHasGasDto
toGSDto -- setHasMethaneDto
toGSDto -- setHasSuperDto
toGSDto -- setHasSuperPlusDto
toGSDto -- setDieselPriceDto
toGSDto -- setGasPriceDto
toGSDto -- setMethanePriceDto
toGSDto -- setSuperPriceDto
toGSDto -- setSuperPlusPriceDto
toGSDto -- setLatDto
toGSDto -- setLonDto
toGSDto -- setReportUserDto
toGSDto -- setReportTimestampDto
toGSDto -- setReportDependabilityDto
toGSDto -- getGasStationId
toGSDto -- getGasStationName
toGSDto -- getGasStationAddress
toGSDto -- getCarSharing
toGSDto -- getHasDiesel
toGSDto -- getHasGas
toGSDto -- getHasMethane
toGSDto -- getHasSuper
toGSDto -- getHasSuperPlus
toGSDto -- getDieselPrice
toGSDto -- getGasPrice
toGSDto -- getMethanePrice
toGSDto -- getSuperPrice
toGSDto -- getSuperPlusPrice
toGSDto -- getLat
toGSDto -- getLon
toGSDto -- getReportUser
toGSDto -- getReportTimestamp
toGSDto -- getReportDependability
getGasStationById -- findOneGs
getGasStationById -- toGSDto
saveGasStation -- setDieselPriceDto
saveGasStation -- setGasPriceDto
saveGasStation -- setMethanePriceDto
saveGasStation -- setSuperPriceDto
saveGasStation -- setSuperPlusPriceDto
saveGasStation -- priceCorrect
saveGasStation -- latLonCorrect
saveGasStation -- saveGs
saveGasStation -- toGSDto
saveGasStation -- findByAddress
getAllGasStations -- findAllGs
getAllGasStations -- toGSDto
deleteGasStation -- findOneGs
deleteGasStation -- deleteGs
getGasStationsByGasolineType -- isGasolineTypeValid
getGasStationsByGasolineType -- findAllGs
getGasStationsByGasolineType -- toGSDto
getGasStationsByGasolineType -- mapGasolineTypeToMethod
getGasStationsByProximity -- latLonCorrect
getGasStationsByProximity -- findAll
getGasStationsByProximity -- geoPointDistance
getGasStationsByProximity -- toGSDto
getGasStationsWithCoordinates -- latLonCorrect
getGasStationsWithCoordinates -- getGasStationsWithoutCoordinates
getGasStationsWithCoordinates -- geoPointDistance
getGasStationsWithoutCoordinates -- isGasolineTypeValid
getGasStationsWithoutCoordinates -- getGasStationByCarSharing
getGasStationsWithoutCoordinates -- mapGasolineTypeToMethod
setReport -- findOneGs
/' setReport -- findOneU '/
setReport -- priceCorrect
setReport -- toGSDto
setReport -- setDieselPrice
setReport -- setGasPrice
setReport -- setMethanePrice
setReport -- setSuperPrice
setReport -- setSuperPlusPrice
setReport -- setReportUser
setReport -- setUser
/'setReport -- user.getUserId'/
setReport -- setReportTimestamp
setReport -- setReportDependability
/'setReport -- user.getReputation'/
setReport -- saveGs
getGasStationByCarSharing -- getAllGasStations
getGasStationByCarSharing -- findByCarSharing
getGasStationByCarSharing -- toGSDto
mapGasolineTypeToMethod -- getHasDieselDto
mapGasolineTypeToMethod -- getHasGasDto
mapGasolineTypeToMethod -- getHasMethaneDto
mapGasolineTypeToMethod -- getHasSuperDto
mapGasolineTypeToMethod -- getHasSuperPlusDto
priceCorrect -- getHasDieselDto
priceCorrect -- getDieselPriceDto
priceCorrect -- getHasGasDto
priceCorrect -- getGasPriceDto
priceCorrect -- getHasMethaneDto
priceCorrect -- getMethanePriceDto
priceCorrect -- getHasSuperDto
priceCorrect -- getSuperPriceDto
priceCorrect -- getHasSuperPlusDto
priceCorrect -- getSuperPlusPriceDto

@enduml
```
     
# Integration approach

    <Write here the integration sequence you adopted, in general terms (top down, bottom up, mixed) and as sequence
    (ex: step1: class A, step 2: class A+B, step 3: class A+B+C, etc)> 
    <The last integration step corresponds to API testing at level of Service package>
    <Tests at level of Controller package will be done later>



#  Tests


## Step 1
|     Classes      | JUnit test cases |
| :--------------: | :--------------: |
| GasStationMapper |    testToGS1     |
|                  |    testToGS2     |
|                  |    testToGS3     |
|                  |    testToGS4     |
|                  |    testToGS5     |
|                  |    testToGS6     |
|                  |   testToGSDto1   |
|                  |   testToGSDto2   |
|                  |   testToGSDto3   |
|                  |   testToGSDto4   |


## Step 2
|                 Classes                  |           JUnit test cases            |
| :--------------------------------------: | :-----------------------------------: |
| GasStationServiceimpl + GasStationMapper |        testGetGasStationById1         |
|                                          |        testGetGasStationById2         |
|                                          |          testSaveGasStation1          |
|                                          |          testSaveGasStation2          |
|                                          |          testSaveGasStation3          |
|                                          |          testSaveGasStation4          |
|                                          |        testGetAllGasStations1         |
|                                          |        testGetAllGasStations2         |
|                                          |         testDeleteGasStation1         |
|                                          |         testDeleteGasStation2         |
|                                          |   testGetGasStationsByGasolineType1   |
|                                          |   testGetGasStationsByGasolineType2   |
|                                          |   testGetGasStationsByGasolineType3   |
|                                          |      testGasStationsByProximity1      |
|                                          |      testGasStationsByProximity2      |
|                                          |      testGasStationsByProximity3      |
|                                          |      testGasStationsByProximity4      |
|                                          |    testGetGasStationsByCarSharing1    |
|                                          |    testGetGasStationsByCarSharing2    |
|                                          |    testGetGasStationsByCarSharing3    |
|                                          |  testGetGasStationsWithCoordinates1   |
|                                          |  testGetGasStationsWithCoordinates2   |
|                                          |  testGetGasStationsWithCoordinates3   |
|                                          |  testGetGasStationsWithCoordinates4   |
|                                          |  testGetGasStationsWithCoordinates5   |
|                                          |  testGetGasStationsWithCoordinates6   |
|                                          | testGetGasStationsWithoutCoordinates1 |
|                                          | testGetGasStationsWithoutCoordinates2 |
|                                          | testGetGasStationsWithoutCoordinates3 |
|                                          |           testPriceCorrect1           |
|                                          |           testPriceCorrect2           |


## Step 3 - API Tests

|                 Classes                 | JUnit test cases |
| :-------------------------------------: | :--------------: |
| UserServiceimpl + GasStationServiceimpl |  testSetReport1  |
|                                         |  testSetReport2  |
|                                         |  testSetReport3  |
|                                         |  testSetReport4  |



# Scenarios


<If needed, define here additional scenarios for the application. Scenarios should be named
 referring the UC they detail>



## Scenario UCx.y

| Scenario       |    name     |
| -------------- | :---------: |
| Precondition   |             |
| Post condition |             |
| Step#          | Description |
| 1              |     ...     |
| 2              |     ...     |



# Coverage of Scenarios and FR


<Report in the following table the coverage of  scenarios (from official requirements and from above) vs FR. 
Report also for each of the scenarios the (one or more) API JUnit tests that cover it. >




| Scenario ID | Functional Requirements covered | JUnit  Test(s) |
| ----------- | ------------------------------- | -------------- |
| ..          | FRx                             |                |
| ..          | FRy                             |                |
| ...         |                                 |                |
| ...         |                                 |                |
| ...         |                                 |                |
| ...         |                                 |                |



# Coverage of Non Functional Requirements


<Report in the following table the coverage of the Non Functional Requirements of the application - only those that can be tested with automated testing frameworks.>


### 

| Non Functional Requirement | Test name |
| -------------------------- | --------- |
|                            |           |


