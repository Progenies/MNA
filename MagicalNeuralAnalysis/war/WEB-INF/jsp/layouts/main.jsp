<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<tiles:insertAttribute name="header" />
<head>
	<tiles:insertAttribute name="html_head" />
</head>

<fmt:setLocale value="${requestScope.locale}" />
<fmt:setBundle basename="i18n.generalApp" var="generalApp" scope="application" />


    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->


		<tiles:insertAttribute name="menu" />
		
 		<div class="container">

		<tiles:insertAttribute name="content" />
           

            <hr>

		<tiles:insertAttribute name="footer" />

        </div> <!-- /container -->

		<tiles:insertAttribute name="html_footer" />

    </body>
</html>

