package training.list;

import java.util.LinkedList;
import java.util.ListIterator;

public class ToDoList {

    private LinkedList<String> toDoList = new LinkedList<>();


    public void addToList(String task) {
        toDoList.add(task);
    }

    public void addToListatPosition(int position, String task) {
        toDoList.add(position, task);  //добавляет эл-т, а остальные сдвигаются
    }

    public boolean addInAlphabeticalOrder(String task) {
        ListIterator<String> listIter = toDoList.listIterator();
        while (listIter.hasNext()) {
            int compared = listIter.next().compareTo(task);
            if (compared == 0) {
                System.out.println("List already has the same task");
                return true;  //Возвращаем true чтобы при добавлении элемента сразу выйти из метода и не добавить элемент повторно через цикл
            } else if (compared > 0) {
                listIter.previous();
                listIter.add(task);
                return true;
            }
        }
        toDoList.add(task);  //Этот метод нужен вне цикла, т.к. если наш лист еще пустой, то hasNext() не найдет элементов и цикл выполяться не будет --> выполнится этот метод.
        return true;         // При этом если цикл выполнится и не добавит элементов, это значит, что наш элемент должен стоять в конце списка по алфавиту, и он добавится этим методом, стоящим вне цикла.
    }



    public void printToDoList() {
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println(i + " - " + toDoList.get(i));
        }
    }

    public void changeTask(int index, String task) {
        toDoList.set(index, task);  //заменяет эл-т под указанным индексом
    }

    public void removeTask(String task) {
        toDoList.remove(task);  //есть 2 варианта метода: удалить по индексу или удалить по содержанию(как в этом примере)
    }

    public int getTaskPriority(String task) {
        return toDoList.indexOf(task);  //возвращает индекс эл-та по его сожержанию
    }
}