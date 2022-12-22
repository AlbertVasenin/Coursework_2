package diary.tasks;

import diary.Repeatability;
import diary.TypeOfTask;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task implements Repeatability {

  public YearlyTask(String name, String description, TypeOfTask type, LocalDateTime date) {
    super(name, description, type, date);
  }

  @Override
  public boolean appearsIn(LocalDate dateTime) {
    return date.toLocalDate().equals(dateTime) || date.toLocalDate().plusYears(dateTime.getYear() -
        date.toLocalDate().getYear()).equals(dateTime);
  }

  @Override
  public LocalDateTime getDateTime(LocalDateTime dateTime) {
    LocalDateTime date = dateTime;
    while (date.isBefore(dateTime)) {
      date = date.plusYears(1);
    }
    return date;
  }

  @Override
  public String getTypeRepeatability() {
    return "ежегодная ";
  }
}
