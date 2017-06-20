package com.sda.todo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTodoChainElement implements TodoChainElement {

    private String path;
    private TodoDao todoDao;
    private TodoView todoView;

    public AddTodoChainElement(String path, TodoDao todoDao, TodoView todoView) {
        this.path = path;
        this.todoDao = todoDao;
        this.todoView = todoView;
    }

    @Override
    public boolean isMyResponsibility(String path) {
        return this.path.equals(path);
    }

    @Override
    public String action(HttpServletRequest req, HttpServletResponse resp) {

        String valueToReturn = "<h1>OK</h1>";
        if (TodoUtil.isWriteRequest(req)) {
            TodoModel todoModel = TodoMapper.map(req);
            todoDao.addTodo(todoModel);
            resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            //redirect statuscode 301 przekierowanie w headerze strony
            //jak przegladarka znajdzie 301 to w headerze pod polem location znajdzie value z adresem gdzie ma przekierowac
            resp.setHeader("Location", "/hello-servlets-1.0-SNAPSHOT/todo/all");
        } else {
            valueToReturn = todoView.showAddForm();
        }
        return valueToReturn;
        //budujemy stringa ktory bedzie odpowiedzialny za dodanie nowej notatki
//        return todoView.showAddForm();
    }
}
