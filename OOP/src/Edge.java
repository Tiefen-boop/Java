public class Edge {
    //fields
    private Integer left;
    private Integer right;

    //constructor
    public Edge(Integer left, Integer right){
        this.left = left;
        this.right = right;
    }

    //copy constructor
    public Edge(Edge other){
        this.left = other.left;
        this.right = other.right;
    }

    //methods
    public Integer getLeft(){
        return left;
    }

    public Integer getRight(){
        return right;
    }

    public void setLeft(Integer left){
        this.left = left;
    }

    public void setRight(Integer right){
        this.right = right;
    }

    public boolean equals(Object other){
        if (!(other instanceof Edge))
            return false;
        return (right == ((Edge)other).getRight() & left == ((Edge)other).getLeft()) | (left == ((Edge)other).getRight() & right == ((Edge)other).getLeft());
    }

    @Override
    public String toString() {
        return "{" + left + ", " + right + "}";
    }
}
