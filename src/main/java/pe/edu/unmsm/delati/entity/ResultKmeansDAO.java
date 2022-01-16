/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.delati.entity;

import java.io.IOException;
import pe.edu.unmsm.delati.config.Connection;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.DatabaseLoader;


/**
 *
 * @author CHRISTOPER
 */
public class ResultKmeansDAO {
    Instances data=null;
    SimpleKMeans kmeans;
    
    public ResultKmeansDAO(String Query) throws IOException{
        Connection con = new Connection();
        DatabaseLoader db_giinwedb = con.getConnection(Query);
        if(Query.isEmpty()){
            db_giinwedb = con.getConnection("select distinct o.htitulo_cat, o.htitulo \n" +
            "from webscraping w inner join oferta o on \n" +
            "(w.id_webscraping=o.id_webscraping) \n" +
            "where o.id_estado is null order by 1,2;");
        }else{
            db_giinwedb = con.getConnection(Query);
        }
        
        data = new Instances(db_giinwedb.getDataSet());
    }
    
    public ResultKmeans getResult(JSONQueryKmeans request){
        if(request==null){
            return null;
        }else{
            return getKmeans(request);
        }
    }
    //ArrayList<NodeKmeans>
    
    public ResultKmeans getKmeans(JSONQueryKmeans request){
        kmeans = new SimpleKMeans();
        
        try{
            
            kmeans.setPreserveInstancesOrder(true);
            kmeans.setSeed(10);
            kmeans.setInitializationMethod(request.getInit());
            kmeans.setNumClusters(request.getN_clusters());
            kmeans.setMaxIterations(request.getMax_iter());
            kmeans.buildClusterer(data);
            double[] sizes=kmeans.getClusterSizes();
            Instances instancias = kmeans.getClusterCentroids();
            ResultKmeans result = new ResultKmeans();
            result.initNodes(sizes,instancias);
            result.setTotal_instances(data.size());
            result.init_centroids(instancias);
            result.init_columns(data);
            result.init_data(data,kmeans.getAssignments());
           
            /*OTRAS PRUEBAS
            NO SE ENCONTRO VARIANZA, INERCIA, NUMERO DE ITERACIONES EJECUTADAS 
            DISTANCIA DE CADA CLUSTER
            */
            System.out.println(kmeans);
            
            
           
            return result;
        }catch(Exception e1){
            System.out.println("Fallo el metodo 'getKmeans': "+ e1);
            return null;
        }
    }
}
