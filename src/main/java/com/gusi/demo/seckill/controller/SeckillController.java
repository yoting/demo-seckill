package com.gusi.demo.seckill.controller;

import com.gusi.demo.seckill.dto.KilledDoing;
import com.gusi.demo.seckill.dto.SeckillInfo;
import com.gusi.demo.seckill.dto.SeckillRsp;
import com.gusi.demo.seckill.pojo.Seckill;
import com.gusi.demo.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by GUSI on 2017/4/18.
 */
@Controller
@RequestMapping(value = "/seckill")
public class SeckillController {

    @Autowired
    SeckillService seckillService;

    @RequestMapping("/hello")
    @ResponseBody
    public String getTest() {
        return "hello";
    }

    /**
     * 查询列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getSeckillList(Model model, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        List<Seckill> seckills = seckillService.querySeckillList(0, 10);

        model.addAttribute("list", seckills);

        return "list";
    }

    /**
     * 查询详情
     *
     * @param seckillId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String getSeckillDetail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redircet:/seckill/list";
        }

        Seckill seckill = seckillService.querySeckillDetail(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        } else {
            model.addAttribute("seckill", seckill);
            return "detail";
        }
    }


    /**
     * 查询秒杀
     *
     * @param seckillId
     * @return
     */
    @RequestMapping(value = "/{seckillId}/info", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SeckillRsp<SeckillInfo> getSeckillInfo(@PathVariable("seckillId") Long seckillId) {
        SeckillRsp<SeckillInfo> response = null;

        SeckillInfo info = seckillService.querySeckillInfo(seckillId);
        if (info != null) {
            response = new SeckillRsp<SeckillInfo>(info);
        } else {
            response = new SeckillRsp<SeckillInfo>("秒杀不存在!");
        }

        return response;
    }


    /**
     * 执行秒杀
     *
     * @param seckillId
     * @param md5
     * @param killMobile
     * @return
     */
    @RequestMapping(value = "/{seckillId}/{md5}/doing", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SeckillRsp<KilledDoing> doingSeckill(@PathVariable("seckillId") Long seckillId, @PathVariable("md5") String md5, @CookieValue(value = "killMobile", required = false) String killMobile) {
        SeckillRsp<KilledDoing> response = null;

        if (killMobile == null) {
            return new SeckillRsp<KilledDoing>("未登录");
        }

        try {
            KilledDoing doing = seckillService.doingSeckill(seckillId, md5, killMobile);
            response = new SeckillRsp<KilledDoing>(doing);
        } catch (Exception e) {
            response = new SeckillRsp<KilledDoing>(e.getMessage());
        }

        return response;
    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    @RequestMapping(value = "/time/now", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SeckillRsp getNowTime() {
        SeckillRsp response = new SeckillRsp(new Date().getTime());
        return response;
    }

}
