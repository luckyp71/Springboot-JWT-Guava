# Spring Boot-JWT-Guava
jenkins testing
<p> Enabling multiple systems to interact with each other within three-tier or n-tier architecture may vary, SOAP and REST are the two main ways to reach it. This repo aims to simulates the system interaction through RESTful web Service. </p> 
<p>Since it's RESTful web service in which it is more of an architectural style than a protocol, there is no protocol restriction like SOAP. With the flexibility it offered, it's likely to choose over nearly any protocol, but for the convenience the RESTful web service of this project used the common protocol for the communication i.e. HTTP. </p>

<h3>Prerequisites</h3>
<p>1. Java 1.8</p>
<p>2. Spring boot</p>
<p>3. Maven</p>
<p>4. STS</p>
<p>5. Postgresql</p> 
<p>6. Tomcat</p>

<p>The only resource provided from the project is customer, nevertheless there are four HTTP methods used for certain purposes i.e. GET, POST, PUT, and Delete to get, insert, update, and delete customer data respectively.</p>

<p>To keep things simple, this project has two same REST URLs to GET a single object of customer data and DELETE as well as three same REST URLs to GET list of customers data, POST, and PUT. Furthermore, this project also followed REST API design's best practice by using plural in naming its resource as well as avoiding verb in naming its relative path.</p>
<p>Following are the details of this project's REST URLs:</p>
<p>1. Retrieve list of customers data</p>
<p>HTTP Method = GET</p>
<p>URL = http://localhost:8090/customers</p>  
<p>2. Retrieve a single object of customer data</p>
<p>HTTP Method = GET</p>
<p>URL = http://localhost:8090/customers/{id}</p>
<p>3. Insert a new customer data</p>
<p>HTTP Method = POST</p>
<p>URL = http://localhost:8090/customers</p>
<p>
JSON's payload example for inserting customer data = 
  </p>
  <p>
{
  "id":"1",
  "name":"name1",
  "address":"address1"
}
</p>
<p>4. Update a customer data</p>
<p>HTTP Method = PUT</p>
<p>URL = http://localhost:8090/customers</p>
<p>
JSON's payload example for updating customer data = 
  </p>
  <p>
{
  "id":"1",
  "name":"name1",
  "address":"address1"
}
</p>
<p>5. Delete a customer data</p>
<p>HTTP Method = DELETE</p>
<p>URL = http://localhost:8090/customers/{id}</p>
<p>6. Evict Cache</p>
<p>HTTP Method = GET</p>
<p>URL = http://localhost:8090/customers/clearCache</p>
<p>7. Get token of JWT</p>
<p>HTTP Method = POST</p>
<p>URL = http://localhost:8090/login</p>
<p>
JSON's payload for login = 
  </p>
  <p>
{
  "username":"admin",
  "password":"admin"
}
</p>
<p>To send the request to each REST URL which has /customers base path, you must add Authorization in the header with token which is generated after login as its value.</p>

<p>Since the image version of this project has hosted on docker hub (https://hub.docker.com/r/luckyp71/sbjwtguava/tags/) then you could also run it in your docker container, but there are things you should bear in mind to get the app running:</p>
<p>1. Create postgreSQL's database called example</p>
<p>2. Create user credential for example database above with username and password, postgres and pratama, respectively</p>  
