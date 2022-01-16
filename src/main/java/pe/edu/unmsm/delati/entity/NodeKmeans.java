/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.delati.entity;

import java.util.ArrayList;

/**
 *
 * @author CHRISTOPER
 */
public class NodeKmeans {
    private String Cluster;
    private double length;
    private double Percentage;
    private ArrayList<Object> title_cluster;

    public NodeKmeans(String Cluster, double length, ArrayList<Object> title_cluster) {
        this.Cluster = Cluster;
        this.length = length;
        this.title_cluster = title_cluster;
    }

    
    public String getCluster() {
        return Cluster;
    }

    public void setCluster(String Cluster) {
        this.Cluster = Cluster;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPercentage() {
        return Percentage;
    }

    public void setPercentage(double Percentage) {
        this.Percentage = Percentage;
    }

    public ArrayList<Object> getTitle_cluster() {
        return title_cluster;
    }

    public void setTitle_cluster(ArrayList<Object> title_cluster) {
        this.title_cluster = title_cluster;
    }


    
    
}
