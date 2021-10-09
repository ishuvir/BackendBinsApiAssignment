# BackendBinsApiAssignment
Assignment for BinsApi automation

Functional requirement: To Automate Bins api CRUD operations
Reference Link :https://jsonbin.io/api-reference
CREATE A BIN--> POST Operation
READ A BIN-->GET Operation
UPDATE A BIN-->PUT Operation
DELETE A BIN-->DELETE Operation

Backend Api Jar/Tools Used for Automation -->
RestAssured 

Programming language-->
Java(11/8)

Reporting-->
Extent Report
Cucumber report

Build tool--> 
Maven

Test Approach-->
BDD/Cucumber

Data approach-->
Configuration property file

Logger-->
Log4j


3 Main folder/package as per BDD approach
-->Feature files
-->StepDefinitions
-->Runner


How to execute the automation project-->

1:locally can be executed by either running testRunner.java class from any IDE
or 
can be executed by selecting maven test from POM.xml

2: using CMD tool by entering below command in you system command prompt
mvn clean test

Report generation-->
1:Extent Report will be generate under target folder as cucumber_report.html
2:Cucumber index.html report get generated under target/reports folder



