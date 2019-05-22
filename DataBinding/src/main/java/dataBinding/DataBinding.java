package dataBinding;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller()
@ResponseBody
public class DataBinding {

    //    http://localhost:8080/baseType.do? 放回默认值100
//    http://localhost:8080/baseType.do?指定参数名=154 放回154
    @RequestMapping(value = "baseType.do")
    public String baseType(@RequestParam(value = "指定参数名", required = false, defaultValue = "100") int age) {
        // 请求参数注解，可以另外指定参数名，required默认为true，此时基本类型不传则报错，包装类型不传则默认为null。如果required为false，可以设置默认值。
        return "age: " + age;
    }

    //    http://localhost:8080/wrapType.do   可以不带参数，返回null
//    http://localhost:8080/wrapType.do?age=10
    @RequestMapping(value = "wrapType.do")
    public String wrapType(Integer age) {
        return "age: " + age;
    }

    //    http://localhost:8080/simpleObject.do?name=Tom&age=22 直接请求到内部
//    输出 user: User{age=22, name='Tom'}
    @RequestMapping(value = "simpleObject.do")
    public String simpleObject(User user) {
        return "user: " + user;
    }

    //    http://localhost:8080/complexObject.do?name=Tom&age=22&user.name=Jack&user.age=45
//    输出 group: Group{age=22, name='Tom', user=User{age=45, name='Jack'}}
    @RequestMapping(value = "complexObject.do")
    public String complexObject(Group group) {
        return "group: " + group;
    }

    //    http://localhost:8080/array.do?array=1&array=4
//    输出 array: [1, 4]
    @RequestMapping(value = "array.do")
    public String array(@RequestParam(value = "array") String[] strings) {
        return "array: " + Arrays.toString(strings);
    }

    //    http://127.0.0.1:8080/similarObject.do?age=1&name=Tom&user.age=2&user.name=Bob
//    输出 group: Group{age=1, name='Tom', user=User{age=2, name='Bob'}} 完全一样的两个对象
//        batch: Group{age=1, name='Tom', user=User{age=2, name='Bob'}}
//    如果用InitBinder预处理，则可以指定对象类数据绑定。如下，不指定的部分还是都一样。
//    http://127.0.0.1:8080/similarObject.do?group.age=2222&name=Tom&batch.user.age=2&user.name=Bob
//    输出 group: Group{age=2222, name='Tom', user=User{age=null, name='Bob'}} batch: Group{age=null, name='Tom', user=User{age=2, name='Bob'}}
    @RequestMapping(value = "similarObject.do")
    public String similarObject(Group group, Batch batch) {
        return "group: " + group + "\nbatch: " + batch;
    }


    @InitBinder(value = "group")
    public void initGroup(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("group.");
    }

    @InitBinder(value = "batch")
    public void initBatch(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("batch.");
    }


    //    http://localhost:8080/list.do?users[0].age=1&users[0].name=Tom&users[2].age=3&users[2].name=Bob&list[0]=111&list[2]=333
//    应该直接请求到内部对象，浏览器直接输入URL则[ ]会被认为是禁止的，返回400，要转码成%4B和%4D，血妈坑。。
//    输出 [111, null, 333]    [User{age=1, name='Tom'}, User{age=null, name='null'}, User{age=3, name='Bob'}]
//    list不需要初始化容量，且如果输出的索引有跳跃，则跳过的索引位置会被置为null，需注意。
//    set类型类似，但是需要初始化容量，且URL中索引不能越过size-1
    @RequestMapping(value = "list.do")
    public String list(ListForm listForm) {
        return listForm.toString();
    }

    //    http://127.0.0.1:8080/map.do?map['s']=aaa&userMap['bb'].name=Tom&userMap['bb'].age=2&userMap['cc'].name=Bob  浏览器输入记得转码
//    输出 map={s=aaa}   userMap: {bb=User{age=2, name='Tom'}, cc=User{age=null, name='Bob'}}
    @RequestMapping(value = "map.do")
    public String map(MapForm mapForm) {
        return mapForm.toString();
    }


//    http://127.0.0.1:8080/json.do
//    {
//        "name":"Matt",
//            "age":26,
//            "user":{
//                "name":"YJJ",
//                "age":26
//                }
//
//    }
//    输出 Group{age=26, name='Matt', user=User{age=26, name='YJJ'}}。
//    限定只能为POST
    @RequestMapping(value = "json.do",method = RequestMethod.POST,consumes = "application/json",produces ="application/json")
    public String json(@RequestBody Group group) {
        return group.toString();
    }

//    http://127.0.0.1:8080/xml.do<?xml version="1.0" encoding="UTF-8"?>
//  <xmlRoot>
//      <name>YJJjjjjj</name>
//        <age>26</age>
//  </xmlRoot>
//    输出: XMLRoot{name='YJJjjjjj', age=26}
    @RequestMapping(value = "xml.do", method = RequestMethod.POST,consumes = "application/xml",produces ="application/xml")
    public String xml(@RequestBody XMLRoot xmlRoot) {
        return xmlRoot.toString();
    }

//    http://127.0.0.1:8080/date.do?data=2008-01-12
//    输出 Sat Jan 12 00:01:00 CST 2008
    @RequestMapping(value = "date.do")
    public String data(Date data){
        return data.toString();
    }

//    http://127.0.0.1:8080/key/aaaaaaaaaaaaaaa 输出aaaaaaaaaaaaaaa
//    REST的请求,映射路径写法以及参数的注解形式.
    @RequestMapping(value = "key/{value}", method = RequestMethod.GET)
    public String getValue(@PathVariable(name = "value") String value){
        return value;
    }

}
