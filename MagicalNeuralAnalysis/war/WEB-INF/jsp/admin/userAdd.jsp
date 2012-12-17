<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row">
	<h3>Mantenimiento de usuarios</h3>
	<span class="span3">
		<h4>Alta de usuario</h4>
		<p class="text-info">Facilite la informaciópn del nuevo usuario</p>
	</span>
	
	<span class="span9">
		
			<spring:hasBindErrors name="userData">
				<div class="alert alert-error">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<c:forEach var="errMsgObj" items="${errors.allErrors}">  
					<li>  
						<spring:message code="${errMsgObj.code}" text="${errMsgObj.defaultMessage}"/>  
					</li>  
					</c:forEach>  
				</div>
			</spring:hasBindErrors>
		<form:form name="theForm" commandName="userData" action="save" method="POST" class="form-horizontal">
			<fieldset>
				<legend>Datos del usuario:</legend>
				
				<c:if test="${requestScope.editingUser}">
					<form:hidden path="idUser"/>
				</c:if>
				
				<div class="control-group">
    				<label class="control-label" for="name">Nombre:</label>
    				<div class="controls">
      					<form:input path="name" placeholder="Nombre" required="true"/>
    				</div>
	    		</div>

				<div class="control-group">
    				<label class="control-label" for="login">Login:</label>
    				<div class="controls">
      					<form:input path="login" placeholder="Login" required="true"/>
    				</div>
  				</div>
  				
  				<div class="control-group">
    				<label class="control-label" for="name">Tipo de usuario:</label>
    				<div class="controls">
      					<form:select path="role">
      						<form:options />
      					</form:select>
    				</div>
  				</div>

  				<%-- Solo se establece contraseña para nuevos usuarios --%>
  				<c:if test="${!requestScope.editingUser}">
					<div class="control-group">
	    				<label class="control-label" for="password">Contraseña:</label>
	    				<div class="controls">
	      					<form:password path="password" placeholder="Contraseña" required="true"/>
	    				</div>
	  				</div>
  				
	  				<div class="control-group">
	    				<label class="control-label" for="repeatPassword">Repetir contraseña:</label>
	    				<div class="controls">
	      					<form:password path="repeatPassword" placeholder="Contraseña" required="true"/>
	    				</div>
	  				</div>
  				</c:if>
	  				
  				<div class="control-group">
    				<label class="control-label" for="active">Activo:</label>
					<div class="controls">
						<form:checkbox path="active" />
					</div>
  				</div>
  				
  				<div class="form-actions">
					<button type="submit" class="btn btn-large btn-primary">Guardar</button>
					<button type="button" onclick="document.location='list'" class="btn btn-large btn-danger">Cancelar</button>
  				</div>
				
			</fieldset>
		</form:form>

	</span>

</div>