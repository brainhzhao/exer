package priv.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/hello")
public class HelloWorldAnotation{
  
    @RequestMapping("/{hi}")
    @ResponseBody
    public String[] save(@PathVariable String hi){
        return new String[]{"123","456","789",hi}; 
    }

    @RequestMapping("/hi1")
    public ModelAndView sayHello(String name,String id){
        ModelAndView mav =new ModelAndView();
        mav.addObject("name", name);
        mav.addObject("id", id);
        mav.setViewName("index");

        return mav;
    }

    @RequestMapping("/hi2")
    public String sayBayBay(Model model,@RequestParam("name")String name){
        model.addAttribute("name", name);
        return "index";
    }

}