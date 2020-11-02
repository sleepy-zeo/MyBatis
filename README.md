# MyBatis

## 动态sql
> if

这里的AND前面必须要有空格，不然拼接后的sql有语法错误
```sql
SELECT * FROM t_customer
WHERE grade = "7"
<if test="name!=null and name!='' ">
	 AND NAME LIKE #{name}
</if>
<if test="telephone!=null and telephone!='' ">
	 AND telephone LIKE #{telephone}
</if>
```

> where

where元素中不需要考虑空格的问题，前面的AND和OR如果在第一个，会自动忽略
```sql
SELECT * FROM t_customer
<where>
	<if test="name!=null and name!='' ">
		AND NAME LIKE #{name}
	</if>
	<if test="telephone!=null and telephone!='' ">
		AND telephone LIKE #{telephone}
	</if>
</where>
```

> choose

相当于switch语句
```sql
SELECT * FROM t_customer
<where>
	<choose>
		<when test="name!=null and name!='' ">
			AND NAME LIKE #{name}
		</when>
		<when test="telephone!=null and telephone!='' ">
			AND telephone LIKE #{telephone}
		</when>
		<otherwise>
		</otherwise>
	</choose>
</where>
```

> sql

sql片段复用
```sql
<sql id="select_customer_sql">
	select id,name,gender,telephone from t_customer
</sql>

<include refid="customerField"/>
<where>
	<if test="name!=null and name!='' ">
		AND NAME LIKE #{name}
	</if>
	<if test="telephone!=null and telephone!='' ">
		AND telephone LIKE #{telephone}
	</if>
</where>
```

> foreach

```
http://www.yiidian.com/mybatis/dynamic-sql.html
```

## 连接池

MyBatis支持三种连接池
- Pooled：   实现dataSource接口，使用了池的思想
- UNPooled： 实现dataSource接口，没有使用池的思想
- JNDI：     采用服务器提供的JNDI技术实现，并且在不同服务器之间获取的连接池不一样










