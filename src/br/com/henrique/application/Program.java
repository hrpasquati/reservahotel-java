package br.com.henrique.application;

import br.com.henrique.model.Exception.DomainException;
import br.com.henrique.model.entities.Reservation;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());

            Reservation r1 = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + r1);


            System.out.println();
            System.out.println("Enter date to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

            r1.updateDates(checkin, checkout);
            System.out.println("Updated Reservation: " + r1);
        } catch (ParseException e){
            System.out.println("Invalid date format!");
        }
        catch (DomainException e){
            System.out.println("Error in reservatio: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

    }
}
