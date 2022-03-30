package bioinformatic.labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* https://rosalind.info/problems/perm/ */
public class PERM {
    private List<List<Integer>> acc;

    public List<List<Integer>> solution(int n) {
        acc = new ArrayList<>();
        List<Integer> list = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
        permute(list, 0);
        return acc;
    }

    private void permute(List<Integer> arr, int k) {
        for(int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            acc.add(new ArrayList<>(arr));
        }
    }
}
