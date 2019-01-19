package BT1;



class Node
{int info;
 Node next;
 Node() {}
 Node(int x, Node p) {info=x;next=p;}
 Node(int x) {this(x,null);}
}
class MyList

{
	Node head, tail;
 MyList() {head=tail=null;}
 boolean isEmpty() {return(head==null);}
 void clear() {head=tail=null;}
 //
 void addToHead(int el) {
	 
		head = new Node(el, head);
		if(tail == null)
			tail = head;	 
 }
 //
 public void addToTail(int el) {
	if(!isEmpty()) {
		tail.next =  new Node(el);
		tail = tail.next;
	}
	else head= tail = new Node(el);
}
 //
 public int deleteFromHead(int el) {
		if (isEmpty())
			
		 el = head.info ;
		if ( head== tail)
			head = tail = null;
		else head=head.next;
		return el;
	}
 //
 public int deleteFromTail(int el) {
		if (isEmpty())
		 el = tail.info;
		if ( head== tail)
			head = tail = null;
		else {
			Node tmp;
			for (tmp= head; tmp.next != tail; tmp=tmp.next);
			tail =  tmp;
			tail.next = null;
		}
		return el;
	}
 //
 public int deleteAfter(Node p) {
		Node tmp= head;
		int inf=0;
		while (tmp!=null) {
			if (tmp.next==p.next) {
				inf=(int) p.next.info;
				tmp.next = tmp.next.next;
			}
			tmp = tmp.next ;
	  }
		return inf;
	}
 //
 public void count() {
		Node tmp = head.next;
		int chieudai = 1;
		while (tmp!= null) {
			chieudai++;
			tmp=tmp.next;
		}
		System.out.println("\n chieu dai la:"+chieudai +"\n");
	}
 //
 public void addBefore(Node q, int x) {
		Node p = new Node(x);
		Node tmp = head;
		while (tmp != null) {
			if (tmp.next== q) {
				p.next = tmp.next;
				tmp.next=p;
				return;
			}
			tmp = tmp.next;
		}
	}
 // 
 public void dele(Node p) {
		Node tmp = head;
		while (tmp!= null) {
			if (tmp.next == p) {
				tmp.next= tmp.next.next;
			}
			tmp=tmp.next;
		}
	}
//
 public boolean search(Node head, int x) 
 { 
      
     while (head != null) 
     { 
         if (head.info == x) 
             return true;   
         head = head.next; 
     } 
     return false;   
 } 
 //
 void delete(final int x) {
	 Node tg = head;
	 while ( tg.next != null) {
		 if (tg.next.info == x)
			 tg.next = tg.next.next;
		 tg=tg.next;
	 }
 }

 
 void addLast(int x)
  {Node q = new Node(x);
   if(isEmpty()) {head=tail=q;return;}
   tail.next=q;
   tail=q;
  }
 void addMany(int [] a)
  {for(int i=0;i<a.length;i++) addLast(a[i]);
  }
 void visit(Node p)
  {System.out.print(p.info + "  ");
  }
 
 
 void traverse()	
  {Node p = head;
   while(p!=null)
    {visit(p);
     p=p.next;
    }
  }
 
 void sort()
  {Node pi,pj; int t;
   pi=head;
   while(pi!=null)
    {pj=pi.next;
     while(pj!=null)
      {if(pj.info<pi.info)
        {t=pi.info;pi.info=pj.info;pj.info=t;
        } 
       pj=pj.next;
      }
     pi=pi.next;
    }
  }
}
public class test
{public static void main(String [] args)
  {MyList t = new MyList();
   int [] a = {7,2,5,9,8,6,3};
   
  
   t.addMany(a);
   System.out.println("Input:");
   t.traverse();
   
   t.addToHead(10);
   System.out.println("\nafter add to head:\n");
   t.traverse();
   
   t.addToTail(1);
   System.out.println("\nafter add to tail:\n");
   t.traverse();
   
   t.deleteFromHead(10);
   System.out.println("\nafter del from head:\n");
   t.traverse();
   
   t.deleteFromTail(1);
   System.out.println("\nafter del from tail:\n");
   t.traverse();
   
   t.deleteAfter(t.head);
   System.out.println("\nafter del affter:"+ "\n");
   t.traverse();
 
  t.addBefore( t.head ,2);
  System.out.println("\nadd beffore"+ "\n");
  t.traverse();
  
  t.dele(t.tail);
  System.out.println("\nafter del number:\n");
  t.traverse();
  
  t.delete(8);
  System.out.println("\n after del number 8:\n");
  t.traverse();
     
   t.sort();
   System.out.println("\nAfter sorting: \n");  
   t.traverse();
   
   t.count(); // chieu dai
   
   System.out.println("\n Search : (6)"+ t.search(t.head, 6) + "\n");
   
   System.out.println();  
   
   
   
  }
}