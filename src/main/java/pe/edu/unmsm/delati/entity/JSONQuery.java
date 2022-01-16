/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.delati.entity;

/**
 *
 * @author Lenovo Legion Y520
 */
public class JSONQuery {
    private String type;
    private String query;
    private double acuity;
    private double cutoff;
    private boolean debug;
    private boolean doNotCheckCapabilities;
    private boolean saveInstanceData;
    private int seed;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public double getAcuity() {
        return acuity;
    }

    public void setAcuity(double acuity) {
        this.acuity = acuity;
    }

    public double getCutoff() {
        return cutoff;
    }

    public void setCutoff(double cutoff) {
        this.cutoff = cutoff;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isDoNotCheckCapabilities() {
        return doNotCheckCapabilities;
    }

    public void setDoNotCheckCapabilities(boolean doNotCheckCapabilities) {
        this.doNotCheckCapabilities = doNotCheckCapabilities;
    }

    public boolean isSaveInstanceData() {
        return saveInstanceData;
    }

    public void setSaveInstanceData(boolean saveInstanceData) {
        this.saveInstanceData = saveInstanceData;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
    
    
    
    @Override
    public String toString() {
        return "TIPO: "+getType()+"\nQuery: "+getQuery();
    }
}
