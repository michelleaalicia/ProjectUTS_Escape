/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverproject;

/**
 *
 * @author asus
 */
public class LoginClass 
{
   private String username;
   private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 

    public LoginClass() {
    }

    public LoginClass(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
   
   
}
