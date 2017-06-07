package com.sda;


import com.sda.calc.Calculator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calculator calculator = new Calculator();
        String pathInfo = req.getPathInfo();
        Map<String, String[]> parameterMap = req.getParameterMap();
        String firstValue = parameterMap.get("first") [0];
        String secondValue = parameterMap.get("second") [0];
        double result = 0;
        if ("/add".equals(pathInfo)) {
            result = calculator.add(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        } else if ("/substract".equals(pathInfo)) {
            result = calculator.substract(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        } else if ("/multiply".equals(pathInfo)) {
            result = calculator.multiply(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        } else if ("/divide".equals(pathInfo)) {
            result = calculator.divide(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        }
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Result: " + result + "</h1>");
        addResponse(writer);
    }

    private void addResponse(PrintWriter writer) {
        writer.println("Add");
        writer.println("<form method=\"get\" action=\"hello-servlets-1.0-SNAPSHOT/add\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("Substract");
        writer.println("<form method=\"get\" action=\"hello-servlets-1.0-SNAPSHOT/subtract\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("Multiply");
        writer.println("<form method=\"get\" action=\"hello-servlets-1.0-SNAPSHOT/multiply\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("Divide");
        writer.println("<form method=\"get\" action=\"hello-servlets-1.0-SNAPSHOT/divide\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
    }

//    method(req, resp);

    private void method(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        Cookie cookie = new Cookie("cookie-key", "cookie-value");
        cookie.setMaxAge(30);
        resp.addCookie(cookie);

        String requestURI = req.getRequestURI();
        String requestUrl = req.getRequestURL().toString();
        String pathInfo = req.getPathInfo();
        String parameterMap = req.getParameterMap().toString();
        Cookie[] cookieList = req.getCookies();
        String cookies = "";
        if (cookieList !=null) {
            cookies = Arrays.asList(req.getCookies()).toString();
        }
        String contextPath = req.getContextPath();
        String method = req.getMethod();

        writer.println("<h1>Hello bla bla bla</h1>");
        writer.println("<ol>");
        writer.println("\t<li>You've requested " + requestURI + "</li>");
        writer.println("\t<li>requestUrl " + requestUrl + "</li>");
        writer.println("\t<li>pathInfo " + pathInfo + "</li>");
        writer.println("\t<li>parameterMap " + parameterMap + "</li>");
        writer.println("\t<li>cookies " + cookies + "</li>");
        writer.println("\t<li>contextPath " + contextPath + "</li>");
        writer.println("\t<li>method " + method + "</li>");
        writer.println("</ol>");
    }
}
