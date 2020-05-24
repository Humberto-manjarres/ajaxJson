/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Humberto Manjarres
 */
public class servletJsonAjax extends HttpServlet {
    List<Persona> listaPersona = new ArrayList<>();
    PersonasDao personaDao;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String user=request.getParameter("userName");
        String edad=request.getParameter("userEdad");
        
//        List<Persona> lista = new ArrayList<Persona>();
//        lista.add(new Persona("pedro", 20));
//        lista.add(new Persona("ana", 30));
//        lista.add(new Persona("humberto", 37));
//        lista.add(new Persona("elias", 3));
//        lista.add(new Persona("lian", 3));
//        lista.add(new Persona(user,Integer.valueOf(edad)));
        
        
        try {
            personaDao=new PersonasDao();
            listaPersona = personaDao.listar();
        } catch (Exception e) {
            System.out.println("error servletJsonAjax --> "+e);
        }
        for (Persona persona : listaPersona) {
            System.out.println("p-> "+persona.getNombre() );
        }
        Gson gson = new Gson();
        PrintWriter pw = response.getWriter();
        pw.println(gson.toJson(listaPersona));
        pw.close();
        
        System.out.println("user--> "+user+" edad--> "+edad);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
