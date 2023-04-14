package ch07_maze;

public class Maze {
	
	private static final char PATHWAY_COLOR = '0';
	private static final char WALL_COLOR = '#';
	private static final char BLOCKED_COLOR = '$';
	private static final char PATH_COLOR = '&';

	private static int N=8;
	private static char[][] maze= {
			{'0','0','0','0','0','0','0','#'},
			{'0','#','#','0','#','#','0','#'},
			{'0','0','0','#','0','0','0','#'},
			{'0','#','0','0','#','#','0','0'},
			{'0','#','#','#','0','0','#','#'},
			{'0','#','0','0','0','#','0','#'},
			{'0','0','0','#','0','0','0','#'},
			{'#','#','#','#','#','#','0','0'}
	};
	
	
	
	public static boolean findMazePath(int x, int y) 
	{
		printMaze();
		if(x<0||y<0||x>=N||y>=N) {
			//좌표의 유효한 범위 밖이면 false를 반환한다.
			return false;
		}
		else if(maze[x][y] != PATHWAY_COLOR) {
			//wall, blocked, path color의 경우에는 false를 호출한다.
			return false;
		}
		else if(x==N-1 && y==N-1) {
			//출구의 경우 (배열의 끝 of 끝)
			maze[x][y] =  PATH_COLOR;
			return true;
		}
		else {
			//일반적인 경우
			maze[x][y]=PATH_COLOR;
			if(findMazePath(x-1,y)|| findMazePath(x,y+1) || findMazePath(x+1,y) || findMazePath(x,y-1)) {
				//서 → 북 → 동 → 남 순서로 시도
				return true;
			}
			maze[x][y] = BLOCKED_COLOR; //dead end
			return false;
		}
	}
	
	public static void printMaze() {
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze[i].length;j++) {
				System.out.print(maze[i][j]+ "   ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clearScreen()
	{
		for(int i = 0; i < 30; i++)
		{
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		printMaze();
		findMazePath(0,0);
		printMaze();
	}

}
