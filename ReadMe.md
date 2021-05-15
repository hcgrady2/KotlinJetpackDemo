### 一、
参考： github
:https://github.com/fmf19870210/MyCainiao5



[1、Jetpack 介绍](./Jetpack.md)

[2、Kotlin 入门](./Kotlin.md)


### 二、项目架构
#### 1、网络库

##### 安全相关
安全接口 ： https://course.api.cniao5.com/

appid : tcvEYU1WEc

appkey : J#y9sJesv*5HmqLqEV1yUPYfpH$pHx$!


接口安全相关：     
token 机制 、 时间戳 、 签名机制（每个签名只使用一次）
签名规则:
+  参数名ascii 排序 得到 stringA
+  stirngA 拼接 appkey 得到 stringSignTemp 字符串，然后 md5，再转大写，得到 signValue


##### 请求相关
公共参数： 每个接口都需要传递，放到 header 。 
appid、version 、platform 、system 、branc、model 、uuid、network、sign、timestamp、token 。、

状态码：
 






### 三、登录模块


### 四、个人中心


### 五、学习中心


### 六、课程中心


### 七、首页


### 八、视频播放


### 九、App 打包 构建


