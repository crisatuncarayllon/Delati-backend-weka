package pe.edu.unmsm.delati.entity;

import java.util.ArrayList;

public class ArbolN {
    int num_nodes;
    int leaf = 0;
    ArrayList<Node> listNodes = new ArrayList();

    public ArbolN() {
    }
    
    public void Separador(String info, String clusterInfo) {
  
        String[] values = info.split("\n");
        ArrayList<String> sinP = new ArrayList();
        ArrayList<String> conP = new ArrayList();
        
        for(int i=1; i< values.length-1; i++){
            if(values[i].indexOf('[') == -1){
                sinP.add(values[i]);}
            else{
                conP.add(values[i]);}
        }
        
        sinP.forEach((value) -> {
            
            String nameNode = value.substring(0, value.indexOf('-'));
            String nameChild = value.substring(2+value.indexOf('-'), value.length());
                
            int indexFather = Integer.parseInt(nameNode.replace("N", ""));
            int indexChild = Integer.parseInt(nameChild.replace("N", ""));
            listNodes.get(indexFather).setChildrens(nameChild);
            listNodes.get(indexChild).setParent(nameNode);
                
            
        });
        
        for(int j = 0; j < conP.size() ; j++){
            
            if(conP.get(j).contains("leaf")){
               listNodes.get(j).setType("Hoja");
               this.leaf++;
            }else{
                listNodes.get(j).setType("Nodo");
            }
            
            int min = conP.get(j).indexOf("(");
            int max = conP.get(j).indexOf(")");
            int quantity = Integer.parseInt(conP.get(j).substring(min, max).replace("(", "").replace(")", ""));
            listNodes.get(j).setNumberDat(quantity);
            
        }
        listNodes.get(0).setType("Raiz");
        
        getExtra(clusterInfo);
    }
    
    public void initNodes(int numberNodes){
        this.num_nodes = numberNodes;
        Node temporal = null;
        
        for(int i=0; i<numberNodes; i++){
            String name = "N"+i;
            temporal = new Node(name);
            this.listNodes.add(temporal);
        }
    }
    
    public  void getExtra(String clusterInfo){
        String[] clusterValues = clusterInfo.split("\n");
        
        String generalInfo = "";
        String clusteresInfo = "";
        for(int i=0; i<3; i++){
            generalInfo += clusterValues[i]+"|";
        }
        
        for(int i=clusterValues.length-this.leaf; i<clusterValues.length; i++){
            clusteresInfo += clusterValues[i]+"|";
        }
        
        Node temporal = new Node("Extra");
        temporal.setType(generalInfo);
        temporal.setParent(clusteresInfo);
        this.listNodes.add(temporal);
        
    }
    
    public ArrayList<Node> getListNodes(){
        return listNodes;
    }

    public int getLeaf() {
        return leaf;
    }
    
    
}
