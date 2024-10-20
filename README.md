# Hotel Reservation System

### Author Information
- **Name**: Lokesh Krishna R
- **Company**: CodeAlpha
- **ID**: CA/O3/42169
- **Domain**: Java Programming
- **Duration**: October 1 to 30

---

## Overview

This Java-based Hotel Reservation System allows users to check for available rooms, make reservations, and view bookings. It is a console-based application that demonstrates basic OOP concepts such as classes, objects, and encapsulation.

## Features

- **Room Management**: Displays available rooms based on their availability.
- **Reservation System**: Users can book rooms by providing their details, select room types, and pay.
- **Bookings Display**: Allows users to view all bookings made during the session.

## Classes

### 1. Room
This class represents a hotel room and stores details like:
- Room Number
- Room Type
- Price
- Availability

### 2. Reservation
This class stores reservation details such as:
- Guest Name
- Room Reserved
- Reservation Date
- Amount Paid

### 3. Hotel
This class manages:
- A list of rooms
- Current reservations
- Checking room availability
- Making new reservations
- Viewing existing bookings

### 4. Main
The `Main` class runs the program and provides a menu-driven system for user interaction.

## How to Run

1. **Compile** the program:
   ```bash
   javac Main.java
   ```

2. **Run** the program:
   ```bash
   java Main
   ```

3. **Menu Options**:
   - Search for available rooms
   - Make a reservation
   - View bookings
   - Exit the system

## Example Usage

- **Check Available Rooms**:
  ```bash
  Hotel Reservation System
  1. Search for available rooms
  2. Make a reservation
  3. View bookings
  4. Exit
  1

  Available Rooms:
  Room Number: 101, Type: Single, Price: $100.0, Available: true
  Room Number: 102, Type: Double, Price: $150.0, Available: true
  ```

- **Make a Reservation**:
  ```bash
  Enter your name: John Doe
  Enter room number to book: 101
  Enter reservation date (e.g., 2024-10-17): 2024-10-17

  Processing payment of $100.0...
  Payment successful!
  Reservation successful for John Doe in room 101
