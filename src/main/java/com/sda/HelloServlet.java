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
        String firstValue = parameterMap.get("first")[0];
        String secondValue = parameterMap.get("second")[0];
        double result = 0;
        if ("/add".equals(pathInfo)) {
            result = calculator.add(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        } else if ("/subtract".equals(pathInfo)) {
            result = calculator.subtract(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
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
        writer.println("<h1>Add</h1>");
        writer.println("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/calc/add\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("<h1>Subtract</h1>");
        writer.println("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/calc/subtract\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("<h1>Multiply</h1>");
        writer.println("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/calc/multiply\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("<h1>Divide</h1>");
        writer.println("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/calc/divide\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
    }

    private void testMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        if (cookieList != null) {
            cookies = Arrays.asList(cookieList).toString();
        }
        String contextPath = req.getContextPath();
        String method = req.getMethod();

        writer.println("<h1>Hello World</h1>");
        writer.println("<ol>");
        writer.println("<li>You've requested " + requestURI + "</li>");
        writer.println("<li>requestUrl " + requestUrl + "</li>");
        writer.println("<li>pathInfo " + pathInfo + "</li>");
        writer.println("<li>parameterMap " + parameterMap + "</li>");
        writer.println("<li>cookies " + cookies + "</li>");
        writer.println("<li>contextPath " + contextPath + "</li>");
        writer.println("<li>method " + method + "</li>");
        writer.println("</ol>");
    }
}
