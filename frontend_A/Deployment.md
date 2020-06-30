# CodeAnalysis项目前端部署文档

## 概要

在项目中根据后端部署的服务器修改后端ip，然后用vue打包成dist，接下来构建基于nginx的Docker镜像，运行容器  
整个过程由Jenkins控制并在开发过程中自动部署，实现持续集成  

## 手动部署

1. 修改后端ip

    在src/request/http.js下修改后端ip地址  

2. 打包

    > $ npm install  
    > $ npm run build

3. 如果前端正在运行，应当停止前端容器并清除相应镜像

    > $ docker stop frontend_ca  
    > $ docker rm frontend_ca  
    > $ docker rmi frontend_ca  

4. 构建镜像

    > $ docker build -t frontend_ca .

5. 运行容器

    > $ docker run -d -p 8081:80 --name frontend_ca frontend_ca

    此处可以自由选择端口映射，建议用80端口

## Jenkins部署

Jenkins也使用Docker部署，需要注意一个问题是在Jenkins容器内构建并发布项目需要链接到宿主机或远程的Docker Daemon  

连接到远程Docker Daemon需要配置远程Docker Daemon的远程连接；为确保安全性，可以使用Docker内置的证书加密，或者使用阿里云安全组策略限制访问ip  

但是我们小组没有这么多台服务器，因此本文以链接到宿主机Docker Daemon为示例  

1. 首先使用Docker部署Jenkins

    > $ docker run -d --name Jenkins \\  
    > -u root -p 8088:8080 \\  
    > -v /var/run/docker.sock:/var/run/docker.sock \\  
    > jenkinsci/blueocean  

    挂载docker.sock是为了访问宿主机的Docker Daemon，-u root是为了保证访问docker.sock的权限，端口映射自己选一个就行  

    然后使用浏览器访问宿主机的8088端口（或者你映射的端口），跟随指引配置即可  

    访问初始密钥的时候需要进入Jenkins容器内部，根据网页提示到容器中的指定目录下寻找

    > $ docker exec -it Jenkins bash

2. 安装所需的Jenkins插件

    首先更新Jenkins本体，以及更新所有可更新的插件

    然后安装下述插件  
    SSH、GitLab、GitLab Hook、Build Authorization Token Root

3. 配置Jenkins和gitlab密钥对

    进入jenkins容器中生成SSH密钥对，输入命令后一路回车，会在/root/生成.ssh/目录

    > $ ssh-keygen -t rsa

    Jenkins主界面-Credentials-System-Global credentials-Add Credentials，添加SSH Username with private key类型的凭证，将id_rsa文件的内容拷贝到Private Key一栏；打开gitlab，点击头像-settings-SSH密钥，将id_rsa.pub文件内容添加进去

    除此以外，还需要在Jenkins中配置SSH服务器，Jenkins主界面-系统管理-系统设置，找到SSH remote hosts，分别填写服务器ip、SSH端口(一般默认为22)并选择刚刚创建的凭证

4. 创建并配置一个流水线项目

    因为Jenkinsfile已经写好，只需要配置好GitLab地址和GitLab Hook就行了

    首先生成一个Token

    > openssl rand -hex 12

    在Jenkins中新建一个流水线项目，Build Triggers配置如下，把生成的Token复制到最后一栏

    ![9EF0E945-BC90-48ED-A7BC-BE224D37C6E1](/Users/macbook/Downloads/9EF0E945-BC90-48ED-A7BC-BE224D37C6E1.jpeg)

    打开需要部署的gitlab仓库-Settings-Integrations，URL一栏为http://Jenkins服务器ip:端口号/buildByToken/build?job=项目名称&token=上述生成的Token，保存即可

    回到Jenkins新建项目流程，Pipeline配置中选择Pipeline script from SCM，SCM选择Git，接下来填写好gitlab仓库的URL，选择凭证（也可以使用gitlab账号密码作为凭证），Branches to build填写master，Additional Behaviours选择Clean before checkout即可，点击保存，配置完毕

5. 如果服务器CPU核心较少或内存不够

    注意到一个问题，如果连续push，Jenkins构建会同时进行，这必定会导致我们价值十块钱的学生服务器爆炸  

    因此需要在Jenkins系统设置里把最大同时构建数改为1，这样push产生的新的构建请求会被排进构建队列里，就不会炸服

6. 最后在master分支push就能自动部署了
