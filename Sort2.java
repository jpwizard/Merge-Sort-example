
//James Panagis


package sorting;
import java.util.*;
public class Sort2 {
public static int[] merge_sort (int[] array, int p, int r) {

//I inserted merge sort
if (p < r)
{

int m = (p+r)/2;
  

merge_sort(array, p, m);
merge_sort(array , m+1, r);
  

merge(array, p, m, r);
}


return array;
}
public static int[] merge (int[] array, int p, int q, int r) {
// inserting the second part for the arrays
       int n1 = q - p + 1;
       int n2 = r - q;

       
       int L[] = new int [n1];
       int R[] = new int [n2];

       
       for (int i=0; i<n1; ++i)
           L[i] = array[p + i];
       for (int j=0; j<n2; ++j)
           R[j] = array[q + 1+ j];


       
       int i = 0, j = 0;

       
       int k = p;
       while (i < n1 && j < n2)
       {
           if (L[i] <= R[j])
           {
               array[k] = L[i];
               i++;
           }
           else
           {
               array[k] = R[j];
               j++;
           }
           k++;
       }

       
       while (i < n1)
       {
           array[k] = L[i];
           i++;
           k++;
       }

      
       while (j < n2)
       {
           array[k] = R[j];
           j++;
           k++;
       }

return array;
}
/*
 * n: the size of the output array
 * k: the maximum value in the array
 */
public static int[] generate_random_array (int n, int k) {
List<Integer> list;
int[] array;
Random rnd;
rnd = new Random(System.currentTimeMillis());
list = new ArrayList<Integer> ();
for (int i = 1; i <= n; i++) 
list.add(new Integer(rnd.nextInt(k+1)));
Collections.shuffle(list, rnd);
array = new int[n];
for (int i = 0; i < n; i++) 
array[i] = list.get(i).intValue();
return array;
}
/*
 * n: the size of the output array
 */
public static int[] generate_random_array (int n) {
List<Integer> list;
int[] array;
list = new ArrayList<Integer> ();
for (int i = 1; i <= n; i++) 
list.add(new Integer(i));
Collections.shuffle(list, new Random(System.currentTimeMillis()));
array = new int[n];
for (int i = 0; i < n; i++) 
array[i] = list.get(i).intValue();
return array;
}
/*
 * Input: an integer array
 * Output: true if the array is acsendingly sorted, otherwise return false
 */
public static boolean check_sorted (int[] array) {
for (int i = 1; i < array.length; i++) {
if (array[i-1] > array[i])
return false;
}
return true;
}
public static void print_array (int[] array) {
for (int i = 0; i < array.length; i++)
System.out.print(array[i] + ", ");
System.out.println();
}
public static void main(String[] args) {
// TODO Auto-generated method stub
System.out.println("Merge sort starts ------------------");
for (int n = 100000; n <= 1000000; n=n+100000) {
int[] array = Sort2.generate_random_array(n);
//Sort.print_array(array);
long t1 = System.currentTimeMillis();
array = Sort2.merge_sort(array, 0, n-1);
long t2 = System.currentTimeMillis();
long t = t2 - t1;
//Sort.print_array(array);
boolean flag = Sort2.check_sorted(array);
System.out.println(n + "," + t + "," + flag);
}
System.out.println("Merge sort ends ------------------");
}
}