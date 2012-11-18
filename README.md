Jersey-Netty-Container
======================

Jersey Container implemenation based on Netty. This is not intended for production usage. It was build to get familiar with the SPI of Jersey.

NOTE: all versions before 0.0.4 are broken.
-------------------------------------------


Dependencies:
-------------


*  Netty 3.3.0.Final

*  Jersey 1.11

*  SLF4J 1.6.4

*  Logback 1.0.0 


How to use it?
--------------

1. Add following Maven artifact repository to your settings.xml or pom.xml:
		
		<repository>
			<id>devsprint.release.repo</id>
			<url>https://github.com/devsprint/devsprint.github.com/raw/master/releases/</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>

2. Add dependencies:

		<dependency>
			<groupId>com.devsprint.jersey.api</groupId>
			<artifactId>jersey-netty-container</artifactId>
			<version>0.0.6</version>
		</dependency>
		<dependency>
			<groupId>com.devsprint.jersey.api</groupId>
			<artifactId>jersey-netty-test-container</artifactId>
			<version>0.0.6</version>
			<scope>test</scope>
		</dependency>

Example project:
----------------

https://github.com/devsprint/async_addressbook

Server configuration:

https://github.com/devsprint/async_addressbook/blob/master/src/main/java/com/devsprint/learning/agenda_service/AsyncRestServer.java

Test Configuration:

https://github.com/devsprint/async_addressbook/blob/master/src/test/java/com/devsprint/learning/agenda_service/Scenario.java


License
---------------------

Copyright 2011 Gabriel Ciuloaica (gciuloaica@gmail.com)

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
