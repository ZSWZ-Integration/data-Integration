from suds.client import Client  # 导入suds.client 模块下的Client类

# Application is the glue between one or more service definitions, interface and protocol choices.
from spyne import Application
# @rpc decorator exposes methods as remote procedure calls
# and declares the data types it accepts and returns
from spyne import rpc
# spyne.service.ServiceBase is the base class for all service definitions.
from spyne import ServiceBase
# The names of the needed types for implementing this service should be self-explanatory.
from spyne import Iterable, Integer, Unicode

from spyne.protocol.soap import Soap11
# Our server is going to use HTTP as transport, It’s going to wrap the Application instance.
from spyne.server.wsgi import WsgiApplication

class webService(ServiceBase):
    @rpc(Unicode, Integer, _returns=Iterable(Unicode))
    def say_hello(self, name, times):
        print("This is the webService method System B offers...")
        return "This is B WebService..."

soap_app = Application([webService], 'spyne.examples.hello.soap',
                       in_protocol=Soap11(validator='lxml'),
                       out_protocol=Soap11())

wsgi_app = WsgiApplication(soap_app)


def getAWebService(url):
    client = Client(url)  # 创建一个webservice接口对象
    result=client.service.AWebService()  # 调用这个接口下的getMobileCodeInfo方法，并传入参数
    #req = str(client)  # 保存请求报文，因为返回的是一个实例，所以要转换成str
    #response = str(client.last_received())  # 保存返回报文，返回的也是一个实例
    print(result)  # 打印请求报文
   # print (response)  # 打印返回报文
    return result