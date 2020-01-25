<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Checkout</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="css/mdb.min.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="css/style.min.css" rel="stylesheet">
	<!-- SCRIPTS -->
  <!-- JQuery -->
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>
  <!-- Initializations -->
</head>

<body>
<!-- Header content -->
<header>
<!-- NavBar -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">
    <div class="container">

      <!-- Brand -->
      <a class="navbar-brand" href="index.html">
        <strong>ReNotes</strong>
      </a>

      <!-- Collapse -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Links -->
      <div class="collapse navbar-collapse" id="navbarSupportedContent">

        

      </div>

    </div>
  </nav>
  <!-- Navbar -->

</header>
	<main>
		<div class="container my-5">
			<div class="row my-5">
				<div class="col-xl-1"></div>
				<div class="col-xl-5 my-5">
					<table >
						<c:forEach items="${cart.getAds()}" var="ad">
							<tr>
								<td>
									<div class="my-3">
										<p class="h5 text-truncate"><span>${ad.getTitle()}</span></p>
										<hr class="my-0">
									</div>
								</td>
							</tr>
						</c:forEach>
				</table>
			</div>
				<div class="col-xl-6 my-5 text-center">
					<p class="h6 font-weight-bold text-danger ml-4"><span>${cart.getTotal()} <i class="fas fa-euro-sign"></i></span></p>
					<form>
						<input type="submit" class="btn bg-success btn-md text-white font-weight-bold ml-5" value="CHECKOUT"/>
					</form>
					</div>
		</div>
			<hr class="my-3">

		<div class="row text-center">
			<div class="col-xl-3">
				
			</div>
			<div class="col-xl-6 my-5">
				<p class="h3 font-weight-bold my-2 mr-5"><span>SCEGLI METODO DI PAGAMENTO</span></p>
				<table>
					<c:forEach items="${payments}" var="payment">
							<tr>
								<td>
									<div class="my-3">
										<c:if test="${payment.isDefault()}">
											<input type="radio" name="selectedMethod" checked> ${payment.getCardNumber()}
										</c:if>
										
										<c:if test="${not payment.isDefault()}">
											<input type="radio" name="selectedMethod"> ${payment.getCardNumber()}
										</c:if>
										
										<hr class="my-0">
									</div>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td>
							<input type="submit" class="btn bg-warning btn-md text-white font-weight-bold my-5 ml-5" value="AGGIUNGI UN NUOVO METODO DI PAGAMENTO"/>
							</td>
						</tr>
				</table>
				</div>
			</div>
		</div>
		<footer class="page-footer position-fixed col-12 footer-card">
  			<p class="footerDisclaimer text-center"><span>ReNotes 2019-2020</span></p>
		</footer>
	</main>
</body>
</html>