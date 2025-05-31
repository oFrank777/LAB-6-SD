<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error - Compras</title>
</head>
<body>
    <h1>¡Ha ocurrido un error!</h1>

    <p><strong>Mensaje:</strong>
        <% 
            if (exception != null) {
                String msg = exception.getMessage();
                if (msg == null || msg.trim().isEmpty()) {
                    out.print("Se produjo un error, pero no hay mensaje detallado.");
                } else {
                    out.print(msg);
                }
            } else {
                out.print("Se produjo un error inesperado.");
            }
        %>
    </p>

    <p><strong>Tipo de error:</strong>
        <% 
            if (exception != null) {
                out.print(exception.getClass().getName());
            } else {
                out.print("Información del error no disponible.");
            }
        %>
    </p>

    <a href="index.html">Volver al inicio</a>
</body>
</html>
