package Duke;

import java.util.Scanner;

import Duke.exception.DukeException;
import Duke.task.TaskList;
import Duke.task.Task;

public class UI {
    protected static String greetingText = "Hello! I'm Duke\nWhat can I do for you?\n";
    protected static String byeText = "Bye. Hope to see you again soon!";

    protected static Scanner scanner = new Scanner(System.in);

    private static String formatWithSpace(String text){
        return "\n" + text + "\n";
    }

    public static void printGreeting(){
        System.out.println(greetingText);
    }

    public static void printBye(){
        System.out.println(byeText);
    }

    public static void printList(TaskList list){
        StringBuilder s = new StringBuilder();
        s.append("Here are the tasks in your list:");
        for(int i = 1; i <= list.getTaskAmount();i++){
            s.append("\n").append(i).append(".").append(list.getTask(i));
        }
        System.out.println(formatWithSpace(s.toString()));
    }

    public static String listTaskAmount(int count){
        return("\nNow you have " + count + " task(s) in the list.");
    }

    public static void printTaskAdded(TaskList list){
        int taskAmount = list.getTaskAmount();
        System.out.println(
                formatWithSpace("Got it. I've added this task:\n"
                        + list.getTask(taskAmount)
                        + listTaskAmount(taskAmount)
                )
        );

    }

    public static void printTaskDone(Task task){
        System.out.println(formatWithSpace("Nice! I've marked this task as done:\n " + task));
    }

    public static void printTaskDeleted(Task task,TaskList list){
        System.out.println(
                formatWithSpace("Ok, I have removed the following task:\n "
                    + task
                    + listTaskAmount(list.getTaskAmount())));

    }

    public static String getUserInput(){
        String input = scanner.nextLine();
        return input;
    }

    public static void printError(DukeException e){
        System.out.println(formatWithSpace(e.getMessage()));
    }

}