
<%@ page import="drive.Journey"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'journey.label', default: 'Journey')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
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
						<asset:image src="manufacturer-logos/${journeyInstance?.vehicle?.make}.png"
							class="ui medium image" />
					</div>
					</br> </br>
					<div class="content">
						<div class="ui red ribbon label">
							<h3>
								${journeyInstance?.vehicle?.make}
								${journeyInstance?.vehicle?.model}
							</h3>
						</div>

						</br></br>

						<div class="description">

							<div class="ui animated list">

								<div class="item">
									<asset:image src="user.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${Calendar.getInstance().get(Calendar.YEAR) - journeyInstance?.vehicle?.driver.year}
										</div>
										Age
									</div>
								</div>

								<div class="item">
									<asset:image src="user.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${journeyInstance?.vehicle?.driver.gender}
										</div>
										Gender
									</div>
								</div>

								<div class="item">
									<asset:image src="user.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${journeyInstance?.vehicle?.driver?.country}
										</div>
										Country
									</div>
								</div>

								<div class="item">
									<asset:image src="car4.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${journeyInstance?.vehicle?.year}
										</div>
										Year
									</div>
								</div>

								<div class="item">
									<asset:image src="car4.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${journeyInstance?.vehicle?.vehicleStyle}
										</div>
										Style
									</div>
								</div>

								<div class="item">
									<asset:image src="car4.png" class="ui avatar image" />
									<div class="content">
										<div class="header">
											${journeyInstance?.vehicle?.vehicleClass}
										</div>
										Class
									</div>
								</div>

								<g:if test="${journeyInstance?.vehicle?.numOfDoors}">
									<div class="item">
										<asset:image src="car4.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.numOfDoors}
											</div>
											Number Of Doors
										</div>
									</div>
								</g:if>


								<g:if test="${journeyInstance?.vehicle?.colourCodes}">
									<div class="item">
										<asset:image src="car4.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												<g:each in="${journeyInstance?.vehicle.colourCodes}" var="j">
													<a class="ui circular label" style="background-color: #${j}"></a>
												</g:each>
											</div>
											Colours
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.features}">
									<div class="item">
										<asset:image src="car4.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												<div class="ui selection list">
													<g:each in="${journeyInstance?.vehicle?.features}" var="j">
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

								<g:if test="${journeyInstance?.vehicle?.engineSize}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.engineSize}
												L
											</div>
											Engine Size
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.engineDisplacement}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.engineDisplacement}
												cc
											</div>
											Displacement
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.engineConfiguration}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.engineConfiguration}
											</div>
											Configuration
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.cylinders}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.cylinders}
											</div>
											Cylinders
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.totalEngineValves}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.totalEngineValves}
											</div>
											Valves
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.compressionRatio}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.compressionRatio}
											</div>
											Compression Ratio
										</div>
									</div>
								</g:if>


								<g:if test="${journeyInstance?.vehicle?.manufacturerEngineCode}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.manufacturerEngineCode}
											</div>
											Engine Code
										</div>
									</div>
								</g:if>


								<g:if test="${journeyInstance?.vehicle?.horsepower}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.horsepower}
												bhp
											</div>
											Horsepower
										</div>
									</div>
								</g:if>


								<g:if test="${journeyInstance?.vehicle?.manufacturerEngineCode}">
									<div class="item">
										<asset:image src="engine.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.torque}
												ft lb
											</div>
											Torque
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.fuelType}">
									<div class="item">
										<asset:image src="fuel.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.fuelType}
											</div>
											Fuel
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.mpgHighway}">
									<div class="item">
										<asset:image src="fuel.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.mpgHighway}
											</div>
											MPG Motorway
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.mpgCity}">
									<div class="item">
										<asset:image src="fuel.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.mpgCity}
											</div>
											MPG City
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.transmissionType}">
									<div class="item">
										<asset:image src="gear.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.transmissionType}
											</div>
											Transmission Type
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.numberOfSpeeds}">
									<div class="item">
										<asset:image src="gear.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												${journeyInstance?.vehicle?.numberOfSpeeds}
											</div>
											Number Of Speeds
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.newPrice}">
									<div class="item">
										<asset:image src="money.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												<g:formatNumber number="${journeyInstance?.vehicle?.newPrice}"
													type="currency" currencyCode="USD" />
											</div>
											New Price
										</div>
									</div>
								</g:if>

								<g:if test="${journeyInstance?.vehicle?.usedPrice}">
									<div class="item">
										<asset:image src="money.png" class="ui avatar image" />
										<div class="content">
											<div class="header">
												<g:formatNumber number="${journeyInstance?.vehicle?.usedPrice}"
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

					<div class="ui red ribbon label">
						<h3>Statistics</h3>
					</div>

					<div class="ui animated list">

						<div class="item">
							<asset:image src="clock.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber number="${journeyInstance?.journeyTimeLength / 6000}"
										maxFractionDigits="1" />
									Minutes
								</div>
								Journey Length
							</div>
						</div>
						<div class="item">
							<asset:image src="speedometer.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber number="${journeyInstance?.averageSpeed}"
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
									${journeyInstance?.topSpeed}
									kph
								</div>
								Highest Recorded Speed
							</div>
						</div>
						<div class="item">
							<asset:image src="rpm.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber number="${journeyInstance?.averageRPM}"
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
									${journeyInstance?.topRPM}
									rpm
								</div>
								Highest Recorded RPM
							</div>
						</div>
						<div class="item">
							<asset:image src="rpm.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									${journeyInstance?.averagePercentageHighRPM}
									%
								</div>
								Percentage High RPM
							</div>
						</div>
						<div class="item">
							<asset:image src="car4.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									${journeyInstance?.heavyAccelerationCount}
								</div>
								Heavy Acceleration Count
							</div>
						</div>
						<div class="item">
							<asset:image src="brake.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									${journeyInstance?.heavyBrakingCount}
								</div>
								Heavy Braking Count
							</div>
						</div>
						<div class="item">
							<asset:image src="engine.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber number="${journeyInstance?.averageEngineLoad}"
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
										number="${journeyInstance?.averageThrottlePosition}"
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
										number="${journeyInstance?.averagePercentageIdle}"
										maxFractionDigits="0" />
									%
								</div>
								Percentage Idle
							</div>
						</div>
						<div class="item">
							<asset:image src="radar.png" class="ui avatar image" />
							<div class="content">
								<div class="header">
									<g:formatNumber number="${journeyInstance?.averageGForce}"
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
										number="${journeyInstance?.topAccelerationGforce}"
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
										number="${journeyInstance?.topDecelerationGforce}"
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
										number="${journeyInstance?.averagePercentageCoasting}"
										maxFractionDigits="0" />
									%
								</div>
								Percentage Coasting
							</div>
						</div>


					</div>
				</div>
			</div>

			<%
				

				def engineColumns = [['string', 'Name'], ['number', 'Progress'], ['number', 'Values'], ['number', 'Values2']]
				
				def lambdaColumns = [['string', 'Name'], ['number', 'Upstream Sensor (%)'], ['number', 'Downstream Sensor (%)']]
				
				def engineCoolantTemperatureColumns = [['string', 'Name'], ['number', 'Engine Coolant Temperature (°C)']]
				
				def engineRPMColumns = [['string', 'Name'], ['number', 'Engine RPM (rpm)']]
				
				def absoluteloadValueColumns = [['string', 'Name'], ['number', 'Absolute Engine Load (%)']]
				
				def engineOilTemperatureColumns= [['string', 'Name'], ['number', 'Engine Oil Temperature (°C)']]
				
				def driversDemandEngineTorqueColumns = [['string', 'Name'], ['number', 'Drivers Demand Engine - Percent Torque (%)']]
				
				def actualEngineTorqueColumns = [['string', 'Name'], ['number', 'Actual Engine - Percent Torque (%)']]
				
				def engineReferenceTorqueColumns = [['string', 'Name'], ['number', 'Engine Reference Torque (Nm)']]
				
				def catalystTemperatureBank1Sensor1Columns = [['string', 'Name'], ['number', 'Catalyst Temperature Bank 1, Sensor 1 (°C)']]
				
				def catalystTemperatureBank1Sensor2Columns = [['string', 'Name'], ['number', 'Catalyst Temperature Bank 1, Sensor 2 (°C)']]
				
				def catalystTemperatureBank2Sensor1Columns = [['string', 'Name'], ['number', 'Catalyst Temperature Bank 2, Sensor 1 (°C)']]
				
				def catalystTemperatureBank2Sensor2Columns = [['string', 'Name'], ['number', 'Catalyst Temperature Bank 2, Sensor 2 (°C)']]

				def fuelPressureColumns = [['string', 'Name'], ['number', 'Fuel Pressure kPa (Gauge)']]

				def fuelInjectionTimingColumns = [['string', 'Name'], ['number', 'Fuel Injection Timing (°)']]

				def engineFuelRateColumns = [['string', 'Name'], ['number', 'Engine Fuel Rate (L/h)']]

				def relativeThrottlePositionColumns = [['string', 'Name'], ['number', 'Relative Throttle Position (%)']]

				def commandedThrottleActuatorColumns = [['string', 'Name'], ['number', 'Commanded Throttle Actuator (%)']]

				def relativeAcceleratorPedalPositionColumns = [['string', 'Name'], ['number', 'Relative Accelerator Pedal Position (%)']]

				def intakeManifoldAbsolutePressureColumns = [['string', 'Name'], ['number', 'Intake Air Temperature (Absolute)']]

				def intakeAirTemperatureColumns = [['string', 'Name'], ['number', 'Intake Air Temperature (°C)']]

				def mafAirFlowRateColumns = [['string', 'Name'], ['number', 'MAF Air Flow Rate (grams/sec)']]

				def barometricPressureColumns = [['string', 'Name'], ['number', 'Barometric pressure kPa (Absolute)']]

				def ambientAirTemperatureColumns = [['string', 'Name'], ['number', 'Ambient Air Temperature (°C)']]
				
				def genderColumns = [['string', 'Gender'], ['number', 'Number']]
				
				def ageColumns = [['string', 'Age'], ['number', 'Number']]
			%>

			<div class="ui red ribbon label">
						<h3>Quick Links</h3>
					</div>
					</br> </br>

