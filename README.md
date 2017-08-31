StudyDemo 学习项目
===================

此项目为本人学习随记，一些常用技术整合！

----------

Documents
-------------

本项目主体为SpringBoot框架，main方法启动类：**com.lhb.study.springBoot.Application**
:  主要配置参数在**application.properties**中；
:  数据库访问的为本地数据库，大家可以导入**database.sql**的sql 到数据库中即可使用！


> **主要功能:**

> - SpringBoot结合Freemarker前端框架.
> - SpringBoot结合iBatis模板使用，封装service及到层，省去编写sql语句！
         需引入jar包：https://github.com/lianghuaibin/dynamic-ibatis.git
         自动生成代码类：ApiBaseDbMappingTool.
> - 分页插件**jd.grid.js**.【css样式在**common.css**中】
>    示例：http://localhost:9090/user/skipPage
> -  commonInit.js 封装了一些常用js方法.

#### <i class="icon-file"></i> 学习小Demo
一些小功能的用法  程序路径 com.lhb.study.devSmallDemo
> **主要功能:**
> 
> - 自定义注解使用，查看包com.lhb.study.devSmallDemo.annotation
>    参见：http://www.cnblogs.com/peida/archive/2013/04/24/3036689.html
> -  lombok 简单应用，对于我来说 也就@slf4j 这个注解感觉还不错，其他的比较鸡肋
> -  CountDownLatch 一个同步辅助类的使用  参见：CountDownLatchDemo.java
> -  zookeeper 简单应用示例  参见：ZkClientDemo.java
> -  mongodb 简单应用示例 参见：MongoTest.java

#### <i class="icon-file"></i> 页面效果Demo
> **主要功能:**
> 
> -  一个基于html5 canvas绘制的网页背景效果,一款很有范的网站背景鼠标点线窝巢特效
      http://localhost:9191/effects/nest
> -  一个基于html5 canvas绘制的网页背景效果  canvasStar特效
      http://localhost:9191/effects/star