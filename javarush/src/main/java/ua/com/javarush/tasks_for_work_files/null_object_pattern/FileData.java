package ua.com.javarush.tasks_for_work_files.null_object_pattern;

public interface FileData {
    public boolean isHidden();
    public boolean isExecutable();
    public boolean isDirectory();

    public boolean isWritable();
}