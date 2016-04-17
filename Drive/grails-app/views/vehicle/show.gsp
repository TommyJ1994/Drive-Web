
<%@ page import="drive.Vehicle"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'manufacturers.label', default: 'Manufacturers')}" />
<title></title>
</head>
<body>

	<div id="list-vehicle" class="content scaffold-list" role="main">

		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>

		<div class="ui segment">
			<div class="ui left rail">
				<div class="ui segment">
					<div class="ui image">
						<asset:image src="manufacturer-logos/${vehicleInstance?.make}.png"
							class="ui medium image" />
					</div>
					</br> </br>
					<div class="content">
						<div class="ui red ribbon label">
							<h3>
								${vehicleInstance?.make}
								${vehicleInstance?.model}
							</h3>
						</div>

						</br></br>

						<div class="description">

							<div class="ui animated selection list">

								<div class="item">
									<asset:image src="user.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${Calendar.getInstance().get(Calendar.YEAR) - vehicleInstance?.driver.year}
										</div>
										Age
									</div>
								</div>

								<div class="item">
									<asset:image src="user.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${vehicleInstance?.driver.gender}
										</div>
										Gender
									</div>
								</div>

								<div class="item">
									<asset:image src="user.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${vehicleInstance?.driver.country}
										</div>
										Country
									</div>
								</div>

								<div class="item">
									<asset:image src="car4.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${vehicleInstance?.year}
										</div>
										Year
									</div>
								</div>

								<div class="item">
									<asset:image src="car4.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${vehicleInstance?.vehicleStyle}
										</div>
										Style
									</div>
								</div>

								<div class="item">
									<asset:image src="car4.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${vehicleInstance?.vehicleClass}
										</div>
										Class
									</div>
								</div>

								<g:if test="${vehicleInstance?.numOfDoors}">
									<div class="item">
										<asset:image src="car4.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.numOfDoors}
											</div>
											Number Of Doors
										</div>
									</div>
								</g:if>


								<g:if test="${vehicleInstance?.colourCodes}">
									<div class="item">
										<asset:image src="car4.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												<g:each in="${vehicleInstance.colourCodes}" var="j">
													<a class="ui circular label" style="background-color: #${j}"></a>
												</g:each>
											</div>
											Colours
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.features}">
									<div class="item">
										<asset:image src="car4.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												<div class="ui list">
													<g:each in="${vehicleInstance.features}" var="j">
														<div class="item header">
															${j}
														</div>
													</g:each>
												</div>
											</div>
											Features
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.engineSize}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.engineSize}
												L
											</div>
											Engine Size
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.engineDisplacement}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.engineDisplacement}
												cc
											</div>
											Displacement
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.engineConfiguration}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.engineConfiguration}
											</div>
											Configuration
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.cylinders}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.cylinders}
											</div>
											Cylinders
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.totalEngineValves}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.totalEngineValves}
											</div>
											Valves
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.compressionRatio}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.compressionRatio}
											</div>
											Compression Ratio
										</div>
									</div>
								</g:if>


								<g:if test="${vehicleInstance?.manufacturerEngineCode}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.manufacturerEngineCode}
											</div>
											Engine Code
										</div>
									</div>
								</g:if>


								<g:if test="${vehicleInstance?.horsepower}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.horsepower}
												bhp
											</div>
											Horsepower
										</div>
									</div>
								</g:if>


								<g:if test="${vehicleInstance?.manufacturerEngineCode}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.torque}
												ft lb
											</div>
											Torque
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.fuelType}">
									<div class="item">
										<asset:image src="fuel.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.fuelType}
											</div>
											Fuel
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.mpgHighway}">
									<div class="item">
										<asset:image src="fuel.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.mpgHighway}
											</div>
											MPG Motorway
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.mpgCity}">
									<div class="item">
										<asset:image src="fuel.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.mpgCity}
											</div>
											MPG City
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.transmissionType}">
									<div class="item">
										<asset:image src="gear.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.transmissionType}
											</div>
											Transmission Type
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.numberOfSpeeds}">
									<div class="item">
										<asset:image src="gear.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${vehicleInstance?.numberOfSpeeds}
											</div>
											Number Of Speeds
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.newPrice}">
									<div class="item">
										<asset:image src="money.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												<g:formatNumber number="${vehicleInstance?.newPrice}"
													type="currency" currencyCode="USD" />
											</div>
											New Price
										</div>
									</div>
								</g:if>

								<g:if test="${vehicleInstance?.usedPrice}">
									<div class="item">
										<asset:image src="money.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												<g:formatNumber number="${vehicleInstance?.usedPrice}"
													type="currency" currencyCode="USD" />
											</div>
											Used Price
										</div>
									</div>
								</g:if>





							</div>

						</div>
					</div>
				</div>
				</br> </br> </br>
			</div>
			<div class="ui right rail">
				<div class="ui segment">

					<div class="content">
						<div class="ui red ribbon label">
							<h3>
								Follow
								${vehicleInstance?.identifier}
							</h3>
						</div>
					</div>

					</br>

					<div align="center">

						<qrcode:image text="${vehicleInstance?.identifier}" height="250" width="250"/>

						<h5>Follow This Vehicle Using The Android App. Just Open The
							Menu and Choose Following.</h5>
					</div>
					</br>

					<div class="ui red ribbon label">
						<h3>Vehicle Statistics</h3>
					</div>

					<div class="ui animated selection list">
						<div class="item">
							<asset:image src="road.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									${vehicleInstance?.journeys.size()}
								</div>
								Journeys
							</div>
						</div>
						<div class="item">
							<asset:image src="clock.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${(vehicleInstance?.overallStatistics?.totalTimeLength)/ 3600}"
										maxFractionDigits="1" />
								</div>
								Hours Driven
							</div>
						</div>
						<div class="item">
							<asset:image src="speedometer.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${vehicleInstance?.overallStatistics?.averageSpeed}"
										maxFractionDigits="0" />
									kph
								</div>
								Average Speed
							</div>
						</div>
						<div class="item">
							<asset:image src="speedometer.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									${vehicleInstance?.overallStatistics?.topSpeed}
									kph
								</div>
								Highest Recorded Speed
							</div>
						</div>
						<div class="item">
							<asset:image src="rpm.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${vehicleInstance?.overallStatistics?.averageRPM}"
										maxFractionDigits="0" />
									rpm
								</div>
								Average RPM
							</div>
						</div>
						<div class="item">
							<asset:image src="rpm.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									${vehicleInstance?.overallStatistics?.topRPM}
									rpm
								</div>
								Highest Recorded RPM
							</div>
						</div>
						<div class="item">
							<asset:image src="rpm.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									${vehicleInstance?.overallStatistics?.averagePercentageHighRPM}
									%
								</div>
								Driven at High RPM
							</div>
						</div>
						<div class="item">
							<asset:image src="car4.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									${vehicleInstance?.overallStatistics?.heavyAccelerationCount}
								</div>
								Heavy Acceleration Count
							</div>
						</div>
						<div class="item">
							<asset:image src="brake.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									${vehicleInstance?.overallStatistics?.heavyBrakingCount}
								</div>
								Heavy Braking Count
							</div>
						</div>
						<div class="item">
							<asset:image src="engine.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${vehicleInstance?.overallStatistics?.averageEngineLoad}"
										maxFractionDigits="0" />
									%
								</div>
								Average Engine Load
							</div>
						</div>
						<div class="item">
							<asset:image src="throttle.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${vehicleInstance?.overallStatistics?.averageThrottlePosition}"
										maxFractionDigits="0" />
									%
								</div>
								Average Throttle Position
							</div>
						</div>
						<div class="item">
							<asset:image src="idle.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${vehicleInstance?.overallStatistics?.averagePercentageIdle}"
										maxFractionDigits="0" />
									%
								</div>
								Average Percentage Idle
							</div>
						</div>
						<div class="item">
							<asset:image src="radar.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${vehicleInstance?.overallStatistics?.averageGForce}"
										maxFractionDigits="2" />
									g
								</div>
								Average G Force
							</div>
						</div>
						<div class="item">
							<asset:image src="radar.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${vehicleInstance?.overallStatistics?.topAccelerationGforce}"
										maxFractionDigits="2" />
									g
								</div>
								Highest Acceleration G Force
							</div>
						</div>
						<div class="item">
							<asset:image src="radar.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${vehicleInstance?.overallStatistics?.topDecelerationGforce}"
										maxFractionDigits="2" />
									g
								</div>
								Highest Deceleration G Force
							</div>
						</div>
						<div class="item">
							<asset:image src="car3.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber
										number="${vehicleInstance?.overallStatistics?.averagePercentageCoasting}"
										maxFractionDigits="0" />
									%
								</div>
								Average Percentage Coasting
							</div>
						</div>



					</div>
				</div>
			</div>

			<div class="ui red ribbon label">
				<h3>Journeys</h3>
			</div>

			<g:if
				test="${journeys == null || vehicleInstance?.journeys.size() == 0}">

				<div align="center">
					<asset:image src="close.png" class="ui tiny image" />
					<h3>No Journeys</h3>
				</div>

			</g:if>
			<g:if test="${journeys}">

				<div class="ui animated divided list">
					<g:each in="${journeys}" var="journey">
						<div class="item">
		
							</br>
							<g:if
								test="${journey?.startTime?.getAt(Calendar.HOUR_OF_DAY) <= 20 && journey?.startTime?.getAt(Calendar.HOUR_OF_DAY) >= 7}">
								<div class="ui image">
									<asset:image src="sun.png" class="ui avatar image" />
								</div>
							</g:if>
							<g:if
								test="${journey?.startTime?.getAt(Calendar.HOUR_OF_DAY) >= 21 || journey?.startTime?.getAt(Calendar.HOUR_OF_DAY) <= 6}">
								<div class="ui image">
									<asset:image src="moon.png" class="ui avatar image" />
								</div>
							</g:if>
							<div class="content">
								<div class="header"style="color: #212B27">
									<h2>
										<small><g:formatDate date="${journey?.startTime}"
												type="datetime" style="MEDIUM" /> <i
											class="long arrow right icon"></i> <g:formatDate
												date="${journey?.endTime}" type="datetime" style="MEDIUM" />
										</small>
									</h2>

								</div>
								
							
								
							</div>

							<h3>
								<small>Journey Overview</small> 
							</h3>
														
							<g:if test="${journey?.averageRPM >= 3500}">
							<div class="ui left floated small red basic label">
								Average RPM : 
								${journey?.averageRPM} rpm
							</div>
							</g:if>
							
							<g:if test="${journey?.averageRPM < 3500}">
							<div class="ui left floated small green basic label">
								Average RPM : 
								${journey?.averageRPM} rpm
							</div>
							</g:if>
							
							<g:if test="${journey?.heavyAccelerationCount >= 1}">
							<div class="ui left floated small red basic label">
								Heavy Acceleration : 
								${journey?.heavyAccelerationCount}
							</div>
							</g:if>
							
							<g:if test="${journey?.heavyAccelerationCount == 0}">
							<div class="ui left floated small green basic label">
								Heavy Acceleration : 
								${journey?.heavyAccelerationCount} 
							</div>
							</g:if>
							
							<g:if test="${journey?.heavyBrakingCount >= 1}">
							<div class="ui left floated small red basic label">
								Heavy Braking : 
								${journey?.heavyBrakingCount}
							</div>
							</g:if>
							
							<g:if test="${journey?.heavyBrakingCount == 0}">
							<div class="ui left floated small green basic label">
								Heavy Braking : 
								${journey?.heavyBrakingCount} 
							</div>
							</g:if>
							
							<g:if test="${journey?.averagePercentageIdle >= 10}">
							<div class="ui left floated small red basic label">
								Idle Percentage : 
								${journey?.averagePercentageIdle} %
							</div>
							</g:if>
							
							<g:if test="${journey?.averagePercentageIdle < 10}">
							<div class="ui left floated small green basic label">
								Idle Percentage : 
								${journey?.averagePercentageIdle} %
							</div>
							</g:if>
							
							
							<g:if test="${journey?.averageEngineLoad >= 90}">
							<div class="ui left floated small red basic label">
								Engine Load Percentage : 
								${journey?.averageEngineLoad} %
							</div>
							</g:if>
							
							<g:if test="${journey?.averageEngineLoad < 90}">
							<div class="ui left floated small green basic label">
								Engine Load Percentage : 
								${journey?.averageEngineLoad} %
							</div>
							</g:if>

							<g:if test="${journey?.sensors?.find {it.name == 'Diagnostic Trouble Codes'} != null}">
							<div class="ui left floated small black label">
								 Engine Light On!
							</div>
							</g:if>

							<g:link controller="journey" action="show" id="${journey.id}"
								class="ui right floated small red labeled icon button">
								<i class="right arrow icon"></i>
								View Journey
									Statistics</g:link>

							</br></br>
						</div>
					</g:each>
				</div>
			</g:if>

			</br>
		</div>

	</div>
</body>
</html>










