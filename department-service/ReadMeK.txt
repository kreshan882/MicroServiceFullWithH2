https://www.youtube.com/watch?v=BnknNTN8icw

update every where it was support all
<version>2.3.4.RELEASE</version>
<spring-cloud.version>Hoxton.SR8</spring-cloud.version>
Git
############################################################
   get file from Git BAST commant font
   ======================================
	git config --global user.email "kreshan882@gmail.com"
	cd D://PROJECTS//ECLIPES_K//PERSONAL_SPRINGBOOT_MS//
	git clone https://github.com/kreshan882/MicroServiceFullWithH2.git
	
	================================
	upload Git BAST commant font
	================================
	git config --global user.email "kreshan882@gmail.com"
	cd PERSONAL_SPRINGBOOT_MS/
	git init
	
	git add department-service/src/* department-service/pom.xml department-service/mvnw* department-service/mvnw.cmd department-service/.gitignore department-service/ReadMeK.txt department-service/.mvn
	git add user-service/src/* user-service/pom.xml user-service/mvnw* user-service/mvnw.cmd user-service/.gitignore user-service/.mvn/*
	git add service-registry/src/* service-registry/pom.xml service-registry/mvnw* service-registry/mvnw.cmd service-registry/.gitignore service-registry/.mvn/*
	git add cloud-gateway/src/* cloud-gateway/pom.xml cloud-gateway/mvnw* cloud-gateway/mvnw.cmd cloud-gateway/.gitignore cloud-gateway/.mvn/*
	git add cloud-config-server/src/* cloud-config-server/pom.xml cloud-config-server/mvnw* cloud-config-server/mvnw.cmd cloud-config-server/.gitignore cloud-config-server/.mvn/*
	
	
	git add department-service/src/* department-service/pom.xml department-service/ReadMeK.txt 
	git add user-service/src/* user-service/pom.xml
	git add service-registry/src/* service-registry/pom.xml
	git add cloud-gateway/src/* cloud-gateway/pom.xml
	git add cloud-config-server/src/* cloud-config-server/pom.xml
	git add configServer/*
	git add hystrix-dashboard/src/* hystrix-dashboard/pom.xml
	
	git status  ==> check status 
	git commit -m "commit fst"
	git log
	git push https://github.com/kreshan882/MicroServiceFullWithH2.git

##########################################################

1) create new SpringBoot [department-service + user-service]
        1.1) https://start.spring.io
        1.2) SpringToolSuit4
            Group :com.msdemokre
            Artific :department-service
            Name    :department-service
            Description:department-service
            package Name: com.msdemokre.department
	1.1) Addedd component
    	SpringWeb + Spring Data Jpa + H2 database + Lambok

	1.2) Run As SpringBootApp

	1.3) Postman [Department]
		post -> body -> row -> json 
		POST -> send request [http://localhost:7001/departments/]
			{
		    "departmentName":"sw",
		    "departmentAddress":"srilanka",
		    "departmentCode":"hitachi"
			}
		Send request
	    
	    GET -> get response [http://localhost:7001/departments/1]
    

	1.4) postman [User]
		POST -> send request [http://localhost:7002/users/]
			{
			    "firstName":"kreshan",
			    "lastName":"rajendran",
			    "email":"kreshan882@gmail.com",
			    "departmentId":"1"
			}
		Send request
	    
	    GET -> get response [http://localhost:7002/users/1]
    
2) Service_registery = discoveryServer [ eureka Server] 
    		Group :com.msdemokre
            Artific :service-registry
            Name    :service-registry
            Description:service-registry
            package Name: com.msdemokre.service_registry
            
            Addedd component --> Eureka Server
            
    2.1) add "Eureka Discovery client" -> POM details to department_service+user_service
    
	2.2) Run Eureka server
		http://localhost:8761/
		binding is listed
	
3) cloude_gateway= ApiGateway [Eureka Discovery client + Gateway + Spring Boot Actuator]
			Group :com.msdemokre
            Artific :cloud-gateway
            Name    :cloud-gateway
            Description:cloud-gateway
            package Name: com.msdemokre.cloud_gateway
	
			Addedd component --> Eureka Discovery client + Gateway + Spring Boot Actuator
			
			3.1) mobile to API-GATEWAY port
			POST -> send request [http://localhost:7171/departments/
			POST -> send request [http://localhost:7171/users/
			GET  -> resi request [http://localhost:7171/users/1
	
			3.2) fall back mathod added to APi-Gateway 
					add "Hystrix" -> POM details added to cloud-gateway  
					<dependency>
						<groupId>org.springframework.cloud</groupId>
						<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
						<version>2.2.7.RELEASE</version>
					</dependency> 
					
				hystrix:
  					command: server down response showing.....
  					
4) Hystrix-dashboard [Eureka Discovery client + histeric dashboard] 
		http://localhost:9295/hystrix --> DashBoard Page
			add apiStriming and monitor (cloude-gateway port)  ??????????????????
			===>> http://localhost:7171/actuator/hystrix.strean ????????? where can get
   ####################################################################
   time 1.02 ======> only dash board not working because no histerix
   ####################################################################
   
   
   
   
5) config server  [Eureka Discovery client + ConfigServer]
	cloud-config-server--> all config in single place + add details to pom all service
	
	
6) ZipKin server => log with trce no (1.12-1.21)
	Download ==> https://zipkin.io/pages/quickstart  (java -> latest release)
	Start ==> java -jar zipkin.jar
	chrome: http://127.0.0.1:9411/
	
	6.1) install ZipKin client ,
		 add "ZipKin client" -> POM details to department_service+user_service+ext..
		 add spring: zipkin: base-url:http://127.0.0.1:9411/
		 
		 Log[ DEPARTMENT-SERVICE:1111-trcId:111,true] ---> all logs are one place
		 
		 