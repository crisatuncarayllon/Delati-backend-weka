/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.delati.entity;

import java.util.ArrayList;
import java.util.HashMap;
import weka.core.Instances;

/**
 *
 * @author CHRISTOPER
 */
public class ResultKmeans {
    
    ArrayList<NodeKmeans> clusters = new ArrayList();
    ArrayList<Cluster_Centroid> centroids = new ArrayList();
    ArrayList<String> columns = new ArrayList();
    All_data data = new All_data();
    
    String n_iter ="";
    int total_instances=0;
    
    private double sumaTotal=0;
    public ResultKmeans() {
    }
    
    public void initNodes(double[] nodes, Instances instancias){
        NodeKmeans temporal = null;
        
        int num=instancias.get(0).numAttributes()+1;
        for(int i=0; i<nodes.length;i++){
            ArrayList<Object> titulosTemporales =new ArrayList<>();
            String name = "cluster "+(i+1);
            Object temporalTitle;
            for(int k=0; k<num;k++){
                if(k<num-1){
                    temporalTitle=instancias.get(i).stringValue(k);
                }else{
                    temporalTitle=i+1;
                } 
                titulosTemporales.add(temporalTitle);
            }
            sumaTotal=sumaTotal+nodes[i];
            temporal = new NodeKmeans(name,nodes[i],titulosTemporales);
            this.clusters.add(temporal);
        }
        modifyPerce(nodes);
    }
    
    public void modifyPerce(double[] nodes){
        for(int i = 0; i<clusters.size();i++){
            Double temporal=(nodes[i]/sumaTotal)*100;
            String porcentajeFormateado= String.format("%.02f",temporal );
            String temp2 = porcentajeFormateado.replace(",", ".");
            Double porc=Double.parseDouble(temp2);
            clusters.get(i).setPercentage(porc);
        }
    }

    
    
    public ArrayList<NodeKmeans> getClusters() {
        return clusters;
    }

    public void setClusters(ArrayList<NodeKmeans> clusters) {
        this.clusters = clusters;
    }

    public String getN_iter() {
        return n_iter;
    }

    public void setN_iter(String n_iter) {
        this.n_iter = n_iter;
    }

    public int getTotal_instances() {
        return total_instances;
    }

    public void setTotal_instances(int total_instances) {
        this.total_instances = total_instances;
    }

    public ArrayList<Cluster_Centroid> getCentroids() {
        return centroids;
    }

    public void setCentroids(ArrayList<Cluster_Centroid> centroids) {
        this.centroids = centroids;
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<String> columns) {
        this.columns = columns;
    }

    public All_data getData() {
        return data;
    }

    public void setData(All_data data) {
        this.data = data;
    }
    
    
    //PARA VER LOS PUNTOS O COORDENADAS DE CADA CLUSTER DE ACUERDO A CADA ATRIBUTO
    
    public void init_centroids(Instances instancias){
        int num=instancias.get(0).numAttributes()+1;
        for(int i=0;i<instancias.numInstances();i++){
            ArrayList<Object> titulo_array =new ArrayList<>();
            Object titulo_cluster=i;    
            double[] puntos_cluster=instancias.get(i).toDoubleArray();
                
            for(int k=0;k<num;k++){
                titulo_cluster=i+1;
                if(k<num-1){
                    titulo_cluster=instancias.get(i).stringValue(k);
                }
                titulo_array.add(titulo_cluster);
            }
                
                Cluster_Centroid temp = new Cluster_Centroid(titulo_array, puntos_cluster);
                this.centroids.add(temp);
            }
        
        
    }
    
    public void init_columns(Instances instancias){
            //PARA OBTENER EL NOMBRE DE CADA COLUMNA
            for(int i=0;i<instancias.numAttributes();i++){
                columns.add(instancias.get(0).attribute(i).name());
            }
    }
    
    
                
    
    
    public void init_data(Instances instancias, int[] cluster_assig){
        //PARA OBTENER LOS DATOS DE CADA FILA POR COLUMNA (I)
        for(int i=0;i<instancias.numInstances();i++){  
            HashMap<String, Object> data_temporal=new HashMap<String, Object>();
            int num=instancias.get(i).numAttributes()+2;
            String clave_temp;
            Object valor_temp;
            for(int k=0;k<num;k++){
                if(k<num-2){
                    clave_temp=instancias.get(i).attribute(k).name();
                    valor_temp=instancias.get(i).stringValue(k);       
                }else if(k==num-2){
                    clave_temp="index";
                    valor_temp=instancias.get(i).index(i)+1;
                    //valor_temp=String.valueOf(instancias.get(i).index(i));
                }else{
                    clave_temp="cluster";
                    valor_temp=cluster_assig[i];
                    
                }
                if(clave_temp=="?"){
                    clave_temp=null;
                }
                if(valor_temp=="?"){
                    valor_temp=null;
                }
                data_temporal.put(clave_temp,valor_temp);
            }
            data.addData(data_temporal);
                
        }
    }
}
