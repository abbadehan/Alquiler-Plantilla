/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagadedBeans;

import alquiler.dvds.DvdItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author SISTEMAS
 */
@Named(value = "app")
@ApplicationScoped
public class AppManagedBean {
private Map<Integer,DvdItem> cd;
private List<String> genero;
    
    public AppManagedBean() {
        System.out.println("----inicializando AppManagedBean");
        cd= new HashMap();
        cd.put(1,new DvdItem(1, "Freedom", "Pop", true));
        cd.put(2,new DvdItem(2, "Lonely", "Flamenco", false));
        cd.put(3,new DvdItem(3, "Rahma", "Espiritual", true));
        cd.put(4,new DvdItem(4, "Paz", "Canticos", false));
        //creamos la lista de genero
        genero= new ArrayList();
        //añadimos lista
        genero.add("Pop");
        genero.add("Rap");
        genero.add("Flamenco");
        genero.add("Cantico");
    }

    public Map<Integer, DvdItem> getCd() {
        return cd;
    }

    public List<String> getGenero() {
        return genero;
    }
    
    
}
