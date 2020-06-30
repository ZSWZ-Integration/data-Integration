# 前端检查点导航

已经部署在服务器上，浏览器输入[http://101.200.172.109:8081/](http://101.200.172.109:8081/)就能访问，如果出现无法访问可能是Jenkins正在自动构建，Jenkins在[http://101.200.172.109:8088/](http://101.200.172.109:8088/)上，账号密码可以询问组长  
关于管理员注册的邀请码，为了方便助教检查就直接去掉了，输入任意字符串都能直接注册为管理员  

提供一些测试项目  
[https://gitee.com/HeBomou/itrust](https://gitee.com/HeBomou/itrust)  
[https://gitee.com/forsakenspirit/Demo](https://gitee.com/forsakenspirit/Demo)  
[https://gitee.com/HeBomou/simple](https://gitee.com/HeBomou/simple)  
[https://gitee.com/HeBomou/funnylayer](https://gitee.com/HeBomou/funnylayer)  
还有一个测试账户  
用户名: hebomou 密码: 19980717

前端页面位置在/src/views下，store下为vuex全局数据，request使用axios封装http请求，components中为封装的组件，主要是cytoscape，assets放置图片文件等资源，router为路由，plugins中是一些相关插件，包括代码高亮和vuetify组件库。

## 检查点1 工作页面概况

工作页面在MainPage.vue文件中，使用components下的DepGraph.vue的组件（封装的cytoscape）。包层次结构为MainPage下的一个vuetify的treeview组件。点击顶点/搜索顶点/点击包结构中的方法，实际上都会产生同样的结构，就是图中对应顶点高亮，右侧显示相关信息，包结构展开到对应位置。

## 检查点2 迭代一中的检查点3 4 5

### 3

边的紧密度阈值作为属性保存。所有的顶点、边、连通域、子图的信息都保存在/src/store/index.js中，使用vuex进行管理。点击图上的边，通过我们封装的DevGraph组件注册的事件来让主界面中显示边的紧密度阈值

### 4

设置紧密度阈值在MainPage界面中的一个AutoComplete组件实现。加载页面的时候会讲所有先前设置过的紧密度阈值加载进该组件。由于紧密度阈值不同，连通域不同，而连通域可能加有标注，因此这里使用自动补全是提示用户之前设置过的紧密度阈值。用户也可以添加或者删除这个紧密度阈值。

### 5

搜索路径时，有两个AutoComplete组件分别输入起点和终点，他们和顶点搜索一样，都有自动补全功能，只需要输入部分的方法名或包名就会提示，用户就可以选中其中一个。同时，可以通过选中某个顶点（通过包结构/顶点搜索/点击图上顶点），然后点击“设置为起点”/“设置为终点”的按钮来将当前选中的顶点设置为起点/终点。搜索后，系统在一个v-list-item-group组件中显示所有的路径，点击某一个之后，图中会将对应的路径高亮。

选中某个顶点的方法：src/views/MainPage.vue: selectVertex(id)

## 检查点3 添加标注、展开包结构、显示源代码

标注保存 src/views/MainPage.vue: saveTag() 根据当前选中的类型调用不同接口保存

展开包结构的方法 src/views/MainPage.vue: selectVertex()的后段，将需要展开的节点放入open数组

显示源代码，由于源代码可能比较多，因此一直显示的话占据太多页面空间，所以我们设置的是，可以点击“显示源代码”按钮，然后弹出源代码。使用v-dialog组件弹出选中的源代码。

## 检查点4 函数名搜索

使用v-autocomplete组件完成。和设置起点/终点类似。在vertexs数组中保存所有顶点的名字。searchVertexSelected监听该组件选中某一顶点的事件，然后调用selectVertex方法，同时展开包结构、在图中高亮显示。

## 检查点5 两类用户

普通用户登陆界面为/src/views/login.vue, 管理员登陆界面为/src/views/adminLogin.vue

普通用户加载项目的界面为/src/views/Porject.vue

管理员界面为/src/views/Admin.vue

## 检查点6 保存图上操作

所有图上的操作通过监听我们封装的DepGraph组件的事件完成

```
    @connectiveDomainSelected="depGraphConnectiveDomain"
    @vertexMoved="depGraphVertexMoved"
    @connectiveDomainMoved="depGraphDomainMoved"
```

监听到移动事件之后，会调用api进行保存。标注的保存在按钮的@click中绑定

## 检查点7 管理员

管理员界面为/src/views/Admin.vue，其中用v-data-table组件展示相关数据。
