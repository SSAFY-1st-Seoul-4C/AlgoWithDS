import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

class Node
{
	String str;
	Node next = null;

	public Node(String str)
	{
		this.str = str;
	}
}

public class KimJaeWoong_7785
{
	static int N;
	static String name, action;
	static final int MOD = 1000007;
	static Node[] a = new Node[MOD];
	static LinkedList<String> res = new LinkedList<>();

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++)
		{
			String[] temp = br.readLine().split(" ");
			name = temp[0];
			action = temp[1];
			int res = rabinFingerprint(name);

			if (action.equals("enter"))
			{
				if (a[res] == null) a[res] = new Node(name);
				else
				{
					Node tmp = a[res];
					while (true)
					{
						if (tmp.next == null)
						{
							tmp.next = new Node(name);
							break;
						}
						else tmp = tmp.next;
					}
				}
			}
			else // delete
			{
				if (a[res] == null) continue;
				Node tmp = a[res];
				if (tmp.str.equals(name))
				{
					a[res]=a[res].next;
					continue;
				}

				while (tmp.next!=null)
				{
					if(tmp.next.str.equals(name))
					{
						Node prev =tmp.next;
						tmp.next =prev.next;
						break;
					}
					else tmp=tmp.next;
				}
			}
		}

		for (int i = 0; i < MOD; i++)
		{
			if (a[i] != null)
			{
				Node tmp = a[i];
				do
				{
					res.addLast(tmp.str);
					tmp = tmp.next;
				} while (tmp != null);
			}
		}

		Collections.sort(res);
		Collections.reverse(res);
		for (String s : res)
		{
			System.out.println(s);
		}

	}

	public static int rabinFingerprint(String str)
	{
		int ret = 0;

		for (int i = 0; i < str.length(); i++)
		{
			ret = (ret * 2 + str.charAt(i)) % MOD;
			if (ret < 0) ret += MOD;
		}
		return ret;
	}
}