package diary.tasks;

import diary.Repeatability;
import diary.TypeOfTask;
import java.time.LocalDateTime;

public class SingleTask extends Task implements Repeatability {

  public SingleTask(String name, String description, TypeOfTask type, LocalDateTime date) {
    super(name, description, type, date);
  }

  @Override
  public LocalDateTime getDateTime(LocalDateTime dateTime) {
    return dateTime;
  }

  @Override
  public String getTypeRepeatability() {
    return "Однократная ";
  }
}
