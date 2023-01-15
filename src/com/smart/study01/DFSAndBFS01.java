package com.smart.study01;


import javafx.collections.transformation.SortedList;

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
public class DFSAndBFS01 {
    public static void main(String[] args){

        Scanner sc = new Scanner("System.in");
        int N = sc.nextInt();//정점
        int M = sc.nextInt();//간선
        int startPoint = sc.nextInt();//시작점

        int a,b;
        //방문한 지점을 기록
        Set<Integer> visitedSet= new HashSet<>();

        Set<Integer> array[] = new Set[N];

        for(int i =0;i<M;i++){
            a=sc.nextInt();
            b=sc.nextInt();
            array[a-1].add(b);


        }





    }


    public String DFSFunction(int startPoint, int vertexCount){


            //내부에서 더이상 연결지점을 찾지 못한다면 지금까지의 탐색결과를 리턴해준다.




        return null;
    }

    public String BFSFunction(){
        Queue<Integer> queue = new LinkedList<>();


        return null;
    }



}
