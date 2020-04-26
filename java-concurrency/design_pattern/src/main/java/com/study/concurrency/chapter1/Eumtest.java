package com.study.concurrency.chapter1;

public enum Eumtest { //season
    SRING("sun","whether");
    String sun;
    String wd;
    Eumtest(String sun,String wd){
        this.sun=sun;
        this.wd=wd;
    }
    public void show() {
        System.out.println(this.sun+" : "+this.wd);
    }


}



class Enumtest1{
    private String sun;
    private String wd;
    public Enumtest1(String sun,String wd){
        this.sun=sun;
        this.wd=wd;
    }

    @Override
    public String toString() {
        return this.sun+" : "+this.wd;
    }
}
class testmain{
    public static void main(String[] args) {
//        Enumtest1 e = new Enumtest1("sun","whether");
//        e.toString();
        Eumtest e = Eumtest.SRING; //new xxxx()
       e.show();
    }
}
