# neo4j-visual-display
Neo4j图数据可视化 Neo4j + SpringBoot + D3.js

图形数据库是以图形结构的形式存储数据的数据库。 它以节点，关系和属性的形式存储应用程序的数据。 正如RDBMS以表的“行，列”的形式存储数据，GDBMS以“图形”的形式存储数据

### 启动Neo4j数据库
安装neo4j community版本(https://neo4j.com/) 并启动./neo4j start

### 导入数据
1. 把数据文件放在neo4j的import文件夹下面 （节点信息 和 关系信息）
2. 导入Node节点（node.csv文件）

  ```
    load csv from "file:///node.csv" as line 
    create(n:Node{name:line[0]}) 
    return n
  ```
3. 导入Node节点的contradion关系（contradion.csv文件）
  ```
    load csv from "file:///contradion.csv" as row 
    match (f1:Node{name:row[0]})
    match (f2:Node{name:row[1]})
    merge (f1)-[r:contradion]->(f2)
    return count(*)
  ```
4. 导入Node节点subClassOf关系（subClassOf.csv文件）
  ```
    load csv from "file:///subClassOf.csv" as row 
    match (f1:Node{name:row[0]})
    match (f2:Node{name:row[1]})
    merge (f1)-[r:subClassOf]->(f2)
    return count(*)
  ```
5. 导入Node节点的complementary关系（complementary.csv文件）
  ```
    load csv from "file:///complementary.csv" as row 
    match (f1:Node{name:row[0]})
    match (f2:Node{name:row[1]})
    merge (f1)-[r:complementary]->(f2)
    return count(*)
  ```

### Start
启动SpringBoot应用程序，访问http://localhost:8080/ 即可查看图谱显示效果

