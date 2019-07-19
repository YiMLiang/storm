#序号	字段	类型	描述
#1	time	Byte	数据统计时间
#2	userAccount	Byte	宽带账户
#3	userIP	Byte	用户以太网IP
#4	qqid	Byte	QQ号
#5	natIP	Byte	内网IP
#6	cookieValue	Byte	Cookie值
#7	devName	Byte	设备名称
#8	osName	Byte	操作系统名称

#创建测试数据库，检测数据是否能完整写入
create table test(
time varchar(25),
userAccount varchar(25),
userIP varchar(25),
qqid varchar(25),
natIP varchar(25),
cookieValue varchar(25),
devName varchar(25),
osName varchar(25)
);

#统计结果分为两个字段，入库
create table wordcount6(timeStamp varchar(25),count varchar(25));
create table wordcount7(userAccount varchar(25),count varchar(25));