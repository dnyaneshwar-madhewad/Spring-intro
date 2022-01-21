# Spring-intro

=============================================================
  SPRING STEPS
=============================================================
Step1:   Create Simple maven project
                               Group id: com.cdac
                               Artifact id: spring-intro
                               Version : 1.0
===========================================================

Step 2:    Google search: “core spring dependencies” and copy 
Link:      https://mvnrepository.com/artifact/org.springframework/spring-core/5.3.15

===========================================================

Step 3: add following dependencies  pom.xml file

 <dependencies>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.15</version>
</dependency>
 </dependencies>

=====================================================
Step 4: create class file Helloworld.java  file in
               com.cdac.component  package

package com.cdac.component;
public class HelloWorld {
	public String SayHello(String name) {
		return "Hello"+ name.toUpperCase();
	}
}

=====================================================

Step5: create XML file Spring-intro/src/main/resources app-config.xml file

Google search-->"Spring config xml"

Link https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/xsd-configuration.html

*********************************************************************************
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->
<bean id="hw" class="com.cdac.component.helloworld" />
</beans>
********************************************************************************

===========================================================
Step 6: create app.java file in com.cdac.app package

com.cdac.app
package com.cdac.app;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cdac.component.HelloWorld;
public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-config.xml");
		HelloWorld h=(HelloWorld) ctx.getBean("hw");
		System.out.println(h.SayHello("  Dnyaneshwar"));
	}
}

=============================================================
Step 7: we want add one more class then
 
Add class calculator.java in—> com.cdac.component
package com.cdac.component;

public class Calculator {
	public int add(int x, int y) {
		return x + y;
	}
}

And add App.JAVA

Calculator c = (Calculator) ctx.getBean("calc");
System.out.println(c.add(10, 20));

=============================================================

Step 8: add app-config.xml file following dependencies
<bean id="hw" class="com.cdac.component.helloworld" />
<bean id="calc" class="com.cdac.component.Calculator" />

=============================================================
Step9:  in app.java create object of that class and access it

package com.cdac.app;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cdac.component.Calculator;
import com.cdac.component.HelloWorld;

public class App
public static void main(String[] args) {
ApplicationContext ctx = new ClassPathXmlApplicationContext("app-config.xml");
            HelloWorld h = (HelloWorld) ctx.getBean("hw");
            System.out.println(h.SayHello("Dnyaneshwar"));
            Calculator c = (Calculator) ctx.getBean("calc");
            System.out.println(c.add(10, 20));		
}
}

=========================================================
                        Now Change app-config.xml(Dependencies injection)
=========================================================
<?xml version="1.0" encoding="UTF-8"?>
<beans 
	xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- bean definitions here -->
    <!-- Classes whose objects will be created by Spring -->
	<bean id="hw" class="com.cdac.component.HelloWorld" />	
	<bean id="calc" class="com.cdac.component.Calculator" />
	
	<!-- To enable loading of annotated beans -->
	<context:component-scan base-package="com.cdac.component" />
</beans>
=============================================================
Step 10:create CurrencyConverter com.cdac.component package


package com.cdac.component;
import org.springframework.stereotype.Component;
@Component("cc")
public class CurrencyConverter {
	public double convert(String from, String to, double amount) {
		if(from.equals("USD") && to.equals("INR"))
			return amount * 74.47;
		else
			return -1;

}
}

Create object in APP.java
CurrencyConverter currConv = (CurrencyConverter) ctx.getBean("cc");
System.out.println(currConv.convert("USD", "INR", 75));

=========================================================

  
Step1:Create class file in Spell checker in component package
package com.cdac.component;
import org.springframework.stereotype.Component;
@Component("splChckr")
public class SpellChecker {
	public void checkSpellingMistakes(String doc) {
		System.out.println("Spelling check done for " + doc +" document..");
	}
}

Step2:Create class file in TextEditor component package

package com.cdac.component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("txtEdtr")
public class TextEditor {

	@Autowired //DI
	private SpellChecker sp;
	
	public void loadDocument(String doc) {
		System.out.println("Document " + doc + " loaded successfully..");
		//from here i want to call checkSpellingMistakes function of SpellChecker class
		//SpellChecker sp = new SpellChecker(); --> we will not do this as Spring is meant for this purpose
		sp.checkSpellingMistakes(doc);
	}
}


Step3: add this code in App.java file

TextEditor te = (TextEditor) ctx.getBean("txtEdtr");
te.loadDocument("abc.txt");

