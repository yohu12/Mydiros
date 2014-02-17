-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.18 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  7.0.0.4363
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 diros 的数据库结构
DROP DATABASE IF EXISTS `diros`;
CREATE DATABASE IF NOT EXISTS `diros` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `diros`;


-- 导出  表 diros.comment 结构
DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `content_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) DEFAULT NULL COMMENT '关联贴子的id，若是对评论的评论则为0',
  `content` longtext COMMENT '评论内容',
  `f_id` int(11) DEFAULT NULL COMMENT '若是对贴子回复为0，对评论回复则为相应的评论id',
  `create_dt` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `user_id` int(11) DEFAULT NULL COMMENT '评论人',
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`content_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  diros.comment 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
REPLACE INTO `comment` (`content_id`, `post_id`, `content`, `f_id`, `create_dt`, `user_id`, `state`) VALUES
	(1, 1, 'Test! You are right!', 0, '2013-08-05 22:00:19', 1, 0),
	(2, 3, '说说我的感受', 0, '2013-08-05 22:16:14', 1, 0);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


-- 导出  表 diros.fast_thought 结构
DROP TABLE IF EXISTS `fast_thought`;
CREATE TABLE IF NOT EXISTS `fast_thought` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `thought_title` varchar(50) NOT NULL COMMENT '主题',
  `user_id` int(11) NOT NULL COMMENT '信息发布人',
  `create_dt` datetime NOT NULL DEFAULT '1970-00-00 00:00:00' COMMENT '信息发布时间',
  `last_mdy_dt` datetime NOT NULL DEFAULT '1970-00-00 00:00:00' COMMENT '最近修改时间',
  `reply_dt` datetime NOT NULL DEFAULT '1970-00-00 00:00:00' COMMENT '最新评论时间',
  `status` int(1) NOT NULL COMMENT '状态',
  `context` text NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='发烧60秒';

-- 正在导出表  diros.fast_thought 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `fast_thought` DISABLE KEYS */;
REPLACE INTO `fast_thought` (`id`, `thought_title`, `user_id`, `create_dt`, `last_mdy_dt`, `reply_dt`, `status`, `context`) VALUES
	(1, 'test', 1, '1970-00-00 00:00:00', '1970-00-00 00:00:00', '1970-00-00 00:00:00', 1, '123'),
	(2, '投身移动互联网：小人物的创业故事', 1, '1970-00-00 00:00:00', '1970-00-00 00:00:00', '1970-00-00 00:00:00', 1, '如今对比百度3.7亿美元收购 PPS，苏宁4.2亿美元收购价格已经让陶闯感到欣喜了，如今对比百度3.7亿美元收购 PPS，苏宁4.2亿美元收购价格已经让陶闯感到欣喜了，如今对比百度3.7亿美元收购 PPS，苏宁4.2亿美元收购价格已经让陶闯感到欣喜了，如今对比百度3.7亿美元收购 PPS，苏宁4.2亿美元收购价格已经让陶闯感到欣喜了，');
/*!40000 ALTER TABLE `fast_thought` ENABLE KEYS */;


-- 导出  表 diros.forum 结构
DROP TABLE IF EXISTS `forum`;
CREATE TABLE IF NOT EXISTS `forum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `r_id` int(11) DEFAULT NULL COMMENT '父节点id',
  `f_name` varchar(32) DEFAULT '论坛模块名称',
  `state` int(11) DEFAULT NULL,
  `f_remark` varchar(32) DEFAULT NULL COMMENT '说明',
  `f_level` varchar(255) DEFAULT NULL COMMENT '妯″潡绾у埆',
  `f_code` varchar(255) DEFAULT NULL COMMENT '鏉垮潡浠ｇ爜',
  `f_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  diros.forum 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
REPLACE INTO `forum` (`id`, `r_id`, `f_name`, `state`, `f_remark`, `f_level`, `f_code`, `f_type`) VALUES
	(1, 0, 'test', 1, 'remark', '1', 'f', '1'),
	(2, 1, '论坛模块名称', 1, '1', '2', '2', '2'),
	(3, 1, '论坛模块名称', 1, '1', '1', '1', NULL),
	(4, 2, '论坛模块名称', 1, '1', '1', '1', '1');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;


