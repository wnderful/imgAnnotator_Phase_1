package starter.entity;

import com.alibaba.fastjson.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class ReqImgMarks {
    private String imgid;
    private JSONObject marks;

    public String getImgid() {
        return imgid;
    }

    public JSONObject getMarks() {
        return marks;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    public void setMarks(JSONObject marks) {this.marks = marks;
    }
}
