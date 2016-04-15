package EE2_Generics;

import java.util.List;

public interface Executor<T> {

    // Добавить таск на выполнение. Результат таска будет доступен через метод getValidResults().
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends T> task);

    // Добавить таск на выполнение и валидатор результата. Результат таска будет записан в ValidResults если validator.isValid вернет true для этого результата
    // Результат таска будет записан в InvalidResults если validator.isValid вернет false для этого результата
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends T> task, Validator<T> validator); //предполагалось использовать в валидаторе <? super T>
    //но мое мнение - это не принципиально.

    // Выполнить все добавленые таски
    void execute();

    // Получить валидные результаты. Бросает Эксепшн если не был вызван метод execute()
    List<T> getValidResults();

    // Получить невалидные результаты. Бросает Эксепшн если не был вызван метод execute()
    List<T> getInvalidResults();

    // Только для теста
    List<Task<? extends T>> getTasks();
}