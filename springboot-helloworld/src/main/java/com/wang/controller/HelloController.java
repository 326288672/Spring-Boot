package com.wang.controller;
import com.wang.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*@RestController由以下注解组成:
* @Controller
  @ResponseBody
* */
@RestController
public class HelloController {


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }
    /*1.绑定参数*/
    @RequestMapping(value = "/one",method = RequestMethod.GET)
    public String getName(@RequestParam String name){
        return name;
    }
    /*2.绑定一个对象
    * 3.URL:http://localhost:8888/two?name=zhangsan&id=123&hobbies=playbasketball,Run,Sleep&son.school=清华大学*/
    @RequestMapping(value = "/two",method = RequestMethod.GET)
    public Person getPerson(Person person){
        return person;
    }
}
