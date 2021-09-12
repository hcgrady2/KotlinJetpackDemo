### 一、
参考： github

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


 用自己的账号密码有 token
 18648957777
 cn5123456

#### 2、 依赖注入框架
面向切面的。解耦的。常用的依赖注入框架，dagger2、hilt 、 koin 。
koin 使用：
+ 业务class 创建
+ 定义 koin 容器模块 module，内部声明类的创建（单例、工厂）
+ 在 application 里面调用 startKoin 里面初始化 module 。


关键函数符好：
+ startKoin
+ module
+ single
+ fragtory
+ viewmodel



#### 3、插件化  组件化、模块化
模块，可以理解为解耦，按照功能分包、解耦，或者使用 module 。

组件，可能是更高的抽象，有模块组成。可能是在模块化之上，进行组件化。

组件化是纵向分层，模块化是横向分层。

插件化更关注动态加载、热更新、热修复等插拔技术。

插件化开源的方案： 阿里的 atlas 、 360 的  RePlugin 、滴滴的  VirtualAPK 。



#### 4、项目模块划分
基于 ARrouter  来实现组件化。
Service 介于 app 和 common 之间。

##### Common 模块包含基础组件
+ Network 、DB
+ Log 、Utils
+ upgreate
+ crashReport、Hotfix
+ baseUI 、 widget
+ Router、EventBus
+ Share 、 ImageLoader
+ WebView
+ push 、permission
+ security

##### 常用的开源库
+ ARouter 、Atlas 、CC
+ Koin 、Hilt/dagger
+ EasyPermission
+ Vacsonic 、AgentWeb （WebView 框架）
+ Gson
+ Glide
+ Retrofit/okhttp/okgo
+ Lottie
+ LeackCanery 、Dokit
+ Zing/Zbar
+ Sophix、TinkerPathc
+ Jeptack
+ Logger、Timber、Hugo
+ vLayout、tangram
+ Luban
+ banner


todo:
1、四個  fragment 集成
2、dokit 集成。



### 三、登录模块
登录不了，是 baseUrl 设置的不对，并且登录之后，现在的页面不对。
只有点击登录的时候，才会加载 config 






### 四、个人中心
#### 1、组合控件开发
db形式封装，和绑定。

todo:
登录功能实现，另一个 demo 是可以，然后看一下另外两个库是否有更新。

关键点：
网络请求 - databinding -> 数据库 - > navigraph 跳转 userInfo 


全局 host 的替换：
放到 common 里面去，通过拦截器来实现，需要看一下另一个项目如何实现的,是否必须冷启动生效？
目前这个项目，不需要重启，那么逻辑是什么？

+ baseHostConfig

每个 libXXX module 中配置 host


还缺少 HostIntercept



### 五、学习中心


### 六、课程中心


### 七、首页


### 八、视频播放


### 九、App 打包 构建



### todo
libXXX.kt 配置的作用 & 数据管理类的作用

internal  & suspend

koin


R.()?

契约关系、契约类

inline

crossinline



login & mine 下 debug 的文件夹是怎么处理的，manifest 是如何动态替换的。



之前绑定图片报错，是在 BindingApc 中 imgSrcCompat  处理了。



三种图片库：
joke，xx，kt 对比，详细测试。


koin 学习。






### 其他
#### 1、BaseActivity 的 封装


#### 2、这个 demo 也是模块化的，看一下另外的两个示例，是否有更新
通过 debug 文件夹来实现的，变量不同，独立运行和作为模块，最终 as 显示的图标不一样。
manifest 放到了 src 下面。




todo：
中秋之前，把所有视频完成。


