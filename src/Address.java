import java.util.ArrayList;

public class Address {

    protected ArrayList<String> listStreet = new ArrayList<String>();
    protected  ArrayList<String> listHouseNumber = new ArrayList<String>();
    protected  ArrayList<String> listFlatNumber = new ArrayList<String>();
    protected  ArrayList<String> listPostcode = new ArrayList<String>();
    protected  ArrayList<String> listPostOffice = new ArrayList<String>();


    String getStreet(int index){return listStreet.get(index);}
    String getHouseNumber(int index){return listHouseNumber.get(index);}
    String getFlatNumber(int index){return listFlatNumber.get(index);}
    String getPostcode(int index){return listPostcode.get(index);}
    String getPostOffice(int index){return listPostOffice.get(index);}

    ArrayList<String> getListStreet(){return listStreet;}
    ArrayList<String> getListHouseNumber(){return listHouseNumber;}
    ArrayList<String> getListFlatNumber(){return listFlatNumber;}
    ArrayList<String> getListPostcode(){return listPostcode;}
    ArrayList<String> getListPostOffice(){return listPostOffice;}

    void setStreet(String street,int index){ listStreet.set(index, street);}
    void setHouseNumber(String houseNumber,int index){ listHouseNumber.set(index, houseNumber);}
    void setFlatNumber(String flatNumber,int index){ listFlatNumber.set(index, flatNumber);}
    void setPostcode(String postcode,int index){ listPostcode.set(index,postcode);}
    void setPostOffice(String postOffice,int index){ listPostOffice.set(index, postOffice);}

}


