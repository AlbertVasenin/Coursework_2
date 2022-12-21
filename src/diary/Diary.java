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
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
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
    try {
      try {
        for (Entry<Integer, Task> integerTaskEntry : tasks.entrySet()) {
          if (integerTaskEntry != null && integerTaskEntry.getValue().getDate().toLocalDate()
              .isAfter(date)) {
            continue;
          }
          if (integerTaskEntry != null && integerTaskEntry.getValue().getClass()
              .equals(DailyTask.class)) {
            for (int i = 0; i < 10000; i++) {
              if (integerTaskEntry != null && integerTaskEntry.getValue().getDate().toLocalDate()
                  .isEqual(integerTaskEntry.getValue().getDate().toLocalDate().plusDays(i))) {
                tasksForDay.put(integerTaskEntry.getKey(), integerTaskEntry.getValue());
              }
            }
          } else if (integerTaskEntry != null && integerTaskEntry.getValue().getClass()
              .equals(WeeklyTask.class)) {
            for (int i = 0; i < 3000; i++) {
              if (date.isEqual(integerTaskEntry.getValue().getDate().toLocalDate().plusWeeks(i))) {
                tasksForDay.put(integerTaskEntry.getKey(), integerTaskEntry.getValue());
              }
            }
          } else if (integerTaskEntry != null && integerTaskEntry.getValue().getClass()
              .equals(MonthlyTask.class)) {
            for (int i = 0; i < 1000; i++) {
              if (date.isEqual(integerTaskEntry.getValue().getDate().toLocalDate().plusMonths(i))) {
                tasksForDay.put(integerTaskEntry.getKey(), integerTaskEntry.getValue());
              }
            }
          } else if (integerTaskEntry != null && integerTaskEntry.getValue().getClass()
              .equals(YearlyTask.class)) {
            for (int i = 0; i < 200; i++) {
              if (date.isEqual(integerTaskEntry.getValue().getDate().toLocalDate().plusYears(i))) {
                tasksForDay.put(integerTaskEntry.getKey(), integerTaskEntry.getValue());
              }
            }
          } else if (integerTaskEntry != null && integerTaskEntry.getValue().getClass()
              .equals(SingleTask.class)) {
            if (date.isEqual(integerTaskEntry.getValue().getDate().toLocalDate())) {
              tasksForDay.put(integerTaskEntry.getKey(), integerTaskEntry.getValue());
            }
          }
        }
        for (Entry<Integer, Task> pair : tasksForDay.entrySet()) {
          System.out.println(pair.getValue());
        }
      } catch (InputMismatchException e) {
        System.out.println("Вы ввели некорректное значение даты");
      }
    } catch (DateTimeException e) {
      System.out.println("Вы ввели некорректное значение даты");
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
