package diary;

import java.time.LocalDate;

public interface Repeatability {

  boolean appearsIn(LocalDate dateTime);
}
