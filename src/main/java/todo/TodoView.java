package todo;

import java.util.List;

public interface TodoView {
    String show(List<TodoModel> todos);

    String show(TodoModel model);
}
