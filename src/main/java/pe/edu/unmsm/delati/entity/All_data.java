/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.delati.entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author CHRISTOPER
 */
public class All_data {
    ArrayList<HashMap> data = new ArrayList<>();

    public All_data() {
    }

    public ArrayList<HashMap> getData() {
        return data;
    }

    public void setData(ArrayList<HashMap> data) {
        this.data = data;
    }
    
    

    public void addData(HashMap<String, Object> data_temporal) {
        data.add(data_temporal);
    }
    
}
