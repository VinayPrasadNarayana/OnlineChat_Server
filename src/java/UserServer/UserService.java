/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserServer;

import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author vinay
 */
@WebService(serviceName = "UserService")
public class UserService {
 PersistentDataService data = new PersistentDataService();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "onLogin")
    public User onLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        for(int i=0; i<data.User.size(); i++){
            if (username.equals(data.User.get(i).getUsername())){
                return data.User.get(i);
            }
        }
        
        return null;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkPassword")
    public Boolean checkPassword(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        for(int i=0; i<data.User.size(); i++){
            if (username.equals(data.User.get(i).getUsername())){
                if (password.equals(data.User.get(i).getPassword()))
                    return true;
                else
                    return false;
            }
        }
        return false;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "register")
    public Boolean register(@WebParam(name = "nickname") String nickname, @WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        //loop through all accounts, if found a match, return false
        for (int i=0; i<data.User.size(); i++) {
            if(username.equals( data.User.get(i).getUsername()))
                    return false;
            
        }
        
        User a = new User(nickname, username, password);
            data.User.add(a);
        
        try {
            data.saveToFile();
        } catch (IOException ex) {
            System.out.println("Error." + ex.getMessage());
        }
        return true;
        
    }
}
