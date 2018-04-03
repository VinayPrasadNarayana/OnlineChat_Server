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
public class UserThread implements Serializable{

    private String Title;
    private String LastEdited;
    private String Author;
    private boolean isEditing = false;

    public UserThread(String Title, String LastEdited, String Author) {
        this.Title = Title;
        this.LastEdited = LastEdited;
        this.Author = Author;
    }

    public String getTitle() {
        return Title;
    }

    public String getLastEdited() {
        return LastEdited;
    }

    public String getAuthor() {
        return Author;
    }

    public boolean isIsEditing() {
        return isEditing;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setLastEdited(String LastEdited) {
        this.LastEdited = LastEdited;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setIsEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }
    
    
    
}