<div class="ui grid" align="center">

						<div class="three wide column">
							<div class="ui card">
								<div class="ui medium rounded image">
									<asset:image src="chart-categories/engine.jpg"
										class="ui medium bordered image" height="200" width="200" />
								</div>

								<div class="content">
									<a class="header">
										<h1 class="ui header" style="font-size: 1rem;">
											Engine
										</h1>
									</a>
								</div>
								<a href="#engine"
									class="ui bottom attached button"
									style="background: #19B26F;color: rgb(254, 254, 254);">
									<i class="search icon"></i>
						      View Charts
						    	</a>
							</div>
						</div>



						<div class="three wide column">
							<div class="ui card">
								<div class="ui medium rounded image">
									<asset:image src="chart-categories/emissions.jpg"
										class="ui medium bordered image" height="200" width="200" />
								</div>

								<div class="content">
									<a class="header">
										<h1 class="ui header" style="font-size: 1rem;">
											Emissions System
										</h1>
									</a>
								</div>
								<a href="#emmisions"
									class="ui bottom attached button"
									style="background: #19B26F;color: rgb(254, 254, 254);">
									<i class="search icon"></i>
						      View Charts
						    	</a>
							</div>
						</div>

						<div class="three wide column">
							<div class="ui card">
								<div class="ui medium rounded image">
									<asset:image src="chart-categories/fuel.jpg"
										class="ui medium bordered image" height="200" width="200" />
								</div>

								<div class="content">
									<a class="header">
										<h1 class="ui header" style="font-size: 1rem;">
											Fuel System
										</h1>
									</a>
								</div>
								<a href="#emmisions"
									class="ui bottom attached button"
									style="background: #19B26F;color: rgb(254, 254, 254);">
									<i class="search icon"></i>
						      View Charts
						    	</a>
							</div>
						</div>

						<div class="three wide column">
							<div class="ui card">
								<div class="ui medium rounded image">
									<asset:image src="chart-categories/pedal.jpg"
										class="ui medium bordered image" height="200" width="200" />
								</div>

								<div class="content">
									<a class="header">
										<h1 class="ui header" style="font-size: 1rem;">
											Pedal/Throttle
										</h1>
									</a>
								</div>
								<a href="#throttle"
									class="ui bottom attached button"
									style="background: #19B26F;color: rgb(254, 254, 254);">
									<i class="search icon"></i>
						      View Charts
						    	</a>
							</div>
						</div>

						<div class="three wide column">
							<div class="ui card">
								<div class="ui medium rounded image">
									<asset:image src="chart-categories/intake.jpg"
										class="ui medium bordered image" height="200" width="200" />
								</div>

								<div class="content">
									<a class="header">
										<h1 class="ui header" style="font-size: 1rem;">
											Intake System
										</h1>
									</a>
								</div>
								<a href="#intake"
									class="ui bottom attached button"
									style="background: #19B26F;color: rgb(254, 254, 254);">
									<i class="search icon"></i>
						      View Charts
						    	</a>
							</div>
						</div>



			</div>

			<div id="engine"></div>

			<div class="ui equal width grid">
				<div class="column">
					<div class="ui red ribbon label">
						<h3>Engine</h3>
					</div>
					</br> </br>

					<g:if test="${engineData != null}">
					<a class="ui teal ribbon label">Calculated Engine Load, Vehicle Speed, Throttle Position</a> 
					<gvisualization:motionChart dynamicLoading="${true}"  elementId="engineDataChart" width="${1080}"
						height="${600}" columns="${engineColumns}" data="${engineData}"/>
					<div id="engineDataChart"></div>
					</g:if></br> </br>

					<g:if test="${engineRPM?.points != null && engineRPM?.points.size() > 0}">
					<a class="ui teal ribbon label">${engineRPM?.name}</a> 
					<gvisualization:steppedAreaCoreChart dynamicLoading="${true}"  elementId="engineRPMChart" width="${1080}"
						height="${600}" columns="${engineRPMColumns}" data="${engineRPM?.points}"/>
					<div id="engineRPMChart"></div>
					</g:if></br> </br>

					<g:if test="${engineCoolantTemperature?.points != null && engineCoolantTemperature?.points.size() > 0}">
					<a class="ui teal ribbon label">${engineCoolantTemperature?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="engineCoolantTemperatureChart" width="${1080}"
						height="${600}" columns="${engineCoolantTemperatureColumns}" data="${engineCoolantTemperature?.points}"/>
					<div id="engineCoolantTemperatureChart"></div>
					</g:if></br> </br>

					<g:if test="${engineOilTemperature?.points != null && engineOilTemperature?.points.size() > 0}">
					<a class="ui teal ribbon label">${engineOilTemperature?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}" dynamicLoading="${true}" dynamicLoading="${true}"  elementId="engineOilTemperatureChart" width="${1080}"
						height="${600}" columns="${engineOilTemperatureColumns}" data="${engineOilTemperature?.points}"/>
					<div id="engineOilTemperatureChart"></div>
					</g:if></br> </br>

					<g:if test="${absoluteloadValue?.points != null && absoluteloadValue?.points.size() > 0}">
					<a class="ui teal ribbon label">${absoluteloadValue?.name}</a> 
					<gvisualization:steppedAreaCoreChart dynamicLoading="${true}"  elementId="absoluteloadValueChart" width="${1080}"
						height="${600}" columns="${absoluteloadValueColumns}" data="${absoluteloadValue?.points}"/>
					<div id="absoluteloadValueChart"></div>
					</g:if></br> </br>

					<g:if test="${driversDemandEngineTorque?.points != null && driversDemandEngineTorque?.points.size() > 0}">
					<a class="ui teal ribbon label">${driversDemandEngineTorque?.name}</a> 
					<gvisualization:steppedAreaCoreChart dynamicLoading="${true}"  elementId="driversDemandEngineTorqueChart" width="${1080}"
						height="${600}" columns="${driversDemandEngineTorqueColumns}" data="${driversDemandEngineTorque?.points}"/>
					<div id="driversDemandEngineTorqueChart"></div>
					</g:if></br> </br>

					<g:if test="${actualEngineTorque?.points != null && actualEngineTorque?.points.size() > 0}">
					<a class="ui teal ribbon label">${actualEngineTorque?.name}</a> 
					<gvisualization:steppedAreaCoreChart dynamicLoading="${true}"  elementId="actualEngineTorqueChart" width="${1080}"
						height="${600}" columns="${actualEngineTorqueColumns}" data="${actualEngineTorque?.points}"/>
					<div id="actualEngineTorqueChart"></div>
					</g:if></br> </br>

					<g:if test="${engineReferenceTorque?.points != null && engineReferenceTorque?.points.size() > 0}">
					<a class="ui teal ribbon label">${engineReferenceTorque?.name}</a> 
					<gvisualization:steppedAreaCoreChart dynamicLoading="${true}"  elementId="engineReferenceTorqueChart" width="${1080}"
						height="${600}" columns="${engineReferenceTorqueColumns}" data="${engineReferenceTorque?.points}"/>
					<div id="engineReferenceTorqueChart"></div>
					</g:if>


				</div>
			</div>
			</br> </br>

				<div id="emmisions"></div>
					<div class="ui red ribbon label">
						<h3>Emissions System</h3>
					</div>
					</br> </br>
					
					<g:if test="${lambdaData[1] != null && lambdaData[2] != null && lambdaData[1].size() > 0 && lambdaData[2].size() > 0}">
					<a class="ui teal ribbon label">Upstream & Downstream Oxygen (Lambda) Sensors</a>
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="lambdaChart" width="${1080}"
						height="${600}" columns="${lambdaColumns}" data="${lambdaData}" aggregationTarget="${'category'}" />
					<div id="lambdaChart"></div>
					</g:if></br> </br>
					
					<g:if test="${catalystTemperatureBank1Sensor1?.points != null && catalystTemperatureBank1Sensor1?.points.size() > 0}">
					<a class="ui teal ribbon label">${catalystTemperatureBank1Sensor1?.name}</a>
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="catalystTemperatureBank1Sensor1Chart" width="${1080}"
						height="${600}" columns="${catalystTemperatureBank1Sensor2Columns}" data="${catalystTemperatureBank1Sensor1?.points}"/>
					<div id="catalystTemperatureBank1Sensor1Chart"></div>
					</g:if></br> </br>
					
					
					<g:if test="${catalystTemperatureBank1Sensor2?.points != null && catalystTemperatureBank1Sensor2?.points.size() > 0}">
					<a class="ui teal ribbon label">${catalystTemperatureBank1Sensor2?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="catalystTemperatureBank1Sensor2Chart" width="${1080}"
						height="${600}" columns="${catalystTemperatureBank1Sensor1Columns}" data="${catalystTemperatureBank1Sensor2?.points}"/>
					<div id="catalystTemperatureBank1Sensor2Chart"></div>
					</g:if></br> </br>
					

					<g:if test="${catalystTemperatureBank2Sensor1?.points != null && catalystTemperatureBank2Sensor1?.points.size() > 0}">
					<a class="ui teal ribbon label">${catalystTemperatureBank2Sensor1?.name}</a>
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="catalystTemperatureBank2Sensor1Chart" width="${1080}"
						height="${600}" columns="${catalystTemperatureBank2Sensor1Columns}" data="${catalystTemperatureBank2Sensor1?.points}"/>
					<div id="catalystTemperatureBank2Sensor1Chart"></div>
					</g:if></br> </br>
					
					
					<g:if test="${catalystTemperatureBank2Sensor2?.points != null && catalystTemperatureBank2Sensor2?.points.size() > 0}">
					<a class="ui teal ribbon label">${catalystTemperatureBank2Sensor2?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="catalystTemperatureBank2Sensor2Chart" width="${1080}"
						height="${600}" columns="${catalystTemperatureBank2Sensor2Columns}" data="${catalystTemperatureBank2Sensor2?.points}"/>
					<div id="catalystTemperatureBank2Sensor2Chart"></div>
					</g:if></br> </br>

					
			<div id="fuel"></div>

			<div class="ui equal width grid">
				<div class="column">
					<div class="ui red ribbon label">
						<h3>Fuel System</h3>
					</div>
					</br> </br>

					<g:if test="${fuelPressure?.points != null && fuelPressure?.points.size() > 0}">
					<a class="ui teal ribbon label">${fuelPressure?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="fuelPressureChart" width="${1080}"
						height="${600}" columns="${fuelPressureColumns}" data="${fuelPressure?.points}"/>
					<div id="fuelPressureChart"></div>
					</g:if></br> </br>

					<g:if test="${fuelInjectionTiming?.points != null && fuelInjectionTiming?.points.size() > 0}">
					<a class="ui teal ribbon label">${fuelInjectionTiming?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="fuelInjectionTimingChart" width="${1080}"
						height="${600}" columns="${fuelInjectionTimingColumns}" data="${fuelInjectionTiming?.points}"/>
					<div id="fuelInjectionTimingChart"></div>
					</g:if></br> </br>

					<g:if test="${engineFuelRate?.points != null && engineFuelRate?.points.size() > 0}">
					<a class="ui teal ribbon label">${engineFuelRate?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="engineFuelRateChart" width="${1080}"
						height="${600}" columns="${engineFuelRateColumns}" data="${engineFuelRate?.points}"/>
					<div id="engineFuelRateChart"></div>
					</g:if></br> </br>
					
					
				</div>
			</div></br> </br>

			<div id="throttle"></div>

			<div class="ui equal width grid">
				<div class="column">
					<div class="ui red ribbon label">
						<h3>Throttle/Pedal</h3>
					</div>
					</br> </br>

					<g:if test="${relativeThrottlePosition?.points != null && relativeThrottlePosition?.points?.size() > 0}">
					<a class="ui teal ribbon label">${relativeThrottlePosition?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="relativeThrottlePositionChart" width="${1080}"
						height="${600}" columns="${relativeThrottlePositionColumns}" data="${relativeThrottlePosition?.points}"/>
					<div id="relativeThrottlePositionChart"></div>
					</g:if></br> </br>

					<g:if test="${commandedThrottleActuator?.points != null && commandedThrottleActuator?.points?.size() > 0}">
					<a class="ui teal ribbon label">${commandedThrottleActuator?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="commandedThrottleActuatorChart" width="${1080}"
						height="${600}" columns="${commandedThrottleActuatorColumns}" data="${commandedThrottleActuator?.points}"/>
					<div id="commandedThrottleActuatorChart"></div>
					</g:if></br> </br>

					<g:if test="${relativeAcceleratorPedalPosition?.points != null && relativeAcceleratorPedalPosition?.points?.size() > 0}">
					<a class="ui teal ribbon label">${relativeAcceleratorPedalPosition?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="relativeAcceleratorPedalPositionChart" width="${1080}"
						height="${600}" columns="${relativeAcceleratorPedalPositionColumns}" data="${relativeAcceleratorPedalPosition?.points}"/>
					<div id="relativeAcceleratorPedalPositionChart"></div>
					</g:if></br> </br>
					
					
				</div>
			</div></br> </br>

			<div id="intake"></div>

			<div class="ui equal width grid">
				<div class="column">
					<div class="ui red ribbon label">
						<h3>Intake</h3>
					</div>
					</br> </br>

					<g:if test="${intakeManifoldAbsolutePressure?.points != null && intakeManifoldAbsolutePressure?.points?.size() > 0}">
					<a class="ui teal ribbon label">${intakeManifoldAbsolutePressure?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="intakeManifoldAbsolutePressureChart" width="${1080}"
						height="${600}" columns="${intakeManifoldAbsolutePressureColumns}" data="${intakeManifoldAbsolutePressure?.points}"/>
					<div id="intakeManifoldAbsolutePressureChart"></div>
					</g:if></br> </br>

					<g:if test="${intakeAirTemperature?.points != null && intakeAirTemperature?.points?.size() > 0}">
					<a class="ui teal ribbon label">${intakeAirTemperature?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="intakeAirTemperatureChart" width="${1080}"
						height="${600}" columns="${intakeAirTemperatureColumns}" data="${intakeAirTemperature?.points}"/>
					<div id="intakeAirTemperatureChart"></div>
					</g:if></br> </br>

					<g:if test="${mafAirFlowRate?.points != null && mafAirFlowRate?.points?.size() > 0}">
					<a class="ui teal ribbon label">${mafAirFlowRate?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="mafAirFlowRateChart" width="${1080}"
						height="${600}" columns="${mafAirFlowRateColumns}" data="${mafAirFlowRate?.points}"/>
					<div id="mafAirFlowRateChart"></div>
					</g:if></br> </br>

					<g:if test="${barometricPressure?.points != null && barometricPressure?.points?.size() > 0}">
					<a class="ui teal ribbon label">${barometricPressure?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="barometricPressureChart" width="${1080}"
						height="${600}" columns="${barometricPressureColumns}" data="${barometricPressure?.points}"/>
					<div id="barometricPressureChart"></div>
					</g:if></br> </br>

					<g:if test="${ambientAirTemperature?.points != null && ambientAirTemperature?.points?.size() > 0}">
					<a class="ui teal ribbon label">${ambientAirTemperature?.name}</a> 
					<gvisualization:scatterCoreChart dynamicLoading="${true}"  elementId="ambientAirTemperatureChart" width="${1080}"
						height="${600}" columns="${ambientAirTemperatureColumns}" data="${ambientAirTemperature?.points}"/>
					<div id="ambientAirTemperatureChart"></div>
					</g:if></br> </br>
					
					
				</div>
			</div>
			
			




					</div>
				
				</div>
			</div>
			</br> </br>

			</div>

		</div>
		</br> </br>

	</div>




</body>
</html>
