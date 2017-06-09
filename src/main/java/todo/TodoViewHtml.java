package todo;

import java.util.List;

public class TodoViewHtml implements TodoView {


    @Override
    public String show(List<TodoModel> todos) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ol>");
//        for (TodoModel todo: todos) {
//            stringBuilder.append(show(todo));
//        }
        todos.stream()
                .map(e -> show(e))
                .forEach(e -> stringBuilder.append(e));

        stringBuilder.append("</ol>");
        return stringBuilder.toString();
    }

    @Override
    public String show(TodoModel model) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<li>\n");
        stringBuilder.append("<h3>" + model.getDate().toString() + "</h3>\n");
        stringBuilder.append("<h1>" + model.getName() + "</h1>\n");
        stringBuilder.append("<p>" + model.getDescription() + "</p>\n");
        stringBuilder.append("<p>");
        for (int i = 0; i < model.getPriority(); i++) {
            stringBuilder.append("X");
        }
        stringBuilder.append("</p>\n");
        stringBuilder.append("</li>\n");
        return stringBuilder.toString();
    }
}
