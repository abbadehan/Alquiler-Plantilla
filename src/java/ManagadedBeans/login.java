/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagadedBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author SISTEMAS
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable {

   
    public login() {
    }
    
}
