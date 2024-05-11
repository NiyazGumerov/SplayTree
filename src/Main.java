import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
        int[] arrayOfRandomElements1 = new int[100];
        for (int i = 0; i < arrayOfRandomElements1.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
        int[] arrayOfRandomElements2 = new int[1000];
        for (int i = 0; i < arrayOfRandomElements2.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
        SplayTree tree = new SplayTree();
        double sumForTime = 0;
        double sumForCounter = 0;
        for (int x: arr) {
            long startTime = System.nanoTime();
            tree.insert(x);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            sumForTime += duration;
            sumForCounter += tree.counter;
        }
        System.out.println("Среднее время операции ДОБАВЛЕНИЕ " + (sumForTime / arr.length));
        System.out.println("Среднее количество итераций на ДОБАВЛЕНИЕ " + (sumForCounter / arr.length));
        sumForTime = 0;
        sumForCounter = 0;
        for (int x: arrayOfRandomElements1) {
            long startTime = System.nanoTime();
            tree.search(arr[x]);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            sumForTime += duration;
            sumForCounter += tree.counter;
        }
        System.out.println("Среднее время операции ПОИСКА " + (sumForTime / arrayOfRandomElements1.length));
        System.out.println("Среднее количество итераций на ПОИСКА " + (sumForCounter / arrayOfRandomElements1.length));
        sumForTime = 0;
        sumForCounter = 0;
        for (int x: arrayOfRandomElements2) {
            long startTime = System.nanoTime();
            tree.remove(arr[x]);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            sumForTime += duration;
            sumForCounter += tree.counter;
        }
        System.out.println("Среднее время операции УДАЛЕНИЕ " + (sumForTime / arrayOfRandomElements2.length));
        System.out.println("Среднее количество итераций на УДАЛЕНИЕ " + (sumForCounter / arrayOfRandomElements2.length));
    }
}
