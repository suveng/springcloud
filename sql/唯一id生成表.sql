-- 1、【用户服务】在注册一个用户时，需要一个用户ID；会请求【生成ID服务(是独立的应用)】的接口

-- 2、【生成ID服务】会去查询数据库，找到user_tag的id，现在的max_id为0，step=1000

-- 3、【生成ID服务】把max_id和step返回给【用户服务】；并且把max_id更新为max_id = max_id + step，即更新为1000

-- 4、【用户服务】获得max_id=0，step=1000；

-- 5、 这个用户服务可以用ID=【max_id + 1，max_id+step】区间的ID，即为【1，1000】

-- 6、【用户服务】会把这个区间保存到jvm中

-- 7、【用户服务】需要用到ID的时候，在区间【1，1000】中依次获取id，可采用AtomicLong中的getAndIncrement方法。

-- 8、如果把区间的值用完了，再去请求【生产ID服务】接口，获取到max_id为1000，即可以用【max_id + 1，max_id+step】区间的ID，即为【1001，2000】

drop table if EXISTS `unique_id` ;
CREATE TABLE `unique_id` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`biz_tag` varchar(20) NOT NULL DEFAULT '' COMMENT '表示业务，因为整体系统中会有很多业务需要生成ID，这样可以共用一张表维护',
	`max_id` bigint(20) NOT NULL  COMMENT '现在整体系统中已经分配的最大ID',
	`desc` varchar(128) NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='唯一id生成记录表';