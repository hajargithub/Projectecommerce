<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>VenuStyle</title>
      <meta name="keywords" content="e-commerce">
      <meta name="description" content="shop">
      <meta name="author" content="Group1">
      <!-- bootstrap css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/favicon.ico" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <!-- fonts -->
      <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
      <!-- font awesome -->
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <!--  -->
      <!-- owl stylesheets -->
      <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesoeet" href="css/owl.theme.default.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
   <style type="text/css">
   .cart-badge {
    width: 39px;;
    text-align: center;
    background-color: #ebcbae;
    color: #000;
    border-radius: 50%;
    font-weight: bold;
    margin-right: 5px;
}
.menu-list {
    display: flex;
    list-style: none;
    padding: 0;
    margin: 0;
}

.menu-list li {
    margin-right: 10px; /* Adjust spacing between menu items */
}
   </style>
   </head>
   <body>
    <!-- banner bg main start -->
      <div class="banner_bg_main">
         <!-- logo section start -->
         <div class="logo_section">
            <div class="container">
               <div class="row">
                  <div class="col-sm-12">
                     <div class="logo"><img src="pics/l1.png"></div>
                  </div>
               </div>
            </div>
         </div>
         <!-- logo section end -->
         <!-- header section start -->
         <div class="header_section">
            <div class="container">
               <div class="containt_main">
                  <div id="mySidenav" class="sidenav">
                     <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                     <a href="ServletIndex">Accueil</a>
                     <c:forEach var="C" items="${ListC}">
  <a  href="detailCategorieServlet?idC=${C.idCategorie}">${C.title}</a>
 </c:forEach>
                  </div>
                  <span class="toggle_icon" onclick="openNav()"><i class="fa fa-bars fa-lg"></i></span>
                  <div class="dropdown">
                     <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tous Les Catégories 
                     </button>
                     <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                       
                         <c:forEach var="C" items="${ListC}">
                          <a class="dropdown-item" href="detailCategorieServlet?idC=${C.idCategorie}">${C.title}</a>
 </c:forEach>
                         
                     </div>
                  </div>
                  <div class="main">
                     <!-- Another variation with a button -->
                     <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search">
                        <div class="input-group-append">
                           <button class="btn btn-secondary" type="button" style="background-color: #ebcbae; border-color:#ebcbae ">
                           <i class="fa fa-search"></i>
                           </button>
                        </div>
                     </div>
                  </div>
              <div class="header_box">
    <div class="login_menu">
        <ul class="menu-list">
            <li>
                <a href="panier.jsp">
                    <input type="text" class="form-control cart-badge" value="0" id="cartLengthInput">
                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                    <span class="padding_10">Panier</span>
                </a>
            </li>
            <li>
                <a href="login.jsp">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <span class="padding_10">Login</span>
                </a>
            </li>
        </ul>
    </div>
