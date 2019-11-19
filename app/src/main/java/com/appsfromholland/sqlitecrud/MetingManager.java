package com.appsfromholland.sqlitecrud;

import java.util.ArrayList;

public class MetingManager {
    private ArrayList<Meting> metingen;

    public MetingManager() {
        this.metingen = new ArrayList<Meting>();
    }

    public void create(Meting meting){
        this.metingen.add(meting);
    }

    public ArrayList<Meting> read(){
        return this.metingen;
    }

    public void update() {
    }

    public void delete() {
    }
}
