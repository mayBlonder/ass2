public class FloorsArrayLink {
    //@TODO: add fields
	double key;
	int arrSize;
	FloorsArrayLink[] forward;
	FloorsArrayLink[] back;
	

    public FloorsArrayLink(double key, int arrSize){
        this.key= key;
        this.arrSize = arrSize;
        this.forward = new FloorsArrayLink[this.arrSize]; 
        this.back = new FloorsArrayLink[this.arrSize]; 
        
        for(int i=0;i<this.arrSize;i++)
        {
        	this.forward[i]= null;
        	this.back[i]= null;
        }
    }

    public double getKey() {
        return this.key;
    }

    public FloorsArrayLink getNext(int i) {
    	FloorsArrayLink next;
    	if(i<forward.length & i>=1)
    		next = forward[i-1];
    	else
    		next = null;
        return next;
    }

    public FloorsArrayLink getPrev(int i) {
    	FloorsArrayLink prev;
    	if(i<forward.length & i>=1)
    		prev = forward[i-1];
    	else
    		prev = null;
        return prev;
    }

    public void setNext(int i, FloorsArrayLink next) {
        if(i<forward.length & i>=1)
        	forward[i-1] = next;
    }

    public void setPrev(int i, FloorsArrayLink prev) {
    	if(i<back.length & i>=1)
        	forward[i-1] = prev;
    }

    public int getArrSize(){
        return this.arrSize;
    }
}

