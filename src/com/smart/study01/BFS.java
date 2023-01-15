package com.smart.study01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem
 * N×M크기의 배열로 표현되는 미로가 있다.
 * <p>
 *  1	0	1	1	1	1
 *  1	0	1	0	1	0
 *  1	0	1	0	1	1
 *  1	1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때,
 * (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * <p>
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 * <p>
 * <p>
 * Params
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 * <p>
 * Result
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 * <p>
 * Example
 * input
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 * <p>
 * result
 * 15
 */
public class BFS {

    static int[] dx = { 1, -1, 0, 0};//2차원 좌표상에서 x축으로의 움직임을 설정
    static int[] dy = { 0, 0, 1, -1};//2차원 좌표상에서 y축으로의 움직임을 설정
    static int N,M;
    static boolean[][] visited;
    static int[][] map;

    static int moveCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        N= Integer.parseInt(str.split(" ")[0]);
        M= Integer.parseInt(str.split(" ")[1]);
        map =new int [N][M];
        visited = new boolean[N][M];
        visited [0][0]=true;

        //read map
        for(int i=0; i<N; i++){
            str=br.readLine();
            //System.out.println(str);
            for(int j=0;j<M;j++){
                //System.out.println("char at : "+str.charAt(j));
                map[i][j]= str.charAt(j)-'0';//문자로 되어있어 문자 '0'을 빼면 원하는 integer 값을 얻을 수 있음
            }
        }
        br.close();

        /* display init map
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        */

        bfsFunction(0,0);

        /* display result map
        System.out.println("final : "+ map[N-1][M-1]);
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        */
        System.out.println(map[N-1][M-1]);
    }
        public static void bfsFunction(int i, int j){
            Queue<Coordinate> queue = new LinkedList<>();
            queue.add(new Coordinate(i,j));

            while(!queue.isEmpty()){
                Coordinate now =queue.poll();
                int x = now.x;
                int y = now.y;

                for(int k=0; k<4 ; k++){
                    Coordinate next = new Coordinate(now.x + dx[k], now.y + dy[k]);

                    //길이 아니거나 도달할 수 없는 좌표일 경우에는 넘어간다
                    if(next.x<0 || next.y<0 ||
                            next.x>=N || next.y>=M ||
                            visited[next.x][next.y] ||
                            map[next.x][next.y] == 0){
                        continue;
                    }

                    queue.add(next);
                    map[next.x][next.y]=map[now.x][now.y]+1;//지나온 길에 경로를 표시
                    visited[next.x][next.y]=true;
                }
                moveCount++;
            }
        }

    /**
     * Description
     * 좌표점을 쉽게 표현하기 위해 클래스로 선언
     */
    public static class Coordinate{
            int x;
            int y;
            Coordinate(int x, int y){
                this.x =x;
                this.y =y;
            }
        }

}