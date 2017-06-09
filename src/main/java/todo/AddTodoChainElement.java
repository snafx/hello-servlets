package todo;

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
    public String action() {
        //budujemy stringa ktory bedzie odpowiedzialny za dodanie nowej notatki
        return todoView.showAddForm();
    }
}
