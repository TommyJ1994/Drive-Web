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
<body class="animated fadeIn" style="background-color: #2B2C2F;">

	<div class="ui inverted primary fixed menu" style="background-color: #2B2C2F;border-bottom: 1px solid;border-bottom-color: #1AB370;">
		<div class="item">
			<asset:image src="logo-dark.png" alt="Grails" />
		</div>
		<a href="/Drive" class="item"> <i class="dashboard icon"></i> Dashboard </a> <a class="item">
			<i class="rocket icon"></i> Features </a> <a class="item"><i class="help icon"></i> Getting Started </a>
		<g:link class="item" controller="vehicle" action="manufacturers"><i class="car icon"></i> Manufacturers</g:link>
		<g:link class="item" controller="vehicle" action="styles"><i class="wizard icon"></i> Vehicle Styles</g:link> 
		<g:link class="item" controller="vehicle" action="engineSizes"><i class="book icon"></i> Engine Sizes</g:link> 
		<g:link class="item" controller="vehicle" action="transmissions"><i class="sitemap icon"></i> Transmission</g:link> 
		<g:link class="item" controller="vehicle" action="fuelTypes"><i class="leaf icon"></i> Fuel Types</g:link> 
		<g:link class="item" controller="vehicle" action="countries"><i class="marker icon"></i> Countries</g:link>
		<g:link class="item" controller="vehicle" action="genders"><i class="male icon"></i> Genders</g:link>  
		<div class="right menu">
			<a class="item" style="background: #1AB370;"><i class="android icon"></i> Download App </a>
			<div class="item">
				<div class="ui icon input">
					<i class="search link icon"></i>
					<g:form controller="vehicle" action="show">
				            <g:textField placeholder="Enter Vehicle ID" name="id" value="${params.id}"/>
				    </g:form>
				</div>
			</div>
		</div>
	</div>
	<div class="ui container responsive">
	</br>
		</br></br></br>
		<g:layoutBody />
		</br></br></br></br></br></br>
	<div align="center" class="footer ui container">
		<div align="center" class="item image ui micro small">
			<asset:image src="logo-dark.png" alt="Grails" />
			<h5 style="color: #fff">The Open Car Network</h5>
		</div>
	</div>
	</div>
</body>
</html>