-- 导出  表 diros.isjoin 结构
DROP TABLE IF EXISTS `isjoin`;
CREATE TABLE IF NOT EXISTS `isjoin` (
  `id` int(11) NOT NULL DEFAULT '0',
  `post_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`post_id`,`user_id`),
  KEY `FK_praise_user_id` (`user_id`),
  CONSTRAINT `FK_post_id` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`),
  CONSTRAINT `FK_praise_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  diros.isjoin 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `isjoin` DISABLE KEYS */;
/*!40000 ALTER TABLE `isjoin` ENABLE KEYS */;


-- 导出  表 diros.location 结构
DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `place` int(11) DEFAULT NULL COMMENT '地点',
  `start_time` datetime DEFAULT NULL COMMENT '活动开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '活动结束时间',
  `details` varchar(255) DEFAULT NULL COMMENT '活动详情',
  `label` varchar(255) DEFAULT NULL COMMENT '标签',
  `initiator` int(11) DEFAULT NULL COMMENT '发起人',
  `state` int(11) DEFAULT NULL COMMENT '状态 1 表示即将开始，2表还是正在进行中，3表示已结束',
  `type` int(11) DEFAULT NULL COMMENT '类型 活动分类',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城';

-- 正在导出表  diros.location 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;


-- 导出  表 diros.location_user 结构
DROP TABLE IF EXISTS `location_user`;
CREATE TABLE IF NOT EXISTS `location_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `l_id` int(11) DEFAULT NULL COMMENT 'Location表id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `is_Interested` int(11) DEFAULT '0' COMMENT '是否感兴趣 1 表还是感兴趣 ，默认为0',
  `is_join` int(11) DEFAULT '0' COMMENT '是否加入 1表示已加入 ，默认为0',
  PRIMARY KEY (`Id`),
  KEY `locUser_Location_pk` (`l_id`),
  KEY `locUser_user_pk` (`user_id`),
  CONSTRAINT `locUser_Location_pk` FOREIGN KEY (`l_id`) REFERENCES `location` (`Id`),
  CONSTRAINT `locUser_user_pk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参加同城活动的人员关联表';

-- 正在导出表  diros.location_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `location_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_user` ENABLE KEYS */;


-- 导出  表 diros.message 结构
DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `message_id` int(11) NOT NULL,
  `group_id` int(11) DEFAULT NULL,
  `msg_title` varchar(32) DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `FK_from_user` (`from_user_id`),
  KEY `FK_to_user` (`to_user_id`),
  CONSTRAINT `FK_from_user` FOREIGN KEY (`from_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_to_user` FOREIGN KEY (`to_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  diros.message 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


