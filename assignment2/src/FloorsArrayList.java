public class FloorsArrayList implements DynamicSet {
    int size;
    int maxSize;
    FloorsArrayLink first;
    FloorsArrayLink last;
    
    public FloorsArrayList(int N){
       this.maxSize = N;
       this.size = 0;
       this.first = new FloorsArrayLink(Double.NEGATIVE_INFINITY, N+1);
       this.last = new FloorsArrayLink(Double.POSITIVE_INFINITY, N+1);
       
       for(int i=0;i<N+1;i++)
       {
    	   this.first.setNext(i, this.last);
    	   this.last.setPrev(i, this.first);
       }
    }

    @Override
    public int getSize(){
        return this.size;
    }
    
    
    private FloorsArrayLink find(double key){
    	int i=1;
    	FloorsArrayLink current=this.first;
    	while(i<=current.getArrSize()&&current.getNext(i).getKey()<=key)
    		{
    			i++;
    		}
    	current=current.getNext(i-1);
    	i=current.getArrSize()-1;
    	while(current.getKey()<=key)
    	{
    		if(current.getNext(i).getKey()<=key)
    			current=current.getNext(i);
    		else
    			i--;
    	}
      	return current;
    }
    
    @Override
    public void insert(double key, int arrSize) {
    	FloorsArrayLink add=new FloorsArrayLink(key,arrSize);
    	FloorsArrayLink prev=find(key);
    	FloorsArrayLink next=prev.getNext(1);
    	int i=1;
    	while(i<arrSize)
    	{
    		while(i<=prev.getArrSize()&i<arrSize)
    		{
    			prev.setNext(i,add);
    			i++;
    		}
    		prev=prev.getPrev(prev.getArrSize());
    		
    	}
    	i=1;
    	while(i<arrSize)
    	{
    		while(i<=next.getArrSize()&i<arrSize)
    		{
    			next.setPrev(i,add);
    			i++;
    		}
    		next=next.getNext(next.getArrSize());
    		
    	}
    }

    @Override
    public void remove(FloorsArrayLink toRemove) {
    	FloorsArrayLink prev=toRemove.getPrev(1);
    	FloorsArrayLink next=toRemove.getNext(1);
    	int i=1;
    	while(i<toRemove.getArrSize())
    	{
    		while(i<=prev.getArrSize()&i<toRemove.getArrSize())
    		{
    			prev.setNext(i,toRemove.getNext(i));
    			i++;
    		}
    		prev=prev.getPrev(prev.getArrSize());
    		
    	}
    	i=1;
    	while(i<toRemove.getArrSize())
    	{
    		while(i<=next.getArrSize()&i<toRemove.getArrSize())
    		{
    			next.setPrev(i,toRemove.getPrev(i));
    			i++;
    		}
    		next=next.getNext(next.getArrSize());
    		
    	}
    }

    @Override
    public FloorsArrayLink lookup(double key) {
    	FloorsArrayLink current=find(key);
    	if(current.getKey()==key)
        	return current;
    	return null;
    }

    @Override
    public double successor(FloorsArrayLink link) {
    	if(link.getNext(1)==last)
		return first.getKey();
    return link.getNext(1).getKey();
    }

    @Override
    public double predecessor(FloorsArrayLink link) {
        if(link.getPrev(1)==first)
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
