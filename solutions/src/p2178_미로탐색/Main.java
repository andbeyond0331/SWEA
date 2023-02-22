package p2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				maze[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		
		List<Node> paths = bfs(maze, 0, 0);
		System.out.println(paths.size());
		System.out.println(paths);
		
		
	}
	
	public static class Node{
		int x;
		int y;
		
		Node prev;
		
		Node(int x, int y, Node prev) {
			this.x = x;
			this.y = y;
			this.prev = prev;
		}
		
		@Override
		public String toString() {
			return String.format("(%d, %d)", x, y);
		}
		
	}
	
	public static List<Node> bfs(int[][] maze, int x, int y) {
		int row = maze.length;
		int col = maze[0].length;
		
		boolean[][] visited = new boolean[row][col];
		
		List<Node> paths = new LinkedList<>();
		
		Queue<Node> queue = new LinkedList<>();
		
		visited[x][y] = true;
		
		queue.offer(new Node(x, y, null));
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			
			if(node.x==5 && node.y==5) {
				
				Node s = node;
				while(s != null) {
					paths.add(0, s);
					s = s.prev;
				}
				break;
			}
			
			// 출구까지 온 게 아니면 현재 칸에서 인접한 노드를
			// 서 남 동 북 순으로 체크
			for (int i = 0; i < dy.length; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(is_path(nx, ny, maze, visited, row, col)) {
					visited[nx][ny] = true;
					queue.offer(new Node(nx, ny, node));
				}
				
			}
		}
		return paths;
		
		
		
	}
	
	public static boolean is_path(int x, int y,
									int[][] board,
									boolean[][] visited,
									int row, int col) {
		if(N==x && y==M) {
			return false;
		}
		if(x<0 || y< 0 || x > col-1 || y > row -1) {
			return false;
		}
		
		if(visited[y][x] || board[y][x] ==1) {
			return false;
		}
		
		return true;
	}
	
	
	
}
