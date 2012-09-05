<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
    <head>
        <title>${ journalEntry.id }</title>
    </head>
    <body>
        <h1>${ journalEntry.id }</h1>
        <h2>${ journalEntry.entryText }</h2>
    </body>
</html>