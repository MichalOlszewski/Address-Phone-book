import java.io.*;

public class FileData {
//        protected  String fileName;
//        public FileWork(String fileName)
//        {
//            this.fileName = fileName;
//        }

        public static void readData(String fileName,  AddressBook book) throws IOException {

            FileReader fileRe = null;

            // odczyt wiersz po wierszu
            BufferedReader fileR = null;
            try {
                fileR = new BufferedReader(new FileReader(fileName));
                String line = fileR.readLine();
                while (line != null) {

                    String[] listData = line.split(" ");
                    book.getListName().add(listData[0]);
                    book.getListSurname().add(listData[1]);
                    book.getListPhone().add(listData[2]);
                    book.getListStreet().add(listData[3]);
                    book.getListHouseNumber().add(listData[4]);
                    book.getListFlatNumber().add(listData[5]);
                    book.getListPostcode().add(listData[6]);
                    book.getListPostOffice().add(listData[7]);
                    line = fileR.readLine();
                }
            } finally {
                if (fileR != null) {
                    fileR.close();
                }
            }
        }

        public static void writeOneData(String fileName, String stringToAdd, boolean append) throws IOException {
            FileWriter fileW = null;
            try
            {
                fileW = new FileWriter(fileName, append);
                fileW.write(stringToAdd);
            }
            finally
            {
                if (fileW != null)
                {
                    fileW.close();
                }
            }

        }

        public static void writeAllData(String fileName, AddressBook book) throws IOException
        {
            String name;
            String surname;
            String phone;
            String street;
            String houseNumber;
            String flatNumber;
            String postcode;
            String postOffice;
            String person;
            for(int i = 0; i<book.getListName().size(); i++)
            {
                name = book.getListName().get(i);
                surname = book.getListSurname().get(i);
                phone = book.getListPhone().get(i);
                street = book.getListStreet().get(i);
                houseNumber = book.getListHouseNumber().get(i);
                flatNumber = book.getListFlatNumber().get(i);
                postcode = book.getListPostcode().get(i);
                postOffice = book.getListPostOffice().get(i);
                person = name + " " + surname + " " + phone + " " + street + " " + houseNumber + " " + flatNumber + " " + postcode + " " + postOffice + "\n";
                if(i==0) writeOneData(fileName, person, false);
                else writeOneData(fileName, person, true);

            }
        }




}


