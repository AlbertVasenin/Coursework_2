package diary.tasks;

import diary.Repeatability;
import diary.TypeOfTask;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class DailyTask extends Task implements Repeatability {

  public DailyTask(String name, String description, TypeOfTask type, LocalDateTime date) {
    super(name, description, type, date);
  }

  public LocalDateTime getDate() {
    return date;
  }

  @Override
  public boolean appearsIn(LocalDate dateTime) {
    return date.toLocalDate().isBefore(ChronoLocalDate.from(dateTime))
        || date.toLocalDate().equals(dateTime);
  }

  @Override
  public LocalDateTime getDateTime(LocalDateTime dateTime) {
    LocalDateTime date = dateTime;
    while (date.isBefore(dateTime)) {
      date = date.plusDays(1);
    }
    return date;
  }

  @Override
  public String getTypeRepeatability() {
    return "ежедневная ";
  }
}
