package todo;

import javax.servlet.ServletContext;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoDaoFile implements TodoDao {

    private ServletContext servletContext;

    private String path;

    public TodoDaoFile(ServletContext servletContext, String path) {
        this.servletContext = servletContext;
        this.path = path;
    }

    @Override
    public List<TodoModel> getAllTodos() {
        List<TodoModel> models = new ArrayList<>();
        try (InputStream inputStream = servletContext.getResourceAsStream(path)) {
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                models.add(TodoMapper.map(scanner));
            }
        } catch (IOException e) {
            System.out.println("Couldn't close input stream");
        }
        return models;
    }

    @Override
    public void addTodo(TodoModel todoModel) {
    }
}
