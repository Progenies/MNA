<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div class="row">
	<h3>Mantenimiento de usuarios</h3>
	<span class="span3">
		<h4>Listado de usuarios</h4>
		<p class="text-info">Puede editar, crear o eliminar usuarios de la aplicación.</p>
		<p>&nbsp;</p>
		<a href="${pageContext.request.contextPath}/admin/Users/add" class="byn btn-large btn-primary">Añadir usuario</a>
	</span>
	
	<span class="span9">

		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Login</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${requestScope.usersList!=null && requestScope.usersList.size()>0}">
						<c:forEach items="${requestScope.usersList}" var="userObj">
							<tr>
								<td><c:out value="${userObj.idUser}" /></td>
								<td><c:out value="${userObj.name}" /></td>
								<td><c:out value="${userObj.login}" /></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan="3" align="center">No se han encontrado usuarios en el sistema</td></tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		
		</table>
</span>

</div>