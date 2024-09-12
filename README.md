# Elevator-Java

Elevator Simulation in JavaThis is a simple elevator simulation program written in Java, demonstrating the use of object-oriented programming (OOP) principles and the Java Collections Framework. The program allows users to request different floors in a building and the elevator processes these requests sequentially.

## Features

Single-threaded: The program runs in a single thread, making it simple to understand and run.
Floor Requests: Users can request any floor within the building's range (0-10).
Priority Queue: Floor requests are handled in an orderly manner using a priority queue.
Object-Oriented Design: The program uses OOP principles, with classes for Elevator, ElevatorRequest and Building.

## Requirements

Java Development Kit (JDK): This program is designed to run on JDK 8 and higher version.

## Usage

when you run the program, you will be promoted to enter the number of floor requests followed by specific floors you want the elevator to stop.
## Classes

1.Elevator request : It representd a single floor requested by the user. Here the "target floor" is the attribute.
2.Elevator : It handels the main logic for the elevator movement .

### attributes:

 *current floor*- Represent the current floor of the elevator.
 *requestQueue*- A priority queue that maintain floor request.
 *movingUp*- A booleean to indicate if the elevator is moving up or down.

 ### methods:

 requestFloor()-Add a floor request to queue.
 move()-Process all request by moving th elevator.

 ## Building 

 Manages the interactiion between the elevator and incoming floor request.
 
 ### methods :
 
 handlerequests() : processes a list of request and send them to the elevator.

### attributes:

 elevator : instance of the elevator class.
 totalFloors: The no of floors in the building.

## Future Improvements

*Multiple elevator*-Add support for multiple elevator.
*Elevator capacity*-Add constraints on the number of passengers or weight limit for each trip.

## Author

Dibyani Debasmita Behera
