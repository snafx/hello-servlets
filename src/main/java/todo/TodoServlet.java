package todo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TodoServlet extends HttpServlet {

    private TodoDao todoDao;

    @Override
    public void init() throws ServletException {
        todoDao = new TodoDaoMock();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html; ISO-8859-1");
        List<TodoModel> allTodos = todoDao.getAllTodos();
        writer.println("<ul>");
        for (TodoModel model : allTodos) {
            writer.println("<li>");
            writer.println("<h3>" + model.getDate().toString() + "</h3>");
            writer.println("<h1>" + model.getName() + "</h1>");
            writer.println("<p>" + model.getDescription() + "</p>");
            writer.println("<p>");
            for (int i = 0; i < model.getPriority(); i++) {
                writer.print("X");
            }
            writer.println("</p>");
            writer.println("</li>");
        }
        writer.println("</ul>");
    }
}
/*
    <li>
        <h3>date</h3>
        <h1>name</h1>
        <p>desciption</p>
        <p>XXXXXX</p> //priorytet
    </li>
 */