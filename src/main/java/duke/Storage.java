package duke;

import duke.task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Storage {
    private final String filePath;
    private final File file;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        }catch(IOException e){
            UI.printError(e);
        }
    }


    public TaskList readList() {
        TaskList list = new TaskList();
        try {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                String[] arr = s.nextLine().split(" \\| ", 4);
                String taskType = arr[0];
                switch (taskType) {
                    case "T":
                        Task t = new Todo(arr[2]);
                        if (arr[1].equals("1")) {
                            t.markComplete();
                        }
                        list.addTask(t);
                        break;
                    case "D":
                        Task d = new Deadline(arr[2], LocalDateTime.parse(arr[3]
                                , DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                        if (arr[1].equals("1")) {
                            d.markComplete();
                        }
                        list.addTask(d);
                        break;
                    case "E":
                        Task e = new Event(arr[2], LocalDateTime.parse(arr[3]
                                , DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                        if (arr[1].equals("1")) {
                            e.markComplete();
                        }
                        list.addTask(e);
                        break;
                    default:
                        break;
                }
            }
        } catch(IOException e) {
            UI.printError(e);
        }
        return list;
    }

    public void writeList(TaskList list) {
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(list.toStorageString());
            fw.close();
        } catch(IOException e){
            UI.printError(e);
        }
    }
}