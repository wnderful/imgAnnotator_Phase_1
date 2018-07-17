package starter.entity;

import java.util.ArrayList;

public class Marks{
    private String overallDesc;
    private ArrayList<PolyMark> polyMarkList;
    private ArrayList<RectMark> rectMarkList;

    public Marks(){
        overallDesc = "a object";
        polyMarkList = new ArrayList<PolyMark>();
        rectMarkList = new ArrayList<RectMark>();
    }
}
