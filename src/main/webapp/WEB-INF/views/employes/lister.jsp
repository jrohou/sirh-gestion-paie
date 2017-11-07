<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Liste des employés</title>

    <!-- css Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/bootstrap-theme.min.css" rel="stylesheet">
    
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-left: 12%;">
        <a class="navbar-brand" href="<c:url value='/lister'/>">Employé</a>
        <a class="navbar-brand" href="<c:url value='../bulletin/lister'/>">Bulletin</a>
    </nav>



    <div class="container">
        <div class="text-center">
            <h1>Liste des employés</h1>
        </div>

        <a href="<c:url value='creer'/>" class="btn btn-info" role="button" style="margin-bottom:2%;margin-left:87%;">Ajouter un employé</a>

        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th width="40%;">Date / Heure de création</th>
                    <th>Matricule</th>
                    <th>Grade</th>
                </tr>
            </thead>
            <c:forEach var ="employe" items="${requestScope.listerEmployes}">
            <tbody>
                <tr>
                    <c:if test="${!empty employe}">
                    <td><c:out value="${employe.creationDate }"/></td>
                    <td><c:out value="${employe.matricule }"/></td>
                    <td><c:out value="${employe.grade.code }"/></td>
                    </c:if>
                </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>
</body>

</html>