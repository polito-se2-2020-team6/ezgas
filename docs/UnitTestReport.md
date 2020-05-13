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
| :-------------: | :-----------------: |
|  String Length  |          0          |
|                 |         >0          |
| Correct Content |    Gasoline type    |
|                 | Not a gasoline type |


**Boundaries**:

|    Criteria     | Boundary values |
| :-------------: | :-------------: |
| Correct Content |      null       |

**Combination of predicates**:

| String Length |   Correct Content   | Valid / Invalid | Description of the test case |      JUnit test case       |
| :-----------: | :-----------------: | :-------------: | :--------------------------: | :------------------------: |
|       0       |          -          |     Invalid     |    Input string is empty     | testIsGasolineTypeValid1() |
|      > 0      | Not a gasoline type |     Invalid     |    Input string is "ciao"    | testIsGasolineTypeValid2() |
|      > 0      |    Gasoline Type    |      Valid      |  Input string is "Methane"   | testIsGasolineTypeValid3() |
|       -       |        null         |     Invalid     |     Input string is null     | testIsGasolineTypeValid9() |

 ### Class GasStationServiceimpl - method geoPointDistance

**Criteria for method geoPointDistance:**	





 ### Class GasStationServiceimpl - method latLonCorrect
 **Criteria for method latLonCorrect:**	
 - Latitude value
 - Longitude value


**Predicates for method latLonCorrect:**

|    Criteria     |     Predicate      |
| :-------------: | :----------------: |
| Latitude value  |       <= -90       |
|                 |  -90< `lat` <= 90  |
|                 |        >90         |
| Longitude value |      <= -180       |
|                 | > -180 `lon` <=180 |
|                 |        >180        |


**Boundaries**:

|    Criteria     |       Boundary values       |
| :-------------: | :-------------------------: |
| Latitude value  |            -90.0            |
|                 | -90 + Double.MIN_INCREMENT  |
|                 | -90 - Double.MIN_INCREMENT  |
|                 |            90.0             |
|                 |  90 - Double.MIN_INCREMENT  |
|                 |  90 + Double.MIN_INCREMENT  |
| Longitude value |           -180.0            |
|                 | -180 + Double.MIN_INCREMENT |
|                 | -180 - Double.MIN_INCREMENT |
|                 |            180.0            |
|                 | 180 + Double.MIN_INCREMENT  |
|                 | 180 - Double.MIN_INCREMENT  |

**Combination of predicates**:

|  Latitude value  |  Longitude Value  | Valid / Invalid |                Description of the test case                |    JUnit test case    |
| :--------------: | :---------------: | :-------------: | :--------------------------------------------------------: | :-------------------: |
|      = -90       |         -         |     Invalid     |                       (-90, -180.0)                        | testlatLonCorrect1()  |
|      < -90       |         -         |     Invalid     |            (-90 - Double.MIN_INCREMENT, 150.0)             | testlatLonCorrect2()  |
| -90< `lat` <= 90 |      < -180       |     Invalid     | (-90 + Double.MIN_INCREMENT, -180 - Double.MIN_INCREMENT)  | testlatLonCorrect3()  |
| -90< `lat` <= 90 |      = -180       |     Invalid     |                       (0.0, -180.0 )                       | testlatLonCorrect4()  |
| -90< `lat` <= 90 | -180<`lon` <=180  |      Valid      |                       (90.0, 180.0 )                       | testlatLonCorrect5()  |
| -90< `lat` <= 90 | -180< `lon` <=180 |      Valid      |  (90 - Double.MIN_INCREMENT, 180 - Double.MIN_INCREMENT )  | testlatLonCorrect6()  |
| -90< `lat` <= 90 | -180< `lon` <=180 |      Valid      | (-90 + Double.MIN_INCREMENT, -180 + Double.MIN_INCREMENT ) | testlatLonCorrect7()  |
| -90< `lat` <= 90 | -180< `lon` <=180 |      Valid      |                          (0, 0 )                           | testlatLonCorrect8()  |
| -90< `lat` <= 90 |       >180        |     Invalid     |              (0, 180 + Double.MIN_INCREMENT)               | testlatLonCorrect9()  |
|       >90        |         -         |     Invalid     |             (90 + Double.MIN_INCREMENT, 50.0)              | testlatLonCorrect10() |



# White Box Unit Tests

### Test cases definition
    
    <JUnit test classes must be in src/test/java/it/polito/ezgas>
    <Report here all the created JUnit test cases, and the units/classes under test >
    <For traceability write the class and method name that contains the test case>


|      Unit name      |       JUnit test case       |
| :-----------------: | :-------------------------: |
| isGasolineTypeValid | testIsGasolineTypeValid1()  |
|                     | testIsGasolineTypeValid2()  |
|                     | testIsGasolineTypeValid3()  |
|                     | testIsGasolineTypeValid4()  |
|                     | testIsGasolineTypeValid5()  |
|                     | testIsGasolineTypeValid6()  |
|                     | testIsGasolineTypeValid7()  |
|                     | testIsGasolineTypeValid8()  |
|                     | testIsGasolineTypeValid9()  |
|                     | testIsGasolineTypeValid10() |
|    latLonCorrect    |    testlatLonCorrect1()     |
|                     |    testlatLonCorrect2()     |
|                     |    testlatLonCorrect3()     |
|                     |    testlatLonCorrect4()     |
|                     |    testlatLonCorrect5()     |
|                     |    testlatLonCorrect6()     |
|                     |    testlatLonCorrect7()     |
|                     |    testlatLonCorrect8()     |
|                     |    testlatLonCorrect9()     |
|                     |    testlatLonCorrect10()    |




### Code coverage report

  
![](Images/Tests/isGasolineTypeValidEclemma.png)


### Loop coverage analysis

    <Identify significant loops in the units and reports the test cases
    developed to cover zero, one or multiple iterations >

| Unit name | Loop rows | Number of iterations | JUnit test case |
| --------- | --------- | -------------------- | --------------- |
|           |           |                      |                 |
|           |           |                      |                 |
|           |           |                      |                 |



