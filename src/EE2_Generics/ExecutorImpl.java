package EE2_Generics;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<T> implements Executor<T> {
    private List<Task<? extends T>> tasks;

    private ArrayList<T> validResults;
    private ArrayList<T> invalidResults;

    boolean isExecuteActivate;

    {
        tasks = new ArrayList<>();
        validResults = new ArrayList<>();
        invalidResults = new ArrayList<>();
    }

    @Override
    public void addTask(Task<? extends T> task) {
        try {
            if (isExecuteActivate) {
                throw new Exception("[ERROR]: Method execute() was activated!");
            }
            tasks.add(task);
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<T> validator) {
        try {
            if (isExecuteActivate) {
                throw new Exception("[ERROR]: Method execute() was activated!");
            }
            task.execute();
            if (validator.isValid(task.getResult())) {
                validResults.add(task.getValue());
            } else {
                invalidResults.add(task.getValue());
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    @Override
    public void execute() {
        Validator<Number> validator = new NumberValidator();
        for (Task<? extends T> task : tasks) {
            task.execute();
            if (validator.isValid((Number) task.getResult())) {
                validResults.add(task.getValue());
            } else {
                invalidResults.add(task.getValue());
            }
        }
        isExecuteActivate = true;
    }

    @Override
    public List<T> getValidResults() {
        try {
            if (isExecuteActivate) {
                return validResults;
            } else {
                throw new Exception("[ERROR]: Method execute() does not activate!");
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
        return null;
    }

    @Override
    public List<T> getInvalidResults() {
        try {
            if (isExecuteActivate) {
                return invalidResults;
            } else {
                throw new Exception("[ERROR]: Method execute() does not activate!");
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
        return null;
    }

    public List<Task<? extends T>> getTasks() {
        return tasks;
    }
}