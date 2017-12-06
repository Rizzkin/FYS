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
public class Brand {
    private int  id;
    private String Brand;

    /**
     * This constructor connects the given values to the right attributes
     * @param id represents all id's for the object
     * @param Brand represents all Brand for the object
     */
    public Brand(int id, String Brand) {
        this.id = id;
        this.Brand = Brand;
    }

    
    public int getId() {
        return id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
    
    
}
