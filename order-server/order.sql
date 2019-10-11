use example;

DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL auto_increment COMMENT 'PK',
  `order_id` bigint(20) NOT NULL COMMENT 'order id',
  `inventory_num` bigint(20) NOT NULL default '0' COMMENT 'inventory num',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'last update time',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='order info table';
