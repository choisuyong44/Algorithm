import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 처음 : size = N*N , start = (0,0)
 *      if 0,0 좌표가 N*N의 모든 좌표랑 같은가? -> isSame(x,y);
 *          해당 좌표 종이++;
 *      else 
 *        if size == 1:
 *          해당 좌표 종이++;
 *        else :
 *          분할
 *
 * 두 번째 : size : N/2 * N/2, start = (0,0), (0,N/2), (N/2,0), (N/2,N/2)
 * ...
 *  */

public class Main {
    static int N;
    static int[][] map;
    static int white, blue;
    public static void main(String[] args) throws IOException {
        input();
        recursion(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void recursion(int r, int c, int size){
        if(isSame(r,c,size)){
            if(map[r][c]==1) blue++;
            else white++;
        }
        else{
            if(size==1) {
                if(map[r][c]==1) blue++;
                else white++;
            }
            else {
                recursion(r,c,size/2);                         // 0,0, N/2
                recursion(r,c+size/2,size/2);               // 0, N/2, N/2
                recursion(r+size/2,c,size/2);               // N/2, 0, N/2
                recursion(r+size/2,c+size/2,size/2);     // N/2, N/2, N/2
            }
        }
    }
    
    static boolean isSame(int r,int c, int size){
        for(int i =r;i<size+r;i++){
            for(int j =c;j<size+c;j++){
                if(map[i][j] != map[r][c]) return false;
            }
        }
        return true;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        white = blue =0;
    }
}