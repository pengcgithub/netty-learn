
- 类（Class）

使用三层矩形框表示。   第一层显示类的名称，如果是抽象类，则就用斜体显示。   第二层是字段和属性。  第三层是类的方法。   注意前面的符号，‘+’表示public，‘-’表示private，‘#’表示protected。 

- 泛化（Generalization）

【关系】指的是一种继承关系，具体形式为类与类之间的继承 关系，接口与接口之间的继承关系，** 类对接口的实现关系 **

【箭头】带三角箭头的实线，箭头指向父类

- 实现（Realization）

【关系】指的是一种类与接口的关系，表示类是接口所有特征和行为的实现.

【箭头】带三角箭头的虚线，箭头指向接口

- 关联（Association)

【关系】表现为变量(has a )，指的是一种拥有的关系，它使一个类知道另一个类的属性和方法。双向关联：两个类都知道另一个类的公共属性和操作。单向关联：只有一个类知道另外一个类的公共属性和操作。

【代码】

```
// 老师
public class Teacher {
	private List<Student> studentList;
}

// 学生
public class Student {
	private List<Teacher> teacherList;
	private List<Course> courseList;
}

// 课程
public class Course {
	private String name;
}
```

【箭头】带普通箭头的实心线，指向被拥有者

- 聚合（Aggregation）

【关系】是整体与部分的关系，且部分可以离开整体而单独存在。如车和轮胎是整体和部分的关系，轮胎离开车仍然可以存在。
【箭头】带空心菱形的实心线，菱形指向整体

- 组合(Composition)

【关系】是整体与部分的关系，但部分不能离开整体而单独存在。如公司和部门是整体和部分的关系，没有公司就不存在部门。

【箭头】带实心菱形的实线，菱形指向整体

-  依赖(Dependency)

【关系】是一种使用的关系，即一个类的实现需要另一个类的协助，所以要尽量不使用双向的互相依赖.

【箭头】带箭头的虚线，指向被使用者

## 参考资料
- [类的关系（泛化, 实现，关联，聚合，组合，依赖）](https://blog.csdn.net/weixin_42927264/article/details/82963556)
- [UML类图的箭头含义](https://www.jianshu.com/p/8969ab8c48c7)
- [https://www.cnblogs.com/huaxingtianxia/p/6590351.html](https://www.cnblogs.com/huaxingtianxia/p/6590351.html)