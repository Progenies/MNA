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
					<c:forEach var="errMsgObj" items="${errors.allErrors}">  
					<li>  
						<spring:message code="${errMsgObj.code}" text="${errMsgObj.defaultMessage}"/>  
					</li>  
					</c:forEach>  
				</div>
			</spring:hasBindErrors>
		<form action="${pageContext.request.contextPath}/admin/Users/save" method="POST" class="form-horizontal">
			<fieldset>
				<legend>Datos del usuario:</legend>
				
				<div class="control-group">
    				<label class="control-label" for="name">Nombre:</label>
    				<div class="controls">
      					<input type="text" id="name" placeholder="Nombre">
    				</div>
  				</div>

				<div class="control-group">
    				<label class="control-label" for="name">Login:</label>
    				<div class="controls">
      					<input type="text" id="login" placeholder="Login">
    				</div>
  				</div>

				<div class="control-group">
    				<label class="control-label" for="name">Contraseña:</label>
    				<div class="controls">
      					<input type="text" id="passwd" type="password" placeholder="Contraseña">
    				</div>
  				</div>
  				
  				<div class="control-group">
    				<label class="control-label" for="name">Activo:</label>
					<div class="controls">
						<input type="checkbox" id="activo"/>
					</div>
  				</div>
  				
  				<div class="control-group">
  					<div class="controls"><a href="${pageContext.request.contextPath}/admin/Users/save" class="byn btn-large btn-primary">Guardar</a></div>
  				</div>
				
			</fieldset>
		</form>

	</span>

</div>