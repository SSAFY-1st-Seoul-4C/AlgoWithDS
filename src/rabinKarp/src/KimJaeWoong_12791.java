import java.io.BufferedReader;
import java.io.InputStreamReader;


class Node
{
	String str;
	Node next = null;

	public Node(String str)
	{
		this.str = str;
	}
}

public class KimJaeWoong_12791
{
	static int Q;
	static Node[] a = new Node[2017];
	static int[] count = new int[2017];

	public static void main(String[] args) throws Exception
	{

		int[] year = { 1967, 1969, 1970, 1971, 1972, 1973, 1973, 1974, 1975, 1976, 1977, 1977, 1979, 1980, 1983, 1984,
				1987, 1993, 1995, 1997, 1999, 2002, 2003, 2013, 2016 };
		String[] s = { "DavidBowie", "SpaceOddity", "TheManWhoSoldTheWorld", "HunkyDory",
				"TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars", "AladdinSane", "PinUps", "DiamondDogs",
				"YoungAmericans", "StationToStation", "Low", "Heroes", "Lodger", "ScaryMonstersAndSuperCreeps",
				"LetsDance", "Tonight", "NeverLetMeDown", "BlackTieWhiteNoise", "1.Outside", "Earthling", "Hours",
				"Heathen", "Reality", "TheNextDay", "BlackStar" };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 25; i++)
		{
			if (a[year[i]] == null)
			{
				a[year[i]] = new Node(s[i]);
				count[year[i]]++;
			}
			else
			{
				Node tmp = a[year[i]];
				while (tmp.next != null)
				{
					tmp = tmp.next;
				}
				tmp.next = new Node(s[i]);
				count[year[i]]++;
			}
		}
		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++)
		{
			String[] temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0]);
			int to = Integer.parseInt(temp[1]);

			int cnt=0;
			for (int j = from; j <= to; j++)
			{
				cnt+=count[j];
			}
			System.out.println(cnt);
			
			for (int j = from; j <= to; j++)
			{
				if (a[j] == null) continue;
				
				Node tmp=a[j];
				
				do
				{
					System.out.println(j+" "+tmp.str);
					tmp=tmp.next;
				}while(tmp!=null);
			}
		}

	}
}