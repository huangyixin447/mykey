# MyKey: 一个专为安全网络传输隐私随机密码设计的JavaWeb应用

这是一个专门设计的JavaWeb网页，旨在提供在网络上安全、私密地传递密码的平台。使用最先进的加密技术，能够确保您的密码信息安全传输，防止信息泄露或被非法访问。

## 使用的相关技术

- Java
- Servlet
- Thymeleaf
- MySQL

## 使用场景

这款程序适用于那些希望在网络上安全地传递私密信息的用户。例如，如果两个人想在网络上传递一些敏感的内容（如裸照），但是担心所有的聊天软件都有监管和后台，他们可以使用本程序。他们可以通过压缩并加密文件的方式来传输，但是传递解压密码又成为一个问题，密码不能通过任何社交平台传播，否则可能被非法获取。在这种情况下，本程序就可以通过Web的方式安全地传递密码。

## 使用方法

1. 用户A使用本程序创建一个密码，并生成一个密码链接。
2. 密码可以通过该链接进行访问，但该链接只可以访问两次，分别由用户A和用户B各访问一次。
3. 当链接被访问第三次时，链接将失效，确保密码的安全。

## 部署教程

### 数据库配置

在MySQL中，使用以下SQL语句创建数据表：

```sql
CREATE TABLE key1(
id INT(3) PRIMARY KEY AUTO_INCREMENT,
key1 VARCHAR(200),
session1 VARCHAR(200),
CONSTRAINT yuwnd UNIQUE(key1)
);
```
修改一下src下的peizhi（配置文件），然后打包成war包keyword.war
将其war包后粘贴到weapps中去，注意名称要是keyword.war，否则会报错,复制后使用tomcat中bin下的start.bat来开启tomcat，这时服务启动，注意关闭cmd窗口服务停止。
服务启动后，访问本机对应设置的ip加端口号加上/keyword，既可。
详细教程：https://blog.lucyqin.cn/?p=737
