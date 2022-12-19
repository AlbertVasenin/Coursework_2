package diary;

import diary.tasks.Task;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Diary {

  private final Map<Integer, Task> tasks;
  private Task task;

  public Diary() {
    this.tasks = new HashMap<>();
  }

  public boolean addMapTask(Task task) {
    return tasks.put(task.getId(), task) == null;
  }

  public void removeMapTask(int id) {
    if (getTasks().containsKey(id)) {
      tasks.remove(id);
    }
  }

  public Map<Integer, Task> getTasks() {
    return tasks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Diary diary = (Diary) o;
    return Objects.equals(tasks, diary.tasks) && Objects.equals(task, diary.task);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tasks, task);
  }

  @Override
  public String toString() {
    return "" + tasks;
  }
}
