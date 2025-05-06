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
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        // long max=Integer.MIN_VALUE;
        // long arr[]=new long[n+1];
        // for(List<Integer> query:queries){
        //     int startIdx=query.get(0);
        //     int endIdx=query.get(1);
        //     int k=query.get(2);

        //     for(int i=startIdx;i<=endIdx;i++){
        //         arr[i]+=k;
        //     }
        // }
        // for(long res:arr){
        //     max=Math.max(res, max);
        // }
        // return max;



        //optimized-prefix sum
        long arr[]=new long[n+2];
        for(List<Integer>query:queries){
            int startIdx=query.get(0);
            int endIdx=query.get(1);
            int k=query.get(2);

            arr[startIdx]+=k;
            arr[endIdx+1]-=k;
        }
        long sum=0,max=0;
        for(int i=1;i<=n;i++){
            sum+=arr[i];
            max=Math.max(sum, max);
        }
        return max;
    }

}

public class CrushProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
