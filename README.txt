
 **** steps for run project in  idea  ***

 1)  src/resource / applications.properties

 changes the  follwing parameter  depend on your databas
 spring.datasource.url = jdbc:mysql://localhost:3306/mr_mangment?useSSL=false
 spring.datasource.username = root
 spring.datasource.password = mysql

 if you want to create hibernate database schema than update following pro

  spring.jpa.hibernate.ddl-auto= update  // update to create


2)  change the  server port if  necessary

    server.port =8082


 3)  from swagger check url

     http://localhost:8082/swagger-ui.html#


  4 ) steps for testing using postman  :


     1)  drugs : add ,update,get , delete drugs ;

     2) representative :   add ,update,delete  representative
         and  assign or remove drugs to representative.

        i am sharing postman collections  and databse dump file for referances





     *********************************






