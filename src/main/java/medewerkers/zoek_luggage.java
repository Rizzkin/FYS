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
    private String DataFound;
    private String TimeFound;
    private String LuggageType;
    private String Brand;
    private String Passenger;
    private String Status;

    public zoek_luggage(String RegistrationNr, String DataFound, String TimeFound, String LuggageType, String Brand, String Passenger, String Status) {
        this.RegistrationNr = RegistrationNr;
        this.DataFound = DataFound;
        this.TimeFound = TimeFound;
        this.LuggageType = LuggageType;
        this.Brand = Brand;
        this.Passenger = Passenger;
        this.Status = Status;
    }

    public String getRegistrationNr() {
        return RegistrationNr;
    }

    public String getDataFound() {
        return DataFound;
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

    public String getPassenger() {
        return Passenger;
    }

    public String getStatus() {
        return Status;
    }

    public void setRegistrationNr(String RegistrationNr) {
        this.RegistrationNr = RegistrationNr;
    }

    public void setDataFound(String DataFound) {
        this.DataFound = DataFound;
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

    public void setPassenger(String Passenger) {
        this.Passenger = Passenger;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
