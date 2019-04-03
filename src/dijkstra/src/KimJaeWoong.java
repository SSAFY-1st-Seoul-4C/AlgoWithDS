import java.io.IOException;
import java.util.Arrays;

public class dijkstra
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		int N =100;
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];

		int[] distance = new int[N]; 

		Arrays.fill(distance, Integer.MAX_VALUE/N);
		distance[0] = 0;

		int min;
		int current = 0; 
		for (int i = 0; i < N; i++)
		{
			min =Integer.MAX_VALUE/N;
			for (int j = 0; j < N; j++) //이부분을 이제 힙으로처리 -> PrioriryQueue
			{
				if (!visited[j] && distance[j] < min)
				{
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			if (current == N-1) break;

			for (int j = 0; j < N; j++)
			{
				if (!visited[j] && adjMatrix[current][j] != 0 && min + adjMatrix[current][j] < distance[j])
				{
					distance[j] = min + adjMatrix[current][j];
				}
			}
		}
	}

}
