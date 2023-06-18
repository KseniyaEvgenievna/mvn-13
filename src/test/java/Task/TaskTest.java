package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTask1() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertTrue(simpleTask.matches("родителям"));
        Assertions.assertFalse(simpleTask.matches("бабушке"));
        Assertions.assertTrue(simpleTask.matches("Позвонить родителям"));
        Assertions.assertFalse(simpleTask.matches("бабушке"));
    }

    @Test
    public void testTMeeting1() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Assertions.assertTrue(meeting.matches("Выкатка"));
        Assertions.assertFalse(meeting.matches("Выкатку"));
        Assertions.assertTrue(meeting.matches("НетоБанка"));
        Assertions.assertTrue(meeting.matches("НетоБанк"));
        Assertions.assertFalse(meeting.matches("вторник"));
    }

    @Test
    public void testEpic1() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Epic epicEmpty = new Epic(55, new String[]{});

        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertFalse(epic.matches("молоко"));
        Assertions.assertTrue(epic.matches("Молок"));
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertFalse(epic.matches("яйца"));
        Assertions.assertFalse(epic.matches("хлеб"));
        Assertions.assertTrue(epic.matches("Хлеб"));
    }
}

