/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medewerkers;

/**
 *
 * @author Gabriel
 */
public class zoek_luggage {
    
    private String RegistrationNr;
    private String DateFound;
    private String TimeFound;
    private String LuggageType;
    private String Brand;
    private String Firstname;
    private String Status;

    public zoek_luggage(String RegistrationNr, String DateFound, String TimeFound, String LuggageType, String Brand, String Firstname, String Status) {
        this.RegistrationNr = RegistrationNr;
        this.DateFound = DateFound;
        this.TimeFound = TimeFound;
        this.LuggageType = LuggageType;
        this.Brand = Brand;
        this.Firstname = Firstname;
        this.Status = Status;
    }

    public String getRegistrationNr() {
        return RegistrationNr;
    }

    public String getDateFound() {
        return DateFound;
    }

    public String getTimeFound() {
        return TimeFound;
    }

    public String getLuggageType() {
        return LuggageType;
    }

    public String getBrand() {
        return Brand;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getStatus() {
        return Status;
    }

    public void setRegistrationNr(String RegistrationNr) {
        this.RegistrationNr = RegistrationNr;
    }

    public void setDateFound(String DateFound) {
        this.DateFound = DateFound;
    }

    public void setTimeFound(String TimeFound) {
        this.TimeFound = TimeFound;
    }

    public void setLuggageType(String LuggageType) {
        this.LuggageType = LuggageType;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
