Camel Project for Spring 
=========================================


This demo expose SOAP endpoint and send the data into database using JDBC. 
The SOAP endpoint is http://localhost:9292/cxf/makePayment 

Steps to Configure and Deploy this demo:

1. Run the following script at the JBoss Fuse CLI to install the required features:

features:install camel-jackson
// features:install camel-http4
osgi:install -s wrap:mvn:commons-dbcp/commons-dbcp/1.4
osgi:install -s wrap:mvn:org.springframework/spring-jdbc/3.2.16.RELEASE
osgi:install -s wrap:mvn:org.postgresql/postgresql/42.2.1
features:install spring-tx
features:install spring-jdbc
features:install camel-sql

2. Create the demo postgresql database. Refers to src/main/resources/createDemoDB.sql for the database script.

3. If your database is not Postgresql, please modify camel-context.xml to reflect the actual configuration:

<bean class="org.apache.commons.dbcp.BasicDataSource" id="myDS">
        <property name="driverClassName" value="org.postgresql.Driver"/>
        <property name="url" value="jdbc:postgresql://localhost:5432/myDemo"/>
        <property name="username" value="postgres"/>
        <property name="password" value="password"/>
    </bean>

4. Create a A-MQ queue named demoQueue via the Fuse Admin Console. 

5. To build this project, change directory to the root source folder and run the following command:

    mvn clean install
    
6. To install, run the following command at the JBoss Fuse CLI:

osgi:install -s mvn:com.jboss.demo/camel-spring-soap-demo/1.0.0-SNAPSHOT

7. To test the SOAP endpoint either using POSTMAN or SOAPUI, point the URL to http://localhost:9292/cxf/makePayment
Enter the following SOAP envelope test data.

<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns1="http://demo.jboss.com/">
   <soap:Header/>
   <soap:Body>
      <ns1:makePayment>
         <ns1:arg0>
            <amount>10.50</amount>
            <merchantId>M-001</merchantId>
            <merchantName>McDonald</merchantName>
            <payeeAccountNo>12345-012-2345</payeeAccountNo>
            <payeeFirstName>CK</payeeFirstName>
            <payeeLastName>Gan</payeeLastName>
            <transactedTimestamp>1517587200000</transactedTimestamp>
            <transctionId>20180203000001</transctionId>
         </ns1:arg0>
      </ns1:makePayment>
   </soap:Body>
</soap:Envelope>


