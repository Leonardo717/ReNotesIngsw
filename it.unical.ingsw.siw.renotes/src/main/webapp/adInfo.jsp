<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Descrizone Inserzione</title>
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
  
  <script src="js/javaScriptUtility.js"></script>
  
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
        <!-- Left -->
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
			<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-auto my-auto my-md-auto">
     			<div class="input-group">
      				 <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
       					<li class="nav-item">
           					 <a class="nav-link" target="_blank">
              					<i class="fas fa-search"></i>
           					 </a>
          				</li>
      			</div>
			</form>
          </li>
        </ul>

        <!-- Right -->
        <ul class="navbar-nav nav-flex-icons">

          <li class="nav-item">
            <a class="nav-link" href="cart">
              <i class="fas fa-cart-arrow-down"></i>
            </a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" target="_blank">
              <i class="fas fa-user"></i>
            </a>
          </li>
          
        </ul>

      </div>

    </div>
  </nav>
  <!-- Navbar -->

</header>
	
	
	<main>
		  <br> <br>
    <div class="container">

      <!--Section: Main info-->
      <section class="mt-5 wow fadeIn">
        <!--Grid row-->
        <div class="row">
          <!--Grid column-->
          <div class="col-md-4 mb-3 my-4">

            <img src="${ad.getPreview().getImage()}" class="img-fluid z-depth-1-half my-2"  alt="" width="200" height="200">
			<figcaption>Created by ${user.getUsername()} </figcaption>
          </div>
          <!--Grid column-->

          <!--Grid column-->
      <div class="col-md-6 mb-4">
			<!-- Main heading -->
      <h3 class="h3 mb-3">${ad.getTitle()}</h3>
      <div class="section1Content">
  	  <p><span>Materia :</span> ${ad.getSubject()}</p>
      <p><span>Universita' :</span> ${ad.getUniversity()}</p>
      <p><span>Corso di Laurea :</span> ${ad.getDegreeCourse()}</p>
	  <p class="text-danger h4"> ${ad.getPrice()} <a class="fas fa-euro-sign"></a></p>
	 
   	  <form method="post" action="ManageCart">
   	  	<textarea name="adIdAdd" hidden>${ad.getId()}</textarea>
   	  	<input type="submit" class="btn btn-success btn-md text-white font-weight-bold" value="AGGIUNGI AL CARRELLO" />
   	  </form>
   	   <form method="" action="">
   	  	<input type="submit" class="btn btn-warning btn-md text-white font-weight-bold" value="EVENTUALMENTE RECENSISCI" />
   	  </form>
		  </div>
            <!-- Main heading -->
          </div>
          <!--Grid column-->

        </div>
        <!--Grid row-->

      </section>
      <!--Section: Main info-->

      <hr class="my-3">

      <!--Section: Main features & Quick Start-->
      <section>

        <!--Grid row-->
        <div class="row wow fadeIn">

          <!--Grid column-->
          <div class="col-lg-6 col-md-12 px-4">

            <!--First row-->
            <div class="row">
              <div class="col-3 mr-2">
              </div>
              <div class="col-10">
                <h2 class="my-3 h3 text-center">VALUTAZIONE</h2>
                <article class="section2Content">
     		 		<div class="section1Content">
     		 			<div class="form-row">
     		 				<div class="col-3 my-3"> 
			      		 		<p><span>Qualita' :</span></p>
			      		 		<p><span>Attendibilita' :</span></p>
			      		 		<p><span>Completezza :</span></p>
	      		 			</div>
	      		 			
	      		 			<div class="col-3" id="statistics">
		      		 			
	      		 			</div>
	      		 			
	      		 		</div>
   			 		</div>
   			 		
    		 	</article>
             </div>
            </div>
            <!--/First row-->
          </div>
          <!--/Grid column-->

          <!--Grid column-->
          <div class="col-lg-6 col-md-12 text-center">
          	<h2 class="my-3 h3 text-center">DESCRIZIONE</h2>
          		<article class="section2Content">
          			<div class="section1Content">
          				<div class="text-black-50">
          					${ad.getDescription()}
          				</div>
          			</div>
          		</article>

          </div>
          <!--/Grid column-->

        </div>
        <!--/Grid row-->

      </section>
      <!--Section: Main features & Quick Start-->

      <hr class="my-5">

      <!--Section: More-->
      <section>

    <h2 class="my-5 h3 text-center">COMMENTI</h2>
    	<hr class="font-weight-bold">
		   <!-- Content -->
      <div class="container">

        <!--Grid row-->
        <div class="row wow fadeIn">

          <!--Grid column-->
          <div class="col-md-6 mb-4 text-center text-md-left">

			<table>
				<c:if test="${reviews == null}">
					<tr>
						<td>
							<h5> NESSUN COMMENTO </h5>
						</td>
					</tr>
				
				</c:if>
				
				<c:if test="${reviews != null}">
					<c:forEach items="${reviews}" var="review">
						<tr>
							<td>
					  			<hr class="font-weight-bold">
					  			
		           				<h5 class="font-weight-bold"> ${review.getUser().getUsername()} </h5>
		
		            			<hr class="font-weight-bold">
		
		            			<p> Qualita':
		              				<span>${review.getQuality()} <i class="fas fa-star text-warning"></i> </span>
		            			</p>
								<p> Attendibilita':
		              				<span>${review.getReliability()} <i class="fas fa-star text-warning"></i> </span>
		            			</p>
								<p> Completezza:
		              				<span>${review.getCompleteness()} <i class="fas fa-star text-warning"></i> </span>
								</p>
				    			
				    			<hr class="font-weight-bold">
				    											
								<div class="col-md-30">
									${review.getComment() }
					  			</div>
					  			
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>

          </div>
          <!--Grid column-->
			
        </div>
        <!--Grid row-->

      </div>
      <!-- Content -->

	<hr class="font-weight-bold">
      </section>
	</div>
	<br>
	<br>
	<footer class="page-footer position-fixed col-12 footer-card">
  			<p class="footerDisclaimer text-center"><span>ReNotes 2019-2020</span></p>
	</footer>
  </main>
  
   <script>
  $(window).on('load', function() {
	 calculateParameters( ${stat["0"]}, ${stat["1"]}, ${stat["2"]} );
  });
  </script>
  
</body>
</html>