</div>

               </div>
            </div>
         </div>
         <!-- header section end -->
         <!-- banner section start -->
         <div class="banner_section layout_padding">
            <div class="container">
                        <div class="row">
                           <div class="col-sm-12">
                              <h1 class="banner_taital">Commencez <br>vos achats préférés</h1>
                              <div class="buynow_bt"><a href="#sectionProduits">Explorer</a></div>
                           </div>
                        </div>
            </div>
         </div>
         <!-- banner section end -->
      </div>
      <!-- banner bg main end -->

      <!-- fashion section start -->
      <div class="fashion_section">

         <div id="main_slider" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
               <div class="carousel-item active">
                  <div class="container" id="sectionProduits">
                     <h1 class="fashion_taital">Nos produits</h1>
                     <div class="fashion_section_2">
                        <div class="row">
                         <c:forEach var="e" items="${ListP}">
                           <div class="col-lg-3 col-sm-3">
                              <div class="box_main">
                                 <h4 class="shirt_text">${e.nom}</h4>
                                 <div class="tshirt_img"><img src="assets/images/${e.urlPhoto}"></div>
                                 <div class="btn_main">
                                    <div class="buy_bt">
 <button type="button" class="btn app-btn-secondary" onclick="addToCart('${e.idProduit}', '${e.nom}', '${e.prix}','${e.quantite_dispo}','${e.urlPhoto}','${e.categorie.title }')"><i class="fa fa-cart-plus fa-lg" aria-hidden="true" ></i></button>
                                   </div>
                                 	  <span style="color: #719192;margin-top: 15px;font-weight: bold;">${e.prix}</span>
                                 </div>
                              </div>
                           </div>
                         </c:forEach>
                        </div>
                     </div>
                  </div>                  
               </div>
         </div>
      </div>
      </div>      
      <!-- fashion section end -->
      <jsp:include page="footer.jsp"></jsp:include>
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <script src="js/plugin.js"></script>
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
      <script>
         function openNav() {
           document.getElementById("mySidenav").style.width = "250px";
         }
         
         function closeNav() {
           document.getElementById("mySidenav").style.width = "0";
         }
      </script>
       <script>


    function addToCart(idProduit, nom, prix, quantity_dispo, urlPhoto,categorie ) {
			//check if the storage is availble in your browser
	  if (typeof(Storage) !== "undefined") {
		 
		  if(quantity_dispo > 0){
			  
			  console.log("storage is exist")
			    var cartItems = localStorage.getItem("cart") ?  JSON.parse(localStorage.getItem("cart")) : [];
				
			        if(localStorage.getItem("cart")){
			        	console.log("local storage is full")

					 const filteredProducts = cartItems.filter(e => e.idProduit === idProduit);
			       	 console.log(filteredProducts)

			         if (filteredProducts[0]) {	
			        	var qt = filteredProducts[0].quantity_choisis += 1
			        	 
			        	console.log("id exist")
						console.log("qt",qt)
						
				    if(quantity_dispo>=qt){

			    	
			        localStorage.setItem("cart", JSON.stringify(cartItems));
			    	location.reload();

				        	}
			        		
			         }else{ 
			     		console.log("idproduct is not exist")
			     		var quantity_choisis =1
				        	if(quantity_dispo>=quantity_choisis){
				        	      var product = {
			                idProduit: idProduit,
			                nom: nom,
			                prix: prix,
			                quantity_dispo :quantity_dispo,
			                quantity_choisis: quantity_choisis,
			                totalrow : prix,
			                urlPhoto : urlPhoto,
			                categorie:categorie,
			                
			             
			            };
			        
				
			        // Add the selected product to the cart
			         cartItems.push(product);

			        // Save the updated cart back to localStorage
			        localStorage.setItem("cart", JSON.stringify(cartItems));
			    	location.reload();
	
				        		
				        	}

			  
			   }
				
				}
			        else {
			        	//localstorage here is empty (first add to the localstorage)
			        	var quantity_choisis =1
			        	console.log("array emty")
			        	if(quantity_dispo>=quantity_choisis){
			        		var product = {
				                    idProduit: idProduit,
				                    nom: nom,
				                    prix: prix,
				                    quantity_dispo :quantity_dispo,
				                    quantity_choisis: quantity_choisis,
				                    totalrow : prix,
				                    urlPhoto : urlPhoto,
				                    categorie:categorie,

				                    
				                };
				            
				    	
				            // Add the selected product to the cart
				             cartItems.push(product);

				            // Save the updated cart back to localStorage
				            localStorage.setItem("cart", JSON.stringify(cartItems));
				            alert("Produit ajouté au panier !");
				            console.log("Produit ajouté au panier ")
				        	location.reload();

				        
				  
			        	}
			        	
			  
			  
		  }
		  }else{
			  console.log("cant add to cart")		  }
	
        
        
        
	  } 
	  else {
        alert("LocalStorage n'est pas disponible dans ce navigateur.");
    }
}

cartLength = JSON.parse(localStorage.getItem("cart"));
	const reducedValue = cartLength.reduce((accumulator, currentObject) => {
	  return accumulator + currentObject.quantity_choisis;
	}, 0);
	console.log(reducedValue)     	
 	document.getElementById("cartLengthInput").value = reducedValue;


</script>
      
   </body>
</html>