package ru.mirea.aod_practice15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static class a{//процесс a, элемент множества S
        private int s;//начальный момент
        private int f;//конечный момент

        public a(int s, int f) {
            this.s = s;
            this.f = f;
        }

        public int getS() {
            return s;
        }

        public int getF() {
            return f;
        }

        @Override
        public String toString() {
            return String.format("{%d;%d}",s,f);
        }
    }
    //решение задачи о выборе процессов
    //(жадный) алгоритм ищет совместимые подмножества минимального размера,чтобы
    //в итоге их было больше
    public static Object[] greedyActivitySelector(a[] S){
        int n = S.length;
        ArrayList <a> A=new ArrayList<>();
        A.add(S[0]);
        int i=0;//всегда индексирует последний элемент A
        for(int m=1; m<n;m++){
            if (S[m].getS()>=S[i].getF()){
                A.add(S[m]);
                i=m;
            }
        }
        return  A.toArray();
    }

    public static void main(String[] args) {
        a[] S={//задаем множество S
                new a(1,4),
                new a(3,5),
                new a(5,7),
                new a(0,6),
                new a(3,8),
                new a(5,9),
                new a(6,10),
                new a(8,11),
                new a(8,12),
                new a(12,14),
                new a(2,13)
        };
        //исходное множество
        System.out.println("S = "+Arrays.toString(S));
        //массив должен быть отсортирован по конечному моменту
        Arrays.sort(S, new Comparator<a>() {
            @Override
            public int compare(a o1, a o2) {
                return o1.getF()- o2.getF();
            }
        });
        //искомое множество
        System.out.println("A = "+Arrays.toString(greedyActivitySelector(S)));
    }
}
