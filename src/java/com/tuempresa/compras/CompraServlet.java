package com.tuempresa.compras;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/CompraServlet")
public class CompraServlet extends HttpServlet {
    private final String usuarioValido = "admin";
    private final String contrasenaValida = "1234";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");

            if (!usuarioValido.equals(usuario) || !contrasenaValida.equals(contrasena)) {
                throw new Exception("Usuario o contraseña incorrectos.");
            }

            int cantidadA = Integer.parseInt(request.getParameter("cantidadA"));
            int cantidadB = Integer.parseInt(request.getParameter("cantidadB"));
            int cantidadC = Integer.parseInt(request.getParameter("cantidadC"));

            if (cantidadA < 0 || cantidadB < 0 || cantidadC < 0) {
                throw new Exception("Lo siento, ingrese una cantidad positiva.");
            }

            double total = cantidadA * 5.00 + cantidadB * 15.00 + cantidadC * 7.50;

            // Muestra la respuesta directamente
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>Gracias por tu compra</h2>");
            response.getWriter().println("<p>Total a pagar: S/ " + total + "</p>");
            response.getWriter().println("</body></html>");

        } catch (Exception e) {
            // Enviar a la página de error y pasarle el mensaje
            request.setAttribute("javax.servlet.error.message", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
