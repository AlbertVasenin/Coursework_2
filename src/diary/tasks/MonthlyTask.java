package diary.tasks;

import diary.Repeatability;
import diary.TypeOfTask;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class MonthlyTask extends Task implements Repeatability {

  public MonthlyTask(String name, String description, TypeOfTask type, LocalDateTime date) {
    super(name, description, type, date);
  }

  public LocalDateTime getDate() {
    return date;
  }

  @Override
  public boolean appearsIn(LocalDate dateTime) {
    return date.toLocalDate().equals(dateTime)
        || (date.toLocalDate().isBefore(ChronoLocalDate.from(dateTime)) &&
        date.toLocalDate().getDayOfMonth() == dateTime.getDayOfMonth());
  }

  @Override
  public LocalDateTime getDateTime(LocalDateTime dateTime) {
    LocalDateTime date = dateTime;
    while (date.isBefore(dateTime)) {
      date = date.plusMonths(1);
    }
    return date;
  }

  @Override
  public String getTypeRepeatability() {
    return "ежемесячная ";
  }
}
