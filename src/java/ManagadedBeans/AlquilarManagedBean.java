/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagadedBeans;

import alquiler.dvds.DvdItem;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author SISTEMAS
 */
@Named(value = "alquilar")
@SessionScoped
public class AlquilarManagedBean implements Serializable {

    @Inject
    AppManagedBean appManagedBean;
    private DvdItem itemActual= null; 
    private boolean modoNuevo = false;
    //private List<DvdItem> cd = new ArrayList();  // //coleccion de dvds , lista de todos los dvds 

    public AlquilarManagedBean() {

    }

    public void setAppManagedBean(AppManagedBean appManagedBean) {
        this.appManagedBean = appManagedBean;
    }

    public Collection<DvdItem> getcd() {
        return appManagedBean.getCd().values();
    }

    public DvdItem getItemActual() {
        return itemActual;
    }

    public void setItemActual(DvdItem itemActual) {
        this.itemActual = itemActual;
    }

    public void setModoNuevo(boolean modoNuevo) {
        this.modoNuevo = modoNuevo;
    }

    public boolean isModoNuevo() {
        return modoNuevo;
    }


  

    public String alquilar(int id) {
        System.out.println("....alquilo id " + id);
        DvdItem item =appManagedBean.getCd().get(id);
        item.setAlquilado(true);
       // cd.get(--id).setAlquilado(true);
        return null;
    }

    public String devolverAlquiler(int id) {
        System.out.println("---devuelvo el id alquilado  " + id);
          DvdItem item =appManagedBean.getCd().get(id);
        item.setAlquilado(false);
     //   cd.get(--id).setAlquilado(false); esto es para el arrayList
        return null;
    }
      //METODO CREAR DISCO
  /*  public String altaDisco() {
        System.out.println("creamos disco " + discos);
      
        item.setAlquilado(false);
     //   cd.add(discos);
        discos = new DvdItem();  //creo una nueva variable de referencia vacia preparada para recibir nuevos discos
    //    System.out.println("   lista es   " + cd);
        return "discos";
    } */
    
    //METODO ALTA dvd
    public String altaDisco(){
        this.modoNuevo=true;
        this.itemActual=new DvdItem();
        return "edita";
    }
    public String modificarDvd(int id){
        this.modoNuevo=false;
        this.itemActual=appManagedBean.getCd().get(id);
        return "edita";
    }
    public String guardar(){
        FacesContext fc = FacesContext.getCurrentInstance();
    
        if(modoNuevo){
             //validar que el id no existe ya
            if(existe(itemActual.getId())){
                fc.addMessage(null,
                        new FacesMessage("No se pudo guardar el nuevo DVD. El id ya existe."));
                return "edita";
            }else{//añadir el item a map
                appManagedBean.getCd().put(itemActual.getId() , itemActual);
                fc.addMessage(null, new FacesMessage("Se ha añadido el nuevo DVD."));
            }
        }else{
            //modificar
            appManagedBean.getCd().put(itemActual.getId() , itemActual);
            fc.addMessage(null, 
                    new FacesMessage("Se ha modificado el DVD con éxito."));
        }
        return "alquila";
    }
     private boolean existe(int id){
        boolean existe = false;
        existe = appManagedBean.getCd().containsKey(id);
        return existe;
    }
}
