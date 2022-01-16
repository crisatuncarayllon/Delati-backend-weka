/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.delati.entity;

import weka.clusterers.SimpleKMeans;
import weka.core.SelectedTag;

/**
 *
 * @author CHRISTOPER
 */
public class JSONQueryKmeans {
    private String type;
    private String query;
    private int n_clusters;
    private String init;// si es 0 se referira a "random"
    private int max_iter;
    private int n_init;
    private int random_state;
    private int axis_x;
    private int axis_y;

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

    public int getN_clusters() {
        return n_clusters;
    }

    public void setN_clusters(int n_clusters) {
        this.n_clusters = n_clusters;
    }

    public SelectedTag getInit() {
        SelectedTag _init=null;
        if(init.equals("random")){
            _init= new SelectedTag(SimpleKMeans.RANDOM, SimpleKMeans.TAGS_SELECTION);
        }else if(init.equals("k-means++")){
            _init= new SelectedTag(SimpleKMeans.KMEANS_PLUS_PLUS, SimpleKMeans.TAGS_SELECTION);
        }/*else if(init==2){
            _init= new SelectedTag(SimpleKMeans.CANOPY, SimpleKMeans.TAGS_SELECTION);
        }else if(init==3){
            _init= new SelectedTag(SimpleKMeans.FARTHEST_FIRST, SimpleKMeans.TAGS_SELECTION);
        }*/
         
        return _init;
    }

    public void setInit(String init) {
        this.init = init;
    }

 
    
    public int getMax_iter() {
        return max_iter;
    }

    public void setMax_iter(int max_iter) {
        this.max_iter = max_iter;
    }

    public int getN_init() {
        return n_init;
    }

    public void setN_init(int n_init) {
        this.n_init = n_init;
    }

    public int getRandom_state() {
        return random_state;
    }

    public void setRandom_state(int random_state) {
        this.random_state = random_state;
    }

    public int getAxis_x() {
        return axis_x;
    }

    public void setAxis_x(int axis_x) {
        this.axis_x = axis_x;
    }

    public int getAxis_y() {
        return axis_y;
    }

    public void setAxis_y(int axis_y) {
        this.axis_y = axis_y;
    }

    
    @Override
    public String toString() {
        return "JSONQueryKmeans{" + "type=" + type + ", query=" + query + '}';
    }
    
    
}
