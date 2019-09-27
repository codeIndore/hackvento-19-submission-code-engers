/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.URegisterAuthenticator;

/**
 *
 * @author Manju
 */
public class URegisterChecker extends HttpServlet {

    
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("kaamkazi_user_signup.html");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("eid");     
       String password = req.getParameter("password");
       String fullname = req.getParameter("fullname");
       String phone = req.getParameter("phone");
       String address = req.getParameter("address");
       String cpassword = req.getParameter("cpassword");
       
        System.out.println(password);
       if(password.equals(cpassword))
       {
       
        UserDTO user=new UserDTO();  // Encapsulating the user's data
        user.setFullname(fullname);
        user.setAddress(address);
        user.setPassword(password);
        user.setPhone(phone);
        user.setUsername(username);
        
        URegisterAuthenticator authenticator=new URegisterAuthenticator();
        boolean register=authenticator.isRegister(user);  //Check whether user is already registered or not
        
        
        if(register)
        {
            resp.sendRedirect("kaamkazi_user_login.html"); // redirect to login page
        }
        else
        {
          resp.sendRedirect("kaamkazi_user_signup.html"); 
                
                
        }
       }
       else
       {
           resp.sendRedirect("kaamkazi_user_signup.html");
       }
        
    }

   

    
}
