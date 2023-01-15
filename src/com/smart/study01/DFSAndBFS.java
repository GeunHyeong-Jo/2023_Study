package com.smart.study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *Problem
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 *
 *
 * Description
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 *
 *
 * @Params
 *
 * @return
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
 * V부터 방문된 점을 순서대로 출력하면 된다.
 *
 *
 * example
 * input
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 *
 * result
 * 1 2 4 3
 * 1 2 3 4
 */
public class DFSAndBFS {

    public static int N,M,V;
    public static boolean[] visited;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String[] temp= str.split(" ");

        N=Integer.parseInt(temp[0]); // 정점
        M=Integer.parseInt(temp[1]); // 간선
        V=Integer.parseInt(temp[2]); // 시작점

        visited = new boolean[N+1]; //방문한 지점
        map= new int[N+1][N+1];

        for(int i =0; i<M;i++){
            str = bufferedReader.readLine();
            temp = str.split(" ");
            map[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])]=
                    map[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])]=1;
        }

        //display init map
//        for (int[] ints : map) {
//            for (int j = 0; j < map[0].length; j++) {
//                System.out.print(ints[j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
        DFSFunction(V);

        //reset
        visited= new boolean[N+1];
        System.out.println();
        BFSFunction(V);
    }


    public static void DFSFunction(int i){
            //내부에서 더이상 연결지점을 찾지 못한다면 지금까지의 탐색결과를 리턴해준다.
        System.out.print(i+" ");
        visited[i]=true;
        for(int j=1;j<=N;j++){
            if(map[i][j]==1 && !visited[j] ){
                DFSFunction(j);
            }
        }
    }

    public static void BFSFunction(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i]=true;
        System.out.print(i+" ");
        int size = 1; //search가 완료되었어도 계속 반복되는 현상이 발생할수 있어 추가

        while(!queue.isEmpty()&& size<N){
            int temp = queue.poll();

            for(int j=1;j<=N;j++){
                if(map[temp][j]==1 && !visited[j] ){
                    visited[j]=!visited[j];
                    queue.offer(j);
                    System.out.print(j+" ");
                    size++;
                }
            }

        }


    }
}
