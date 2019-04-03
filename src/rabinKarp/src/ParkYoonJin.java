import java.util.Scanner;


public class ParkYoonJin {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine();
		String P = sc.nextLine();

		int sizeP = P.length();
		int N = (int)1e7+7; //10e7+9 , 10e9+7 , 898765231

		int p=11;
		//결과
		StringBuffer sb=new StringBuffer();
		int cnt=0;

		if(sizeP> T.length()) {
			System.out.println(cnt);
			return;
		}
		
		int mul=1;
		for(int i=0;i<sizeP;++i) {
			mul *= p;
			mul = mul%N;
		}

		int hashP=0; 
		int prevH=0; 
		for(int j=0;j<sizeP;++j) {
			hashP = (hashP*p+P.charAt(j))%N;
		}

		for(int i=0;i<T.length()-sizeP+1;++i) {
			int val=0;
			if(i==0) {
				for(int j=0;j<sizeP;++j) {
					val = (val*p+T.charAt(j))%N;
				}
			}else {
				val = (int) ((p*prevH)-(T.charAt(i-1)*mul)+T.charAt(i+sizeP-1))%N;
				if(val<0) val= val+N;
			}

			if(hashP==val) {
				cnt+=1;
				sb.append(i+1).append(" ");
			}
			prevH = val;
		}
		
		System.out.println(cnt);
		System.out.println(sb.toString());
		
		sc.close();
			

	}

}