-- 导出  表 diros.news 结构
DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(160) DEFAULT NULL COMMENT '标题（最大长度为80个汉字）',
  `content` text COMMENT '新闻内容',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '新闻创建时间',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '新闻创建人',
  `replay_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '最新回复时间',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- 正在导出表  diros.news 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
REPLACE INTO `news` (`Id`, `title`, `content`, `create_time`, `user_id`, `replay_time`, `state`) VALUES
	(1, '涨大水勒', '好的的水呀，桥都冲垮勒', '2013-07-31 10:45:20', 0, '2013-07-31 10:50:20', NULL),
	(2, 'qwe', 'qweqweqweqweqweasdasd', '2013-07-31 10:49:20', 0, '2013-07-31 11:45:20', NULL),
	(3, '货来了', '<p><br/></p><h1 label="Title center" name="tc" style="border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;text-align:center;margin:0px 0px 20px;" class="ue_t">[此处键入文章标题]</h1><p><img src="http://img.baidu.com/hi/youa/y_0034.gif" style="width:300px;height:200px;float:left;" border="0" height="200" hspace="0" vspace="0" width="300"/>图文混排方法</p><p>1. 图片居左，文字围绕图片排版</p><p>方法：在文字前面插入图片，设置居左对齐，然后即可在右边输入多行文本</p><p><br/></p><p>2. 图片居右，文字围绕图片排版</p><p>方法：在文字前面插入图片，设置居右对齐，然后即可在左边输入多行文本</p><p><br/></p><p>3. 图片居中环绕排版</p><p>方法：亲，这个真心没有办法。。。</p><p><br/></p><p><br/></p><p><img src="http://img.baidu.com/hi/youa/y_0040.gif" style="width:300px;height:300px;float:right;" border="0" height="300" hspace="0" vspace="0" width="300"/></p><p>还有没有什么其他的环绕方式呢？这里是居右环绕</p><p><br/></p><p>欢迎大家多多尝试，为UEditor提供更多高质量模板！</p><p><br/></p><p>占位</p><p><br/></p><p>占位</p><p><br/></p><p>占位</p><p><br/></p><p>占位</p><p><br/></p><p>占位</p><p><br/></p><p><br/></p><p><br/></p>', '2013-08-01 16:25:19', 0, NULL, 0),
	(4, ' 【战报】奥迪杯-沙拉维梅开二度佩塔尼亚破门 米兰3-5完败曼城', '<p style="text-align: center;"><img style="cursor: url(&quot;http://tb2.bdstatic.com/tb/static-pb/img/cur_zin.cur&quot;), pointer;" class="BDE_Image" src="http://i3.sinaimg.cn/ty/g/seriea/2013-08-01/U8691P6T12D6699739F44DT20130801103023.jpg" height="374" width="560"/></p><p><br/></p><p>新浪体育讯　北京时间8月1日00:15(德国当地时间7月31日18:15)，2013奥迪杯半决赛在安联竞技场先赛一场，曼城5比3取胜AC米兰，席\r\n尔瓦、里查兹和科拉罗夫各入一球，哲科梅开二度。5球落后的AC米兰连追3球，沙拉维同样梅开二度，佩塔格纳打入一球。曼城进入奥迪杯决赛，将同拜仁和圣\r\n保罗之间的胜者争夺冠军。<br/>　　曼城派出三新援首发，约维蒂奇、纳瓦斯和费尔南迪尼奥均出场，哲科继续出任中锋，席尔瓦和亚亚-图雷首发。AC米兰方面，沙拉维和博阿滕出场，巴洛特利未进入比赛名单对阵旧主。<br/>　\r\n　曼城第3分钟取得领先，纳瓦斯右路轻松突破蒙塔里传中，约维蒂奇远点垫传门前，席尔瓦近距离推射破门。曼城持续施压，第8分钟，哲科右路内切引致米兰防\r\n线混乱，康斯坦特传球失误，约维蒂奇禁区右侧的小角度射门偏出远角。第12分钟，科拉罗夫左路传中，哲科小禁区边缘铲射打在贝尔加拉腿上偏转，皮球擦右侧\r\n立柱偏出底线。第16分钟，约维蒂奇传球，亚亚-图雷远射偏出。<br/>　　曼城第19分钟扩大比分，亚亚-图雷传球，里查兹突入禁区右侧10码处射门被\r\n阿梅利亚勉强扑挡，里查兹随即跟进补射入网，2-0。第22分钟，约维蒂奇直传，科拉罗夫禁区左侧12码处射入远角，3-0。AC米兰首次射门出现在第\r\n27分钟，博阿滕禁区前远射送上看台。第32分钟，纳瓦斯右路传中，阿梅利亚和安东尼尼均未能拦截皮球，哲科远点小角度轻松打入空门，4-0。<br/>　\r\n　第34分钟，里查兹右路传中，约维蒂奇小禁区边缘铲射错过皮球。第36分钟，亚亚-图雷直传，哲科10码处胸部停球后转身抽射破门，5-0。AC米兰3\r\n分钟连扳两城，第37分钟，哈维-加西亚停球失误，沙拉维抢断后突入禁区右侧小角度射入远角，1-5。第39分钟，蒙塔里直传，佩塔格纳禁区边缘内拿球摔\r\n倒，跟进的沙拉维拿球晃过乔-哈特破门，2-5。第43分钟，蒙塔里直传，反越位成功的佩塔格纳12码处单刀推射破门，3-5。第45分钟，沙拉维禁区左\r\n侧射失单刀。<br/>　　下半场，内格雷多、纳斯里和罗德维尔均替补出场，约维蒂奇、纳瓦斯和费迪南迪尼奥均被换下。AC米兰换上尼昂和诺切里诺。第51\r\n分钟，席尔瓦开出角球，里查兹12码处头球攻门偏出。第54分钟，蒙塔里回传，博阿滕禁区前射门打偏。第55分钟，纳斯里禁区右侧的小角度射门偏出远角。\r\n第56分钟，沙拉维小禁区前混战中未能及时起脚射门，曼城后卫及时解围。<br/><br/>　　第58分钟，沙拉维直传，博阿滕禁区左侧12码处单刀射门被\r\n乔-哈特及时出击用腿挡出。第63分钟，纳斯里开出角球，哈维-加西亚小禁区前头球攻门被加布里埃尔神勇扑出，里查兹再射被没收。第67分钟，诺切里诺直\r\n传，波利小禁区边缘试图扣过乔-哈特射门，但曼城门将及时用腿将皮球扫出。比赛频频被换人打乱节奏。第79分钟，纳斯里传球，内格雷多20码处劲射打中横\r\n梁上沿弹出。<br/>　　曼城出场阵容(4-2-3-1)：1-乔-哈特；2-里查兹，14-哈维-加西亚，6-莱斯科特，13-科拉罗夫；25-费尔南\r\n迪尼奥(46&#39;,17-罗德维尔)，42-亚亚-图雷；15-纳瓦斯(46&#39;,8-纳斯里)，35-约维蒂奇(46&#39;,9-内格雷多)，21-席尔瓦\r\n(63&#39;,7-米尔纳)；10-哲科(63&#39;,18-巴里)<br/>　　AC米兰出场阵容(4-3-1-2)：1-阿梅利亚(46&#39;,59-加布里埃\r\n尔)；77-安东尼尼，81-扎卡尔多(73&#39;,35-帕奇菲科)，33-贝尔加拉，21-康斯坦特(65&#39;,28-艾玛努埃尔森)；12-特劳雷\r\n(46&#39;,23-诺切里诺)，34-德容(73&#39;,24-克里斯坦特)，4-蒙塔里(65&#39;,16-波利)；10-博阿滕(79&#39;,38-皮纳\r\n托)；37-佩塔格纳(46&#39;,78-尼昂)，92-沙拉维(66&#39;,39-小博阿滕)</p><p style="text-align: center;"><img style="cursor: url(&quot;http://tb2.bdstatic.com/tb/static-pb/img/cur_zin.cur&quot;), pointer;" class="BDE_Image" src="http://i2.sinaimg.cn/ty/g/seriea/2013-08-01/U8691P6T12D6699320F44DT20130801081809.jpg" height="375" width="560"/></p><p><br/></p><p><br/></p><p style="text-align: center;"><span class="edit_font_color"><strong>进球视频-曼城铁卫乌龙助攻 沙拉维彪悍单骑闯关 37分钟</strong></span></p><p><br/></p><p><br/></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p style="text-align:center"><embed type="application/x-shockwave-flash" class="edui-faked-video" pluginspage="http://www.macromedia.com/go/getflashplayer" src="http://you.video.sina.com.cn/api/sinawebApi/outplayrefer.php/vid=111158722_6_Zky3GHZuXjTK+l1lHz2stqkM7KQNt6njnynt71+iJwlaUQyMYorfO4kK4SjXAcpK9m5P/s.swf" width="420" height="280" wmode="transparent" play="true" loop="false" menu="false" allowscriptaccess="never" allowfullscreen="true"/></p>', '2013-08-01 16:57:05', 0, NULL, 0),
	(5, NULL, NULL, '2014-01-22 23:35:28', 0, NULL, 0);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


-- 导出  表 diros.news_comment 结构
DROP TABLE IF EXISTS `news_comment`;
CREATE TABLE IF NOT EXISTS `news_comment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `news_id` int(11) NOT NULL DEFAULT '0' COMMENT '评论对象的id',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime DEFAULT NULL COMMENT '评论时间',
  `root_id` int(11) DEFAULT NULL COMMENT '根节点id 若为0这表示对新闻的评论，不唯一则表示对该新闻下的某条评论的评论',
  `state` int(11) NOT NULL DEFAULT '0',
  `user_id` varchar(255) DEFAULT NULL COMMENT '发表评论的用户的id',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='新闻评论表';

