<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - App</title>
<link rel="stylesheet"
	href='<c:url value="/css/bootstrap.min.css"></c:url>'>
</head>
<body class="container">
	<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
	<c:if test="${param.error !=null}">
		<div class="alert alert-danger">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
			<strong>Erreur d'authentification !</strong> 
			<p>Identifiant ou mot de passe incorrect.</p>
			<p>Veuillez réessayer</p>
		</div>
	</c:if>
	
	<h1>Connexion</h1>
	<!-- Spring Security s'attend aux paramètres "username" et "password" -->
			              <form method="post">
                  <div class="form-group">
                    <label for="identifiant">Identifiant</label>
                    <input type="text" class="form-control" name="username" aria-describedby="Idendifiant" placeholder="Saisir votre Idendifiant" required>
                    <small id="identifiant" class="form-text text-muted">Veuillez saisir votre Idendifiant.</small>
                  </div>
                  <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <input type="password" class="form-control" name="password" aria-describedby="Password" placeholder="Saisir votre Mot de passe" required>
                    <small id="password" class="form-text text-muted">Veuillez saisir votre mot de passe.</small>
                  </div>
                  <div class="form-check">
                    <label class="form-check-label">
                      <input type="checkbox" class="form-check-input">
                      Se souvenir de moi
                    </label>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="close btn btn-secondary" data-dismiss="modal" aria-label="Close">Fermer</button>
                  <button class="btn btn-primary" type="submit"  id="btnConnecter">Se connecter</button>
                  			<sec:csrfInput/>
                </form>
</body>
</html>