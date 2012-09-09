<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="gandul" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="entry-view" tagdir="/WEB-INF/tags/entry-views" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
    <head>
        <title>${ journalEntry.id }</title>
        <gandul:bootstrap-head/>
    </head>
    <body>
        <gandul:navbar/>
        <div class="container">
            <c:choose>
                <c:when test="${journalEntry.type == 'DIAGNOSIS'}">
                    <entry-view:diagnosis entry="${journalEntry}" />
                </c:when>
            </c:choose>
        </div>
    </body>
</html>