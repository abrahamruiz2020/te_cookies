
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VistasServlet", urlPatterns = {"/VistasServlet"})
public class VistasServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //Udsuario que ingresa por primera vez al sitio
        boolean nuevoUsuario = true;
        //Obtener arreglo de cookies existentes en el servidor
        Cookie[] cookies = request.getCookies();
        //Verificar si ya existe la cookie
        if (cookies != null){
            for (Cookie c : cookies){
                   if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                       nuevoUsuario = false;
                       break;
                   }
            }
        }
        String mensaje = null;
        if (nuevoUsuario){
        //creamos el cookie
        Cookie visitanteN = new Cookie("visitanteRecurrente","si");
        response.addCookie(visitanteN);
        mensaje = "Bienvenido a nuestro sitio Web";
        }
        else{
            mensaje = "Gracias por visitarnos nuevamente";
        }
        response.setContentType("text/html;charset-UTF-8");
        out.println("Mensaje: "+mensaje);
        out.close();
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

}
