<%@ include file="includes/cabecera.jsp" %>

<div>
	<form action="Login" method="post">
		<label for="nombre">Usuario</label><input type="text" name="nombre"/>
		<label for="pass">Contraseña</label><input type="password" name="pass"/>
		<input type="submit"/>
		<p>${error}</p>
	</form>
</div>
<%@ include file="includes/pie.jsp" %>