import com.hamri.java_scripting_01.app.dao.ItemsReposirory
import com.hamri.java_scripting_01.app.entities.Item
import groovy.transform.Field
import org.springframework.context.ApplicationContext

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Field ApplicationContext ctx = (ApplicationContext)spring;
@Field ItemsReposirory itemsReposirory = ctx.getBean("itemsReposirory");

ExecutorService executor = Executors.newFixedThreadPool(5);  // Adjust the number of threads based on your system capabilities

int numberOfItems = 100;

// Create and save 100 items with unique IDs
for (int i = 1; i <= numberOfItems; i++) {
    final int itemId = i;  // Must be final or effectively final for use in lambda
    executor.submit(() -> {
        Item item = new Item(itemId, "Model Item #" + itemId);
        itemsReposirory.save(item);
        return; // Optional, just for clarity
    });
}

// Shut down executor and wait for all tasks to complete
executor.shutdown();
try {
    if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
        executor.shutdownNow();
    }
} catch (InterruptedException e) {
    executor.shutdownNow();
    Thread.currentThread().interrupt();  // Preserve interrupt status
}

return "100 items saved successfully.";
