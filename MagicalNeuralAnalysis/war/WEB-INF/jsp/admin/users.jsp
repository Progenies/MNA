<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
	<h3>Mantenimiento de usuarios</h3>
	<span class="span3">
		<h4>Listado de usuarios</h4>
		<p class="text-info">Puede editar, crear o eliminar usuarios de la aplicación.</p>
		<p>&nbsp;</p>
		<a href="${pageContext.request.contextPath}/admin/Users/add" class="byn btn-large btn-primary">Añadir usuario</a>
	</span>
	
	<span class="span9">
		<script>
		function editUser(idUser)
		{
			document.editForm.idUser.value=idUser;
			document.editForm.submit();
		}
		function disableUser(idUser, currentStatus)
		{
			document.disableForm.idUser.value=idUser;
			document.disableForm.active.value=!currentStatus;
			document.disableForm.submit();
		}
		</script>
	
		<form name="editForm" action="edit" method="post">
			<input type="hidden" name="idUser"/>
		</form>
		<form name="deleteForm" action="delete" method="post">
			<input type="hidden" name="idUser"/>
		</form>
		<form name="disableForm" action="disable" method="post">
			<input type="hidden" name="idUser"/>
			<input type="hidden" name="active"/>
		</form>

		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Login</th>
					<th>Tipo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${requestScope.userList!=null && requestScope.userList.size()>0}">
						<c:forEach items="${requestScope.userList}" var="userObj">
							<tr class='${userObj.active?"":"disabled" }'>
								<td onclick="editUser(${userObj.idUser})" class="hand"><c:out value="${userObj.idUser}" /></td>
								<td onclick="editUser(${userObj.idUser})" class="hand"><c:out value="${userObj.name}" /></td>
								<td onclick="editUser(${userObj.idUser})" class="hand"><c:out value="${userObj.login}" /></td>
								<td onclick="editUser(${userObj.idUser})" class="hand"><c:out value="${userObj.role}" /></td>
								<td class="no-strike">
									<a href="#" onclick="disableUser(${userObj.idUser}, ${userObj.active})"><c:choose>
										<c:when test="${userObj.active}"><i class="icon-remove"></i></c:when>
										<c:otherwise><i class="icon-ok"></i></c:otherwise>
									</c:choose></a>
									<a href="#myModal" onclick="document.deleteForm.idUser.value=${userObj.idUser}" role="button" data-toggle="modal"><i class="icon-trash"></i></a>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan="3" align="center">No se han encontrado usuarios en el sistema</td></tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		
		<!-- Delete user Modal -->
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  			<div class="modal-header">
    			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    			<h3 id="myModalLabel">Eliminar usuario</h3>
  			</div>
  			<div class="modal-body">
    			<p>¿Está seguro de que desea eliminar este usuario?</p>
    			<p>Esta acción no se puede deshacer</p>
  			</div>
  			<div class="modal-footer">
    			<button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
    			<button class="btn btn-danger" onclick="document.deleteForm.submit()">Continuar</button>
  			</div>
		</div>
</span>

</div>