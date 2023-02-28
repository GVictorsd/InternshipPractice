package mypack;


public class Simple{
    public Simple(){
        System.out.println("Constructor!! A");
    }
    public Simple(int i){
        this.i = i;
    }
    protected int i;
    public int geti(){
        return this.i;
    }
    public void seti(int n){
        this.i = n;
    }
    private void pm(){
        System.out.println("private method");
    }
    protected void prom(){
        System.out.println("protected method");
    }

    @Override
    public boolean equals(Object b){
        System.out.println("equals method");
        Simple c = (Simple) b;
        return this.i == c.geti();
    }

    @Override
    public int hashCode(){
        return (""+this.i).hashCode();
    }

}