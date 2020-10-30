#MyBatis

##动态sql
> if

这里的AND前面必须要有空格，不然拼接后的sql有语法错误
```
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
```
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
```
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
```
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













