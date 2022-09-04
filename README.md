# Shortest Path Finder Application

This application aim to Find the path from source to destination in a matrix that satisfies given constraints.

# note 
The work is still in progress for satisfying all the constraints. 

## How to run:

 1. Run application with command mvn spring-boot:run

## Rest End-Points: 

1.  Find the shortest path from (0,0) to given destination location 
	http://localhost:8080/api/findshortestpath?robotId=1&destX=2&destY=0
	Sample output
	
	```
	[
	    {
	        "x": 0,
	        "y": 0,
	        "distanceFromSource": 0
	    },
	    {
	        "x": 0,
	        "y": 1,
	        "distanceFromSource": 1
	    },
	    {
	        "x": 0,
	        "y": 2,
	        "distanceFromSource": 2
	    },
	    {
	        "x": 1,
	        "y": 2,
	        "distanceFromSource": 3
	    }
	]
	```
	
2. Add User:

   POST URL: localhost:8080/users
   
   Request Body:
   
   { "id": 1, "name": "XYZ", "email": "xyz@gmail.com"}

3. Get User By Id:

   GET URL: localhost:8080/users/{id}

4. Get users:

   GET URL: localhost:8080/users
