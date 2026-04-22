package com.music.view;

import com.music.model.MusicItem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ListLibraryServlet")
public class ListLibraryServlet extends HttpServlet {

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
        ArrayList<MusicItem> List=new ArrayList<>();
        List.add(new MusicItem("Standing in the Eyes of the World", "Ella", "2012", "Pop"));
        List.add(new MusicItem("CYBERPUNK DEAD BOY", "MAIKI P","2024", "Electronic"));
        List.add(new MusicItem("blender", "Komedawara and r SOUND DESIGN","2024", "Electronic"));
        List.add(new MusicItem("Rollin Girl", "wowaka", "2010", "Rock"));
        List.add(new MusicItem("Romeo and Cinderella", "doriko", "2009", "Pop"));
        List.add(new MusicItem("Bury the Light", "Casey Edwards and Victor Borba", "2020", "Metal"));
        List.add(new MusicItem("The Snow White Princess is", "Noburo↑-P", "2010", "Vocaloid"));
        List.add(new MusicItem("Lost One's Weeping", "Neru", "2013", "Rock"));
        String sortBy=request.getParameter("sort");
        if(sortBy != null){
            if(sortBy.equalsIgnoreCase("year")){
                Collections.sort(List, new Comparator<MusicItem>(){
                    public int compare(MusicItem m1, MusicItem m2){
                        return Integer.parseInt(m1.getYear()) - Integer.parseInt(m2.getYear());
                    }
                });
            }
            else if(sortBy.equalsIgnoreCase("artist")){
                Collections.sort(List, new Comparator<MusicItem>(){
                    public int compare(MusicItem m1, MusicItem m2){
                        return m1.getName().compareToIgnoreCase(m2.getName());
                    }
                });
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ListLibraryServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<br><br><a href='https://mnzmi54.github.io/mnzmi-5/'>Back to Index</a>");
            out.println("<h1>ListLibraryServlet</h1>");
            out.println("You currently have <b>"+List.size()+"</b> Music in your collection: <br><br>");
            out.println("<a href='ListLibraryServlet?sort=year'>Sort by Year</a> | ");
            out.println("<a href='ListLibraryServlet?sort=artist'>Sort by Artist</a><br><br>");
            out.println("<table border='0', cellspacing='0' cellpadding='5'>");
            out.println("<tr>");
            out.println("<th>TITLE</th>");
            out.println("<th>ARTIST</th>");
            out.println("<th>YEAR</th>");
            out.println("<th>GENRE</th>");
            out.println("</tr>");
            
            Iterator it=List.iterator();
            while(it.hasNext()){
                MusicItem item=(MusicItem)it.next();
                out.println("<tr>");
                out.println("<td>"+item.getTitle()+"</td>");
                out.println("<td>"+item.getName()+"</td>");
                out.println("<td>"+item.getYear()+"</td>");
                out.println("<td>"+item.getGenre()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
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
