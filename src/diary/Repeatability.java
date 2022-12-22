package diary;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Repeatability {
  boolean appearsIn(LocalDate dateTime);
  LocalDateTime getDateTime(LocalDateTime dateTime);
}
