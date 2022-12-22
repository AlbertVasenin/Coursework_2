package diary;

import diary.tasks.DailyTask;
import diary.tasks.MonthlyTask;
import diary.tasks.SingleTask;
import diary.tasks.Task;
import diary.tasks.WeeklyTask;
import diary.tasks.YearlyTask;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class Diary {
  Map<Integer, Task> tasksForDay = new HashMap<>();
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

  public void getTaskForDay(LocalDate date) {
    for (Entry<Integer, Task> integerTaskEntry : tasks.entrySet()) {
      if (integerTaskEntry.getValue().appearsIn(date)) {
        System.out.println(integerTaskEntry.getKey() + " " + integerTaskEntry.getValue());
      }
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
    return Objects.equals(tasksForDay, diary.tasksForDay) && Objects.equals(tasks,
        diary.tasks) && Objects.equals(task, diary.task);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tasksForDay, tasks, task);
  }

  @Override
  public String toString() {
    return "" + tasks;
  }
}
