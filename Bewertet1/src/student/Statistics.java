package student;

public class Statistics{

    public static int min(int [] array)
    {

        int min = 0;
        if(array.length == 0) {
            System.out.println("Leeres Array!");
        }else{
            min = array[0];
        }

        for(int i = 1; i < array.length; i++)
        {

            if(array[i] < min){
                min = array[i];
            }

        }

        return min;
    }


    public static int max(int [] array)
    {

        int max = 0;
        if(array.length == 0)
        {
            System.out.println("Leeres Array!");
        }else{
            max = array[0];
        }

        for(int i = 1; i < array.length; i++)
        {

            if(array[i] > max)
            {
                max = array[i];
            }

        }

        return max;
    }


    public static double mean(int [] array)
    {
        double mean = 0;

        for (int j : array) {
            mean += j;
        }
        return mean/array.length;
    }


    public static double stddev(int [] array)
    {

        double stddev;
        double store = 0;
        double mean = mean(array);

        for (int j : array) {
            store = store + Math.pow((j - mean), 2);
        }

        stddev = Math.sqrt(store/array.length);
        return stddev;

    }

}