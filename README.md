# mingran


## 介绍
基于 https://gitee.com/y_project/RuoYi-Vue 开发

想要开发一个 个人管理系统


没有时间一步一步的搭建环境，直接拿现成的用了。后面自己优化吧
反正只要自己足够菜，就有的学了

## 支持的功能
blog
note
task

## 使用

### 初始化

```bash
docker run -it --name mingran-mysql -p 3306:3306 -v /d/dockerDrive/mysql:/app -e MYSQL_DATABASE=mingran -e MYSQL_USER=chenran -e MYSQL_PASSWORD=chenran123456 -e MYSQL_ROOT_PASSWORD=111111 wangxian/alpine-mysql
```

```bash
docker run --name mingran-redis  -p 6379:6379 -d redis:5.0.7-alpine
```


### 本地启动
```java

```



### 代码自动生成
自动生成代码其实蛮有意思的，后面研究下，减少crud的工作量其实蛮好的



