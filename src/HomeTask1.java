/**
 * Created by IntelliJ IDEA.
 * User: Oleg
 * Date: 25.11.13
 * Time: 8:13
 * To change this template use File | Settings | File Templates.
 */
import java.util.Scanner;
public class HomeTask1 {
    public static void main(String[] args) {
        System.out.println("Choose number of task.\n 1. Adding arrays. \n 2. Merge without duplicates. \n 3. Inner Join. \n 4. Outer Join.");
        Scanner readLine = new Scanner(System.in);
        switch (readLine.nextInt()){
            case 1: Task1(); break;
            case 2: Task2(); break;
            case 3: Task3(); break;
            case 4: Task4(); break;
            default: System.out.println("Task does not exist!");
        }
    }
    public static int [] AddingArray(int [] array1, int [] array2)
    {
        int k=array1.length+array2.length;
        int [] result1=new int[k];
        for(int i=0; i< array1.length;i++)
            result1[i]= array1[i];
        for(int j =0; j<array2.length; j++)
            result1[array1.length+j]= array2[j];
        return result1;
    }
    public static void printElements( int [] array){
        for (int i=0; i<array.length;i++)
            System.out.print("Elements: "+array[i]+" \n");
    }
    public static int [] MergeArrays(int [] arr1, int [] arr2){
        int [] rez = new int [arr1.length+arr2.length];

        for(int i=0; i<arr1.length;i++)
            rez[i]=arr1[i];
        int index=arr1.length;
        for(int i=0; i<arr2.length; i++)
            for(int j=0; j<arr1.length;j++)
                if(arr2[i]!=arr1[j] && j==arr1.length-1){
                    rez[index]=arr2[i];
                    index++;
                } else if(arr1[j]==arr2[i]) break;
        return removeNullElements(rez, index);
    }
    public static int [] InnerJoin(int [] arr1, int [] arr2){
        int [] rez=new int[arr1.length];
        int index=0;
        for (int i=0; i<arr1.length; i++)
            for (int j=0; j<arr2.length; j++)
                if (arr1[i]==arr2[j]){
                    rez[index] = arr1[i];
                    index++;
                    break;
                }
        return removeNullElements(rez, index);
    }
    public static int [] OuterJoin(int [] arr1, int [] arr2){
        int [] res = new int[arr1.length+arr2.length];
        int index=0;
        for (int i=0; i<arr1.length;i++)
            for (int j=0; j< arr2.length; j++)
                if (arr1[i]!=arr2[j] && j==arr2.length-1){
                    res[index]=arr1[i];
                    index++;
                } else if (arr1[i]==arr2[j]) break;
        for (int i=0; i<arr2.length; i++)
            for (int j=0; j<arr1.length; j++)
                if (arr2[i]!=arr1[j] && j==arr1.length-1){
                    res[index]=arr2[i];
                    index++;
                } else if(arr1[j]==arr2[i]) break;
        return removeNullElements(res, index);
    }
    public static int [] removeNullElements(int [] arr, int countOfElements){
        int [] rez = new int [countOfElements];
        for (int i=0; i<countOfElements; i++)
            rez[i] = arr[i];
        return rez;
    }
    public static void Task1(){
        int [] array1_1, array1_2;
        array1_1 = new int[]{1,10,8};
        array1_2 = new int[]{2,5,6,3};
        int [] result = AddingArray(array1_1, array1_2);
        printElements(result);
    }
    public static void Task2(){
        int [] array2_1, array2_2;
        array2_1=new int[]{1,5,4,23,65,32,78};
        array2_2=new int[]{3,5,24,54,1,2,34,45,32};
        int [] result = MergeArrays(array2_1, array2_2);
        printElements(result);
    }
    public static void Task3(){
        int [] array3_1, array3_2;
        array3_1 = new int[]{1,5,4,23,65,32,78};
        array3_2 = new int[]{3,5,24,4,1,2,32,45,32,5};
        int [] result = InnerJoin(array3_1,array3_2);
        printElements(result);
    }
    public static void Task4(){
        int [] array4_1, array4_2;
        array4_1 = new int[]{1,5,4,23,65,32,78};
        array4_2 = new int[]{3,5,24,4,1,2,34,45,32,5};
        int [] result = OuterJoin(array4_1, array4_2);
        printElements(result);
    }
}