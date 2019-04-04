
class ParkYoonJin{

	class Node{
		String val;
		int hash;
		Node nxt=null;

		Node(String val, int hash){
			this.val = val;
			this.hash = hash;
		}
	}

	class Hash{
		Node[] table;
		int N = 1000;

		Hash(){
			table = new Node[N];
		}

		void put(String value){
			int hash = hash(value);

			int i= indexFor(hash, table.legnth);

			if(table[i]==null) table[i]=new Node(val, hash);
			else{
				Node n = table[i];
				while(n.nxt!=null) n = n.nxt;
				n.nxt = new Node(val, hash);
			}
		}

		int hash(String value){
			int h;
			return (value==null)?(h=hashCode(value) ^ (h>>16);
		}

		int hashCode(String value){
			int h = 0;
			if(h==0 && value.length>0){
				for(int i=0;i<value.length;++i) h = 31*h+value.charAt(i);
			}
			return h;
		}

		int indexFor(int hash, int length){
			return hash % length;
		}


		void remove(String value){
			int hash = hash(value);

			int i= indexFor(hash, table.legnth);

			if(table[i]!=null){
				Node prev = table[i];
				for(Node n=table[i]; n!=null; n = n.nxt){
					if(n.hash == hash) prev.nxt = n.nxt;
					prev = n;
				}
			}

		}

		boolean contains(String value){
			int hash = hash(value);

			int i= indexFor(hash, table.legnth);
			boolena isFound = false;

			if(table[i]!=null){
				Node prev = table[i];
				for(Node n=table[i]; n!=null; n = n.nxt){
					if(n.value.equals(value)) return true;
					if(n.hash == hash) prev.nxt = n.nxt;
					prev = n;
				}
			}
			return false;
		}

	}



}
