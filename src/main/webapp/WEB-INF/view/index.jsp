<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<meta name="description" content="">
<!-- site metas -->
<title>SF</title>
<c:set var="now" value="<%=new java.util.Date()%>" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="template/imports_top.jsp"%>
</head>
<body>
	<section id="home" class="header-area">
		<%@include file="template/header.jsp"%>
		<div id="home" class="slider-area">
		<div class="bd-example">
			<div class="banner_section layout_padding layout_padding_all">
				<div class="banner_section_2">
					<div class="owl-carousel owl-theme gift_owl_carousel">

						<c:forEach items="${carousels}" var="carousel">
							<div class="item">
								<div class=" banner_main">
									<h3 class="banner_taital">${carousel.text}</h3>
									<img src="data:${carousel.type};base64,${carousel.image}" />
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			</div>
		</div>
	</section>
	
	
	<!-- about section start -->
	<!--====== ABOUT PART START ======-->

    <section id="about" class="about-area">
        <div class="container">
            <div class="row justify-content-center">
            	<div class="col-lg-12">
                    <div class="section-title text-center pb-20">
                        <h3 class="title">About Us</h3>
                    </div> <!-- row -->
                </div>
                <div class="col-xl-6 col-lg-8">
                    <div class="about-image text-center wow fadeInUp" data-wow-duration="1.5s" data-wow-offset="100">
                        <img src="<c:url value='images/about-img.png'/>">
                    </div>
                    <div class="section-title text-center mt-30 pb-40">
                        <h4 class="title wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.6s">The journey of your desired furniture starts here</h4>
                        <p class="text wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="1s">Sajgure Furniture in Buldhana is one of the leading businesses in the Carpenters</p>
                    </div> <!-- section title -->
                </div>
            </div> <!-- row -->
            
            <div class="row">
                <div class="col-lg-6">
                    <div class="single-about d-sm-flex mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="1.2s">
                        <div class="about-icon">
                            <img src="<c:url value='images/quality.jpeg'/>" alt="Icon">
                        </div>
                        <div class="about-content media-body">
                            <h4 class="about-title">Good Build Quality</h4>
                            <p class="text">Poorly designed presentations are a thing of the past. Create beautiful and high-quality content that is aligned.</p>
                        </div>
                    </div> <!-- single about -->
                </div>
                <div class="col-lg-6">
                    <div class="single-about d-sm-flex mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="1.4s">
                        <div class="about-icon">
                            <img src="<c:url value='images/durable.png'/>" alt="Icon">
                        </div>
                        <div class="about-content media-body">
                            <h4 class="about-title">Durable Materials</h4>
                            <p class="text">Poorly designed presentations are a thing of the past. Create beautiful and high-quality content that is aligned.</p>
                        </div>
                    </div> <!-- single about -->
                </div>
                <div class="col-lg-6">
                    <div class="single-about d-sm-flex mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="1.6s">
                        <div class="about-icon">
                            <img src="<c:url value='images/expertise.png'/>" alt="Icon">
                        </div>
                        <div class="about-content media-body">
                            <h4 class="about-title">Professional Expertise</h4>
                            <p class="text">Poorly designed presentations are a thing of the past. Create beautiful and high-quality content that is aligned.</p>
                        </div>
                    </div> <!-- single about -->
                </div>
                <div class="col-lg-6">
                    <div class="single-about d-sm-flex mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="1.8s">
                        <div class="about-icon">
                            <img src="<c:url value='images/intime.png'/>" alt="Icon">
                        </div>
                        <div class="about-content media-body">
                            <h4 class="about-title">Just in Time Delivery</h4>
                            <p class="text">Poorly designed presentations are a thing of the past. Create beautiful and high-quality content that is aligned.</p>
                        </div>
                    </div> <!-- single about -->
                </div>
            </div> <!-- row -->
        </div> <!-- container -->
    </section>

    <!--====== ABOUT PART ENDS ======-->
	
	<!-- about section end -->
	
	<!--====== FURNITURE WORK STYLE EIGHT START ======-->

    <section id="furniture-work" class="furniture-work-area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section-title text-center pb-20">
                        <h3 class="title">Our Furnitures Work</h3>
                        <p class="text">Stop wasting time and money designing and managing a website that doesn’t get results. Happiness guaranteed!</p>
                    </div> <!-- section title -->
                </div>
            </div> <!-- row -->
            <div class="row justify-content-center">
				<c:forEach items="${furnitureWorks}" var="furnitureWork">
					<div class="col-lg-4 col-md-7 col-sm-9">
						<div class="furniture-work-style-one mt-40 wow fadeIn"
							data-wow-duration="1.5s" data-wow-delay="0.2s">
							<div class="furniture-work-icon text-center">
								<img
									src="data:${furnitureWork.type};base64,${furnitureWork.image}" />
							</div>
							<div class="furniture-work-header text-center">
								<h5 class="sub-title">${furnitureWork.text}</h5>
							</div>
							<div class="furniture-work-btn rounded-buttons text-center">
								<a class="main-btn rounded-three" href="#">GET STARTED</a>
							</div>
						</div>
						<!-- furniture-work style one -->
					</div>
				</c:forEach>
            </div> <!-- row -->
        </div> <!-- container -->
    </section>

    <!--====== FURNITURE WORK STYLE EIGHT ENDS ======-->
    
    
    <!--====== trending-products PART START ======-->

    <section id="trending-products" class="trending-products-area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section-title text-center pb-20">
                        <h3 class="title">Trending Products</h3>
                    </div> <!-- row -->
                </div>
            </div> <!-- row -->
            <div class="row">
            </div> <!-- row -->
            <div class="row grid">
                <div class="col-lg-4 col-sm-6 branding-3 planning-3">
                    <div class="single-trending-products mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.2s">
                        <div class="trending-products-image">
                            <img src="<c:url value='images/blog-img1.png'/>" alt="">
                            <div class="trending-products-overlay d-flex align-items-center justify-content-center">
                                <div class="trending-products-content">
                                    <div class="trending-products-icon">
                                        <a class="image-popup" href="<c:url value='images/blog-img1.png'/>"><i class="lni-zoom-in"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="trending-products-text">
                            <h4 class="trending-products-title"><a href="#">Chairs</a></h4>
                            <p class="text">Short description for the ones who look for something new. Awesome!</p>
                        </div>
                    </div> <!-- single trending-products -->
                </div>
                <div class="col-lg-4 col-sm-6 branding-3 planning-3">
                    <div class="single-trending-products mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.2s">
                        <div class="trending-products-image">
                            <img src="<c:url value='images/blog-img2.png'/>" alt="">
                            <div class="trending-products-overlay d-flex align-items-center justify-content-center">
                                <div class="trending-products-content">
                                    <div class="trending-products-icon">
                                        <a class="image-popup" href="<c:url value='images/blog-img2.png'/>"><i class="lni-zoom-in"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="trending-products-text">
                            <h4 class="trending-products-title"><a href="#">Chair</a></h4>
                            <p class="text">Short description for the ones who look for something new. Awesome!</p>
                        </div>
                    </div> <!-- single trending-products -->
                </div>
                <div class="col-lg-4 col-sm-6 branding-3 planning-3">
                    <div class="single-trending-products mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.2s">
                        <div class="trending-products-image">
                            <img src="<c:url value='images/blog-img3.png'/>" alt="">
                            <div class="trending-products-overlay d-flex align-items-center justify-content-center">
                                <div class="trending-products-content">
                                    <div class="trending-products-icon">
                                        <a class="image-popup" href="<c:url value='images/blog-img3.png'/>"><i class="lni-zoom-in"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="trending-products-text">
                            <h4 class="trending-products-title"><a href="#">SideBoard</a></h4>
                            <p class="text">Short description for the ones who look for something new. Awesome!</p>
                        </div>
                    </div> <!-- single trending-products -->
                </div>
                
                <div class="col-lg-4 col-sm-6 marketing-3 research-3">
                    <div class="single-trending-products mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.4s">
                        <div class="trending-products-image">
                            <img src="<c:url value='images/blog-img4.png'/>" alt="">
                            <div class="trending-products-overlay d-flex align-items-center justify-content-center">
                                <div class="trending-products-content">
                                    <div class="trending-products-icon">
                                        <a class="image-popup" href="<c:url value='images/blog-img4.png'/>"><i class="lni-zoom-in"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="trending-products-text">
                            <h4 class="trending-products-title"><a href="#">Chairs</a></h4>
                            <p class="text">Short description for the ones who look for something new. Awesome!</p>
                        </div>
                    </div> <!-- single trending-products -->
                </div>
                <div class="col-lg-4 col-sm-6 branding-3 marketing-3">
                    <div class="single-trending-products mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.7s">
                        <div class="trending-products-image">
                            <img src="<c:url value='images/blog-img5.png'/>" alt="">
                            <div class="trending-products-overlay d-flex align-items-center justify-content-center">
                                <div class="trending-products-content">
                                    <div class="trending-products-icon">
                                        <a class="image-popup" href="<c:url value='images/blog-img5.png'/>"><i class="lni-zoom-in"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="trending-products-text">
                            <h4 class="trending-products-title"><a href="#">Chair</a></h4>
                            <p class="text">Short description for the ones who look for something new. Awesome!</p>
                        </div>
                    </div> <!-- single trending-products -->
                </div>
                <div class="col-lg-4 col-sm-6 planning-3 research-3">
                    <div class="single-trending-products mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.2s">
                        <div class="trending-products-image">
                            <img src="<c:url value='images/blog-img6.png'/>" alt="">
                            <div class="trending-products-overlay d-flex align-items-center justify-content-center">
                                <div class="trending-products-content">
                                    <div class="trending-products-icon">
                                        <a class="image-popup" href="<c:url value='images/blog-img6.png'/>"><i class="lni-zoom-in"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="trending-products-text">
                            <h4 class="trending-products-title"><a href="#">Sideboard</a></h4>
                            <p class="text">Short description for the ones who look for something new. Awesome!</p>
                        </div>
                    </div> <!-- single trending-products -->
                </div>
                <div class="col-lg-4 col-sm-6 marketing-3">
                    <div class="single-trending-products mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.4s">
                        <div class="trending-products-image">
                            <img src="<c:url value='images/blog-img7.png'/>" alt="">
                            <div class="trending-products-overlay d-flex align-items-center justify-content-center">
                                <div class="trending-products-content">
                                    <div class="trending-products-icon">
                                        <a class="image-popup" href="<c:url value='images/blog-img7.png'/>"><i class="lni-zoom-in"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="trending-products-text">
                            <h4 class="trending-products-title"><a href="#">Chairs</a></h4>
                            <p class="text">Short description for the ones who look for something new. Awesome!</p>
                        </div>
                    </div> <!-- single trending-products -->
                </div>
                <div class="col-lg-4 col-sm-6 planning-3">
                    <div class="single-trending-products mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.7s">
                        <div class="trending-products-image">
                            <img src="<c:url value='images/blog-img8.png'/>" alt="">
                            <div class="trending-products-overlay d-flex align-items-center justify-content-center">
                                <div class="trending-products-content">
                                    <div class="trending-products-icon">
                                        <a class="image-popup" href="<c:url value='images/blog-img8.png'/>"><i class="lni-zoom-in"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="trending-products-text">
                            <h4 class="trending-products-title"><a href="#">Chair</a></h4>
                            <p class="text">Short description for the ones who look for something new. Awesome!</p>
                        </div>
                    </div> <!-- single trending-products -->
                </div>
                <div class="col-lg-4 col-sm-6 planning-3">
                    <div class="single-trending-products mt-30 wow fadeInUp" data-wow-duration="1.5s" data-wow-delay="0.7s">
                        <div class="trending-products-image">
                            <img src="<c:url value='images/blog-img9.png'/>" alt="">
                            <div class="trending-products-overlay d-flex align-items-center justify-content-center">
                                <div class="trending-products-content">
                                    <div class="trending-products-icon">
                                        <a class="image-popup" href="<c:url value='images/blog-img9.png'/>"><i class="lni-zoom-in"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="trending-products-text">
                            <h4 class="trending-products-title"><a href="#">Sideboard</a></h4>
                            <p class="text">Short description for the ones who look for something new. Awesome!</p>
                        </div>
                    </div> <!-- single trending-products -->
                </div>
            </div> <!-- row -->
        </div> <!-- container -->
    </section>

    <!--====== trending-products PART ENDS ======-->
	
	<!--====== CONTACT TWO PART START ======-->

    <section id="contact" class="contact-area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section-title text-center pb-20">
                        <h3 class="title">Get in touch</h3>
                        <p class="text">Sajgure Furniture in has a wide range of
							products and / or services to cater to the varied requirements of
							their customers. The staff at this establishment are courteous
							and prompt at providing any assistance. They readily answer any
							queries or questions that you may have.</p>
                    </div> <!-- section title -->
                </div>
            </div> <!-- row -->
            <div class="row">
                <div class="col-lg-6">
                    <div class="contact-two mt-50 wow fadeIn" data-wow-duration="1.5s" data-wow-delay="0.2s">
                    	<h4 class="contact-title">Address</h4>
						<p class="text"></p>
						<ul class="contact-info">
							<li><i class="lni-money-location"></i> Samta Nagar, Sagwan,
								Buldhana</li>
							<li><i class="lni-phone-handset"></i> +91 7709993825</li>
							<li><i class="lni-envelope"></i> sajgurefurniture@gmail.com</li>
						</ul>
						<p class="contact-info">
						<div class="map_main map_container">
							<div class="map-responsive">
								<iframe
									src="https://www.google.com/maps/embed/v1/place?key=AIzaSyD1nnEyzDLSk75CvU938NA85HBG1Rvti3Q&amp;q=Sajgure+Furniture+Buldhana"
									width="600" height="368" frameborder="0"
									style="border: 0; width: 100%;" allowfullscreen=""></iframe>
							</div>
						</div>
					</div> <!-- contact two -->
                </div>
                <div class="col-lg-6">
                    <div class="contact-form form-style-one mt-35 wow fadeIn" data-wow-duration="1.5s" data-wow-delay="0.5s">
                        <form  id="contact-form">
                            <div class="form-input mt-15">
                                <label>Name</label>
                                <div class="input-items default">
                                    <input type="text" placeholder="Name" name="name" id="enquiryName">
                                    <i class="lni-user"></i>
                                </div>
                            </div> <!-- form input -->
                            <div class="form-input mt-15">
                                <label>Phone Number</label>
                                <div class="input-items default">
                                    <input type="number" placeholder="Phone number" name="phoneNo" id="enquiryPh">
                                    <i class="lni-mobile"></i>
                                </div>
                            </div> <!-- form input -->
                            <div class="form-input mt-15">
                                <label>Email</label>
                                <div class="input-items default">
                                    <input type="email" placeholder="Email" name="email" id="enquiryEmail">
                                    <i class="lni-envelope"></i>
                                </div>
                            </div> <!-- form input -->
                            <div class="form-input mt-15">
                                <label>Massage</label>
                                <div class="input-items default">
                                    <textarea placeholder="Massage" name="massage" id="enquiryMsg"></textarea>
                                    <i class="lni-pencil-alt"></i>
                                </div>
                            </div> <!-- form input -->
                            <p class="form-message"></p>
                            <div class="form-input rounded-buttons mt-20">
                                <button type="button" id="contactFormBtn" class="main-btn rounded-three">Submit</button>
                                
                                <span id="contact-form-message"></span>
                                
                            </div> <!-- form input -->
                        </form>
                    </div> <!-- contact form -->
                </div>
            </div> <!-- row -->
        </div> <!-- container -->
    </section>

    <!--====== CONTACT TWO PART ENDS ======-->
	
	<section>
		<%@include file="template/footer.jsp"%>
	</section>
	
	<!-- Javascript files-->
	<%@include file="template/imports_bottom.jsp"%>
	<script>
	$(document).ready(function() {


		$("#contactFormBtn").click(function() {
			$(this).attr("disabled", true);
			var enquiryObject = {"name": $('#enquiryName').val(),
				    "email": $('#enquiryEmail').val(),
				    "phoneNo": $('#enquiryPh').val(),
				    "message": $('#enquiryMsg').val()};
			
			$.ajax({
		        type: "POST",
		        url: "<c:url value='/enquiry'/>",
		        data: JSON.stringify(enquiryObject),
	            contentType: "application/json; charset=utf-8",
		        success: function (data, status, xhr) {
			        console.log(status)
			        showMessage("Form submitted successfully.", "text-success");
			        $('#contact-form')[0].reset();
		        },
		        error: function (error) {
			        showMessage("Something went wrong while submitting form.", "text-danger");
		        	
		        }
		    });
		});

		function showMessage(message, cls){
			$("#contact-form-message").fadeIn();
        	$('#contact-form-message').text(message).addClass(cls);
        	$("#contact-form-message").fadeOut(3000);
        	$("#contactFormBtn").removeAttr("disabled");
		}
				
		var carouselSize = ${carousels.size()};
		
		var owl = $('.gift_owl_carousel');
		owl.owlCarousel({
			items : 3,
			lazyLoad:true,
			loop : true,
			margin : 10,
			nav : true,
			dots : true,
			navText : [ "<i class='lni lni-arrow-left-circle'></i>",
					"<i class='lni lni-arrow-right-circle'></i>" ],
			autoplay : false,
			autoplayTimeout : 3000,
			autoplayHoverPause : true,
			stagePadding : 15,
			responsive : {
				0:{
		            items:1,
		            //nav:true
		        },
		        480:{
		            items:2,
		           // nav:false
		        },
		        768:{
		            items:3,
		            //nav:true,
		            loop:false
		        }
			}
		});
	});
		//===== Sticky

	    $(window).on('scroll', function(event) {
	        var scroll = $(window).scrollTop();
	        if (scroll < 10) {
	            $(".navbar-area").removeClass("sticky");
	        } else{
	            $(".navbar-area").addClass("sticky");
	        }
	    });

	     //===== close navbar-collapse when a  clicked

	    $(".navbar-nav a").on('click', function () {
	        $(".navbar-collapse").removeClass("show");
	    });

	    
	</script>
</body>
</html>