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
                    
                </div>
            </div>
</div>