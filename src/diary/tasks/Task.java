package diary.tasks;

import diary.TypeOfTask;
import java.time.LocalDateTime;

public abstract class Task {

  private final String name;
  private final String description;
  private final TypeOfTask type;
  private final int id;
  private static int counter = 0;
  protected final LocalDateTime date;

  public Task(String name, String description, TypeOfTask type, LocalDateTime date) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.date = date;
    counter++;
    this.id = counter;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public TypeOfTask getType() {
    return type;
  }

  public int getId() {
    return id;
  }

  public abstract String getTypeRepeatability();

  @Override
  public String toString() {
    return "\"" + name + "\"" +
        ", необходимо " + description +
        ". " + type + ", дата выполнения: " + date +
        ", уникальный id задачи в списке: " + id;
  }

}
