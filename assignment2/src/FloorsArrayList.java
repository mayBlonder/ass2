public class FloorsArrayList implements DynamicSet {
    int size;
    int maxSize;
    FloorsArrayLink first;
    FloorsArrayLink last;
    
    public FloorsArrayList(int N){
       this.maxSize = N;
       this.size = 0;
       this.first = new FloorsArrayLink(Double.NEGATIVE_INFINITY, N+1);//creating neg.inf link
       this.last = new FloorsArrayLink(Double.POSITIVE_INFINITY, N+1);//creating inf link
       
       for(int i=0;i<N+1;i++)// loop for setting the arrays to point to the correct link
       {
    	   this.first.setNext(i, this.last);
    	   this.last.setPrev(i, this.first);
       }
    }

    @Override
    public int getSize(){
        return this.size;// returning the size of the array
    }
   
 
    private FloorsArrayLink find(double key){ // private function that return the biggest link that has a key which is smaller or equal to the wanted key
    	if(key<this.minimum())//if the key is smaller then the minimum returning neg.inf
    		return first;
    	if(key>=this.maximum()) //if the key is larger or equal to   the maximum returning maximum
    		return last.getPrev(1);
    	int i=1;
    	FloorsArrayLink current=this.first;
    	while(i<=current.getArrSize()&&current.getNext(i).getKey()<=key) // finding the highest link who is smaller then the wanted key 
		{
			i++;
		}
    	i--;
    	while(i>0||current.getNext(1).getKey()<key) //going forward until the successor is of current is bigger then key
    	{
    		current=current.getNext(i);
    		i=current.getArrSize();
    		while(i>0&&current.getNext(i).getKey()>key)
    		{
    			i--;
    		}
    	}
    	return current;
    	
    }
    
    @Override
    public void insert(double key, int arrSize) {
    	FloorsArrayLink add=new FloorsArrayLink(key,arrSize);// creating link with the wanted values
    	FloorsArrayLink prev=find(key);//finding the predecessor of the link we want to insert 
    	FloorsArrayLink next=prev.getNext(1);//getting the successor
    	int i=1;
    	while(i<=arrSize) // setting the pointing arrays correctly(inserted backwards predecessors forward)
    	{
    		while(i<=prev.getArrSize()&i<=arrSize)
    		{
    			prev.setNext(i,add);
    			add.setPrev(i,prev);
    			i++;
    		}
    		if(prev!=first)
    			prev=prev.getPrev(prev.getArrSize());
    		
    	}
    	i=1;
    	while(i<=arrSize) // setting the pointing arrays correctly(inserted forward successors backwards)
    	{
    		while(i<=next.getArrSize()&i<=arrSize)
    		{
    			next.setPrev(i,add);
    			add.setNext(i,next);
    			i++;
    		}
    		if(next!=last)
    			next=next.getNext(next.getArrSize());
    		
    	}
    	size++;
    }

    @Override
    public void remove(FloorsArrayLink toRemove) {
    	FloorsArrayLink prev=toRemove.getPrev(1);//
    	FloorsArrayLink next=toRemove.getNext(1);
    	int i=1;
    	while(i<=toRemove.getArrSize())// setting the pointing arrays correctly(predecessors forward)
    	{
    		while(i<=prev.getArrSize()&i<=toRemove.getArrSize())
    		{
    			prev.setNext(i,toRemove.getNext(i));
    			i++;
    		}
    		prev=prev.getPrev(prev.getArrSize());
    		
    	}
    	i=1;
    	while(i<=toRemove.getArrSize())// setting the pointing arrays correctly(successors backwards)
    	{
    		while(i<=next.getArrSize()&i<=toRemove.getArrSize())
    		{
    			next.setPrev(i,toRemove.getPrev(i));
    			i++;
    		}
    		next=next.getNext(next.getArrSize());
    		
    	}
    	size--;
    }

    @Override
    public FloorsArrayLink lookup(double key) {
    	FloorsArrayLink current=find(key);// using the private function
    	if(current.getKey()==key) //if the key of the return link is equal returning the link
        	return current;
    	return null;
    }

    @Override
    public double successor(FloorsArrayLink link) {
    	if(link.getNext(1)==last)// if there is no successor returning neg.inf
		return first.getKey();
    return link.getNext(1).getKey();
    }

    @Override
    public double predecessor(FloorsArrayLink link) {
        if(link.getPrev(1)==first)// if there is no predecessor returning neg.inf
			return last.getKey();
        return link.getPrev(1).getKey();
    }

    @Override
    public double minimum() {
        return first.getNext(1).getKey();
    }

    @Override
    public double maximum() {
        return last.getPrev(1).getKey();
    }
}
