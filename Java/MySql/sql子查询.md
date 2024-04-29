sql子查询是指在一个sql查询语句里面内嵌另一个完整的查询语句

select  *  from table1 where  colum1 = (select colum from table2 where colum = 1)