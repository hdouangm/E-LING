/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.responsableLaboratoire.domain;

import java.util.ArrayList;

/**
 *
 * @author Reda Amhaouch
 */
public class DMP {
    private int id;
    private String name;
    
    public DMP(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
        
    public static ArrayList<DMP> getAllDMPs(){
        ArrayList<DMP> DMPs = new ArrayList<>();
        DMP d1 = new DMP(1, "DMP 1");
        DMP d2 = new DMP(2, "DMP 2");
        DMP d3 = new DMP(3, "DMP 3");
        
        DMPs.add(d3);
        DMPs.add(d1);
        DMPs.add(d2);

        return DMPs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
