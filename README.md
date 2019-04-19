# berry-email-starter
浆果系列，邮件发送Spring Boot Starter

# SpringBoot使用说明
- 首先，在需要使用此starter的工程的POM文件中新增一下依赖
  ```xml
  <dependencies>
    <dependency>
  	  <groupId>com.github.eugeneheen</groupId>
  	  <artifactId>berry-email-starter</artifactId>
  	  <version>1.0.0</version>
    </dependency>
  </dependencies>
  ```
- 配置邮件返送账号信息，在需要使用此starter的工程的src\main\resources目录下的config目录中的email.properties配置文件中配置发送邮件相关属性及值
  ```vim
  # 邮件SMTP发送地址
  email.smtpAddr: smtp.qq.com
  # 邮件账户
  email.smtpPort: 465
  # 邮件账户密码
  email.userName: xxxxxx@qq.com
  # 是否开启SSL
  email.password: xxxxxx
  # 邮件发送方地址
  email.addresser: xxxxxx@qq.com
  ```
 - 在需要使用的业务成直接注入邮件服务接口依赖，调用相关方法即可
   ```java
   public class UserService implements IUserService {
    
       @Autowired
       private IEmailService emailService;
    
       public boolean save(User user) {
           // ......保存用户代码省略
           this.emailService.sendBySmtp("abc@qq.com", "用户注册通知", "您已成功注册一个xxx系统用户，注册用户名是xxxx，初始密码是xxx。请收到邮件后立即修改初始密码！");
       }
   }
   ```
   >sendBySmtp方法的三个参数依次是：收件人邮箱地址、邮件标题、邮件正文内容