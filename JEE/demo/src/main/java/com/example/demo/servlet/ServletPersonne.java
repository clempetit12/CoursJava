package com.example.demo.servlet;

import com.example.demo.model.Personne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "personne", value = "/personne")
public class ServletPersonne extends HttpServlet {


    private List<Personne> personneList;

    @Override
    public void init() throws ServletException {
        personneList = new ArrayList<>();
        Personne personne = new Personne("helene", "de troie");
        Personne personne2 = new Personne("olivia", "pigani");
        Personne personne3 = new Personne("marie", "antoinette");
        personneList.add(personne);
        personneList.add(personne2);
        personneList.add(personne3);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        Personne personne = new Personne(lastName, firstName);
        personneList.add(personne);
        req.setAttribute("personnes", personneList);
        req.getRequestDispatcher("personne-list.jsp").forward(req,resp);


    }
}
