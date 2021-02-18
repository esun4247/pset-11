import java.util.ArrayList;

public class ProblemSet11 {

    public static void main(String[] args) {
    }

    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start >= end) {
            return null;
        }
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = start; i < end; i++) {
            arr.add(Integer.toString(i));
            if ((i) % 3 == 0) {
                arr.set(i-start, "Fizz");
            }
            if ((i) % 5 == 0) {
                arr.set(i-start, "Buzz");
            }
            if ((i) % 3 == 0 && (i) % 5 == 0) {
                arr.set(i-start, "FizzBuzz");
            }
        }
        return arr;
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if(numbers == null){
            return -1;
        }
        int endPoint = 0;
        int result = 0;
        for(int i = 0; i < numbers.size(); i++){
            for(int j = i + 1; j < numbers.size(); j++){
                if(numbers.get(j) == numbers.get(i)){
                    endPoint = j + 1;
                }
            }
            if(endPoint - i > result){
                result = endPoint - i;
            }
        }
        return result;
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if(numbers == null){
            return null;
        }
        if(numbers.get(numbers.size()-1) == 3){
            return null;
        }
        int threeCount = 0;
        int fourCount = 0;
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == 3){
                threeCount++;
            }
            if(numbers.get(i) == 4){
                fourCount++;
            }
            if(threeCount == 0 && fourCount > 0){
                return null;
            }
        }
        if(threeCount != fourCount){
            return null;
        }
        for(int i = 0; i < numbers.size()-1; i++){
            if(numbers.get(i) == 3 && numbers.get(i+1) == 3){
                return null;
            }
        }
        for(int i =0; i < numbers.size(); i++){
            if(numbers.get(i) == 3){
                for(int j = 0; j < numbers.size(); j++){
                    if(numbers.get(j) == 4 && j == 0){
                        numbers.set(j, numbers.get(i+1));
                        numbers.set(i+1, 4);
                        break;
                    }else if(numbers.get(j) == 4 && numbers.get(j-1) != 3){
                        numbers.set(j, numbers.get(i+1));
                        numbers.set(i+1, 4);
                        break;
                    }
                }
            }
        }
        return numbers;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if(numbers == null){
            return null;
        }
        if(numbers.get(numbers.size()-1) == 4){
            return null;
        }
        int fourCount = 0;
        int fiveCount = 0;
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == 4){
                fourCount++;
            }
            if(numbers.get(i) == 5){
                fiveCount++;
            }
        }
        if(fourCount != fiveCount){
            return null;
        }
        for(int i = 0; i < numbers.size()-1; i++){
            if(numbers.get(i) == 4 && numbers.get(i+1) == 5){
                return null;
            }
        }
        boolean firstFive = false;
        for(int i =0; i < numbers.size(); i++){
            if(numbers.get(i) == 4){
                for(int j = 0; j < numbers.size(); j++){
                    if(numbers.get(j) == 5 && j == 0){
                        numbers.set(j, numbers.get(i+1));
                        numbers.set(i+1, 5);
                        break;
                    }else if(numbers.get(j) == 5 && numbers.get(j-1) != 4){
                        numbers.set(j, numbers.get(i+1));
                        numbers.set(i+1, 5);
                        break;
                    }
                }
            }
        }
        return numbers;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if(numbers == null || numbers.size() ==0){
            return false;
        }
        for(int i = 0; i < numbers.size()-1; i++){
            int firstCount = 0;
            int lastCount = 0;
            for(int j = 0; j <= i; j++){
                firstCount += numbers.get(j);
            }
            for(int j = i+1; j< numbers.size(); j++){
                lastCount += numbers.get(j);
            }
            if(firstCount == lastCount) {
                return true;
            }
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {
        if(outer == null || inner == null || outer.size() == 0 || inner.size() == 0){
            return false;
        }
        for(int i = 0; i < outer.size() -1; i++){
            if(outer.get(i+1) < outer.get(i)){
                return false;
            }
        }
        for(int i = 0; i < inner.size() -1; i++){
            if(inner.get(i+1) < inner.get(i)){
                return false;
            }
        }
        int inPointer = 0;
        int outPointer = 0;
        int count = 0;
        while(inPointer < inner.size() && outPointer < outer.size()){
            if(inner.get(inPointer) < outer.get(outPointer)){
                inPointer++;
            }
            if(inner.get(inPointer) > outer.get(outPointer)){
                outPointer++;
            }
            if(inner.get(inPointer) == outer.get(outPointer)){
                count++;
                inPointer++;
            }
        }
        return(count == inner.size());
    }

    public ArrayList<Integer> squareUp(int n) {
        if(n < 0){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n*n; i++){
            if(i / n + 1 >= n - i % n){
                arr.add(n - i % n);
            }else{
                arr.add(0);
            }
        }
        return arr;
    }

    public ArrayList<Integer> seriesUp(int n) {
        if(n < 0){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int count = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                arr.add(j+1);
                count++;
            }
        }
        return arr;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if(numbers == null){
            return -1;
        }
        if(numbers.size()==0){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < numbers.size(); i++){
            for(int j = i; j < numbers.size(); j++){
                ArrayList<Integer> arr = new ArrayList<Integer>();
                for(int k = j; k >= i; k--){
                    arr.add(j-k, numbers.get(k));
                }
                int countMirrored = 0;
                for(int k = 0; k < numbers.size(); k++){
                    if(countMirrored < arr.size() && numbers.get(k) == arr.get(countMirrored)){
                        countMirrored++;
                    }else{
                        countMirrored=0;
                    }
                }
                if(countMirrored == arr.size() && countMirrored > max){
                    max=countMirrored;
                }
            }
        }
        return max;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if(numbers == null){
            return -1;
        }
        int count = 0;
        int size = 0;
        for(int i = 0; i < numbers.size() -1; i++){
            if(numbers.get(i) == numbers.get(i+1)){
                size++;
            }else if(size > 0){
                count++;
                size = 0;
            }
        }
        if(size > 0){
            count++;
        }
        return count;
    }
}
