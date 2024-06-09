import com.hamri.java_scripting_01.app.entities.Item
import com.hamri.java_scripting_01.scripting.Registry

Item item = new Item(55, "test55");
println(item);

Item i01 = (Item) spring.getBean("item01");
return i01.toString();