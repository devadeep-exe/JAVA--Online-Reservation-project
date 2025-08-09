This is a Java console-based application that simulates a real-world train reservation system.
It uses JDBC to connect with a MySQL database for storing and managing reservation data.

The project includes:
1)User authentication (Login module)
2)Ticket reservation with PNR generation
3)Random seat, berth, and coach assignment based on travel class
4)Ticket cancellation using PNR number
5)Database storage & retrieval of all ticket details

Modules:
 1)Login Module – Validates user credentials stored in MySQL.
 2)Reservation Module – Books tickets, generates PNR, assigns seat number, berth type, and coach number.
 3)Cancellation Module – Cancels booked tickets using PNR.
 4)Database Module – Handles all ticket & user data using MySQL.
