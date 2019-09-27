/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Manju
 */
public class URegisterAuthenticator {
   Connection con=DBConnector.getConnection();
    public boolean isRegister(UserDTO user)
    {
        String username=user.getUsername();
        String fullname=user.getFullname();
        String password = user.getPassword();
        String phone=user.getPhone();
        String address=user.getAddress();
        
        
        System.out.println(password);
        
        
        try
        {
            Statement st= con.createStatement();
            String query= "select password from usertable where password='"+password+"' ";
            ResultSet rs = st.executeQuery(query);
            
            
            if(rs.next())
                     {
                         return false;
                     }
                     else
                     {
                        PreparedStatement pst=con.prepareStatement("Insert into student values(?,?,?,?,?)");
                         
                         pst.setString(1,fullname);
                         pst.setString(2,username);
                         pst.setString(3,password);
                         pst.setString(4,phone);
                         pst.setString(5,address);

                         System.out.println(pst.toString());
                         int i=pst.executeUpdate();
                         if(i>0)
                         {
                             return true;
                         }
                         else
                         {
                             System.out.println("Registration Unsuccesfull");
                         }
                     }
            
        }
        catch(SQLException ex)
            
        {
            System.out.println(ex);
        }
         if(username!=null && password!=null && !password.trim().equals("") && password.equals(password))
        {
            return true;
        }
       return false;
    }
}
