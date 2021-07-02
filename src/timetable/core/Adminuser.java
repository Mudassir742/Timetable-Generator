/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.core;

import timetable.data.DAOFactory;
import timetable.data.IDAO;

/**
 *
 * @author DELL
 */
public class Adminuser extends User{
    
    public Adminuser() {super();};
    
    public Adminuser(String Name, String Password){
        super(Name, Password);
    }

    @Override
    public void save() {
        IDAO userdao = DAOFactory.getDao("User");
        if (userdao != null) {
            userdao.insertuser("Admin", this);
        }
    }

    @Override
    public boolean autenticate(String Password, String name) {
        IDAO userdao = DAOFactory.getDao("User");
        if (userdao != null) {
            if (Password.equals((userdao.getAdminUser("ADMIN", name)))) {
                return true;
            }
        }
        return false;
    }
}
