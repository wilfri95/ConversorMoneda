<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Currency Convertor</title>
</head>

	<style type="text/css"> /* personalizar componentes (etiquestas, campo, botón, mensaje) */
    	body {
    		text-align: center; /* centrar todo los componentes*/
    		font-family: Helvetica; /*  tipo de letra */
			color: #207584; /*color de letra*/
    	}

    </style>
<body>
	<form action="ConversorMoneda" method="get">
	<h1>Conversor de moneda</h1> <!-- Encabezados  h1 y h2-->
	<h2>Ingrese el monto (CLP)</h2>
	<input type="text" name="monto"> <br> <!-- campo de texto para introducir el monto a transformar-->
	<input type="submit" value="Convertir"> <br> <!-- botón -->
	
	${mensaje} <!-- mensaje que muestra el el monto convertido de 'CLP' a 'USD' -->
	
	</form>
	
</body>
</html>