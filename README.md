Jersey-Netty-Container
======================

Jersey Container implemenation based on Netty.

NOTE: all versions before 0.0.4 are broken.
-------------------------------------------


Dependencies:
-------------


 com.devsprint.jersey.api:jersey-netty-test-container:jar:0.0.4
  com.sun.jersey.jersey-test-framework:jersey-test-framework-http:jar:1.11:compile
     com.sun.jersey.jersey-test-framework:jersey-test-framework-core:jar:1.11:compile
          javax.servlet:javax.servlet-api:jar:3.0.1:compile
          junit:junit:jar:4.8.2:compile
          com.sun.jersey:jersey-servlet:jar:1.11:compile
          com.sun.jersey:jersey-client:jar:1.11:compile
      com.devsprint.jersey.api:jersey-netty-container:jar:0.0.4
       com.sun.jersey:jersey-server:jar:1.11:compile
          asm:asm:jar:3.1:compile
          com.sun.jersey:jersey-core:jar:1.11:compile
       org.jboss.netty:netty:jar:3.2.7.Final:compile
    org.slf4j:slf4j-api:jar:1.6.1:compile
    ch.qos.logback:logback-core:jar:0.9.28:compile
       ch.qos.logback:logback-classic:jar:0.9.28:compile


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
