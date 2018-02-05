Camel Project for Spring 
=========================================

This demo expose SOAP endpoint and send the data into database using JDBC.

Before Deploy, run the following script at the JBoss Fuse CLI to install the required features:

features:install camel-jackson
features:install camel-http4
osgi:install -s wrap:mvn:commons-dbcp/commons-dbcp/1.4
osgi:install -s wrap:mvn:org.springframework/spring-jdbc/3.2.16.RELEASE
osgi:install -s wrap:mvn:org.postgresql/postgresql/42.2.1
features:install spring-tx
features:install spring-jdbc
features:install camel-sql


A database need to be created, please refer to the src/main/resources/insertTxnLog.sql for the SQL statements with required table name and structure.

Change the following in the camel-context.xml to the correct JDBC driver and connection detail:

<bean class="org.apache.commons.dbcp.BasicDataSource" id="myDS">
        <property name="driverClassName" value="org.h2.Driver"/>
        <property name="url" value="jdbc:h2:file:~/demo/kbtg/db/ps"/>
        <property name="username" value="sa"/>
        <property name="password" value="sa"/>
    </bean>

To build this project, change directory to the root source folder and run the following command:

    mvn install
    
To install, run the following command at the JBoss Fuse CLI:

JBossFuse:karaf@root> osgi:install -s mvn:com.jboss.demo/camel-spring-soap-demo/1.0.0-SNAPSHOT

After installed, to the endpoint, use a SOAP client such as POSTMAN or SOAPUI with the following SOAP envelope.
The endpoint URL is http://localhost:9292/cxf/makePayment

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


Additional information:
========================

1. Demo Database Details.

Create a database named myDemo and a schema named demo.

Run the following script to create the table.
 
Postgresql table structure:

DROP TABLE demo.txnlog;

CREATE TABLE demo.txnlog
(
    txnid character varying(255) COLLATE pg_catalog."default",
    merchantid character varying(255) COLLATE pg_catalog."default",
    merchantname character varying(255) COLLATE pg_catalog."default",
    amount character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    rejectreason character varying(255) COLLATE pg_catalog."default",
    txndate character varying(255) COLLATE pg_catalog."default",
    testq character varying(255) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE demo.txnlog
    OWNER to postgres;

GRANT ALL ON TABLE demo.txnlog TO postgres;


