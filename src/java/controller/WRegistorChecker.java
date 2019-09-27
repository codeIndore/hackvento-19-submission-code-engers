/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.WUserDto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.WRegistorAuthenticator;

/**
 *
 * @author Manju
 */
public class WRegistorChecker extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("email");     
       String password = req.getParameter("password");
       String fullname = req.getParameter("fullname");
       String ph = req.getParameter("phone");
       int phone=Integer.parseInt(ph);
       String address = req.getParameter("address");
       int experience = Integer.parseInt(req.getParameter("exp"));
       int age= Integer.parseInt(req.getParameter("age"));
       String occupation=req.getParameter("occupation");
       System.out.println(occupation);
       
       
        WUserDto user=new WUserDto();  // Encapsulating the user's data
        user.setEid(username);
        user.setWname(fullname);
        user.setPassword(password);
        user.setExperience(experience);
        user.setPhone(phone);
        user.setAddress(address);
        user.setExperience(experience);
        user.setAge(age);
        user.setOccupation(occupation);
        
     
        
        
        
        WRegistorAuthenticator authenticator=new WRegistorAuthenticator();
        boolean register=authenticator.isRegistor(user);  //Check whether user is already registered or not
        
        
        if(register)
        {
            resp.sendRedirect("kaamkazi_worker_login.html"); // redirect to login page
        }
        else
        {
          resp.sendRedirect("kaamkazi_worker_signup.html"); 
                
                
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("kaamkazi_worker_signup.html");
    }

    
}
