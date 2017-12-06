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
public class Record {
    private String registrationNr;
    private String DataFound;
    private String TimeFound;
    private String LuggageType;
    private String Brand;

    public Record(String registrationNr, String DataFound, String TimeFound, 
            String LuggageType, String Brand) {
        this.registrationNr = registrationNr;
        this.DataFound = DataFound;
        this.TimeFound = TimeFound;
        this.LuggageType = LuggageType;
        this.Brand = Brand;
    }

    public String getRegistrationNr() {
        return registrationNr;
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

    public void setRegistrationNr(String registrationNr) {
        this.registrationNr = registrationNr;
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

    
    
}
