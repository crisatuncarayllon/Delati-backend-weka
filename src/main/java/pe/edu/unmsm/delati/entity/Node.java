package pe.edu.unmsm.delati.entity;

import java.util.ArrayList;

public class Node {
    private String identifier;
    private String type;
    private String parentName;
    private int numberDat;

    
    private ArrayList<String> childrensName;
    
    public Node(String nameData) {
        this.childrensName = new ArrayList();
        this.identifier = nameData;
        this.parentName = "---";
        this.type = "";
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ArrayList<String> getChildrens() {
        return childrensName;
    }

    public void setChildrens(String child) {
        this.childrensName.add(child);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParent() {
        return parentName;
    }

    public void setParent(String parent) {
        this.parentName = parent;
    }
    
    public int getNumberDat() {
        return numberDat;
    }

    public void setNumberDat(int numberDat) {
        this.numberDat = numberDat;
    }
    
    @Override
    public String toString() {
        return "Identifier: "+getIdentifier()+"\nType: "+getType()+"\nParent: "+getParent()+"\nNumero de Datos: "+getNumberDat()+"\n";
    }
}
