import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
                    String name="", phone="", houseNumber="", flatNumber="", postCode="", postOffice="";
                    surname="";
                    boolean inputOK = false;
                    while (!inputOK) {
                        try {
                            System.out.print("Podaj imię: ");
                            name = scan.next();
                            if (!name.matches("[A-Z][a-zA-Z]*"))
                                throw new InputMismatchException();
                            else inputOK = true;
                        }
                        catch(Exception e) {
                            System.out.println("Imię musi zaczynać się wersalikiem oraz zawierać tylko litery!");
                        }
                    }

                    inputOK = false;
                    while (!inputOK) {
                        try {
                            System.out.print("Podaj nazwisko: ");
                            surname = scan.next();
                            if (!surname.matches("[A-Z][a-zA-z]*(['-][a-zA-Z]+)*"))
                                throw new InputMismatchException();
                            else inputOK = true;
                        }
                        catch(Exception e) {
                            System.out.println("Nazwisko musi zaczynać się wersalikiem, może zawierać litery i myślnik!");
                        }
                    }

                    inputOK = false;
                    while (!inputOK) {
                        try {
                            System.out.print("Podaj numer telefonu: ");
                            phone = scan.next();
                            if (!phone.matches("[0-9]{9}"))
                                throw new InputMismatchException();
                            else inputOK = true;
                        }
                        catch(Exception e) {
                            System.out.println("Numer telefonu musi składac się z dziewięciu cyfr!");
                        }
                    }

                    System.out.print("Podaj ulicę: ");
                    String street = scan.nextLine();

                    inputOK = false;
                    while (!inputOK) {
                        try {
                            System.out.print("Podaj numer domu: ");
                            houseNumber = scan.next();
                            if (!houseNumber.matches("[0-9]+"))
                                throw new InputMismatchException();
                            else inputOK = true;
                        }
                        catch(Exception e) {
                            System.out.println("Numer domu musi być liczbą!");
                        }
                    }

                    inputOK = false;
                    while (!inputOK) {
                        try {
                            System.out.print("Podaj numer mieszkania: ");
                            flatNumber = scan.next();
                            if (!flatNumber.matches("^[0-9]+$|^[-]$"))
                                throw new InputMismatchException();
                            else inputOK = true;
                        }
                        catch(Exception e) {
                            System.out.println("Numer mieszkania musi być liczbą lub '-'!");
                        }
                    }

                    inputOK = false;
                    while (!inputOK) {
                        try {
                            System.out.print("Podaj kod pocztowy: ");
                            postCode = scan.next();
                            if (!postCode.matches("^(\\d){2}[-](\\d){3}$"))
                                throw new InputMismatchException();
                            else inputOK = true;
                        }
                        catch(Exception e) {
                            System.out.println("Kod pocztowy musi mieć format \"dd-ddd\", gdzie d jest cyfrą!");
                        }
                    }

                    inputOK = false;
                    while (!inputOK) {
                        try {
                            System.out.print("Podaj miejscowość: ");
                            postOffice = scan.nextLine();
                            if (!postOffice.matches("^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+$|^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+\\s[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+$"))
                                throw new InputMismatchException();
                            else inputOK = true;
                        }
                        catch(Exception e) {
                            System.out.println("Nazwa miejscowości musi zaczynać się wersalikiem i zawierać tylko litery!");
                        }
                    }

                    String personalData = name + " " + surname + " " + phone + " " + street + " " + houseNumber + " " + flatNumber + " " + postCode + " " + postOffice + '\n';
                    FileData.writeOneData("dane.txt", personalData, true);

                    book.add(name, surname, phone, street, houseNumber, flatNumber, postCode, postOffice);
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
                    postCode = scan.next();
                    System.out.println("");

                    System.out.print("Podaj urząd pocztowy: ");
                    postOffice = scan.next();
                    System.out.println("");

                    book.modify(oldPhone, name, surname, phone, street, houseNumber, flatNumber, postCode, postOffice);
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
}

