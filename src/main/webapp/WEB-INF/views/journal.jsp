<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="gandul" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="sv">
    <head>
        <title>Journal</title>
        <gandul:bootstrap-head/>
    </head>
    <body>
        <gandul:navbar/>

        <div class="container">
            <h3>Journal</h3>

            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Text</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${journalEntries}" var="journalEntry">
                        <tr>
                            <td><a href="/journal-entry/${journalEntry.id}">${journalEntry.id}</a></td>
                            <td>
                                ${journalEntry.entryText}
                                <c:if test="${journalEntry.stricken}">
                                    <span class="label label-warning">Struken</span>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>