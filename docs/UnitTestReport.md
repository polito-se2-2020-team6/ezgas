# Unit Testing Documentation

Authors: Alessandro Borione, Giacomo Garaccione, Corrado Vecchio, Marco Vinai

Date: 13/05/2020

Version: 0.1

# Contents

- [Black Box Unit Tests](#black-box-unit-tests)




- [White Box Unit Tests](#white-box-unit-tests)


# Black Box Unit Tests

    <Define here criteria, predicates and the combination of predicates for each function of each class.
    Define test cases to cover all equivalence classes and boundary conditions.
    In the table, report the description of the black box test case and (traceability) the correspondence with the JUnit test case writing the 
    class and method name that contains the test case>
    <JUnit test classes must be in src/test/java/it/polito/ezgas   You find here, and you can use,  class EZGasApplicationTests.java that is executed before 
    the set up of all Spring components
    >

 ### Class GasStationServiceimpl - method isGasolineTypeValid



**Criteria for method isGasolineTypeValid:**	
 - String Length
 - Correct Content

**Predicates for method isGasolineTypeValid:**

|    Criteria     |      Predicate      |
|:---------------:|:-------------------:|
|  String Length  |          0          |
|                 |         >0          |
| Correct Content |    Gasoline type    |
|                 | Not a gasoline type |


**Boundaries**:

|    Criteria     | Boundary values |
|:---------------:|:---------------:|
| Correct Content |      null       |

**Combination of predicates**:

| String Length |   Correct Content   | Valid / Invalid | Description of the test case |      JUnit test case       |
|:-------------:|:-------------------:|:---------------:|:----------------------------:|:--------------------------:|
|       0       |          -          |     Invalid     |    Input string is empty     | testIsGasolineTypeValid1() |
|      > 0      | Not a gasoline type |     Invalid     |    Input string is "ciao"    | testIsGasolineTypeValid2() |
|      > 0      |    Gasoline Type    |      Valid      |  Input string is "Methane"   | testIsGasolineTypeValid3() |
|       -       |        null         |     Invalid     |     Input string is null     | testIsGasolineTypeValid9() |

 ### Class GasStationServiceimpl - method geoPointDistance

**Criteria for method geoPointDistance:**	





 ### Class GasStationServiceimpl - method latLonCorrect

# White Box Unit Tests

### Test cases definition
    
    <JUnit test classes must be in src/test/java/it/polito/ezgas>
    <Report here all the created JUnit test cases, and the units/classes under test >
    <For traceability write the class and method name that contains the test case>


|      Unit name      |      JUnit test case       |
|:-------------------:|:--------------------------:|
| isGasolineTypeValid | testIsGasolineTypeValid1() |
|                     | testIsGasolineTypeValid2() |
|                     | testIsGasolineTypeValid3() |
|                     | testIsGasolineTypeValid4() |
|                     | testIsGasolineTypeValid5() |
|                     | testIsGasolineTypeValid6() |
|                     | testIsGasolineTypeValid7() |
|                     | testIsGasolineTypeValid8() |
|                     | testIsGasolineTypeValid9() |


### Code coverage report

  
![](Images/Tests/isGasolineTypeValidEclemma.png)


### Loop coverage analysis

    <Identify significant loops in the units and reports the test cases
    developed to cover zero, one or multiple iterations >

| Unit name | Loop rows | Number of iterations | JUnit test case |
|-----------|-----------|----------------------|-----------------|
|           |           |                      |                 |
|           |           |                      |                 |
|           |           |                      |                 |



