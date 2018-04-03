/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadServer;

import java.io.Serializable;

/**
 *
 * @author vinay
 */
public class Message implements Serializable{

    private String Message;
    private String LastEdited;
    private String Author;
    private String Thread;

    public Message(String Message, String LastEdited, String Author, String Thread) {
        this.Message = Message;
        this.LastEdited = LastEdited;
        this.Author = Author;
        this.Thread = Thread;
    }

    public String getMessage() {
        return Message;
    }

    public String getLastEdited() {
        return LastEdited;
    }

    public String getAuthor() {
        return Author;
    }

    public String getThread() {
        return Thread;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setLastEdited(String LastEdited) {
        this.LastEdited = LastEdited;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setThread(String Thread) {
        this.Thread = Thread;
    }
    
    
}
