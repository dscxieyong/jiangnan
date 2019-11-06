# 江南
学习和记录常用命令的工具
# 相关开源工具文档
* [umi.js文档](https://umijs.org)
* [dva.js文档](https://dvajs.com)
* [ant.design组件库文档](https://ant.design/docs/react/practical-projects-cn)
* [spring boot文档](https://spring.io/projects/spring-boot/)
....
##结构说明
* [技术方案](https://souche.yuque.com/bggh1p/8961260/xxl3nx) 
项目一共由下面几个部分组成:
 -   asset-plenty-admin(后台管理员模块)
 -   asset-plenty-api(api接口模块)
 -   asset-plenty-bootstrap(启动入口)
 -   asset-plenty-common
 -   asset-plenty-core(业务域)
 -   asset-plenty-user(用户域)
 -   asset-plenty-rest(外部用户入口)

# 前端模块(asset-plenty-admin)运行注意点： 
第一次打开需要在asset-plenty-admin/src/main/antd目录下执行如下如下命令：
````
   //安装依赖
    yarn
   //编译
    yarn build
   //本地启动
    yarn start
   或者直接执行package.json文件相关命令    
````
在IDEA中第一次打开前端部分的js文件，IDEA会询问是否识别项目，点击switch识别成react项目，不然后续打开js文件都会提示语法错误 

# 本地开发注意
  可以采用前后端分离模式开发，如需要采用前后端分离模式，需要打开.umirc.js的proxy属性，用来支持跨域请求
# 部署注意点
    
