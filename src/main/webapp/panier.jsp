<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Panier</title>
      <meta name="keywords" content="e-commerce">
      <meta name="description" content="cart">
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
   <style>
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
 </c:forEach>                  </div>
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
                            <div class="header_box">
    <div class="login_menu">
        <ul class="menu-list">
           <li style="margin-right:50px;">
                <a href="panier.jsp">
                    <i class="fa fa-shopping-cart fa-lg position-relative" ></i>
                    <span class="position-absolute top-0 start-100 translate-middle p-2 rounded-circler">
                    <input type="text" class="form-control cart-badge" value="0" id="cartLengthInput">
                    </span>
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
                        </div>
            </div>
         </div>
         <!-- banner section end -->
      </div>
      <!-- banner bg main end -->
      
      <!-- Cart Starts -->
     <!-- 
  Bootstrap docs: https://getbootstrap.com/docs
  Get more snippet on https://bootstraptor.com/snippets
-->

<section class="pt-5 pb-5">
  <div class="container col-lg-8 col-md-8 col-8">
    <div class="row w-100">
        <div class="col-lg-12 col-md-12 col-12">
            <h1 class="fashion_taital">Panier</h1>
			<br>
            <table id="cartDataDisplay" class="table table-condensed table-responsive table-striped">
<thead class="thead-light">                    <tr>
                        <th style="width:20%">Photo</th>
                        <th style="width:12%">Nom</th>
                         <th style="width:16%">Categorie</th>
                        <th style="width:10%">Prix</th>
                        <th style="width:16%">Quantité</th>                        
                         <th style="width:16%">total</th>
                          <th style="width:16%">action</th>
                    </tr>
                </thead>
<tbody  >                </tbody>
            </table>
            <div class="float-right text-right">
                <h2>Total:</h2>
                <h1 id="Totalpanier"></h1>
            </div>
        </div>
    </div>
    <div class="row mt-4 d-flex align-items-center">
        <div class="col-sm-6 order-md-2 text-right">
                  
        <c:if test="${sessionScope.isUserLoggedIn}">
            <button id="commandButton" class="btn btn-success mb-4 btn-lg pl-5 pr-5">Commander</button>
        </c:if>
        <c:if test="${empty sessionScope.isUserLoggedIn}">
       <a href="login.jsp" class="btn btn-success mb-4 btn-lg pl-5 pr-5">Commander</a>
         	</c:if>
        </div>
        <div class="col-sm-6 mb-3 mb-m-1 order-md-1 text-md-left">
            <a href="ServletIndex">
                <i class="fa fa-arrow-left mr-2"></i>Retour au magasin</a>
        </div>
    </div>
