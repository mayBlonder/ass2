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
    	return null;
    }
    
    @Override
    public void insert(double key, int arrSize) {
        //@TODO: implement
    }

    @Override
    public void remove(FloorsArrayLink toRemove) {
        //@TODO: implement
    }

    @Override
    public FloorsArrayLink lookup(double key) {
        //@TODO: implement
        return null;
    }

    @Override
    public double successor(FloorsArrayLink link) {
        //@TODO: implement
        return 0;
    }

    @Override
    public double predecessor(FloorsArrayLink link) {
        //@TODO: implement
        return 0;
    }

    @Override
    public double minimum() {
        //@TODO: implement
        return 0;
    }

    @Override
    public double maximum() {
        //@TODO: implement
        return 0;
    }
}
