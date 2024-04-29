![[Pasted image 20240306151659.png]]

(1)  创建本地文件夹
(2)  初始化命令    git init
(3)  允许克隆子目录   git config core.sparseCheckout true
(4)  添加所需要的文件夹或者目录（把路径写清楚）  
```text
echo '/文件夹名/*' >> .git/info/sparse-checkout
```
(5)  添加目标仓库的地址
```bash
git remote add bird 仓库地址
```
 (6)  开始下载文件
 ```bash
git pull bird master
```
