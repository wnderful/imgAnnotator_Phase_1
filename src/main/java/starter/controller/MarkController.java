package starter.controller;

import com.alibaba.fastjson.*;
import org.springframework.web.bind.annotation.*;
import starter.entity.ReqImgMarks;
import starter.serviceimpl.MarkServiceImpl;

@RestController()
@RequestMapping(value = "/mark")
public class MarkController {
    private MarkServiceImpl markService= new MarkServiceImpl();

    @RequestMapping(value = "/setMark",method = RequestMethod.POST)
    public ReqImgMarks receiveMark(@RequestBody ReqImgMarks reqImgMarks){
        if(reqImgMarks !=null) {
            String content = reqImgMarks.getMarks().toJSONString();
            markService.write("/marks/"+reqImgMarks.getImgid(),content);
        }
        return reqImgMarks;
    }

    @ResponseBody
    @RequestMapping(value = "/findMark/{imgid}")
    public ReqImgMarks findMark(@PathVariable("imgid") String imgid){
        ReqImgMarks reqImgMarks = new ReqImgMarks();
        reqImgMarks.setImgid(imgid);
        JSONObject marks = JSON.parseObject(markService.read("/marks/"+imgid));
        reqImgMarks.setMarks(marks);
        return reqImgMarks;
    }

    @RequestMapping(value = "/deleteMark/{imgid}",method = RequestMethod.DELETE)
    public String  deleteMark(@PathVariable("imgid") String imgid){
        return markService.delete("/marks/"+imgid);
    }

    @RequestMapping(value = "/renewMark",method = RequestMethod.PUT)
    public ReqImgMarks renewMark(@RequestBody ReqImgMarks reqImgMarks){
        String content = reqImgMarks.getMarks().toString();
        markService.renew("/marks/"+reqImgMarks.getImgid(),content);
        return reqImgMarks;
    }
}
