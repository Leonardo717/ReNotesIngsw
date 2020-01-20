<!DOCTYPE html>
<html>
<head>
 <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="vendor/chart.js/Chart.min.js"></script>
  <script src="vendor/datatables/jquery.dataTables.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>
  
  <script src="js/calculateReview.js"></script>
	
</head>
<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="index.jsp">ReNotes</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
        <div class="input-group-append">
          <button class="btn btn-primary" type="button">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
      <li class="nav-item dropdown no-arrow mx-1">
        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-cart-arrow-down fa-fw"></i>
        </a>
        
      </li>
      <li class="nav-item dropdown no-arrow">
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user-circle fa-fw"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="#">Settings</a>
          <a class="dropdown-item" href="#">Activity Log</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
        </div>
      </li>
    </ul>

</nav>
	<!-- Footer Primay Color -->
<footer class="bg-primary"><br></footer><br>
	<!--Section Rounded Inserzione -->
<section class="text-white my-0 bg-dark mx-md-5 rounded-top col-4 h2">
	${ad.getTitle()}
	</section>
	<!-- Div Inserzione con Anteprima Materia Università e Cdl  -->
<div class="form-row mx-md-5 border bg-light">
	<section class="col-3 my-2">
	  <img src="${ad.getPreview().getImage()}" width="300" height="150" alt="" class="align-middle"/>
	  <figcaption>Created by ${user.getUsername()} </figcaption>
	</section>
	<section class="mx-md-4 col-2 my-3">
			<i class="text-body text">
			Materia:<br><br>
			Universita':<br><br>
			Corso di Laurea:<br>
			</i>
	</section>
	<section class="col-3 my-3">
		<i class="text-secondary">
		${ad.getSubject()}<br>
		<br>
		${ad.getUniversity()}<br>
		<br>
		${ad.getDegreeCourse()}<br>
    </i>
	</section>
	<section class="bg-light col-1 my-3 align-self-center">
		<em class="text-secondary">
			Qualita':<br>
			Completezza:<br>
			Attendibilita':<br>
			</em>
		</section>
		
	<section class=" my-3 ml-4 align-self-center" id="statistics">
		
	</section>
		
	</section>
	<section class="align-self-center col-1"></section>
	<section class="align-self-center">
		<i class="text-danger">${ad.getPrice()}</i><br>
		<button class="fas fa-cart-plus">
			</button>
		</section>
	</div>
	<br>
	
	<!-- Section Rounded Descrizione-->
<section class="text-white my-0 bg-dark mx-md-5 rounded-top col-2 h5">
	Descrizione
	</section>
	<!-- Box Descrizione -->
	<div class="mx-md-5 border bg-light">
		<section class="mx-md-3 break-word"> 
			<br>
			${ad.getDescription()}<br>
			aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcccccccccccccccc
			<br>
			</section>
		</div>
	<br>
	<br>
	<!--Section Rounded di Commenti-->
	<section class="text-white my-0 bg-dark mx-md-5 rounded-top col-2 h5">
		Commenti
		</section>
	<!-- Box di Commenti-->
	<div class="mx-md-5 border bg-light">
		<section class="mx-md-3 break-word" id="reviewsValues" > 
			
		</section>
		</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
			
	<footer class="sticky-footer">
		<div class="container my-auto copyright">
			<div class="text-center my-auto text-light">
				<br>
	            <span>ReNotes 2019-2020</span>
				<br>
				<br>
	         	</div>
          	</div>
		</footer>
		
	<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  <script>
  $(document).ready(function() {
	 calculate(${stat["0"]}, ${stat["1"]}, ${stat["2"]});
  });
  </script>
</body>
</html>
 