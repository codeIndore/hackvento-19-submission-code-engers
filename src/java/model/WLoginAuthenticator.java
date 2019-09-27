/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.WUserDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manju
 */
public class WLoginAuthenticator {
    
    public boolean isLogin(WUserDto user)
    {
        String username = user.getEid();
        String password = user.getPassword();
        
        String cPassword="";
        
        try{
            Statement st=DBConnector.getStatement();
            
            String query="Select upassword from wtable where username='"+username+"'";
            System.out.println("Query= "+query);
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                cPassword=rs.getString(1);
            }
            else
            {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WLoginAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(username!=null && password!=null && !username.trim().equals("") && !password.trim().equals("")  && password.equals(cPassword))
        {
            return true;
        }
        return false;
    }
   
}
