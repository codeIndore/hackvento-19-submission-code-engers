/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.UserDTO;
import dto.WUserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Manju
 */
public class WRegistorAuthenticator {
    
    Connection con=DBConnector.getConnection();
    public boolean isRegistor(WUserDto user)
    {
        String username=user.getEid();
        String fullname=user.getWname();
        String password = user.getPassword();
        int experience=user.getExperience();
        int phone=user.getPhone();
        int age=user.getAge();
        String address=user.getAddress();
        String occupation=user.getOccupation();
        
        System.out.println(password);
        
        
        try
        {
            Statement st= con.createStatement();
            String query= "select password from wtable where password='"+password+"' ";
            ResultSet rs = st.executeQuery(query);
            
            
            if(rs.next())
                     {
                         return false;
                     }
                     else
                     {
                        PreparedStatement pst=con.prepareStatement("Insert into wtable values(?,?,?,?,?,?,?,?)");
                         
                         pst.setString(1,username);
                         pst.setString(2,fullname);
                         pst.setString(3,password);
                         pst.setInt(4,experience);
                         pst.setInt(5,phone);
                         pst.setString(6,address);
                         pst.setInt(7,age);
                         pst.setString(8,occupation);

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
