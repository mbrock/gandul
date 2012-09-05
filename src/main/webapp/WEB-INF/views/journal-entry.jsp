<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html>
    <head>
        <title>Hello, world!</title>
    </head>
    <body>
        <h1>Hello, world!</h1>
        <ol>
            <c:forEach items="${requestScope.journalEntries}" var="entry">
                <li><tags:jsonify value="${entry}"/></li>
            </c:forEach>
        </ol>
    </body>
</html>