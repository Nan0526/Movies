# 电影院数据库设计

#### 1.用户表Users
|    类型    |   字段名   |    说明          |
| ---------- |  -------- | ---------------- |
| String   | username    | 用户名(主键) |
| String   | psw    | 密码 |
| String   | name    | 真实姓名 |
| String   | nick    | 昵称 |
| int   | age    | 年龄 |
| String   | phone    | 电话 |
| float   | money    | 余额 |

#### 2.电影院表Cinemas
|    类型    |   字段名   |    说明          |
| ---------- |  -------- | ---------------- |
| int |  id   | 编号(主键)  |
| String   |  city   | 城市名 |
| String   |  name   | 电影院名 |

#### 3.电影表Movies
|    类型    |   字段名   |    说明          |
| ---------- |  -------- | ---------------- |
| int |  id   | 编号(主键)  |
| String   |  name   | 电影名 |
| float   |  price   | 价格 |
| String   |  director   | 导演 |
| String   |  artists   | 主要演员 |
| String   |  leading   | 主演 |
| String   |  intro   | 简介 |
| String   |  img   | 图片 |
| String   |  state   | 状态(coming/showing/end) |
| String   |  dates   | 上映日期 |
| String   |  type   | 类型 |

#### 4.订票信息OrderInfo
|    类型    |   字段名   |    说明          |
| ---------- |  -------- | ---------------- |
| int |  id   | 编号(主键)  |
| int   |  cinemaId   | 影院Id |
| int   |  movieId   | 电影Id |
| String   |  dates   | 播放日期 |
| String   |  times   | 播放时间 |
| String   |  username   | 用户名 |
| String   |  orderTime   | 订购时间 |
| String   |  seats   | 座位号(1,2) |
| float   |  prices   | 付款金额 |

#### 5.影院使用情况CinemaState
|    类型    |   字段名   |    说明          |
| ---------- |  -------- | ---------------- |
| int |  id   | 编号(主键)  |
| int   |  cinemaId   | 影院Id |
| int   |  movieId   | 电影Id |
| String   |  dates   | 播放日期 |
| String   |  times   | 播放时间 |
| String   |  seats   | 已用座位号(1,2顺序) |

#### 6.轮播表Carousel
|    类型    |   字段名   |    说明          |
| ---------- |  -------- | ---------------- |
| int   |  movieId   | 电影Id(主键) |
| String   |  img   | 轮播图 |






