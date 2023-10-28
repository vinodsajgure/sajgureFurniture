<script type="text/javascript">
	$("#header>.menu-button").click(function() {
		$("#sidemenu").toggleClass("open");
		$(".copyright").toggleClass("show");
		$("#content-wrapper").toggleClass("sidebar-open");
	});
	$("#sidemenu, #top-bar, #content-wrapper").click(function(e) {
		$("#sidemenu").removeClass("open");
		$(".copyright").removeClass("show");
	});
</script>