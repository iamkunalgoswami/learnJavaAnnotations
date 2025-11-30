
# Adding Spring dependencies
```xml
    <spring.version>6.1.10</spring.version>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version> 
            <scope>test</scope>
        </dependency>
    </dependencies>
```


# Add Jetty to the Server

```text
This will:
•  Start Jetty on port 8080
•  Deploy the application at http://localhost:8080/

We can access:
•  http://localhost:8080/ - Shows "Hello World from Jetty!"
•  http://localhost:8080/test - Shows "Test endpoint working!"

To stop the server, press Ctrl+C.

I've configured application to:
1. Package as a WAR file
2. Added the Jetty Maven plugin
3. Created Spring MVC configuration with component scanning
4. Added a web initializer for servlet 3.0+ (no web.xml needed)
5. Created a sample controller with two endpoints
```

    1. Packaging: JAR → WAR
       •  Your original app was a standalone JAR with a main() method
       •  Jetty is a servlet container that hosts web applications
       •  Web applications must be packaged as WAR (Web Application Archive) files
       •  WAR files contain servlets, web resources, and metadata that Jetty understands

    2. Jetty Maven Plugin
       •  Provides the mvn jetty:run command
       •  Without it, you'd have to manually download Jetty, configure it, and deploy your WAR
       •  The plugin does all this automatically during development

    3. Servlet API Dependency (jakarta.servlet-api)
       •  Jetty implements the servlet specification
       •  To create web endpoints and handle HTTP requests, you need servlet classes
       •  Spring MVC builds on top of servlets (DispatcherServlet)
       •  Marked as provided because Jetty already includes these classes

    4. WebConfig (Spring Configuration)
       •  @EnableWebMvc - Activates Spring's web MVC features
       •  @ComponentScan - Tells Spring where to find your controllers
       •  Without this, Spring doesn't know how to handle HTTP requests
        

```xml
        <web-app xmlns="http://jakarta.ee/xml/ns/jakartaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://jakarta.ee/xml/ns/jakartaee
                                 http://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
             version="6.0">
    
            <!-- Spring DispatcherServlet -->
            <servlet>
                <servlet-name>dispatcher</servlet-name>
                <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
                <init-param>
                    <param-name>contextConfigLocation</param-name>
                    <param-value>/WEB-INF/spring-config.xml</param-value>
                </init-param>
                <load-on-startup>1</load-on-startup>
            </servlet>
        
            <!-- Servlet Mapping -->
            <servlet-mapping>
                <servlet-name>dispatcher</servlet-name>
                <url-pattern>/</url-pattern>
            </servlet-mapping>
        
        </web-app>
```

```java
package com.selenophile.annotations;

import com.selenophile.annotations.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
```
    6. HelloController
       •  My original App.java just prints to console
       •  Controllers handle HTTP requests and return responses
       •  Without at least one controller, visiting the URL would show an error.