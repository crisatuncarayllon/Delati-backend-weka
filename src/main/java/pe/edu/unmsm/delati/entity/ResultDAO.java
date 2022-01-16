package pe.edu.unmsm.delati.entity;

import java.io.IOException;
import java.util.ArrayList;
import pe.edu.unmsm.delati.config.Connection;
import weka.clusterers.ClusterEvaluation;
import weka.core.Instances;
import weka.core.converters.DatabaseLoader;
import weka.clusterers.Cobweb;


public class ResultDAO {
    Instances data;
    
    public ResultDAO(String Query) throws IOException{
        Connection con = new Connection();
        DatabaseLoader db_delati = con.getConnection(Query);
            
        if(Query.isEmpty()){
            db_delati = con.getConnection("select distinct o.htitulo_cat, o.htitulo \n" +
            "from webscraping w inner join oferta o on \n" +
            "(w.id_webscraping=o.id_webscraping) \n" +
            "where o.id_estado is null order by 1,2;");
        }else{
            db_delati = con.getConnection(Query);
        }
        
        data = new Instances(db_delati.getDataSet());
        
    }
    

    public ArrayList<Node> getResult(JSONQuery request){
       if(request == null){
            return null;
       }else{
           return getCobweb(request);
       }
    }
    
    public ArrayList<Node> getCobweb(JSONQuery request){
        Cobweb model = new Cobweb();
        
        try{
            model.buildClusterer(data);
            model.setAcuity(request.getAcuity());
            model.setCutoff(request.getCutoff());
            model.setDebug(request.isDebug());
            model.setDoNotCheckCapabilities(request.isDoNotCheckCapabilities());
            model.setSaveInstanceData(request.isSaveInstanceData());
            model.setSeed(request.getSeed());
            
            
            ClusterEvaluation clsEval = new ClusterEvaluation();
            clsEval.setClusterer(model);
            clsEval.evaluateClusterer(data);
            
             
            String result = clsEval.clusterResultsToString();//clsEval.clusterResultsToString();//.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;");
            
            String grafico = model.graph();
            
            ArbolN dataArbol = new ArbolN();
            dataArbol.initNodes(model.numberOfClusters());
            dataArbol.Separador(grafico, result);
           
            return dataArbol.getListNodes();
            
        }catch(Exception e){
            System.out.println("Fallo el metodo 'getCobweb': "+ e);
            return null;
        }
    }
    

    private void ClustererPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
