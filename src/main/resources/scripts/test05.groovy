import com.hamri.java_scripting_01.scripting.Registry

StringBuffer beans = new StringBuffer();
spring.beanDefinitionNames.each { it ->
    beans.append(it + "\n");
}

return Registry.getApplicationContext().getBean("jjj");
