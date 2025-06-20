
import java.util.*;

/**
 * SortedStack reads integers from standard input, stores them in a {@link java.util.Stack},
 * and keeps the stack sorted in ascending order.
 *
 * <p>This class is a maintenance update of <code>SortedList</code> from Project #4.
 * The original program relied on {@link java.util.LinkedList}; only the underlying
 * data structure and the sorting logic have been adapted—everything else stays
 * intact to maximise code‑reuse.</p>
 *
 * <p><b>Author:</b> Marisa Lavoratore<br>
 * <b>Updated:</b> June 9, 2025</p>
 */
public class SortedStack {

    /**
     * Runs the program:
     * 1. Reads integers from the user until “done” is entered.
     * 2. Sorts them in ascending order.
     * 3. Pushes them onto a {@link java.util.Stack}.
     * 4. Prints the stack contents (smallest → largest).
     *
     * @param args not used
     */
    public static void main(String[] args) {

        // --- Step 1 & 2: Read & collect the numbers -------------------------
        Scanner scanner = new Scanner(System.in);
        List<Integer> buffer = new ArrayList<>();

        System.out.println("Enter integers (type 'done' to finish):");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                buffer.add(scanner.nextInt());
            } else {
                String token = scanner.next();
                if ("done".equalsIgnoreCase(token)) {
                    break;
                } else {
                    System.out.printf("Ignored invalid token: %s%n", token);
                }
            }
        }

        // Sort the buffer so we can push in ascending order
        Collections.sort(buffer);

        // --- Step 3: Transfer into a Stack in ascending order ---------------
        Stack<Integer> numbers = new Stack<>();
        for (int num : buffer) {
            numbers.push(num);          // ensures bottom→top = smallest→largest
        }

        // --- Step 4: Display the result -------------------------------------
        System.out.println("\nSorted Stack (bottom→top = smallest→largest):");
        System.out.println(numbers);

        scanner.close();
    }
}
