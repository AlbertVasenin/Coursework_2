package diary.tasks;

import diary.Repeatability;
import diary.TypeOfTask;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task implements Repeatability {

  public SingleTask(String name, String description, TypeOfTask type, LocalDateTime date) {
    super(name, description, type, date);
  }

  @Override
  public boolean appearsIn(LocalDate dateTime) {
    return date.toLocalDate().equals(dateTime);
  }

  @Override
  public String getTypeRepeatability() {
    return "однократная ";
  }
}
