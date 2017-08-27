# flylib-site
测试环境部署 <br/>

http://localhost:20100/passport/register
下面是一些测试url<br/>
注册账号
<a href="http://localhost:20100/passport/register?username=13011111111&password=123456&accountType=1">http://localhost:20100/passport/register?username=13011111111&password=123456&accountType=1</a>
<br/>
登录
<br/>
<a href="http://localhost:20100/passport/login?username=13011111111&password=123456&accountType=1">
http://localhost:20100/passport/login?username=13011111111&password=123456&accountType=1
</a>
登录成功后，调用任何需要认证的所有http接口都需要带上参数userId和token
例如<br/>
<a href="http://localhost:20100/account/getInfo?userId=5&token=069473bedcc609b0d25d6746c11760e5">http://localhost:20100/account/getInfo?userId=5&token=069473bedcc609b0d25d6746c11760e5</a>
<br/>

