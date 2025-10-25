package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        Integer numberRomms = sc.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(numberRomms, checkIn, checkOut);
            System.out.println("Reservation: " + reservation.toString());

            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkInUpdate = sdf.parse(sc.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOutUpdate = sdf.parse(sc.next());

            Date now = new Date();
            if (checkInUpdate.before(now) || checkOutUpdate.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future.");
            } else if (!checkOutUpdate.after(checkInUpdate)){
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
            } else {
                reservation.updateDates(checkInUpdate, checkOutUpdate);
                System.out.println("Reservation: " + reservation.toString());
            }
        }












        sc.close();
    }
}
