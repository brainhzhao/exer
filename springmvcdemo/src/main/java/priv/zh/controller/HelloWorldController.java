package priv.zh.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response){
        try {
            response.getWriter().println("HelloWorld");
        } catch (Exception e) {
            
        }
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/WEB-INF/index.jsp");
        return mav;
    }
}