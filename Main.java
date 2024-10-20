import java.util.Scanner;

class Room {
    private int roomNumber;
    private String roomType;
    private boolean isAvailable;
    private double price;

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Type: " + roomType + ", Price: $" + price + ", Available: " + isAvailable;
    }
}

class Reservation {
    private String guestName;
    private Room room;
    private String reservationDate;
    private double amountPaid;

    public Reservation(String guestName, Room room, String reservationDate, double amountPaid) {
        this.guestName = guestName;
        this.room = room;
        this.reservationDate = reservationDate;
        this.amountPaid = amountPaid;
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getRoom() {
        return room;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    @Override
    public String toString() {
        return "Guest Name: " + guestName + ", Room: " + room.getRoomNumber() + " (" + room.getRoomType() + "), Date: " + reservationDate + ", Amount Paid: $" + amountPaid;
    }
}

class Hotel {
    private Room[] rooms;
    private Reservation[] reservations;
    private int reservationCount;

    public Hotel() {
        rooms = new Room[5];
        reservations = new Reservation[10];
        rooms[0] = new Room(101, "Single", 100.00);
        rooms[1] = new Room(102, "Double", 150.00);
        rooms[2] = new Room(103, "Suite", 250.00);
        rooms[3] = new Room(104, "Single", 100.00);
        rooms[4] = new Room(105, "Double", 150.00);
        reservationCount = 0;
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isAvailable()) {
                System.out.println(rooms[i]);
            }
        }
    }

    public Room findRoom(int roomNumber) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getRoomNumber() == roomNumber && rooms[i].isAvailable()) {
                return rooms[i];
            }
        }
        return null;
    }

    public void makeReservation(String guestName, int roomNumber, String date) {
        Room room = findRoom(roomNumber);
        if (room != null) {
            double amount = room.getPrice();
            processPayment(amount);
            room.setAvailable(false);
            reservations[reservationCount++] = new Reservation(guestName, room, date, amount);
            System.out.println("Reservation successful for " + guestName + " in room " + roomNumber);
        } else {
            System.out.println("Sorry, room is unavailable.");
        }
    }

    public void viewBookings() {
        if (reservationCount == 0) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("Bookings:");
            for (int i = 0; i < reservationCount; i++) {
                System.out.println(reservations[i]);
            }
        }
    }

    private void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + "...");
        System.out.println("Payment successful!");
    }
}

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View bookings");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter reservation date (e.g., 2024-10-17): ");
                    String date = scanner.nextLine();
                    hotel.makeReservation(guestName, roomNumber, date);
                    break;
                case 3:
                    hotel.viewBookings();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}