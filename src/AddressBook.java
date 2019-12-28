import java.util.*;

public class AddressBook extends Address {
    static int numPeople = 0;
    protected  ArrayList<String> id = new ArrayList<String>();
    protected  ArrayList<String> listName = new ArrayList<String>();
    protected  ArrayList<String> listSurname = new ArrayList<String>();
    protected  ArrayList<String> listPhone = new ArrayList<String>();

    static int numPeople()
    {

        return numPeople;
    }
    void add(String name, String surname, String phone, String street, String houseNumber, String flatNumber, String postcode, String postOffice)
    {
        numPeople++;
        listName.add(name);
        listSurname.add(surname);
        listPhone.add(phone);
        listStreet.add(street);
        listHouseNumber.add(houseNumber);
        listFlatNumber.add(flatNumber);
        listPostcode.add(postcode);
        listPostOffice.add(postOffice);

    }
    void remove(String phone){ //podajemy nr telefonu osoby którą chcemy usunąc
        int index;

        index = listPhone.indexOf(phone);
        if (index>-1) {
            listName.remove(index);
            listSurname.remove(index);
            listPhone.remove(index);
            listStreet.remove(index);
            listHouseNumber.remove(index);
            listFlatNumber.remove(index);
            listPostcode.remove(index);
            listPostOffice.remove(index);
        }
        else
            System.out.println("Brak numeru w książce!");

    }
    void modify(String oldPhone,String name, String surname, String phone, String street, String houseNumber, String flatNumber, String postcode, String postOffice)
    {  //podajemy nr telefonu osoby którą chcemy usunąc
        int index;
        index = listPhone.indexOf(oldPhone);
        if (index>-1) {
            listName.set(index, name);
            listSurname.set(index, surname);
            listPhone.set(index, phone);
            listStreet.set(index, street);
            listHouseNumber.set(index, houseNumber);
            listFlatNumber.set(index, flatNumber);
            listPostcode.set(index, postcode);
            listPostOffice.set(index, postOffice);
        }
        else
            System.out.println("Brak numeru w książce!");
    }

    void search(String surname){
        ArrayList<Integer> listIndex = new ArrayList<>();
        for (int i = 0; i < listSurname.size(); i++)
        {
            if(listSurname.get(i).equals(surname))
            {
                //System.out.print(i);
                listIndex.add(i);
            }
        }
        for(int j = 0; j < 70; j++) System.out.print("-");
        System.out.print('\n');
        //System.out.println("Imie          |Nazwisko           |Nr telefonu|Ulica              |Nr domu|Mieszkanie|Kod pocztowy|");
        if (listIndex.size()==0 )
            System.out.println("Brak osób o podanym nazwisku!");
        else
            for(int i: listIndex)
            {
                System.out.print(String.format("%"+-15+"s", getName(i)) + '\t');
                System.out.print(String.format("%"+-20+"s",getSurname(i)) + '\t');
                System.out.print(String.format("%"+-11+"s",getPhone(i)) + '\t');
                System.out.print(String.format("%"+-20+"s",getStreet(i)) + '\t');
                System.out.print(String.format("%"+-7+"s",getHouseNumber(i)) + '\t');
                System.out.print(String.format("%"+-10+"s",getFlatNumber(i)) + '\t');
                System.out.print(String.format("%"+-5+"s",getPostcode(i)) + '\t');
                System.out.print(String.format("%"+-30+"s",getPostOffice(i)) + '\n');
            }
        for(int j = 0; j < 70; j++) System.out.print("-");
        System.out.print('\n');
    }

    void writeAll()
    {
        for(int j = 0; j < 70; j++) System.out.print("-");
        System.out.print('\n');
        for(int i = 0; i<listName.size(); i++)
        {
            System.out.print(String.format("%"+-15+"s", getName(i)) + '\t');
            System.out.print(String.format("%"+-20+"s",getSurname(i)) + '\t');
            System.out.print(String.format("%"+-10+"s",getPhone(i)) + '\t');
            System.out.print(String.format("%"+-20+"s",getStreet(i)) + '\t');
            System.out.print(String.format("%"+-4+"s",getHouseNumber(i)) + '\t');
            System.out.print(String.format("%"+-3+"s",getFlatNumber(i)) + '\t');
            System.out.print(String.format("%"+-5+"s",getPostcode(i)) + '\t');
            System.out.print(String.format("%"+-30+"s",getPostOffice(i)) + '\n');
        }
        for(int j = 0; j < 70; j++) System.out.print("-");
        System.out.print('\n');
    }
    String getName(int index){return listName.get(index);}
    String getSurname(int index){return listSurname.get(index);}
    String getPhone(int index){return listPhone.get(index);}
    ArrayList<String> getListName(){return listName;}
    ArrayList<String> getListSurname(){return listSurname;}
    ArrayList<String> getListPhone(){return listPhone;}

    void setName(String name,int index){listName.set(index, name);}
    void setSurname(String surname,int index){listSurname.set(index, surname);}
    void setPhone(String phone,int index){listPhone.set(index, phone);}
}
