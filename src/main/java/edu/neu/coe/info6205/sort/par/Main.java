package edu.neu.coe.info6205.sort.par;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int arrLength = 1000000;
        int[] array = new int[arrLength];
        int treadNumb = 8;
        ArrayList<Long> timeList = new ArrayList<>();
        for (int j = 50; j < 100; j++) {

            ParSort.cutoff = 10000 - (j*100);
            ParSort.myPool = new ForkJoinPool(treadNumb);
            System.out.println("Degree of parallelism: " + ParSort.myPool.getParallelism());
            long time;
            long startTime = System.currentTimeMillis();
            for (int t = 0; t < 10; t++) {
                for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000000);
                ParSort.sort(array, 0, array.length);
            }
            long endTime = System.currentTimeMillis();
            time = (endTime - startTime);
            timeList.add(time);


            System.out.println("cutoff：" + (ParSort.cutoff) + "\t\t10times Time:" + time + "ms");

        }
        try {
            String FileName = "./src/result" + arrLength + "-" + ParSort.myPool.getParallelism() + ".csv";
            FileOutputStream fis = new FileOutputStream(FileName);
            OutputStreamWriter isr = new OutputStreamWriter(fis);
            BufferedWriter bw = new BufferedWriter(isr);
            int j = 50;
            for (long i : timeList) {
                String content = (double) (10000 - j*100) / arrLength + "," + (double) i / 10 + "\n";
                j++;
                bw.write(content);
                bw.flush();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
