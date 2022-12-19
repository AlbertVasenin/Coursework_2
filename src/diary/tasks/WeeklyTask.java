package diary.tasks;

import diary.Repeatability;
import diary.TypeOfTask;
import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatability {

  public WeeklyTask(String name, String description, TypeOfTask type, LocalDateTime date) {
    super(name, description, type, date);
  }

  @Override
  public LocalDateTime getDateTime(LocalDateTime dateTime) {
    LocalDateTime date = dateTime;
    while (date.isBefore(dateTime)) {
      date = date.plusWeeks(1);
    }
    return date;
  }

  @Override
  public String getTypeRepeatability() {
    return "Еженедельная ";
  }
}
