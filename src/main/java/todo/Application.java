package todo;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        TodoDao todoDao = new TodoDaoMock();
        TodoView todoView = new TodoViewHtml();
        TodoChain todoChain = new TodoChain(todoView, todoDao);

        Scanner scanner = new Scanner(System.in);
        System.out.println("/all Wyswietl wszystkie");
        System.out.println("/add Dodaj");
        String answer = scanner.nextLine();

    }
}
