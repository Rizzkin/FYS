/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supervisor;

/**
 *
 * @author Gabriel
 */
public class LuggageType {
    private int  id;
    private String LuggageType;

    public LuggageType(int id, String LuggageType) {
        this.id = id;
        this.LuggageType = LuggageType;
    }

    public int getId() {
        return id;
    }

    public String getLuggageType() {
        return LuggageType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLuggageType(String LuggageType) {
        this.LuggageType = LuggageType;
    }
    
    
}
