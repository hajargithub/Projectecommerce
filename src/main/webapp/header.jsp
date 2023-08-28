<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                     <a href="venustyle.jsp">Accueil</a>
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
                        <ul>
                           <li><a href="panier.jsp">
                              <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                              <span class="padding_10">Panier</span></a>
                           </li>
                           <li><a href="login.jsp">
                              <i class="fa fa-user" aria-hidden="true"></i>
                              <span class="padding_10">Login</span></a>
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
                              <div class="buynow_bt"><a href="#">Explorer</a></div>
                           </div>
                        </div>
            </div>
         </div>
         <!-- banner section end -->
      </div>
      <!-- banner bg main end -->

</body>
</html>