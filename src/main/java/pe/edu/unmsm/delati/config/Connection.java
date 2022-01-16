package pe.edu.unmsm.delati.config;

import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.converters.DatabaseLoader;


public class Connection {
 
    public DatabaseLoader getConnection(String query){
        
    DatabaseLoader delati;
    String url = "jdbc:postgresql://128.199.1.222:5432/giinwedb";//Se ha cambiado la base de datos delati por giinwebd
    String user = "modulo4";
    String pwd = "modulo4";
    
    
        try {
            delati = new DatabaseLoader();
            delati.setUrl(url);
            delati.setUser(user);
            delati.setPassword(pwd);
            delati.setQuery(query);
            delati.setSource(delati.getUrl(), delati.getUser(), delati.getPassword());
            
            return delati;
        } catch (Exception ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Fallo conexion: "+ ex);
            return null;
        }
        
    }
}
