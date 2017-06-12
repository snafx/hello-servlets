package todo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TodoChainElement {
        boolean isMyResponsibility(String path);

        String action(HttpServletRequest req, HttpServletResponse resp);
}
