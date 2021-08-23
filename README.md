# bookmall


## 版本




* JDK14
* Maven3.6
* Tomcat9.0
* MySQL8.0


## 如何运行




1. 在IDEA中build
2. 运行src/main/java/com/xgy/bookmall/Application.java
3. 打开浏览器，输入http://localhost:8080/


## 各个文件说明




目录结构（从src/main开始）：

* java/com/xgy/bookmall
  * Application.java：启动类，在IDEA中Run这个类的静态方法main
  * controller：控制类，与前端交互就靠它了
  * entity：数据库中的表将映射到这个包中的类
  * mapper：用于访问数据库
  * service：服务层，把mapper封装起来了
    * impl：service层的实现类
* resources
  * mapper：放置Mybatis的xml映射文件。也是写SQL语句的地方
  * static：放置静态资源。你觉得文件是静态的就放这里
  * templates；放置html文件。放这的html文件会给Thymeleaf渲染
  * application.yml：项目配置文件。记得在这里改**数据库账号密码**


## 思路




* 用户请求，服务器响应（request，response）
* 请求在html的js代码中，响应在controller中
* 请求常用get和post
* 响应常用@GetMapping，@PostMapping，@RequestMapping，@ResponseBody注释
* RequestMapping和ResponseMapping一起用好像可以返回Json类型
