```java id="repo002"
package repository;

import java.io.FileWriter;
import java.io.IOException;

public class ResultRepository {

    public void saveResult(String username, int score) {

        try (FileWriter writer = new FileWriter("src/resources/results.csv", true)) {

            writer.append(username)
                  .append(",")
                  .append(String.valueOf(score))
                  .append("\n");

        } catch (IOException e) {
            System.out.println("Error saving result.");
        }
    }
}
```
