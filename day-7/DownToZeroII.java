import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'downToZero' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    static class Pair {
        int number, steps;
        Pair(int number, int steps) {
            this.number = number;
            this.steps = steps;
        }
    }

    public static int downToZero(int n) {
        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new Pair(n, 0));
        visited.add(n);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int num = current.number;
            int steps = current.steps;

            if (num == 0) return steps;

            if (!visited.contains(num - 1)) {
                visited.add(num - 1);
                queue.add(new Pair(num - 1, steps + 1));
            }

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    int jump = Math.max(i, num / i);
                    if (!visited.contains(jump)) {
                        visited.add(jump);
                        queue.add(new Pair(jump, steps + 1));
                    }
                }
            }
        }

        return -1;













        // if(n==0){
        //     return 0;
        // }
        // int minMoves=downToZero(n-1);
        // for(int i=2;i*i<=n;i++){
        //     if(n%i==0){
        //         int max=Math.max(i, n/i);
        //         minMoves=Math.min(minMoves, downToZero(max));
        //     }
        // }
        // return 1+minMoves;


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
