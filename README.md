Jersey-Netty-Container
======================

Jersey Container implemenation based on Netty.

NOTE: all versions before 0.0.4 are broken.
-------------------------------------------


Dependencies:
-------------

[INFO] --- maven-dependency-plugin:2.1:tree (default-cli) @ jersey-netty-test-container ---
[INFO] com.devsprint.jersey.api:jersey-netty-test-container:jar:0.0.4
[INFO] +- com.sun.jersey.jersey-test-framework:jersey-test-framework-http:jar:1.11:compile
[INFO] |  \- com.sun.jersey.jersey-test-framework:jersey-test-framework-core:jar:1.11:compile
[INFO] |     +- javax.servlet:javax.servlet-api:jar:3.0.1:compile
[INFO] |     +- junit:junit:jar:4.8.2:compile
[INFO] |     +- com.sun.jersey:jersey-servlet:jar:1.11:compile
[INFO] |     \- com.sun.jersey:jersey-client:jar:1.11:compile
[INFO] +- com.devsprint.jersey.api:jersey-netty-container:jar:0.0.4
[INFO] |  +- com.sun.jersey:jersey-server:jar:1.11:compile
[INFO] |  |  +- asm:asm:jar:3.1:compile
[INFO] |  |  \- com.sun.jersey:jersey-core:jar:1.11:compile
[INFO] |  \- org.jboss.netty:netty:jar:3.2.7.Final:compile
[INFO] +- org.slf4j:slf4j-api:jar:1.6.1:compile
[INFO] +- ch.qos.logback:logback-core:jar:0.9.28:compile
[INFO] \- ch.qos.logback:logback-classic:jar:0.9.28:compile


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
			<version>0.0.4</version>
		</dependency>
		<dependency>
			<groupId>com.devsprint.jersey.api</groupId>
			<artifactId>jersey-netty-test-container</artifactId>
			<version>0.0.4</version>
			<scope>test</scope>
		</dependency>

Example project:
----------------

https://github.com/devsprint/async_addressbook


License
---------------------

Copyright 2011 Gabriel Ciuloaica (gciuloaica@gmail.com)

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
