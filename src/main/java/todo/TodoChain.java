package todo;

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
    }

    public String invoke(String path) {
        Iterator<TodoChainElement> iterator = chainElements.iterator();
        TodoChainElement finalElement = null;
        boolean flag = false;
        while(!flag && iterator.hasNext()) {
            TodoChainElement next = iterator.next();
            if (next.isMyResponsibility(path)) {
                finalElement = next;
                flag = true;
            }
        }
//        String result = "<h1>Cannot find page</h1>";
//        if (finalElement != null) {
//            result = finalElement.action();
//        }
//        return result;
        return finalElement !=null ? finalElement.action() : "<h1>Cannot find page</h1>";
    }
}