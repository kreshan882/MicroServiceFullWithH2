https://www.youtube.com/watch?v=BnknNTN8icw

Git
############################################################
   get file from Git BAST commant font
   ======================================
	git config --global user.email "kreshan882@gmail.com"
	cd D://PROJECTS//ECLIPES_K//PERSONAL_SPRINGBOOT//
	git clone https://github.com/kreshan882/MicroServiceFullTest.git
	
	================================
	upload Git BAST commant font
	================================
	git config --global user.email "kreshan882@gmail.com"
	cd PERSONAL_SPRINGBOOT_MS/
	git init
	git add cloud-gateway/src/* cloud-gateway/pom.xml cloud-gateway/mvnw* cloud-gateway/mvnw.cmd cloud-gateway/.gitignore cloud-gateway/.mvn/*
	git add department-service/src/* department-service/pom.xml department-service/mvnw* department-service/mvnw.cmd department-service/ReadMeK.txt
	git add user-service/src/* user-service/pom.xml user-service/mvnw* user-service/mvnw.cmd 
	git add service-registry/src/* service-registry/pom.xml service-registry/mvnw* service-registry/mvnw.cmd 
	git status  ==> check status 
	git commit -m "commit fst"
	git log
	git push https://github.com/kreshan882/MicroServiceFullTest.git

##########################################################

1) create new SpringBoot
        1.1) https://start.spring.io
        1.2) SpringToolSuit4
            Group :com.msdemokre
            Artific :department-service
            Name    :department-service
            Description:department-service
            package Name: com.msdemokre.department
2) Addedd component
    SpringWeb + Spring Data Jpa + H2 database + Lambok

3) Run As SpringBootApp

4) Postman [Department]
	post -> body -> row -> json 
	POST -> send request [http://localhost:9001/departments/]
		{
	    "departmentName":"sw",
	    "departmentAddress":"srilanka",
	    "departmentCode":"hitachi"
		}
	Send request
    
    GET -> get response [http://localhost:9001/departments/1]
    

5) postman [User]
	POST -> send request [http://localhost:9002/users/]
		{
		    "firstName":"kreshan",
		    "lastName":"rajendran",
		    "email":"kreshan882@gmail.com",
		    "departmentId":"1"
		}
	Send request
    
    GET -> get response [http://localhost:9002/users/1]
    
5) Service_registery = discoveryServer [ eureka Server] 
    		Group :com.msdemokre
            Artific :service-registry
            Name    :service-registry
            Description:service-registry
            package Name: com.msdemokre.service_registry
            
            Addedd component --> Eureka Server
            
    --> add "eureka client" -> POM details to department_service+user_service
    
6) Run Eureka server
	http://localhost:8761/
	binding is listed
	
7) cloude_gateway= ApiGateway [Eureka Discovery client]
			Group :com.msdemokre
            Artific :cloud-gateway
            Name    :cloud-gateway
            Description:cloud-gateway
            package Name: com.msdemokre.cloud_gateway
	
			Addedd component --> Eureka Discovery client + Gateway + Spring Boot Actuator
			

