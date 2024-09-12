import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// ElevatorRequest class to represent a request made to the elevator
class ElevatorRequest {
    private int targetFloor;

    public ElevatorRequest(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }
}

// Elevator class to represent the elevator's movement and operations
class Elevator {
    private int currentFloor;
    private PriorityQueue<Integer> requestQueue;  // Min-heap to maintain the floor request priority
    private boolean movingUp;

    public Elevator() {
        this.currentFloor = 0;  // Assuming elevator starts at ground floor
        this.requestQueue = new PriorityQueue<>();
        this.movingUp = true;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    // Request a floor
    public void requestFloor(int floor) {
        System.out.println("Requesting floor: " + floor);
        requestQueue.add(floor);
    }

    // Move the elevator to the next requested floor
    public void move() {
        while (!requestQueue.isEmpty()) {
            int targetFloor = requestQueue.poll();

            if (targetFloor > currentFloor) {
                moveUp(targetFloor);
            } else if (targetFloor < currentFloor) {
                moveDown(targetFloor);
            }

            stopAtFloor(targetFloor);
        }
        System.out.println("All requests completed. Elevator is at floor: " + currentFloor);
    }

    // Moves the elevator up to the requested floor
    private void moveUp(int targetFloor) {
        System.out.println("Elevator moving up...");
        while (currentFloor < targetFloor) {
            currentFloor++;
            System.out.println("Elevator at floor: " + currentFloor);
        }
    }

    // Moves the elevator down to the requested floor
    private void moveDown(int targetFloor) {
        System.out.println("Elevator moving down...");
        while (currentFloor > targetFloor) {
            currentFloor--;
            System.out.println("Elevator at floor: " + currentFloor);
        }
    }

    // Simulate stopping the elevator at a floor
    private void stopAtFloor(int floor) {
        System.out.println("Elevator stopping at floor: " + floor);
    }
}

// Building class to manage elevator requests
class Building {
    private Elevator elevator;
    private int totalFloors;

    public Building(int totalFloors) {
        this.elevator = new Elevator();
        this.totalFloors = totalFloors;
    }

    // Handles incoming requests from users
    public void handleRequests(List<ElevatorRequest> requests) {
        for (ElevatorRequest request : requests) {
            int floor = request.getTargetFloor();
            if (floor >= 0 && floor <= totalFloors) {
                elevator.requestFloor(floor);
            } else {
                System.out.println("Invalid floor request: " + floor);
            }
        }

        elevator.move();
    }
}

public class ElevatorSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a building with 10 floors
        Building building = new Building(10);

        // Taking multiple requests from the user
        List<ElevatorRequest> requests = new ArrayList<>();
        System.out.println("Enter the number of floor requests: ");
        int numberOfRequests = scanner.nextInt();

        for (int i = 0; i < numberOfRequests; i++) {
            System.out.println("Enter the requested floor (0-10): ");
            int floor = scanner.nextInt();
            requests.add(new ElevatorRequest(floor));
        }

        // Handle the elevator requests
        building.handleRequests(requests);
    }
}