-- 正在导出表  diros.news_comment 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `news_comment` DISABLE KEYS */;
REPLACE INTO `news_comment` (`Id`, `news_id`, `content`, `create_time`, `root_id`, `state`, `user_id`) VALUES
	(1, 1, '水从河里溢出来了', '2013-07-31 14:25:33', 0, 0, '2'),
	(2, 1, '淹到腰了', '2013-07-31 14:26:33', 0, 0, '1'),
	(3, 1, '你那算什么，简直弱爆了，我这儿已经淹到脖子了', '2013-07-31 14:27:33', 2, 0, '89');
/*!40000 ALTER TABLE `news_comment` ENABLE KEYS */;


-- 导出  表 diros.post 结构
DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `forum_id` int(1) DEFAULT NULL,
  `title` varchar(32) DEFAULT NULL COMMENT '标题',
  `create_dt` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '发帖时间',
  `lost_mdy_dt` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '发帖人',
  `chg_who` int(11) DEFAULT NULL COMMENT '修改人',
  `content` longtext COMMENT '内容',
  `type` int(11) DEFAULT NULL COMMENT '1=news;\r\n2=post;',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`post_id`),
  KEY `FK_post_user_id` (`user_id`),
  KEY `FK_post_forum_id` (`forum_id`),
  CONSTRAINT `FK_post_forum_id` FOREIGN KEY (`forum_id`) REFERENCES `forum` (`id`),
  CONSTRAINT `FK_post_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='贴子表';

-- 正在导出表  diros.post 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
REPLACE INTO `post` (`post_id`, `forum_id`, `title`, `create_dt`, `lost_mdy_dt`, `user_id`, `chg_who`, `content`, `type`, `state`) VALUES
	(1, 1, 'test', '2013-01-01 00:00:00', '2013-01-01', 1, 1, 'test', 1, '1'),
	(3, 1, 'This is a test', '2012-01-01 00:00:00', '2012-01-01', 1, NULL, 'Hello word', 0, '0'),
	(4, 1, '这是关于Mysql的测试', '2013-01-01 00:00:00', '2012-01-01', 1, NULL, 'test 111', 0, '0');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;


-- 导出  表 diros.user 结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT '',
  `sex` varchar(1) DEFAULT NULL,
  `pword` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `regiest_dt` datetime DEFAULT NULL,
  `last_login_dt` datetime DEFAULT NULL,
  `email` varchar(32) NOT NULL,
  `nick_name` varchar(32) DEFAULT '',
  `location` varchar(32) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `fans_count` decimal(32,0) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  diros.user 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`user_id`, `name`, `sex`, `pword`, `regiest_dt`, `last_login_dt`, `email`, `nick_name`, `location`, `level`, `fans_count`, `photo`, `state`) VALUES
	(1, 'tom', NULL, 'tom', NULL, NULL, '', '', NULL, NULL, NULL, NULL, 0),
	(2, '张三疯', 'M', 'lueSGJZetyySpUndWjMBEg==', '2013-08-15 22:31:18', NULL, '826102928@qq.com', '123', '123', 0, 0, NULL, -100),
	(3, 'zhangsan', 'M', '4861iBoKH9qtASltdVSGjQ==', '2013-08-15 22:34:03', '2013-08-15 23:08:11', '826102928@qq.com', '123', '123', 0, 0, NULL, 0),
	(4, 'yohu', NULL, 'ICy5YqxZB1uWSwcVLSNLcA==', '2013-08-26 22:39:40', NULL, 'ttt', 'yohu', 'ttt', 0, 0, NULL, 0),
	(5, 'yohu', NULL, 'ICy5YqxZB1uWSwcVLSNLcA==', '2013-08-26 22:40:46', NULL, 'ttt', 'yohu', 'ttt', 0, 0, NULL, 0),
	(6, 'yohu', NULL, 'ICy5YqxZB1uWSwcVLSNLcA==', '2013-08-26 22:40:49', NULL, 'ttt', 'yohu', 'ttt', 0, 0, NULL, 0),
	(7, 'tom1', 'M', '4QrcOUm6Wau+VuBX8g+IPg==', '2013-08-28 20:36:36', NULL, 'tankboo@163.com', 'asdasd', 'adasd', 0, 0, NULL, -100),
	(8, 'huyong', 'M', 'ICy5YqxZB1uWSwcVLSNLcA==', '2014-01-08 22:29:57', NULL, '82370288@qq.com', 'yohu', '', 0, 0, NULL, -100),
	(9, 'tt', 'M', '41jvpIn1gGLxDdcxa2Vkng==', '2014-01-08 22:32:25', NULL, 't', 't', 't', 0, 0, NULL, -100),
	(10, 'y', 'M', 'QVKQdpWURg4uSFkikE80XQ==', '2014-01-08 22:34:08', NULL, 'y', 'y', 'y', 0, 0, NULL, -100),
	(11, 't', 'M', '41jvpIn1gGLxDdcxa2Vkng==', '2014-01-08 22:35:11', NULL, 't', 't', 't', 0, 0, NULL, -100);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- 导出  表 diros.userprofier 结构
DROP TABLE IF EXISTS `userprofier`;
CREATE TABLE IF NOT EXISTS `userprofier` (
  `user_id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `regiest_dt` date DEFAULT NULL,
  `last_login_dt` date DEFAULT NULL,
  `email` varchar(32) NOT NULL,
  `nick_name` varchar(32) NOT NULL,
  `location` varchar(32) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `fans_count` decimal(32,0) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`email`,`nick_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  diros.userprofier 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `userprofier` DISABLE KEYS */;
/*!40000 ALTER TABLE `userprofier` ENABLE KEYS */;


-- 导出  表 diros.user_fans_map 结构
DROP TABLE IF EXISTS `user_fans_map`;
CREATE TABLE IF NOT EXISTS `user_fans_map` (
  `user_id` int(11) NOT NULL,
  `follower_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`follower_id`),
  UNIQUE KEY `Index_user_id` (`user_id`) USING BTREE,
  KEY `FK_follower_id` (`follower_id`),
  CONSTRAINT `FK_follower_id` FOREIGN KEY (`follower_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  diros.user_fans_map 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_fans_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_fans_map` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
