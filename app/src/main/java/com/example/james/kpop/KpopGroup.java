package com.example.james.kpop;

/**
 * Created by James on 9/15/2017.
 */

public class KpopGroup {
    String name;
    String type;

    public KpopGroup(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }


}
