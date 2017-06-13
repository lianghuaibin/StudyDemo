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