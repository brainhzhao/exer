package priv.zh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import org.springframework.web.HttpRequestHandler;

public class HttpRequestController implements HttpRequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request,HttpServletResponse response) 	throws ServletException, IOException{
        System.out.println("123");
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}