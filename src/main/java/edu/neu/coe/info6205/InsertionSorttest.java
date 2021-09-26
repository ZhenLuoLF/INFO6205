package edu.neu.coe.info6205;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class InsertionSorttest {

    public static void main(String[] args) {
        int n = 100;
        for (int i  = 0; i < 5; i++){
            System.out.println("The" + i + "lap:");
            List<Integer> list = new ArrayList<>();
            Random rand = new Random();
            int upperbound = 1000;
            //generate random values from 0-1000
            for (int j = 0; j < n; j++) {
                list.add(rand.nextInt(upperbound));
            }

            Integer[] randomArray = list.toArray(new Integer[0]);
            Benchmark<Integer> Benchimark_random = new Benchmark_Timer<>("Testforinsertionsort", input -> {
                InsertionSort.sort(randomArray);
            });

            Collections.sort(list);
            Integer[] orderdArray = list.toArray(new Integer[0]);
            Benchmark<Integer> Benchimark_ordered = new Benchmark_Timer<>("Testforinsertionsort", input -> {
                InsertionSort.sort(orderdArray);
            });

            Collections.reverse(list);
            Integer[] reversArray = list.toArray(new Integer[0]);
            Benchmark<Integer> Benchimark_reversOrdered = new Benchmark_Timer<>("Testforinsertionsort", input -> {
                InsertionSort.sort(reversArray);
            });

            list.clear();
            for(int j = 0; j < n/2;j++){
                list.add(j);
            }
            for(int j = n/2; j < n; j++){
                list.add(rand.nextInt(upperbound));
            }
            Integer[] partOrArr = list.toArray(new Integer[0]);
            Benchmark<Integer> Benchimark_partordered = new Benchmark_Timer<>("Testforinsertionsort", input -> {
                InsertionSort.sort(partOrArr);
            });

            double time_random = Benchimark_random.run(0, 1000);
            double time_ordere = Benchimark_ordered.run(0, 1000);
            double time_revers = Benchimark_reversOrdered.run(0, 1000);
            double time_partOrder = Benchimark_partordered.run(0, 1000);
            System.out.println("Time of random:" + time_random);
            System.out.println("Time of ordered:" + time_ordere);
            System.out.println("Time of revers:" + time_revers);
            System.out.println("Time of partOrder:" + time_partOrder);
            n = n * 2;
        }
    }
}
