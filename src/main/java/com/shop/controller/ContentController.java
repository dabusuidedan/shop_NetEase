package com.shop.controller;



import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shop.entity.Account;
import com.shop.entity.Content;
import com.shop.service.AccountService;
import com.shop.service.ContentService;
import com.shop.util.ContentUtil;
import com.shop.util.JsonUtil;
import com.shop.util.Temp;

@Controller
@RequestMapping("/home")
public class ContentController {
	
	
	@Autowired
	private ContentService con;
	
	@Autowired
	private AccountService acc;
	
	
	@RequestMapping("/shouye")
    public ModelAndView Add(@RequestParam(value="contentFlag",required=false,defaultValue="1") String contentFlag,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<Content> list;
		int conflag=Integer.valueOf(contentFlag);
		if(conflag==1) {
			list=con.findAll();
			if(session.getAttribute("cflag")!=null)
			session.removeAttribute("cflag");
		}
		else
		{
			list=con.findNotBuy();
			session.setAttribute("cflag", 1);
		}
        ModelAndView mv = new ModelAndView();
        mv.setViewName("shouye");
        mv.addObject("contents",list);
        return mv;
    }
	
	@RequestMapping("/show")
    public ModelAndView show(@RequestParam(value="contentId",required=false,defaultValue="1") String contentId,HttpServletRequest request,HttpServletResponse response){
		int contId=Integer.valueOf(contentId);
		Content content=con.findById(contId);
		Account account=acc.findByContentId(contId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("show");
        mv.addObject("content",content);
        if(account!=null)
        {
        mv.addObject("account",account);
        }
        return mv;
    }
	
	@RequestMapping("/settleAccount")
    public ModelAndView settleAccount(HttpServletRequest request,HttpServletResponse response){	
        ModelAndView mv = new ModelAndView();
        mv.setViewName("settleAccount");
        return mv;
    }
	
	@RequestMapping("/account")
    public ModelAndView account(HttpServletRequest request,HttpServletResponse response){	
        ModelAndView mv = new ModelAndView();
        List<Account> accountAll=acc.findAll();
        System.out.println(accountAll);
        double sum=acc.sum();
        mv.addObject("accountAll",accountAll);
        mv.addObject("sum",sum);
        mv.setViewName("account");
        return mv;
    }
	
	@RequestMapping("/buy")
	@ResponseBody
    public JsonUtil buy(@RequestBody List<Temp> temps,HttpServletRequest request,HttpServletResponse response){	
		// ModelAndView mv = new ModelAndView("redirect:/home/account.action");
		int i=0;
        for(Temp t : temps){
            System.out.println("Id:"+t.getId()+";"+"Number"+t.getNumber());
            Content con1=con.findById(t.getId());
            Account acc1=new Account();
            System.out.println(con1.getContentTitle());
            acc1.setAccountTitle(con1.getContentTitle());
            acc1.setAccountImage(con1.getContentImage());
            acc1.setAccountTime(new Date());
            acc1.setAccountPrice(con1.getContentPrice());
            acc1.setAccountNum(t.getNumber());
            acc1.setAccountContentId(t.getId());
            acc.insert(acc1);
            con.update(t.getId());
            i++;
        }
        //mv.setViewName("account");
        JsonUtil j=new JsonUtil();
        j.setCode(200);     
        j.setMessage(String.valueOf(i));
        return j;
    }
	
	
	@RequestMapping("/publicSubmit")
    public ModelAndView fabu(ContentUtil conUtil,HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        Content con2=new Content();
        con2.setContentTitle(conUtil.getTitle());
        con2.setContentImage(conUtil.getImage());
        con2.setContentPrice(Double.valueOf(conUtil.getPrice()));
        con2.setContentAbstract(conUtil.getSummary());
        con2.setContentBody(conUtil.getDetail());
        con2.setContentFlag(0);
        con.insert(con2);
        int zhujian=con2.getContentId();
        mv.addObject("zhujian",zhujian);
        mv.setViewName("publicSuccess");
        return mv;
    }
	
	@RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value="id",required=false,defaultValue="1") String id,HttpServletRequest request,HttpServletResponse response){	
        ModelAndView mv = new ModelAndView();
        int id1=Integer.valueOf(id);
        Content conEdit=con.findById(id1);
        System.out.println(conEdit);
        mv.addObject("conEdit",conEdit);
        mv.setViewName("edit");
        return mv;
    }
	
	@RequestMapping("/editSubmit")
    public ModelAndView editSubmit(@RequestParam(value="id",required=false,defaultValue="1") String id,ContentUtil conUtil,HttpServletRequest request,HttpServletResponse response){	
        ModelAndView mv = new ModelAndView();
        Content con2=con.findById(Integer.valueOf(id));
        con2.setContentTitle(conUtil.getTitle());
        con2.setContentImage(conUtil.getImage());
        con2.setContentPrice(Double.valueOf(conUtil.getPrice()));
        con2.setContentAbstract(conUtil.getSummary());
        con2.setContentBody(conUtil.getDetail());
        con.updateByCon(con2);
        int zhujian=Integer.valueOf(id);
        mv.addObject("zhujian",zhujian);
        mv.setViewName("publicSuccess");
        return mv;
    }
	
	
	@RequestMapping("/delete")
	@ResponseBody
    public Object delete(@RequestParam(value="id",required=false,defaultValue="1") String id,HttpServletRequest request,HttpServletResponse response){	
        int i=con.delete(Integer.valueOf(id));
        return i;
    }
	
	
	@RequestMapping("/upload")
	@ResponseBody
    public JsonUtil upload(MultipartFile file,HttpServletRequest request,HttpServletResponse response,HttpSession session){	
		JsonUtil json=new JsonUtil();
		if(!file.isEmpty()){  
			String fileName=file.getOriginalFilename();// 文件原名称
			String pathRoot = request.getSession().getServletContext().getRealPath("");
			System.out.println(pathRoot);
			String path= pathRoot+"/image/"+fileName;
			String path1="../image/"+fileName;
            try {
				file.transferTo(new File(path));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            json.setResult(path1);
    }
       return json;

}
}