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
import javax.servlet.http.HttpSession;
import model.WLoginAuthenticator;

/**
 *
 * @author Manju
 */
public class WLoginChecker extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username); //Testing purpose
        WUserDto user =new WUserDto();
        user.setEid(username);
        user.setPassword(password);
        
        
        WLoginAuthenticator au=new WLoginAuthenticator();
        boolean login=au.isLogin(user);
        if(login)
        {
            HttpSession session= req.getSession(true);
            session.setAttribute("username",username);
            resp.sendRedirect("profile.html");
        }   
        else
        {
             resp.sendRedirect("kaamkazi_worker_login.html");
                
        }
    }
   

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("kaamkazi_worker_login.html");
    }
}

    


