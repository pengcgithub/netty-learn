package com.tracy.thrift;

import com.tracy.thrift.generated.DataException;
import com.tracy.thrift.generated.Person;
import com.tracy.thrift.generated.PersonService;
import org.apache.thrift.TException;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.0.0
 * @title PersonServiceImpl
 * @package com.tracy.thrift
 * @time 2019/5/21 9:59
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param"+username);
        //可以使用链式编程，当然也可以分开
        Person person = new Person().setUsername("张三").setAge(14).setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("保存对象");
        System.out.println(person.username);
        System.out.println(person.age);
        System.out.println(person.married);
    }

}
