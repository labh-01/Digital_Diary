/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.library;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author parth
 */
public class DigitalLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        homepage page = new homepage();
        page.setLocationByPlatform(true);
        page.setVisible(true);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DigitalLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
        page.setVisible(false);
        createDiary user = new createDiary();
        user.setLocationRelativeTo(page);
        user.setVisible(true);
    }
    
}
