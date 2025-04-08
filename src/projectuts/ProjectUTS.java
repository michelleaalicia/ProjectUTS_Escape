/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectuts;

/**
 *
 * @author Michelle Alicia
 */
public class ProjectUTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        FormRegister reg = new FormRegister();
        reg.pack();
        reg.setLocationRelativeTo(null);
        reg.setDefaultCloseOperation(FormRegister.EXIT_ON_CLOSE);
        reg.setState(java.awt.Frame.NORMAL);
        reg.setVisible(true);
        
        
    }
    
}
