<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<fmt:setBundle basename="i18n.generalApp" var="generalApp" scope="application" />
<fmt:setBundle basename="i18n.menu" var="menu_messages" scope="application" />

<div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="${pageContext.request.contextPath}/"><fmt:message key="APPLICATION_NAME" bundle="${generalApp}" /></a>
                    
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                        	<c:forEach items="${requestScope.menu.entries}" var="menu">
                        		<%-- si es el punto activo poner class="active" --%>
                        		<c:choose>
				                     <c:when test="${menu.childs==null}">
                        				<li><a href="${pageContext.request.contextPath}${menu.url}"><fmt:message key="${menu.nameKey}" bundle="${menu_messages}" /></a></li>
                        			</c:when>
	                        		<c:otherwise>
		                            	<li class="dropdown">
		                            		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="${menu.nameKey}" bundle="${menu_messages}"  /><b class="caret"></b></a>
		                            		<ul class="dropdown-menu">
			                                	<c:forEach items="${menu.childs}" var="submenu">
				                                	<c:choose>
					                                	<c:when test="${submenu.url == null }" >
					                                		<li class="divider"></li>
	                                    					<li class="nav-header"><fmt:message key="${submenu.nameKey}" bundle="${menu_messages}" /></li>
					                                	</c:when>
					                                	<c:otherwise>
					                                		<li><a href="${pageContext.request.contextPath}${submenu.url}"><fmt:message key="${submenu.nameKey}" bundle="${menu_messages}" /></a></li>
					                                	</c:otherwise>
				                                	</c:choose>
			                                	</c:forEach>
			                                </ul>
		                            	</li>
	                           		</c:otherwise>
	                           	</c:choose>
                            </c:forEach>
                        </ul>
                        <p class="navbar-text pull-right">
                        	<fmt:message key="USER_NAME" bundle="${generalApp}" />: <c:out value="${requestScope.userProfile.name}"/>
                        </p>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>