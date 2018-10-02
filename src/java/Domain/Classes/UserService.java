/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Classes;

/**
 *
 * @author 697148
 */
public class UserService {
    
    public boolean login(String username, String password) {
        
        if(username.equals("adam")){
          return username.equals("adam") && password.equals("password");  
        }
        
        return username.equals("betty") && password.equals("password");
    }

    
}
