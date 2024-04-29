1.创建项目（梯子环境下创建项目）

2.引入依赖（搜索依赖和下载依赖需要关闭梯子）

3.创建需要的目录和文件
main下创建webapp，webapp下创建WEB-INF，在WEB-INF里创建web.xml
文件内具体内容

```javascript
<!DOCTYPE web-app PUBLIC  
                        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"  
                        "http://java.sun.com/dtd/web-app_2_3.dtd" >  
        <web-app>                <display-name>Archetype Created Web Application</display-name>  
        </web-app>
```


4.在main-java文件夹下开始编写代码



打包操作
1.修改文件
```javascript
<packaging>war</packaging>  
<build>  
    <finalName>  
        initial  
    </finalName>  
</build>
```
打包成war包，包的名字是initial

2.拷贝到webapps里面

![[Pasted image 20231213194621.png]]

3.启动tomcat