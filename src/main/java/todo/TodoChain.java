package todo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoChain {
    private List<TodoChainElement> chainElements;

    private TodoView todoView;
    private TodoDao todoDao;

    public TodoChain(TodoView todoView, TodoDao todoDao) {
        this.chainElements = new ArrayList<>();
        this.todoView = todoView;
        this.todoDao = todoDao;
        init();
    }

    private void init() {
        chainElements.add(new AllTodosChainElement("/all", todoDao, todoView));
        chainElements.add(new AddTodoChainElement("/add", todoDao, todoView));
    }

    public String invoke(HttpServletRequest req, HttpServletResponse resp) {
        Iterator<TodoChainElement> iterator = chainElements.iterator();
        TodoChainElement finalElement = null;
        boolean flag = false;
        while(!flag && iterator.hasNext()) {
            TodoChainElement next = iterator.next();
            if (next.isMyResponsibility(req.getPathInfo())) {
                finalElement = next;
                flag = true;
            }
        }
//        String result = "<h1>Cannot find page</h1>";
//        if (finalElement != null) {
//            result = finalElement.action();
//        }
//        return result;
        return finalElement !=null ? finalElement.action(req, resp) : "<h1>Cannot find page</h1>";
    }
}