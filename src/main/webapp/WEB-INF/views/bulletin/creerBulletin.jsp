<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Remplacer la ligne du dessus par celle-ci pour d�sativer le zoom -->
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Permet d'afficher un ic�ne dans la barre d'adresse -->
    <!-- <link rel="shortcut icon" href="image/favicon.png"> -->
    <title>Cr�er Bulletin</title>

    <!-- css Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- HTML5 Shim et Respond.js permet � IE8 de supporter les �l�ments du HTML5 -->
    <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-left: 12%;">
        <a class="navbar-brand" href="<c:url value='../employes/lister'/>">Employ�</a>
        <a class="navbar-brand" href="<c:url value='../bulletin/lister'/>">Bulletin</a>
    </nav>



    <div class="container">
        <a href="index.html"><i class="icon icon-arrow-left" aria-hidden="true" style="font-size:100px;color:black;"></i></a>
        <div class="text-center" style="margin-top: -8%;">
            <h1>Ajouter un bulletin</h1>
        </div>
        <form class="form-horizontal" role="form" name="form" action="lister" method="post">
            <div class="form-group">
                <label for="inputPeriode" class="col-sm-7 control-label">P�riode</label>
                <div class="col-sm-10">
                    <select class="form-control" name="periode">
                        <option>Veuillez choisir la p�riode</option>
                            <c:forEach var ="periode" items="${requestScope.listePeriode}">
                            <option value="${periode.id }">${periode.dateDebut} - ${periode.dateFin}</option>
                            </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="inputMatricule" class="col-sm-7 control-label">Matricule</label>
                <div class="col-sm-10">
                    <select class="form-control" name="matricule">
                        <option>Veuillez choisir la p�riode</option>
                            <c:forEach var ="matricule" items="${requestScope.listeEmploye}">
                            <option value="${matricule.id }">${matricule.matricule}</option>
                            </c:forEach>
                        </select>
                </div>
            </div>

            <div class="form-group">
                <label for="inputPrime" class="col-sm-7 control-label">Prime Exceptionnelle</label>
                <div class="col-sm-10">
                    <input type="text" name="prime" class="form-control" id="prime">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-20">
                    <button type="submit" class="btn btn-primary" style="margin-left: 54.5%;"><i class="icon icon-check icon-lg"></i> Ajouter</button>
                </div>
            </div>
        </form>

    </div>
</body>

</html>