</div>
</section>
      <!-- Cart Ends -->
      
		<!-- footer section start -->
      <div class="footer_section layout_padding">
         <div class="container">
            <p class="h2 text-center">VenuStyle</p>
            <div class="input_bt">
               <input type="text" class="mail_bt" placeholder="Email" name="Email">
               <span class="subscribe_bt" id="basic-addon2"><a href="#">S'abonner</a></span>
            </div>
            <div class="location_main">Fixe : 05 22 33 44 55</div>
         </div>
      </div>
      <!-- footer section end -->
      <!-- copyright section start -->
      <div class="copyright_section">
         <div class="container">
            <p class="copyright_text">© 2023 All Rights Reserved to VenuStyle teams.</p>
         </div>
      </div>
      <!-- copyright section end -->
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
        // Retrieve data from local storage
      var cartData = localStorage.getItem("cart");

        // Display data in the HTML table
        var cartDataDisplay = document.getElementById("cartDataDisplay");
        var tbody = cartDataDisplay.querySelector("tbody");
        
        if (cartData !== null) {
            var parsedCartData = JSON.parse(cartData);
            if (Array.isArray(parsedCartData)) {
                parsedCartData.forEach(function(item) {
                    var row = document.createElement("tr");
                    
                    var imageCell = document.createElement("td");
                    var imageElement = document.createElement("img");
                    var imgeeee = "assets/images/"
                        imageElement.src =imgeeee+item.urlPhoto;
                    imageCell.appendChild(imageElement);
                    row.appendChild(imageCell);
                    
                    
                    var nameCell = document.createElement("td");
                    nameCell.textContent = item.nom;
                    row.appendChild(nameCell);
                    
                    var catCell = document.createElement("td");
                    catCell.textContent = item.categorie;
                    row.appendChild(catCell);
                    
                    var priceCell = document.createElement("td");
                    priceCell.textContent = item.prix;
                    row.appendChild(priceCell);
                    
                  
                          
                    var q = document.createElement("td");
                     q.style.display = 'flex'; 
                     q.style.alignItems = 'center';
 
                    var boutn1 = document.createElement("button");
                    boutn1.textContent = "-";
                    boutn1.className = "btn btn-link px-2";

                    var input1 = document.createElement("input");
                    input1.className = "form-control form-control-sm";
                    input1.style.margin = '0 5px'; // Adjust margin for proper spacing
                    input1.style.width = '50px'; // Set a specific width for the input field
                    input1.style.padding = '5px'; // Adjust padding for the input field
                    input1.style.boxSizing = 'border-box';
                    input1.value = item.quantity_choisis;

                    var boutn2 = document.createElement("button");
                    boutn2.textContent = "+";
                    boutn2.className = "btn btn-link px-2";
                  
                     q.appendChild(boutn1);
                    q.appendChild(input1);
                    q.appendChild(boutn2);
                    row.appendChild(q);
                    boutn2.addEventListener("click", function() {
                    	input1.value++
                    	item.quantity_choisis++
                        localStorage.setItem("cart", JSON.stringify(parsedCartData));
                    	location.reload();
                    });
                    boutn1.addEventListener("click", function() {
                    	if(input1.value>1){
                    	
                    		input1.value--
                    	    item.quantity_choisis--
                    	    localStorage.setItem("cart", JSON.stringify(parsedCartData));
                    		location.reload();
                    	}
                    	
                    });
      
                    
                    var total_row = document.createElement("td");
                    total_row.textContent = parseFloat(item.quantity_choisis)*parseFloat(item.prix);
                    row.appendChild(total_row)
                    item.totalrow =parseFloat(item.quantity_choisis)*parseFloat(item.prix);

                     localStorage.setItem("cart", JSON.stringify(parsedCartData));

                    var v = document.createElement("td");
                    var btn = document.createElement("button");
                    btn.className = "btn btn-danger"; 
                    btn.textContent = "supprimer";
					btn.addEventListener("click", function() {
			            removeFromCart(item.idProduit); // Call the function with the idProduit
			            location.reload();
						
					});
					
					
					function removeFromCart(idProduit) {
					    // Get existing cart items from localStorage
					    var cartItems = JSON.parse(localStorage.getItem("cart")) || [];

					    // Find the index of the item with the specified idProduit
					    var index = -1;
					    for (var i = 0; i < cartItems.length; i++) {
					        if (cartItems[i].idProduit === idProduit) {
					            index = i;
					            break;
					        }
					    }

					    if (index !== -1) {
					        // Remove the item at the found index
					        cartItems.splice(index, 1);

					        // Save the updated cart back to localStorage
					        localStorage.setItem("cart", JSON.stringify(cartItems));

					        // Refresh the cart display
					        

					        alert("Produit supprimé du panier !");
					    }
					}
                    v.appendChild(btn);
                    row.appendChild(v); 
                    
                    tbody.appendChild(row);

                });
            } else {
                cartDataDisplay.textContent = "Cart data is not in the expected format.";
            }
        } else {
            cartDataDisplay.textContent = "Cart data is empty.";
        } 
        
         var s = JSON.parse(localStorage.getItem("cart"));
    	const reducedValue = s.reduce((accumulator, currentObject) => {
    	  return accumulator + currentObject.totalrow;
    	}, 0);
    	//console.log(reducedValue)  
        var total = document.getElementById("Totalpanier");
			total.innerHTML = reducedValue+"DH";  
document.addEventListener("DOMContentLoaded", function() {
    var commanderButton = document.getElementById("hrefcommande");

    commanderButton.addEventListener("click", function(event) {
        event.preventDefault(); // Prevent the default behavior of the link

        var payload = {
        		cartData: parsedCartData, // Your cart data here
            otherInfo: "Additional information if needed"
        };

        var servletUrl = 'ServletCommande';

        fetch(servletUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(payload)
        })
        .then(response => response.json())
        .then(data => {
            // Handle the response from the servlet if needed
            console.log('Response from servlet:', data);
            // Now, you can redirect the user to a confirmation page or perform other actions
            window.location.href = 'confirmationPage.jsp';
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});
//Assuming cartData is a valid JSON array
var cartData = JSON.parse(cartData); // Your cart data here
// Create an object with the data to send
var payload = {
    cartData: cartData,
    otherInfo: "Additional information if needed"
};

var servletUrl = 'ServletCommande'; // Adjust this URL to match your servlet's path


 fetch(servletUrl, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(payload)
})
.then(response => response.json())
.then(data => {
    // Handle the response from the servlet if needed
    console.log('Response from servlet:', data);
    // Now, you can redirect the user to a confirmation page or perform other actions
    window.location.href = 'confirmationPage.jsp';
})
.catch(error => {
    console.error('Error:', error);
});
 cartLength = JSON.parse(localStorage.getItem("cart"));
 console.log("hhh",cartLength)
	const reducedValueint = cartLength.reduce((accumulator, currentObject) => {
	  return accumulator + currentObject.quantity_choisis;
	}, 0);
	console.log(reducedValueint)     	
	document.getElementById("cartLengthInput").value = reducedValueint;


</script>
  
</body>
</html>