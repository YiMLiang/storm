# storm实时监测共享账户项目

![](ER.png)

>抓取采集到的流量流向信息，分析有异常的账户，每隔5分钟统计一次数据，落库，前端使用echart简单展示

- 技术栈

```
数据采集：Flume，kafka
数据分析：Storm
数据存储：MySql
据可视化：Echart
```



blog : https://ymliang.netlify.com