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
-Correct latitude
-Correct longitude 

**Predicates for method geoPointDistance:**

|      Criteria      |    Predicate     |
| :----------------: | :--------------: |
| Correct latitude1  |  -90<`lat1`<=90  |
| Correct longitude1 | -180<`lon1`<=180 |
| Correct latitude2  |  -90<`lat2`<=90  |
| Correct longitude2 | -180<`lon2`<=180 |

**Boundaries**:

|      Criteria      |       Boundary values       |
| :----------------: | :-------------------------: |
| Correct latitude1  | -90 + Double.MIN_INCREMENT  |
|                    |  90 - Double.MIN_INCREMENT  |
|                    |             90              |
| Correct longitude1 | -180 + Double.MIN_INCREMENT |
|                    | 180 - Double.MIN_INCREMENT  |
|                    |             180             |
| Correct latitude2  | -90 + Double.MIN_INCREMENT  |
|                    |  90 - Double.MIN_INCREMENT  |
|                    |             90              |
| Correct longitude2 | -180 + Double.MIN_INCREMENT |
|                    | 180 - Double.MIN_INCREMENT  |
|                    |             180             |

**Combination of predicates**:

|     Correct Latitude1      |     Correct Longitude1      |     Correct Latitude2      |     Correct Longitude2      | Valid / Invalid |            Description of the test case            |     JUnit test case      |
| :------------------------: | :-------------------------: | :------------------------: | :-------------------------: | :-------------: | :------------------------------------------------: | :----------------------: |
|       -90<`lat1`<=90       |      -180<`lon1`<=180       |       -90<`lat2`<=90       |      -180<`lon2`<=180       | Valid(10051.81) |             (-30.10;-100.2;-40.6;20.3)             | testGeoPointDistance1()  |
| -90 + Double.MIN_INCREMENT |      -180<`lon1`<=180       |       -90<`lat2`<=90       |      -180<`lon2`<=180       | Valid(12278.67) |  (-90 + Double.MIN_INCREMENT;-100.45;20.43;61.6)   | testGeoPointDistance2()  |
| 90 - Double.MIN_INCREMENT  |      -180<`lon1`<=180       |       -90<`lat2`<=90       |      -180<`lon2`<=180       | Valid(12853.52) |   (90 - Double.MIN_INCREMENT;65.21;-25.6;120.34)   | testGeoPointDistance3()  |
|             90             |      -180<`lon1`<=180       |       -90<`lat2`<=90       |      -180<`lon2`<=180       | Valid(12975.82) |               (90;89.90;-26.7;55.7)                | testGeoPointDistance4()  |
|       -90<`lat1`<=90       | -180 + Double.MIN_INCREMENT |       -90<`lat2`<=90       |      -180<`lon2`<=180       | Valid(11129.19) |  (-30.4;-180 + Double.MIN_INCREMENT;36.43;-100.4)  | testGeoPointDistance5()  |
|       -90<`lat1`<=90       | 180 - Double.MIN_INCREMENT  |       -90<`lat2`<=90       |      -180<`lon2`<=180       | Valid(11587.9)  | (29.09;180 - Double.MIN_INCREMENT;-50.34;-103.34)  | testGeoPointDistance6()  |
|       -90<`lat1`<=90       |             180             |       -90<`lat2`<=90       |      -180<`lon2`<=180       | Valid(7291.82)  |             (-45.54;180;-21.43;103.54)             | testGeoPointDistance7()  |
|       -90<`lat1`<=90       |      -180<`lon1`<=180       | -90 + Double.MIN_INCREMENT |       180<`lon2`<=180       | Valid(12477.69) |  (22.22;-102.34;-90 + Double.MIN_INCREMENT;27.76)  | testGeoPointDistance8()  |
|       -90<`lat1`<=90       |      -180<`lon1`<=180       | 90 - Double.MIN_INCREMENT  |       180<`lon2`<=180       | Valid(18986.73) | (-80.76;-170.54;90 - Double.MIN_INCREMENT;102.54)  | testGeoPointDistance9()  |
|       -90<`lat1`<=90       |      -180<`lon1`<=180       |             90             |       180<`lon2`<=180       | Valid(14850.48) |              (-43.56;109.34;90;99.09)              | testGeoPointDistance10() |
|       -90<`lat1`<=90       |      -180<`lon1`<=180       |       -90<`lat2`<=90       | -180 + Double.MIN_INCREMENT |  Valid(6366.8)  | (-30.54;103.54;-76.76;-180 + Double.MIN_INCREMENT) | testGeoPointDistance11() |
|       -90<`lat1`<=90       |      -180<`lon1`<=180       |       -90<`lat2`<=90       | 180 - Double.MIN_INCREMENT  | Valid(6510.84)  |   (31.67;66.78;89.43;180 - Double.MIN_INCREMENT)   | testGeoPointDistance12() |
|       -90<`lat1`<=90       |      -180<`lon1`<=180       |       -90<`lat2`<=90       |             180             | Valid(8846.99)  |              (55.76;-59.76;30.88;180)              | testGeoPointDistance13() |

 ### Class GasStationServiceimpl - method latLonCorrect

# White Box Unit Tests

### Test cases definition
    
    <JUnit test classes must be in src/test/java/it/polito/ezgas>
    <Report here all the created JUnit test cases, and the units/classes under test >
    <For traceability write the class and method name that contains the test case>


|      Unit name      |      JUnit test case       |
| :-----------------: | :------------------------: |
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
| --------- | --------- | -------------------- | --------------- |
|           |           |                      |                 |
|           |           |                      |                 |
|           |           |                      |                 |



