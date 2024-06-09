import com.hamri.java_scripting_01.app.dao.ItemsReposirory
import com.hamri.java_scripting_01.app.entities.Item
import groovy.transform.Field
import org.springframework.context.ApplicationContext

@Field ApplicationContext ctx = (ApplicationContext)spring;
@Field ItemsReposirory itemsReposirory = ctx.getBean("itemsReposirory");
StringBuffer buffer = new StringBuffer();
getAllItems(buffer);

buffer.append("\n##################\n");

Item item = new Item(888, "a model example");
itemsReposirory.save(item);

getAllItems(buffer);

return buffer.toString();

void getAllItems(StringBuffer buffer) {
    itemsReposirory.findAll().stream().forEach {i ->
        buffer.append(i.toString().concat("\n"))
    }
}