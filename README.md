# Plane Management System

## Introduction
The Plane Management System is a Java-based console application that allows users to manage seat bookings for a plane. It provides functionalities for buying and canceling tickets, checking seat availability, displaying seating plans, and printing ticket information.

## Features
- **Buy a Seat**: Allows users to purchase a seat by selecting a row and column and entering personal details.
- **Cancel a Seat**: Users can cancel their ticket if needed.
- **Find First Available Seat**: Finds the first available seat in the plane.
- **Show Seating Plan**: Displays a visual representation of available and sold seats.
- **Print Ticket Information and Total Sales**: Shows all sold tickets along with total sales revenue.
- **Search Ticket**: Allows users to check if a specific seat has been sold.

## Seat Pricing
- **Columns 1-5**: £200 per seat
- **Columns 6-9**: £150 per seat
- **Columns 10-14**: £180 per seat

## Usage
After running the program, you will see a menu with the following options:
```
*************************************************
*                MENU OPTIONS                   *
*************************************************
1) Buy a seat
2) Cancel a seat
3) Find first available seat
4) Seating plan
5) Print ticket information and total sales
6) Search ticket
0) Quit
*************************************************
`
## Example Usage
### Buying a Seat
```
Enter row letter (A-D): A </br>
Enter seat number (1-14): 3 </br>
Enter your name: John </br>
Enter your surname: Doe </br>
Enter your email: john.doe@example.com </br>
You have purchased the ticket successfully!
```

### Displaying Seating Plan
```
A O O X O O O O O O O O O O </br>
B O O O O O O O O O O O O </br>
C O O O O O O O O O O O O </br>
D O O O O O O O O O O O O O
```
(`X` indicates a sold seat, `O` indicates an available seat)



