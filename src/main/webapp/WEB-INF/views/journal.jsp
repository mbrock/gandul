<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="sv">
    <head>
        <title>Journal</title>
        <link href="/static/bootstrap/css/bootstrap.css" rel="stylesheet" />
        <style>
            body {
                padding-top: 60px;
            }
        </style>
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Gandul</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="active"><a href="#">Journal</a></li>
                            <li><a href="#about">Administration</a></li>
                            <li><a href="#contact">Annat</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

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
                                <c:if test="${journalEntry.stricken}">
                                    <span class="label label-warning">Struken</span>
                                </c:if>
                                ${journalEntry.entryText}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="/static/bootstrap/js/bootstrap.js"></script>
    </body>
</html>