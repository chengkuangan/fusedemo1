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

<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns1="http://security.demo.jboss.com/">
   <soap:Header/>
   <soap:Body>
      <ns1:submitSec>
         <!--Optional:-->
         <ns1:arg0>
            <records>
      <record>
         <awsRegion>us-east-2</awsRegion>
         <eventName>StartInstances</eventName>
         <eventSource>ec2.amazonaws.com</eventSource>
         <eventTime>2014-03-06T21:22:54Z</eventTime>
         <eventVersion>1.0</eventVersion>
         <requestParameters>
            <instancesSet>
               <instancesSetItems>
                  <instancesSetElement>
                     <instanceId>i-ebeaf9e2</instanceId>
                  </instancesSetElement>
               </instancesSetItems>
            </instancesSet>
         </requestParameters>
         <responseElements>
            <responseInstancesSet>
               <responseItems>
                  <responseElement>
                     <currentState>
                        <code>0</code>
                        <name>pending</name>
                     </currentState>
                     <instanceId>i-ebeaf9e2</instanceId>
                     <previousState>
                        <code>80</code>
                        <name>stopped</name>
                     </previousState>
                  </responseElement>
               </responseItems>
            </responseInstancesSet>
         </responseElements>
         <sourceIPAddress>205.251.233.176</sourceIPAddress>
         <userAgent>ec2-api-tools 1.6.12.2</userAgent>
         <userIdentity>
            <accessKeyId>EXAMPLE_KEY_ID</accessKeyId>
            <accountId>123456789012</accountId>
            <arn>arn:aws:iam::123456789012:user/Alice</arn>
            <principalId>EX_PRINCIPAL_ID</principalId>
            <type>IAMUser</type>
            <userName>Alice</userName>
         </userIdentity>
      </record>
   </records>
         </ns1:arg0>
      </ns1:submitSec>
   </soap:Body>
</soap:Envelope>


