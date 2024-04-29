
安装以及配置：查看Google浏览器版本，下载对应的谷歌浏览器驱动

自动化测试：将人工做的工作进行转换，让代码去执行测试工作，目的是为了提高测试效率，提高测试产品质量

常见自动化测试：自动化分离，单元自动化测试，接口自动化测试，ui自动化测试

selenium工作原理：

用Selenium实现自动化，主要需要三个东西：

1.自动化测试代码：自动化测试代码发送请求给浏览器的驱动（比如火狐驱动、谷歌驱动，IE驱动）
2.浏览器驱动：它来解析这些自动化测试的代码，解析后把它们发送给浏览器
3.浏览器：执行浏览器驱动发来的指令，并最终完成工程师想要的操作。

Selenium脚本执行时后端实现的流程：

1.对于每一条Selenium脚本，一个http请求会被创建并且发送给浏览器的驱动  
2.浏览器驱动中包含了一个HTTP Server，用来接收这些http请求  
3.HTTP Server接收到请求后根据请求来具体操控对应的浏览器  
4.浏览器执行具体的测试步骤  
5.浏览器将步骤执行结果返回给HTTP Server  
6.HTTP Server又将结果返回给Selenium的脚本，如果是错误的http代码我们就会在控制台看到对应的报错信息。




对前端页面元素的定位

点击要找到的元素，ctrl+F，可以对页面里的数据进行查找


（1）css定位器定位元素
类选择器：. class
id选择器： #  加上id值
父类选择器  子类选择器：  类名   空格   类名
标签选择器  ：标签名


（2）Xpath定位元素
1.绝对路径（通过“/”开头）
2.相对路径（“//”开头）
【1】相对路径加索引  //form/span【1】
【2】相对路径加上属性值  //from【@class="id_name"】  （对标签的属性子进行呼叫）
【3】相对路径加上通配符 //*[@*="bdsug bdsug-new new-pmd"]
【4】相对路径加上文本  //a[text()="新闻"]


css定位方式想对于Xpath定位方式更高效

```javascript
private static void test01 () {  
    //创建一个驱动  
    WebDriver webDriver=new ChromeDriver ();  
    //打开百度网页  
    webDriver.get ("http://www.baidu.com");  
    //定位百度搜索框  
    //WebElement search_input= webDriver.findElement (By.cssSelector ("#kw"));  
    //WebElement search_input= webDriver.findElement (By.xpath ("//*[@id=\"kw\"]"));         WebElement search_input= webDriver.findElement (By.tagName ("input"));  
    //测试  
    if(search_input==null){  
        System.out.println ("测试失败");  
    }else {  
        System.out.println ("测试成功");  
    }  
  
    //webDriver.quit ();//关闭浏览器会清楚cookie  
    webDriver.close ();  
}
```


quit会关闭页面并清除所有cookie，close则不会，推荐使用quit

```javascript
List<WebElement> search_result=webDriver.findElements (By.xpath ("//font[text()=\"测试开发\"]"));
```

去寻找该页面中的所有元素，来测试是否完成搜索

按住CTRL加左键可以进入该函数，查看该函数的返回值，以及方法的实现

隐式等待，设置一个最大等待时间，在这段时间之内如果页面全部加载完成，就停止等待
```javascript
webDriver.manage ().timeouts ().implicitlyWait (5,MINUTES);
```
CTRL加左键查看函数，选择合适的等待参数


显示等待，等待页面里面的某个元素出现，就停止等待
```javascript
WebDriverWait wait=new WebDriverWait (webDriver,3);  
//判断元素是否可以点击  
wait.until (ExpectedConditions.elementToBeClickable (By.cssSelector ("#s-top-left > a:nth-child(4)")));
```
出现预期的可点击元素，就会停止等待
推荐使用隐式等待


```javascript
WebElement search_input=webDriver.findElement (By.cssSelector ("#kw"));  

search_input.sendKeys ("测试开发");  
  
WebElement click_button =webDriver.findElement (By.cssSelector ("#su"));  
click_button.submit ();
click_button.click();
```
submit( )进行提交数据，但是只能是from标签类的，有些按钮不发送数据，只进行页面跳转，此时使用submit（）就会报错
而使用click( )就不会出现这种情况

操作元素:
点击：click
获取文本:getText()
清空：clear
提交：submit
打开网页：get（url）
关闭浏览器：quit（ ） close ( )

```javascript
private static void test08 () {  
    WebDriver webDriver=new ChromeDriver ();  
    webDriver.get ("https://www.baidu.com");  
    //上面的语句等价于  
    webDriver.navigate ().to ("https://www.baidu.com");  
    //浏览器最大化  
    webDriver.manage ().window ().maximize ();  
    //设置浏览器大小  
    webDriver.manage ().window ().setSize (new Dimension (100,100));  
    //浏览器的前进后退  
    //navigate()导航
    webDriver.navigate ().forward ();//导航前进  
    webDriver.navigate ().back ();//导航控制后退  
    //然后获取当前页面的url,用equals()来判断结果  

	//execute  执行  
	//执行脚本，将界面的滚动条拖动到最下面  
	((JavascriptExecutor)webDriver).executeScript("document.documentElement.scrollTop=10000");  
sleep(3000);  
//滚动到最上面  
((JavascriptExecutor)webDriver).executeScript ("document.documentElement.scrollTop=0");
}
```
selenium对javascript脚本的执行
selenium有内置方法executeScript，将webDriver类强制类型转换为 JavascriptExecutor（javascript脚本执行器）类，在进行脚本执行，方法中式具体的执行脚本内容


键盘按键的使用
```javascript
input.sendKeys (Keys.ENTER);
input.sendKeys (Keys.CONTROL,"A"); //全选 

input.sendKeys (Keys.CONTROL,"X"); //剪切

input.sendKeys (Keys.CONTROL,"V");//复制
```

右键操作以及点击效果展示
```javascript
Actions actions=new Actions (webDriver);  
//要看到执行的效果，使用  perfrom（）  
//contextClick()执行的操作是鼠标右键进行点击
actions.moveToElement (target).contextClick ().perform ();  

```










