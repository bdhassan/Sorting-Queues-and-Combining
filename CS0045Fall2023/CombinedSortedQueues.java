package CS0045Fall2023;

import java.util.Scanner;

public class CombinedSortedQueues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create two ArrayQueues to store the input integers
        ArrayQueue<Integer> queue1 = new ArrayQueue<>();
        ArrayQueue<Integer> queue2 = new ArrayQueue<>();

        // Display the prompter to enter the first set of integers and add them to queue1
        System.out.println("Enter the first set of integers (separated by spaces):");
        //Get input in string datatype
        String input1 = scanner.nextLine();
        //Get input separated by spaces
        String[] values1 = input1.split(" ");
        // for every input get values and then push it in queue1
        for (String value : values1) {
            queue1.enqueue(Integer.parseInt(value));
        }

        // Prompt the user to enter the second set of integers(in strings) and add them to queue2
        System.out.println("Enter the second set of integers (separated by spaces):");
        String input2 = scanner.nextLine();
        String[] values2 = input2.split(" ");
        for (String value : values2) {
            queue2.enqueue(Integer.parseInt(value));
        }

        // Create ALists to sort the integers from queue1 and queue2
        AList<Integer> list1 = new AList<>();
        AList<Integer> list2 = new AList<>();

        // Get one by one from queue1 to Sort into list1 (low to high)
        while (!queue1.isEmpty()) {
            Integer current = queue1.dequeue();
            int index = 1;
            while (index <= list1.getLength() && current > list1.getEntry(index)) {
                index++;
            }
            list1.add(index, current);
        }

        // Get one by one from queue2 to Sort into list2 (low to high)
        while (!queue2.isEmpty()) {
            // get the one value by dequque from queue2 and assign to current
            Integer current = queue2.dequeue();
            int index = 1;
            //nested while loop is to iterate the list(index) with current value of queue.
            while (index <= list2.getLength() && current > list2.getEntry(index)) {
                index++;
            }
            //add the (current value of queue) to the next position of index
            list2.add(index, current);
        }

        // Enqueue the sorted items from list1 back into queue1
        for (int i = 1; i <= list1.getLength(); i++) {
            queue1.enqueue(list1.getEntry(i));
        }

        // Enqueue the sorted items from list2 back into queue2
        for (int i = 1; i <= list2.getLength(); i++) {
            queue2.enqueue(list2.getEntry(i));
        }

        // Create a new sorted ArrayQueue and combine queue1 and queue2 into it
        ArrayQueue<Integer> combinedQueue = new ArrayQueue<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            Integer element1 = !queue1.isEmpty() ? queue1.getFront() : null;
            Integer element2 = !queue2.isEmpty() ? queue2.getFront() : null;

            if (element1 != null && (element2 == null || element1 <= element2)) {
                combinedQueue.enqueue(queue1.dequeue());
            } else {
                combinedQueue.enqueue(queue2.dequeue());
            }
        }

        // Print the sorted, combined ArrayQueue by dequeuing all entries
        System.out.println("Sorted, combined ArrayQueue:");
        while (!combinedQueue.isEmpty()) {
            System.out.print(combinedQueue.dequeue() + " ");
        }
    }
}
