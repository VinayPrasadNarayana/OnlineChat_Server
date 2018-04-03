/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserServer;

import ThreadServer.Message;
import ThreadServer.UserThread;
import UserServer.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinay
 */
public class PersistentDataService {

    ArrayList<User> User = new ArrayList<>();
    String fileName = "User.list";

    ArrayList<UserThread> threads = new ArrayList<>();
    ArrayList<Message> messages = new ArrayList<>();
    
    String threadFile = "threads.list";
    String messageFile = "message.list";

    public PersistentDataService() {
        try {
            File f = new File(fileName);
            if (f.exists() && f.canRead()) {
                readFromFile();
            }
             File f2 = new File(threadFile);
            if (f2.exists() && f2.canRead()) {
                loadThreads();
            }
            File f3 = new File(messageFile);
            if (f3.exists() && f3.canRead()) {
                loadMessages();
            }
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(PersistentDataService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersistentDataService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void AddUser(User user) {
        System.out.println("SimpleDataService - addSample(" + user + ")");
        User.add(user);
        try {
            saveToFile();
        } catch (IOException ex) {
            Logger.getLogger(PersistentDataService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveToFile() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(User);
        oos.close();
        fos.close();
    }

    public void readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        User = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
    }

    private void loadThreads() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis2 = new FileInputStream(threadFile);
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        threads = (ArrayList) ois2.readObject();
        ois2.close();
        fis2.close();
    }

    public void addThreadToFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream fos2 = new FileOutputStream(threadFile);
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeObject(threads);
        oos2.close();
        fos2.close();
    }

    private void loadMessages() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis3 = new FileInputStream(messageFile);
        ObjectInputStream ois3 = new ObjectInputStream(fis3);
        messages = (ArrayList) ois3.readObject();
        ois3.close();
        fis3.close();
    }

    public void addMessageToFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream fos3 = new FileOutputStream(messageFile);
        ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
        oos3.writeObject(messages);
        oos3.close();
        fos3.close();
    }

}
