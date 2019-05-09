# springboot-mvc-jsp-security-example
springboot-mvc-jsp-security-example

Spring là một framework nổi tiếng vì nó hỗ trợ nhiều công nghệ cho tầng View (View Layer). Các công nghệ mà Spring hỗ trợ cho tầng View là JSP, Thymeleaf, Freemarker,... 
Vì sự đơn giản của Thymeleaf, nó được coi như công nghệ mặc định để sử dụng cho tầng View, và được Spring Boot tự động cấu hình. Vì vậy nếu bạn lựa chọn JSP cho tầng View, bạn cần phải cấu hình nó.
Trong bài viết này tôi sẽ hướng dẫn bạn tạo một ứng dụng Web với Spring Boot, và sử dụng JSP để hiển thị dữ liệu. Các nội dung sẽ được đề cập trong bài viết này:
Cấu hình để sử dụng JSP cho tầng View (View Layer)
Giải thích nguyên tắc hoạt động của Controller & JSP.

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14247061.png"><br>

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14247164.png"><br>

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14247225.png"><br>

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14247342.png"><br>

SpringBootJspApplication.java

```
package org.o7planning.sbjsp;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class SpringBootJspApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJspApplication.class, args);
    }
}
```

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14247519.png"><br>

Cấu hình các thư viện cần thiết cho JSP/Servlet trong tập tin pom.xml:
```
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
 
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
</dependency>
```
<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14247625.png"><br>

application.properties

```
# =============================================
# VIEW RESOLVER
# =============================================
 
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14247716.png"><br>

Person.java
```
package org.o7planning.sbjsp.model;
 
public class Person {
 
    private String firstName;
    private String lastName;
 
    public Person() {
 
    }
 
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
}
```

MainController.java

```
package org.o7planning.sbjsp.controller;
 
import java.util.ArrayList;
import java.util.List;
 
import org.o7planning.sbjsp.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {
 
    private static List<Person> persons = new ArrayList<Person>();
 
    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }
 
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        String message = "Hello Spring Boot + JSP";
 
        model.addAttribute("message", message);
 
        return "index";
    }
 
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "personList";
    }
 
}
```

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14247832.png"><br>

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14247832.png"><br>

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14248879.png"><br>

<img src="https://github.com/vomtung/springboot-mvc-jsp-security-example/blob/master/springboot-mvc-jsp-security-example/image/14248955.png"><br>

