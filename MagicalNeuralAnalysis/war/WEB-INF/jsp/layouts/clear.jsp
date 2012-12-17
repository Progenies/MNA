<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<tiles:insertAttribute name="header" />

<fmt:setBundle basename="i18n.generalApp" var="generalApp" scope="application" />
<head>
	<tiles:insertAttribute name="html_head" />

    <style type="text/css">
      body {
        padding-top: 80px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

    </style>
</head>

 <body>
 
 	<tiles:insertAttribute name="menu" />

    <div class="container">
    	
    	<tiles:insertAttribute name="content" />
    	
     </div> <!-- /container -->

		<tiles:insertAttribute name="html_footer" />

    </body>
</html>