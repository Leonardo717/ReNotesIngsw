<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ad Info</title>
	
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

	
</head>
<body id="page-top">
	<div id="content-wrapper"> 
		<div id="container-fluid"> 
			<div class="row">
				
				<aside class="col-xs-3 col-sm-3 col-lg-3 jumbotron">
					<figure>
					  <img src="${ad.getPreview().getImage()}" alt="AD iMAGE" width="300"/>
					  	 <figcaption>Created by ${user.getUsername()} </figcaption>
					 
					</figure>
				</aside>
				
				<div class="col-xs-1 col-sm-1 col-lg-1 jumbotron"></div>
				
				<div class="col-xs-4 col-sm-4 col-lg-4 jumbotron"> 
					<div> <h3> ${ad.title} </h3><br></div>	
					<div> <h3> ${ad.subject} </h3><br> </div>
					<div> <h3> ${ad.university} </h3><br></div>
					<div> <h3> ${ad.degreeCourse} </h3><br>	</div>
				</div>
				
				<div class="col-xs-1 col-sm-1 col-lg-1 jumbotron"></div>
				
				<div class="col-xs-3 col-sm-3 col-lg-3 jumbotron"> 
				<button class="btn btn-link btn-sm text-warning bg-success" > ${ad.price} </button>
				</div>	
			
			</div>
			<div >	
			
				<div> <h5> Quality: ${stat["0"] } </h5><br></div>	

				<div> <h5> Reliability:	${stat["1"] } </h5><br> </div>

				<div> <h5> Completeness: ${stat["2"] } </h5><br></div>
				
			</div>
			
			<div class="card mb-4">
				<div class="card-header"> Description </div>
				<div class="card-body"> ${ad.getDescription()} </div>
				<div class="card-footer"></div>
			
			</div>
		</div>
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
	
	<a class="scroll-to-top rounded" href="#page-top" style="display: none;">
		<i class="fas fa-angle-up"></i>
	</a>
	
</body>
</html>