/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.library;

/**
 *
 * @author parth
 */
class Eventdetail {
String title,last_modified_date,notes;
boolean fav;
    public Eventdetail(String t, String d, String n, boolean f) {
        title = t;
        last_modified_date = d;
        notes = n;
        fav = f;
    }
    
}
