/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadServer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author vinay
 */
@WebService(serviceName = "ThreadService")
public class ThreadService {
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
    @WebMethod(operationName = "AddThread")
    public void AddThread(@WebParam(name = "title") String title, @WebParam(name = "author") String author) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String currentdate = dateFormat.format(date);
            UserThread t = new UserThread(title, currentdate, author);
            data.threads.add(t);
            
            
            data.addThreadToFile();
        } catch (IOException ex) {
            System.out.println("Error." + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error." + ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getThreadInfo")
    public Object[] getThreadInfo(@WebParam(name = "i") Integer i) {
        Object[] threadStuff = new Object[3];
        
        threadStuff[0] = data.threads.get(i).getTitle();
        threadStuff[1] = data.threads.get(i).getLastEdited();
        threadStuff[2] = data.threads.get(i).getAuthor();
        
        return threadStuff;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMessagesInfo")
    public Object[] getMessagesInfo(@WebParam(name = "i") Integer i) {
        Object[] messagesStuff = new Object[3];
        
        messagesStuff[0] = data.messages.get(i).getMessage();
        messagesStuff[1] = data.messages.get(i).getLastEdited();
        messagesStuff[2] = data.messages.get(i).getAuthor();
        
        return messagesStuff;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNumOfThreads")
    public Integer getNumOfThreads() {
        return data.threads.size();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getThreads")
    public ArrayList<UserThread> getThreads() {
        return data.threads;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNumOfMessages")
    public Integer getNumOfMessages() {
        return data.messages.size();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findThread")
    public UserThread findThread(@WebParam(name = "title") String title) {
        for(int i=0; i<data.threads.size(); i++){
            if(title.equals(data.threads.get(i).getTitle())){
                return data.threads.get(i);
            }
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createMessage")
    public void createMessage(@WebParam(name = "message") String message, @WebParam(name = "author") String author) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String LastEdited = dateFormat.format(date);
            
            String editingThread = "";
            
            for(int i = 0; i < data.threads.size(); i++) {
                if(getThreads().get(i).isIsEditing()) {
                    editingThread = getThreads().get(i).getTitle();
                }
            }
            
            Message ms = new Message(message, LastEdited, author, editingThread);
            ms.setThread(editingThread);
            System.out.println("Message was added");
            data.messages.add(ms);
            data.addMessageToFile();
        } catch (IOException ex) {
            System.out.println("Error." + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error." + ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "returnMessages")
    public ArrayList<Message> returnMessages() {
        return data.messages;
    }
    


    /**
     * Web service operation
     */
    @WebMethod(operationName = "saveThreads")
    public void saveThreads() {
        try {
            data.addThreadToFile();
        } catch (IOException ex) {
            System.out.println("Error." + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error." + ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "resetIsEditing")
    public void resetIsEditing() {
        for(int i = 0; i < data.threads.size(); i++) {
            data.threads.get(i).setIsEditing(false);
            System.out.println(data.threads.get(i).isIsEditing());
        }
    }

    /**
     * Web service operation
     * @param Title
     * @return 
     */
    @WebMethod(operationName = "setisEditing")
    public String setisEditing(@WebParam(name = "edit") String Title) {
        //TODO write your implementation code here:
        for(int i = 0; i < data.threads.size(); i++) {
            if(getThreads().get(i).getTitle() == null ? Title == null : getThreads().get(i).getTitle().equals(Title)) {
                    getThreads().get(i).setIsEditing(true);
                }
        }
        return null;
    }

    

    
   
}
