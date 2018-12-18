<p align="center">
  <img src="http://qiniu.tomxin.cn/jdzf.png" alt="" width=200>
</p>
<p align="center">
  <a href="http://house.jiandan.live/">
    <img src="https://img.shields.io/badge/build-passing-brightgreen.svg" alt="">
  </a>
  <a href="http://tomxin.cn">
     <img src="https://img.shields.io/badge/author-tomxin7-orange.svg" alt="">
  </a>
</p>


# :black_nib: 简单找房

> 除了一些大的中介、同城等专业租房APP之外，很多朋友也喜欢使用豆瓣、微博等社交平台来找房，上面转租和房东直租会稍微多一些，但是由于其分类或者发帖风格会比较混乱，所以也会给找房带来一些难度，“简单找房”就是为了解决这些痛点诞生的。系统会实时监控这些平台的招租信息，用户在设置关键字后，有合适的租房信息会在第一时间推送到用户邮箱（后期会增加微信或者其他形式的提醒）。不用再整天盯着手机，害怕错过合适的房子，让美好的生活主动找上你——房子是租来的，但是生活不是！

#### 官网

- [http://house.jiandan.live](http://house.jiandan.live)

## 运行原理（开局一张图，其他全靠编）

![mark](http://qiniu.tomxin.cn/blog/20181203/EnTpbSO2nurr.png?imageslim)

## 技术选型

- 前端：Amaze UI
- 后端：Java8、SpringBoot、SpringData
- 爬虫：Python 3.6

## 项目地址
- 前端源码：https://github.com/tomxin7/jiandan_house_web
- 爬虫源码：https://github.com/tomxin7/jiandan_house_py


## 核心功能点

- 城市
  1. 获取城市
  2. 新增城市（接口不公开）
  3. 删除城市（接口不公开）
- 登录（QQ登录）
  1. 颁发token
  2. 校验token
- 记录
  1. 新增记录
  2. 修改记录

## 更多好玩的

关注公众号：程序员的小浪漫，爱上简单的生活

![mark](http://qiniu.tomxin.cn/blog/180521/Echm6dehec.jpg?imageslim)

#### 站在巨人的肩膀上：

- [Amaze UI](http://amazeui.org/) ：HTML5 跨屏前端框架
- [SpringBoot](http://spring.io/projects/spring-boot) ：Spring Boot is designed to get you up and running as quickly as possible

