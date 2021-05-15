### 一、语法速览

https://github.com/zhiwei1990/android-jetpack-demo


md 编辑器：

Typora



#### 1、变量
```kotlin

var a:Int  = 2

var a = 3

var ss:String ? = null

lateinit var str : String  //不能为 null，必须是引用类型

var ssstr:String by lazy { "by laze "  }


const val pi = 3.14

```

#### 2、函数
```kotlin

fun div(c:Int ,d:Flouat = 1f)


fun more(vararg a :Int) = 999

```



#### 3、语法
+ for
+ while
+ if
+ when


#### 4、类 
class
object
data class
sealed class  (密封类，类似枚举类)


#### 5、常用的高级函数
类型别名：
typealias ob = java.Observer 

+ also

+ let

+ apply

+ with

+ run

take、takeunless,takeif,runcathing,group,map,flatmap,last,first 





### 二、协程
协程，以同步的方式来写异步的代码。

协程的优点、特点：
+ 轻量
+实质，便于多线程开发
+ 线程池
+ 网路库支持，轻便优雅


#### 1、异步处理的方式
+ 线程
+ 回调
+ Futures，Promise
+ Rx 享应扩展
+ 协程








