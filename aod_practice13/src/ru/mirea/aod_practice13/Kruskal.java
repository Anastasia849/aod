package ru.mirea.aod_practice13;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

    public static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public String toString() {
            return this.u + " " + this.v + " " + this.weight;
        }

        // сортировка ребер будет производиться на основе веса
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nodes = scn.nextInt();
        int[][] graph = new int[nodes + 1][nodes + 1];
        int numEdges = scn.nextInt();
        Edge[] edges = new Edge[numEdges];
        for (int edge = 0; edge < numEdges; edge++) {
            int u = scn.nextInt(), v = scn.nextInt(), w = scn.nextInt();

            //  поскольку граф будет двунаправленным, то " v "будет соседом "u" и наоборот
            graph[u][v] = graph[v][u] = w;

            // добавляем ребро в массив ребер, который будет отсортирован позже
            edges[edge] = new Edge(u, v, w);
        }

        kruskalAlgorithm(nodes, numEdges, edges, graph);

    }

    public static void kruskalAlgorithm(int numVertices, int numEdges, Edge[] edges, int[][] graph) {


        // для хранения сформированного минимального остовного дерева
        int[][] mst = new int[graph.length][graph.length];
        //сортируем ребра
        Arrays.sort(edges);

        /* мы используем parents & size для создания непересекающихся множества */
        int[] parents = new int[numVertices + 1];
        int[] size = new int[numVertices + 1];
        for (int vertex = 1; vertex < graph.length; vertex++) {
            parents[vertex] = vertex;
            size[vertex] = 1;
        }

        int edgeCounter = 0;
        int edgedTaken = 1;
        /* для соединения всех вершин нам нужно иметь
         *  не менее vertices-1 ребер */
        while (edgedTaken <= numVertices - 1) {
            Edge e = edges[edgeCounter];
            edgeCounter++;
            /*
             * мы будем включать только те ребра, которые
             * не создают никакого цикла
             */
            if (isCyclic(e.u, e.v, parents))
                continue;

            union(findParent(e.u, parents), findParent(e.v, parents), parents, size);
            mst[e.u][e.v] = e.weight;
            edgedTaken++;
        }

        /* вывод минимального остовного дерева */
        for (int u = 1; u < mst.length; u++) {
            for (int v = 0; v < mst.length; v++) {
                if (mst[u][v] != 0) {
                    System.out.println(u + " " + v + " " + mst[u][v]);
                }
            }
        }

    }

    public static boolean isCyclic(int u, int v, int[] parents) {
        /*
         * если родители обеих вершин ребра
         * одинаковы, это означает, что они привязаны
         * к общей вершине, и, следовательно, если мы положим это
         * ребро в дерево, то будет цикл.
         */
        return findParent(u, parents) == findParent(v, parents);
    }

    public static void union(int u, int v, int[] parents, int[] size) {

        u = findParent(u, parents);
        v = findParent(v, parents);
        if (size[u] > size[v]) {
            parents[v] = u;
            size[u] += size[v];
        } else {
            parents[u] = v;
            size[v] += size[u];
        }
    }

    public static int findParent(int u, int[] parents) {

        if (parents[u] == u) {
            return u;
        } else {
            parents[u] = findParent(parents[u], parents);
            return parents[u];
        }
    }

}
