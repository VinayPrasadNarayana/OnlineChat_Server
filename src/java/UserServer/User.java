/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserServer;

import java.io.Serializable;

/**
 *
 * @author vinay
 */
public class User implements Serializable {

    private String Username;
    private String Password;
    private String Name;
    
    public User(String Name, String username, String Password){
        this.Username =username;
        this.Name =Name;
        this.Password = Password;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }
    
    

}
