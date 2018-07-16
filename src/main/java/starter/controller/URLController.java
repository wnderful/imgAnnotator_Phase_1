package starter.controller;

import org.springframework.web.bind.annotation.*;
import starter.entity.ReqImgURL;
import starter.serviceimpl.MarkServiceImpl;

@RestController()
@RequestMapping(value = "/URL")
public class URLController {
    MarkServiceImpl markService = new MarkServiceImpl();

    @RequestMapping(value = "/setURL",method = RequestMethod.POST)
    public ReqImgURL receiveMark(@RequestBody ReqImgURL reqImgURL){
        if(reqImgURL !=null) {
            String content = reqImgURL.getImgURL();
            markService.write("/URLs/"+reqImgURL.getImgid(),content);
        }
        return reqImgURL;
    }

    @RequestMapping(value = "/findURL/{imgid}",method = RequestMethod.GET)
    public ReqImgURL findMark(@PathVariable("imgid") String imgid){
        ReqImgURL reqImgURL = new ReqImgURL();
        reqImgURL.setImgid(imgid);
        reqImgURL.setImgURL(markService.read("/URLs/"+imgid));
        return reqImgURL;
    }

    @RequestMapping(value = "/deleteURL/{imgid}",method = RequestMethod.DELETE)
    public String  deleteMark(@PathVariable("imgid") String imgid){
        return markService.delete("/URLs/"+imgid);
    }

    @RequestMapping(value = "/renewURL",method = RequestMethod.PUT)
    public ReqImgURL renewMark(@RequestBody ReqImgURL reqImgURL){
        String content = reqImgURL.getImgURL();
        markService.write("/URLs/"+reqImgURL.getImgid(),content);
        return reqImgURL;
    }
}
