# REST SERVICE - Vendor Info
<p><b> > /catalog/</b> - main page with info about service</p>
<p><b> > /catalog/booking/21-12-2016</b> - get info about vendor by date</br>
[{"id":"2","name":"P2alace H2otel","roomNumber":"1932"},{"id":"3","name":"Bé2atrice Imp2érial Hot2el","roomNumber":"164"},{"id":"4","name":"D2an Bou2tique","roomNumber":"88"}]</p>
<p><b> > /catalog/booking/21-12-2016/2</b> - get info about vendor by date by id</br>
{"id":"2","name":"Pa2lace Hot2el","roomNumber":"1932"}</p>

# SIMPLE SPRING BOOT APPLICATION - Vendor Info
<p>Application runs on port 8080 in TOMCAT</p>
<p>In root folder located packaged JAR file</p>
<p>Also in root folder located Dockerfile. With this file we can create image with our JAR and run container from our image</p></br>

<p>Clone project, enter to folder and run command:</p>
<p>> docker build -f Dockerfile -t springboot .		// In current folder should be file Dockerfile. Dot at the end - current directory</p>
<p>We can check if image created by running command:</p>
<p>> docker images</p>
<p>Now we can start container from our newly created image</p>
<p>> docker run --name web -p 8080:8080 springboot</p><br>

<p>SWAGGER:</p>
<p>/swagger-ui.html#/catalog</p>
