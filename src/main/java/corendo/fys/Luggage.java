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
public class Luggage {
    
    private String RegistrationNr;
    private String DataFound;
    private String TimeFound;
    private String LuggageType;
    private String Brand;
    private String ArrivedFlight;
    private String LuggageTag;
    private String LocationFound;
    private String MainColor;
    private String SecondColor;
    private String Size;
    private String Weight;
    private String Image;
    private String Status;

    public Luggage(String RegistrationNr, String DataFound, String TimeFound, String LuggageType, String Brand, String ArrivedFlight, String LuggageTag, String LocationFound, String MainColor, String SecondColor, String Size, String Weight, String Image, String Status) {
        this.RegistrationNr = RegistrationNr;
        this.DataFound = DataFound;
        this.TimeFound = TimeFound;
        this.LuggageType = LuggageType;
        this.Brand = Brand;
        this.ArrivedFlight = ArrivedFlight;
        this.LuggageTag = LuggageTag;
        this.LocationFound = LocationFound;
        this.MainColor = MainColor;
        this.SecondColor = SecondColor;
        this.Size = Size;
        this.Weight = Weight;
        this.Image = Image;
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

    public String getArrivedFlight() {
        return ArrivedFlight;
    }

    public String getLuggageTag() {
        return LuggageTag;
    }

    public String getLocationFound() {
        return LocationFound;
    }

    public String getMainColor() {
        return MainColor;
    }

    public String getSecondColor() {
        return SecondColor;
    }

    public String getSize() {
        return Size;
    }

    public String getWeight() {
        return Weight;
    }

    public String getImage() {
        return Image;
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

    public void setArrivedFlight(String ArrivedFlight) {
        this.ArrivedFlight = ArrivedFlight;
    }

    public void setLuggageTag(String LuggageTag) {
        this.LuggageTag = LuggageTag;
    }

    public void setLocationFound(String LocationFound) {
        this.LocationFound = LocationFound;
    }

    public void setMainColor(String MainColor) {
        this.MainColor = MainColor;
    }

    public void setSecondColor(String SecondColor) {
        this.SecondColor = SecondColor;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public void setWeight(String Weight) {
        this.Weight = Weight;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    
}
