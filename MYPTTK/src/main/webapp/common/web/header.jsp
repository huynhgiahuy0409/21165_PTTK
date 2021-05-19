<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Navigation -->
<div class="header_section header_main">
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="logo"><a href="#"><img src="template/web/images/logo.png"></a></div>
				</div>
				<div class="col-sm-9">
					<nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                           <a class="nav-item nav-link" href="<c:url value = "/trang-chu"/>">Home</a>
                           <a class="nav-item nav-link" href="<c:url value = "/product-page"/>">Product</a>
                           <a class="nav-item nav-link" href="<c:url value = "/sale-page"/>">Sale</a>
                           <a class="nav-item nav-link" href="<c:url value = "/blog-page?page=1&maxPageItem=9&sortName=title&sortBy=desc" />">Blog</a>
                           <a class="nav-item nav-link" href="<c:url value = "/contact-page"/>">Contact</a>
                           <a class="nav-item nav-link last" href="<c:url value="/search-bar"/>"><i class="fas fa-search"></i></a>
                           <a class="nav-item nav-link last" href="<c:url value="/account"/>"><i class="fas fa-user"></i></a>
                           <a class="nav-item nav-link last" href="<c:url value="/wishlist"/>"><i class="fas fa-heart"></i></a>
                           <a class="nav-item nav-link last" href="<c:url value="/shopping-cart"/>"><i class="fas fa-shopping-cart"></i></a>
                        </div>
                    </div>
                    </nav>
				</div>
			</div>
		</div>
</div>