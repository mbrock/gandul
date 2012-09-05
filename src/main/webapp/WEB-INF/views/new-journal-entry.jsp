<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <title>New entry</title>
    </head>
    <body>
        <h1>Total of <c:out value="${fn:length(requestScope.journalEntries)}" /></h1>
    </body>
</html>