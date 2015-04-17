姓名：${username}
<br/>
密码：${password}
<br/>
年龄：${userInfo.age}
<br/>
登录时间：${userInfo.signinTime?string("yyyy-MM-dd HH:mm:ss")}
<br/>
QQ：${userInfo.qq!}
<br/>
地址：${userInfo.addr}
<hr/>
我的书籍：
<#list userInfo.books as book>
 ${book}&nbsp;
</#list>

<#if username==password>
用户密码相同！
</#if> 
<#if userInfo.qq=="">
QQ为空
</#if> 

<#assign answer=42/> 
${answer?string.number} 
${answer?string.currency} 
${answer?string.percent} 
${"我的文件保存在C:\\盘"} 
${'我名字是\"annlee\"'} 

列表
<#assign list=["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"]/>
${list[2]} 

集合
<#assign scores = {"语文":86,"数学":78} + {"数学":87,"Java":93}> 
语文成绩是${scores.语文} 
Java成绩是${scores.Java} 

<#assign test="Tom & Jerry"> 
${test?html} 
${test?upper_case?html} 

<#assign age=23> 
<#if (age>60)>老年人 
<#elseif (age>40)>中年人 
<#elseif (age>20)>青年人 
<#else> 少年人 
</#if> 

<#macro book booklist>     
<#list booklist as book> 
   ${book} 
</#list> 
</#macro> 
<@book booklist=["spring","j2ee"] />   

<#assign seq = ["winter", "spring", "summer", "autumn"]> 
<#list seq as x> 
  ${x_index + 1}. ${x}<#if x_has_next>@@</#if> 
</#list> 

