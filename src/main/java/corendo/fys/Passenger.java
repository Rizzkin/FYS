/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corendo.fys;

/**
 *
 * @author Gabriel
 */
public class Passenger {
    private String Firstname;
    private String Lastname;
    private String Email;
    private String PhoneNr;
    private String Address;
    private String Zipcode;
    private String City;
    private String CountryName;

    public Passenger(String Firstname, String Lastname, String Email, String PhoneNr, String Address, String Zipcode, String City, String CountryName) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Email = Email;
        this.PhoneNr = PhoneNr;
        this.Address = Address;
        this.Zipcode = Zipcode;
        this.City = City;
        this.CountryName = CountryName;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNr() {
        return PhoneNr;
    }

    public String getAddress() {
        return Address;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public String getCity() {
        return City;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhoneNr(String PhoneNr) {
        this.PhoneNr = PhoneNr;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }
    
    
}
