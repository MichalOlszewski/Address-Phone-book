import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        AddressBook book = new AddressBook();
        FileData.readData("dane.txt", book);


        System.out.println("WITAMY W INTERAKTYWNEJ KSIĄŻCE TELEFONICZNEJ");
        boolean run = true;
        while (run) {
            System.out.println("Wybierz odpowiednią cyfrę:");
            System.out.println("1. - Wyświetl całą książke");
            System.out.println("2. - Wyświetl osobę o konkretnym nazwisku");
            System.out.println("3. - Dodaj nową osobę do książki");
            System.out.println("4. - Usuń osobę o wskazanym numerze telefonu");
            System.out.println("5. - Zmodyfikuj dane osoby o wskazanym numerze telefonu");
            System.out.println("6. - Zakończ pracę z książką");

            int option = scan.nextInt();

            switch (option) {
                case 1:
                    book.writeAll();
                    break;
                case 2:
                    System.out.println("Podaj nazwisko osoby, którą chcesz wyszukać:");
                    String surname = scan.next();
                    System.out.println("");
                    book.search(surname);
                    break;
                case 3:
                    System.out.print("Podaj imię: ");
                    String name = getName();

                    System.out.print("Podaj nazwisko: ");
                    surname = getName();

                    System.out.print("Podaj telefon: ");
                    String phone = getPhoneNumber(book);
                    System.out.println("");

                    System.out.print("Podaj ulicę: ");
                    String street = scan.next();
                    System.out.println("");

                    System.out.print("Podaj numer domu: ");
                    String houseNumber = getHouseNumber();
                    System.out.println("");

                    System.out.print("Podaj numer mieszkania lub wpisz \"-\" jeśli nie dotyczy: ");
                    String flatNumber = scan.next();
                    System.out.println("");

                    System.out.print("Podaj kod pocztowy: ");
                    String postcode = scan.next();
                    System.out.println("");

                    System.out.print("Podaj urząd pocztowy: ");
                    String postOffice = scan.next();
                    System.out.println("");

                    String personalData = name + " " + surname + " " + phone + " " + street + " " + houseNumber + " " + flatNumber + " " + postcode + " " + postOffice + '\n';
                    FileData.writeOneData("dane.txt", personalData, true);

                    book.add(name, surname, phone, street, houseNumber, flatNumber, postcode, postOffice);
                    break;
                case 4:
                    System.out.println("Podaj numer osoby, którą chcesz usunąć:");
                    phone = scan.next();
                    book.remove(phone);
                    break;
                case 5:
                    System.out.println("Podaj numer osoby, której dane chcesz zmodyfikować::");
                    String oldPhone = scan.next();

                    System.out.print("Podaj imię: ");
                    name = scan.next();
                    System.out.println("");

                    System.out.print("Podaj nazwisko: ");
                    surname = scan.next();
                    System.out.println("");

                    System.out.print("Podaj telefon: ");
                    phone = scan.next();
                    System.out.println("");

                    System.out.print("Podaj ulicę: ");
                    street = scan.next();
                    System.out.println("");

                    System.out.print("Podaj numer domu: ");
                    houseNumber = scan.next();
                    System.out.println("");

                    System.out.print("Podaj numer mieszkania lub wpisz \"-\" jeśli nie dotyczy: ");
                    flatNumber = scan.next();
                    System.out.println("");

                    System.out.print("Podaj kod pocztowy: ");
                    postcode = scan.next();
                    System.out.println("");

                    System.out.print("Podaj urząd pocztowy: ");
                    postOffice = scan.next();
                    System.out.println("");

                    book.modify(oldPhone, name, surname, phone, street, houseNumber, flatNumber, postcode, postOffice);
                    break;
                case 6:
                    run = false;
                    FileData.writeAllData("dane.txt", book);
                    break;
                default:
                    System.out.println("Wybrano liczbę poza zakresu!");
                    break;
            }


        }
    }

    public static String getName() {

        String name = "";
        try {
            name = scan.next();
            if (name.matches(".*\\d.*") || name.matches("[a-z]*"))
                throw new IllegalArgumentException();

        } catch (IllegalArgumentException exception) {
            System.out.print("Dozwolone są tylko litery! Pierwsza litera musi być wersalikiem!\n Podaj ponownie: ");
            getName();
        }
        return name;
    }

    public static String getPhoneNumber(AddressBook book) {

        String number = "";
        try {
            number = scan.next();
            if (!number.matches("^\\d{9}$"))
                throw new IllegalCharException(" 9 ");
            else if (book.listPhone.contains(number))
                throw new NumberAlreadySavedException();

        } catch (IllegalCharException exception) {

            getPhoneNumber(book);
        } catch (NumberAlreadySavedException exception) {
            getPhoneNumber(book);
        }
        return number;
    }

    public static String getHouseNumber() {

        String number = "";
        try {
            number = scan.next();
            if (!number.matches("\\d*\\d*"))
                throw new IllegalCharException("");

        } catch (IllegalCharException exception) {
            getHouseNumber();
        }
        return number;
    }
}
class IllegalCharException extends Exception{
    public IllegalCharException(String num){
        System.out.println("Numer powinien składać się z" + num + "cyfr!\n Podaj ponownie: ");
        }
}
class NumberAlreadySavedException extends Exception
{
    public NumberAlreadySavedException(){
        System.out.println("Podany numer jest już zapisany! \nPodaj ponownie: ");
    }
}
