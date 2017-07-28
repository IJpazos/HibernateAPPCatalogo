<%@ include file="includes/cabecera.jsp" %>
	<table>
	<thead>
		<tr>
			<th>ID producto</th>
			<th>Nombre</th>
			<th>Descripción</th>
			<th>Precio</th>
			<th>Tienda</th>
			<th>Tags</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${applicationScope.productos}" var="producto">
				<tr>
					<td>${producto.id}</td>
					<td>${producto.nombre}</td>
					<td>${producto.descripcion}</td>
					<td>${producto.precio}</td>
					<td><a href="/ControladorCRUD?tipo=tienda&id=${producto.tienda.id}">${producto.tienda.nombre}</a></td>
					<td>
						<c:forEach items="${producto.tags}" var="tag">
							<a href="/BusquedaTags?tag=${tag}">${tag} </a>
						</c:forEach>
						</td>
				</tr>
		</c:forEach>
	</tbody>


</table>

<%@ include file="includes/pie.jsp" %>