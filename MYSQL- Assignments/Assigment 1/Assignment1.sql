-- Question 1

select S.FirstName, S.LastName, S.StaffID
from staff S
where S.PositionName='treasurer';select S.FirstName, S.LastName, S.StaffID
from staff S
where S.PositionName='treasurer';

-- Question 2

select B.TripID
from passengers P, booking B
where P.PassID=B.PassengerID and P.FirstName='James' and P.LastName='Bond'and MONTH(B.BookDate)=7 and YEAR(B.BookDate)=2019
;select B.TripID
from passengers P, booking B
where P.PassID=B.PassengerID and P.FirstName='James' and P.LastName='Bond'and MONTH(B.BookDate)=7 and YEAR(B.BookDate)=2019
;

-- Question 3 

select P.FirstName, P.LastName, P.PhoneNumber
from pilots P, flies F, trips T
where P.PilotID=F.PilotID and T.TripID=F.TripID and YEAR(T.DeptDate)=2019 and MONTH(T.DeptDate)=7
group by P.PilotID, P.FirstName, P.LastName, P.PhoneNumber
having count(distinct f.TripID)=1;

-- Question 4

select Distinct P.FirstName, P.LastName, P.RewardPoints
from passengers P, trips T, booking B
where B.TripID=T.TripID AND P.PassID=B.PassengerID AND P.RewardPoints>=2000 AND T.ArrTown='El Paso'
order by RewardPoints ASC;

-- Question 5 

select *
from staff S , departments D
where D.DeptID=S.DepartmentID and S.PositionName = 'manager' and D.Category='Finance';

-- Question 6

SELECT B.TripID 
FROM booking B
WHERE B.PassengerID IN (
    SELECT P.PassID 
    FROM passengers P
    WHERE P.FirstName IN ('James', 'John') and P.LastName IN ("Bond", "Wick")
)
Group by B.TripID
having count(B.TripID) > 1;

-- Question 7 

SELECT S.FirstName, S.LastName, S.Birthdate,P.FirstName, P.LastName, P.Birthdate
FROM staff S
LEFT JOIN pilots P ON S.FirstName=P.FirstName
ORDER BY  S.FirstName=P.FirstName DESC
;

-- Question 8

SELECT P.FirstName, P.LastName, P.PilotID, P.Rating
FROM pilots P
WHERE P.Rating< (SELECT AVG(P.Rating)
                 from pilots P)
ORDER BY P.Rating ASC;

-- Question 9 

SELECT P.LastName,T.TripID, T.ArrTown
FROM trips T
INNER JOIN  flies F  ON  T.TripID=F.TripID
INNER JOIN pilots P on P.PilotID=F.PilotID
WHERE T.Capacity>=450 AND T.DeptTown LIKE 'S%'
;

-- Question 10 

select count(distinct(S.ServiceID)) as Service
from pilots P, services S, trips T, flies F
where P.PilotID = F.PilotID and F.TripID = T.TripID and T.AirCraftID = S.AirCraftID and P.FirstName = "Parth" and P.LastName = "Nagarkar" 

