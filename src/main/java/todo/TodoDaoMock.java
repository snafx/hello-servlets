package todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoMock implements TodoDao {

    private List<TodoModel> todos;

    public TodoDaoMock() {
        todos = new ArrayList<>();
        init();
    }

    @Override
    public List<TodoModel> getAllTodos() {
        return todos;
    }

    @Override
    public void addTodo(TodoModel todoModel) {
        todos.add(todoModel);
    }

    private void init() {
        todos.add(new TodoModel(
                "Zadanie domowe fiza",
                "Wyliczyc predkosc auta",
                false,
                5,
                LocalDate.now()));
        todos.add(new TodoModel(
                "Zadanie domowe chemia",
                "Otrzymac proch",
                false,
                4,
                LocalDate.now()));
        todos.add(new TodoModel(
                "Zadanie domowe chemia",
                "Otrzymac TNT w warunkach domowych",
                false,
                3,
                LocalDate.now()));
        todos.add(new TodoModel(
                "Zakupy",
                "Kupic maslo, chleb, bulki i vude",
                false,
                3,
                LocalDate.now().minusDays(3)));
        todos.add(new TodoModel(
                "Serwis auta",
                "Oddac fure do przegladu",
                false,
                4,
                LocalDate.now().plusDays(7)));
    }
}
