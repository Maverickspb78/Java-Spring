package org.example.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/task")
public class TaskServlet extends HttpServlet {
    private List<Product> list;

    @Override
    public void init() throws ServletException {
        list = new ArrayList<>(9);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/page_header").include(req,resp);
    if (list.size()<10) {
        resp.getWriter().println("<h3>форма для добавления</h3>");
        resp.getWriter().println("<form method='post'>");
        resp.getWriter().println("Введите id: <input type='test' name='id'>");
        resp.getWriter().println("Введите title: <input type='text' name='title'>");
        resp.getWriter().println("Введите cost: <input type='text' name='cost'>");
        resp.getWriter().println("<input type='submit'>");
        resp.getWriter().println("</form>");
    }

        list.add(new Product(req.getParameter("id"), req.getParameter("title"), req.getParameter("cost")));

            for (Product s : list) {
                if ((s.getId() != null) && (s.getTitle() != null) && (s.getCost() != null)) {
                    resp.getWriter().println("<p>" + "id: " + s.getId() + ", title: " + s.getTitle() + ", cost: " + s.getCost() + "</p>");
                }
            }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
