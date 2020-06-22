# Project Estimation  

Authors: Alessandro Borione, Giacomo Garaccione, Corrado Vecchio, Marco Vinai

Date: 25/04/2020

Version: 1.0

# Contents



- [Project Estimation](#project-estimation)
- [Contents](#contents)
- [Estimation approach](#estimation-approach)
- [Estimate by product decomposition](#estimate-by-product-decomposition)
- [Estimate by activity decomposition](#estimate-by-activity-decomposition)
    - [Gantt Chart](#gantt-chart)
    


# Estimation approach


# Estimate by product decomposition


|                                                                                                         | Estimate |
| ------------------------------------------------------------------------------------------------------- | -------- |
| NC =  Estimated number of classes to be developed                                                       | 25       |
| A = Estimated average size per class, in LOC                                                            | 110      |
| S = Estimated size of project, in LOC (= NC * A)                                                        | 2750     |
| E = Estimated effort, in person hours (using our productivity of 8.88 LOC per person hour)              | 310      |
| C = Estimated cost, in euro (here use 1 person hour cost = 30 euro)                                     | 9300     |
| Estimated calendar time, in calendar weeks (Assume team of 4 people, 8 hours per day, 5 days per week ) | 4        |

Since work can't be parallelized for each activity, the estimated calendar time is not the direct division (2750/(4x8x5)).
The resulting estimated calendar time is not feasible for our situation, since we won't work full time on this project. Having worked together for both requirement document and GUI prototype, the number of hours spent in those activities is very high due to factor 4.
In any case, for a full-time working team, that estimate could be quite accurate, as shown in the Gantt Chart.

# Estimate by activity decomposition


| Activity name       | Estimated effort (person hours) |
| ------------------- | ------------------------------- |
| Requirements        | 64                              |
| Design              | 44.8                            |
| Coding              | 31                              |
| Unit Testing        | 21.5                            |
| Integration Testing | 71.1                            |
| Acceptance Testing  | 69.8                            |
| Management          | 7.8                             |



### Gantt Chart

![](Images/gantt_new.png)

Saturdays and Sundays appear in the chart but there is no work done on these days.