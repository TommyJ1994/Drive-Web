<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle default="Grails" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="${assetPath(src: 'apple-touch-icon.png')}">
<link rel="apple-touch-icon" sizes="114x114"
	href="${assetPath(src: 'apple-touch-icon-retina.png')}">
<asset:stylesheet src="semantic.css" />
<asset:stylesheet src="animate.css" />
<asset:stylesheet src="icon.css" />
<asset:javascript src="semantic.js" />
<asset:javascript src="jsapi.js" />
<g:layoutHead />
</head>
<body class="animated fadeIn" style="background: linear-gradient(180deg, #3367d6, #fff); height: 100%;margin: 0;
    background-repeat: no-repeat;
    background-attachment: fixed;">
	<div class="ui inverted primary menu" style="background-color: #3367d6">
		<div class="item">
			<asset:image src="logo-white-small.png" alt="Grails" />
		</div>
		<a href="/Drive" class="item"> Dashboard </a> <a class="item">
			Features </a> <a class="item"> Getting Started </a>
		<g:link class="item" controller="vehicle" action="manufacturers">Manufacturers</g:link>
		<a class="item"> Vehicle Types </a>
		<div class="right menu">
			<div class="item">
				<div class="ui icon users">
					<i class="users icon"></i> 3,500 Drivers
				</div>
			</div>
			<div class="item">
				<div class="ui icon car">
					<i class="car icon"></i> 4,500 Vehicles
				</div>
			</div>
			<div class="item">
				<div class="ui icon location arrow">
					<i class="location arrow icon"></i> 38,500 Journeys
				</div>
			</div>
			<div class="item">
				<div class="ui icon clock">
					<i class="clock icon"></i> 67,382 Hours
				</div>
			</div>
			<div class="item">
				<div class="ui icon input">
					<input type="text" placeholder="Search..."> <i
						class="search link icon"></i>
				</div>
			</div>
		</div>
	</div>
	<div class="ui container responsive">
		<g:layoutBody />
		</br>
		</br>
	
	<div align="center" class="footer ui container" role="contentinfo">
		<div align="center" class="item image ui micro small">
			<asset:image src="logo-white-small.png" alt="Grails" />
			<h6>Drive - The Open Car Network</h6>
		</div>
	</div>
	</div>
</body>
</html>
