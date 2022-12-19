import static diary.TypeOfTask.PERSONAL_TASK;
import static diary.TypeOfTask.WORK_TASK;

import diary.Diary;
import diary.TypeOfTask;
import diary.tasks.DailyTask;
import diary.tasks.MonthlyTask;
import diary.tasks.SingleTask;
import diary.tasks.Task;
import diary.tasks.WeeklyTask;
import diary.tasks.YearlyTask;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

  private static final Diary diary = new Diary();
  private static Task task;
  public static final DateTimeFormatter D_T_FORMAT = DateTimeFormatter.ofPattern(
      "yyyy.MM.dd','HH:mm");

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      label:
      while (true) {
        printMenu();
        System.out.print("Выберите пункт меню: ");
        if (scanner.hasNextInt()) {
          int menu = scanner.nextInt();
          switch (menu) {
            case 1:
              inputTask(scanner);
              break;
            case 2:
              // todo: обрабатываем пункт меню 2
              break;
            case 3:
              // todo: обрабатываем пункт меню 3
              break;
            case 0:
              break label;
          }
        } else {
          scanner.next();
          System.out.println("Выберите пункт меню из списка!");
        }
      }
    }
    System.out.println(diary);
  }

  private static void inputTask(Scanner scanner) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите название задачи: ");
    String taskName = sc.nextLine();
    System.out.println("Введите описание задачи: ");
    String description = sc.nextLine();
    System.out.println("Введите, задача \"Личная\" или \"Рабочая\"?");
    TypeOfTask typeOfTask;
    if (scanner.next().trim().equalsIgnoreCase("Личная")) {
      typeOfTask = PERSONAL_TASK;
    } else {
      typeOfTask = WORK_TASK;
    }
    LocalDateTime dateTime;
    System.out.println("Введите дату и время задачи (ГГГГ.ММ.ДД,ЧЧ:00):");
    dateTime = LocalDateTime.parse(scanner.next(), D_T_FORMAT);
    System.out.println(
        "Это однократная, ежедневная, еженедельная, ежемесячная, ежегодная задача?");
    switch (scanner.next()) {
      case "однократная":
        task = new SingleTask(taskName, description, typeOfTask, dateTime);
        break;
      case "ежедневная":
        task = new DailyTask(taskName, description, typeOfTask, dateTime);
        break;
      case "еженедельная":
        task = new WeeklyTask(taskName, description, typeOfTask, dateTime);
        break;
      case "ежемесячная":
        task = new MonthlyTask(taskName, description, typeOfTask, dateTime);
        break;
      case "ежегодная":
        task = new YearlyTask(taskName, description, typeOfTask, dateTime);
        break;
    }
    if (diary.addMapTask(task)) {
      System.out.println("Задача успешно добавлена!");
      return;
    }
    throw new RuntimeException("Задача не добавлена");
  }

  private static void printMenu() {
    System.out.println(
        "1. Добавить задачу \n2. Удалить задачу \n3. Получить задачу на указанный день \n0. Выход ");
  }
}
