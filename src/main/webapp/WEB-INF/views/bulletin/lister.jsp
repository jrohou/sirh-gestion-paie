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
    <title>Liste des bulletins</title>

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
        <!-- <a href="index.html"><i class="icon icon-arrow-left" aria-hidden="true" style="font-size:100px;color:black;"></i></a> -->
        <div class="text-center">
            <h1>Liste des Bulletin</h1>
        </div>

        <a href="<c:url value='creer'/>"  class="btn btn-info" role="button" style="margin-bottom:2%;margin-left:84%;">Cr�e un nouveau bulletin</a>

        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th width="20%;">Date / Heure de cr�ation</th>
                    <th>P�riode</th>
                    <th>Matricule</th>
                    <th>Salaire Brut</th>
                    <th>Net Impossable</th>
                    <th>Net A Payer</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>...</td>
                    <td>...</td>
                    <td>...</td>
                    <td>...</td>
                    <td>...</td>
                    <td>...</td>
                    <td>...</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>

</html>