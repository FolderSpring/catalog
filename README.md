# catalog
VendorInfo


<h1>SIMPLE SPRING BOOT APPLICATION - Vendor Info</h1>
<p>Application runs on port 8080 in TOMCAT</p>
<p>In root folder located packaged JAR file</p>
<p>Also in root folder located Dockerfile. With this file we can create image with our JAR and run container from our image</p></br>

<p>Clone project, enter to folder and run command:</p>
<p>> docker build -f Dockerfile -t springboot .		// In current folder should be file Dockerfile. Dot at the end - current directory</p>
<p>We can check if image created by running command:</p>
<p>> docker images</p>
<p>Now we can start container from our newly created image</p>
<p>> docker run --name web -p 8080:8080 springboot</p>
