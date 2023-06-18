package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodosTest {
    @Test
    public void testWhenFewTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Хлеб");
        Task[] expected = {simpleTask, epic};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchingWithNoMatches() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить облигации"));
        todos.add(new Epic(2, new String[]{"Погулять с собакой"}));
        Task[] expected = {};
        Task[] actual = todos.search("Приготовить ужин");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void returnArrayOfTasksWhenSearchingWithOneMatch() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить облигации"));
        todos.add(new Epic(2, new String[]{"Погулять с собакой"}));
        Task[] expected = {new SimpleTask(1, "облигации")};
        Task[] actual = todos.search("облигации");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnArrayOfAllTasksWhenSearchingWithEmptyQuery() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить облигации"));
        todos.add(new Epic(2, new String[]{"Погулять с собакой"}));
        Task[] expected = {new SimpleTask(1, "Купить облигации"), new Epic(2, new String[]{"Погулять с собакой"})};
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }
}
