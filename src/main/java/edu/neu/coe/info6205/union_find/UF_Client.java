package edu.neu.coe.info6205.union_find;

import java.util.ArrayList;
import java.util.Random;

public class UF_Client {

    static int count(int n){
        UF_HWQUPC uf = new UF_HWQUPC(n);
        int count = 0;
        Random random = new Random();
        while(uf.components() > 1){
            int i = random.nextInt(n);
            int j = random.nextInt(n);
            count++;
            if(!uf.isConnected(i,j)){
                uf.union(i,j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(500);
        arrayList.add(1000);
        arrayList.add(5000);
        arrayList.add(10000);
        arrayList.add(30000);
        arrayList.add(50000);
        arrayList.add(70000);
        arrayList.add(100000);
        arrayList.add(300000);
        arrayList.add(500000);
        arrayList.forEach(n->{
            System.out.println(count(n));
        });
    }
}
