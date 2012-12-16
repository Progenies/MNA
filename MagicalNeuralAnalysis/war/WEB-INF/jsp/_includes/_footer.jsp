<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<fmt:setBundle basename="i18n.generalApp" var="generalApp" scope="application" />
            <footer>
                <p><fmt:message key="COPYRIGHT" bundle="${generalApp}" /></p>
            </footer>
