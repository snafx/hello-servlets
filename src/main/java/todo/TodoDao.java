package todo;


import java.util.List;

public interface TodoDao {
    List<TodoModel> getAllTodos();
    void addTodo(TodoModel todoModel);
}
