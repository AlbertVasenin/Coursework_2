package diary.tasks;

import diary.Repeatability;
import diary.TypeOfTask;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class WeeklyTask extends Task implements Repeatability {

  public WeeklyTask(String name, String description, TypeOfTask type, LocalDateTime date) {
    super(name, description, type, date);
  }

  @Override
  public boolean appearsIn(LocalDate dateTime) {
    return date.toLocalDate().equals(dateTime) || (date.toLocalDate().isBefore(
        ChronoLocalDate.from(dateTime)) &&
        date.toLocalDate().getDayOfWeek().equals(dateTime.getDayOfWeek()));
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
    return "еженедельная ";
  }

}
